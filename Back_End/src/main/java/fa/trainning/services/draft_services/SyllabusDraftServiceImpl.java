package fa.trainning.services.draft_services;

import fa.trainning.dto.request.forcreate.CAssessmentScheme;
import fa.trainning.dto.request.forcreate.CTrainingMaterial;
import fa.trainning.dto.request.forcreate.CTrainingUnit;
import fa.trainning.dto.request.forcreate.draft.CAssessmentSchemeDraft;
import fa.trainning.dto.request.forcreate.draft.CSyllabusDraft;
import fa.trainning.dto.request.forcreate.draft.CTrainingMaterialDraft;
import fa.trainning.dto.request.forcreate.draft.CTrainingUnitDraft;
import fa.trainning.entities.*;
import fa.trainning.entities.Enums.SyllabusPublishStatus;
import fa.trainning.entities.draft.*;
import fa.trainning.repositories.SyllabusRepository;
import fa.trainning.repositories.UserRepository;
import fa.trainning.repositories.draft.SyllabusDraftRepository;
import fa.trainning.services.draft_services.template.*;
import fa.trainning.services.template.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class SyllabusDraftServiceImpl implements ISyllabusDraftService {
    @Autowired
    private SyllabusDraftRepository syllabusRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ILearningObjectiveDraftService learningObjectiveService;
    @Autowired
    private ISyllabusObjectiveDraftService syllabusObjectiveService;
    @Autowired
    private ITrainingUnitDraftService trainingUnitService;
    @Autowired
    private ITrainingContentDraftService trainingContentService;
    @Autowired
    private IAssessmentSchemeDraftService assessmentSchemeService;
    @Autowired
    private ITrainingMaterialDraftService trainingMaterialService;
    @Override
    public SyllabusDraft createSyllabusDraft(CSyllabusDraft syllabusDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String createdByEmail = authentication.getName();
        User userCreated = userRepository.findByEmail(createdByEmail);
        SyllabusDraft syllabus = modelMapper.map(syllabusDTO,SyllabusDraft.class);

        syllabus.setCreateDate(LocalDateTime.now());
        syllabus.setCreatedBy(userCreated);
        syllabus.setPublishStatus(SyllabusPublishStatus.DRAFTING);

        // get list learning objective
        Set<String> syllabusObjectiveList = syllabusDTO.getSyllabusObjectives();

        // create new set syllabus objective for saving to database
        Set<SyllabusObjectiveDraft> syllabusObjectivesSet = new HashSet<>();
        for(String s: syllabusObjectiveList) {
            LearningObjectiveDraft learningObjective = learningObjectiveService.findLearningObjectiveByCode(s);
            SyllabusObjectiveDraft syllabusObjective = new SyllabusObjectiveDraft(syllabus, learningObjective);
            syllabusObjectivesSet.add(syllabusObjective);
        }

        // save syllabus first to have syllabus code
        SyllabusDraft result = syllabusRepository.save(syllabus);

        syllabusObjectiveService.addListSyllabusDraftObjective(syllabusObjectivesSet);

        // outline screen

        // get list training unit
        Set<CTrainingUnitDraft> cTrainingUnitSet = syllabusDTO.getTrainingUnits();
        Set<TrainingUnitDraft> trainingUnitSet = new HashSet<>();

        // list training content
        Set<TrainingContentDraft> trainingContentSet = new HashSet<>();
        // Add new Training unit
        for(CTrainingUnitDraft c : cTrainingUnitSet) {
            String unitCode = autoCreateUnitCode(c.getUnitName());
            TrainingUnitDraft trainingUnit = new TrainingUnitDraft(unitCode,c.getUnitName(),c.getDayNumber(),syllabus);
            trainingUnitSet.add(trainingUnit);
        }

        // save list to database
        trainingUnitService.addListTrainingUnit(trainingUnitSet,trainingContentSet,cTrainingUnitSet);

        //other screen
        CAssessmentSchemeDraft cAssessmentScheme = syllabusDTO.getAssessmentScheme();
        AssessmentSchemeDraft assessmentScheme = new AssessmentSchemeDraft(syllabus, cAssessmentScheme);

        //save assessment scheme
        assessmentSchemeService.addAssessmentSchemeDraftService(assessmentScheme);

        // save training material
        List<CTrainingMaterialDraft> listTraining = syllabusDTO.getTrainingMaterials();
        trainingMaterialService.createTrainingMaterial(syllabus,listTraining);

        return result;
    }
    public static String autoCreateUnitCode(String unitName) {
        String unitCode = "UNIT-";
        UUID uuid = UUID.randomUUID();
        unitCode +=  uuid.toString().toUpperCase().substring(0, 6);
        return unitCode;
    }
}
