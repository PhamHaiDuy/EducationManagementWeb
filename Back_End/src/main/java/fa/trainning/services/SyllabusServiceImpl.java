package fa.trainning.services;

import fa.trainning.dto.request.forcreate.*;
import fa.trainning.dto.response.fordetail.DResponseSyllabus;
import fa.trainning.entities.*;
import fa.trainning.entities.Enums.SyllabusPublishStatus;
import fa.trainning.repositories.SyllabusRepository;
import fa.trainning.repositories.UserRepository;
import fa.trainning.services.template.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class SyllabusServiceImpl implements ISyllabusService {
    @Autowired
    private SyllabusRepository syllabusRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ILearningObjectiveService learningObjectiveService;
    @Autowired
    private ISyllabusObjectiveService syllabusObjectiveService;
    @Autowired
    private ITrainingUnitService trainingUnitService;
    @Autowired
    private ITrainingContentService trainingContentService;
    @Autowired
    private IAssessmentSchemeService assessmentSchemeService;
    @Autowired
    private ITrainingMaterialService trainingMaterialService;
    @Override
    public Syllabus createSyllabus(CSyllabus syllabusDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String createdByEmail = authentication.getName();
        User userCreated = userRepository.findByEmail(createdByEmail);
        Syllabus syllabus = modelMapper.map(syllabusDTO,Syllabus.class);

        syllabus.setCreateDate(LocalDateTime.now());
        syllabus.setCreatedBy(userCreated);
        syllabus.setPublishStatus(SyllabusPublishStatus.ACTIVE);

        // get list learning objective
        Set<String> syllabusObjectiveList = syllabusDTO.getSyllabusObjectives();

        // create new set syllabus objective for saving to database
        Set<SyllabusObjective> syllabusObjectivesSet = new HashSet<>();
        for(String s: syllabusObjectiveList) {
            LearningObjective learningObjective = learningObjectiveService.findLearningObjectiveByCode(s);
            SyllabusObjective syllabusObjective = new SyllabusObjective(syllabus, learningObjective);
            syllabusObjectivesSet.add(syllabusObjective);
        }

        // save syllabus first to have syllabus code
        Syllabus result = syllabusRepository.save(syllabus);

        syllabusObjectiveService.addListSyllabusObjective(syllabusObjectivesSet);

        // outline screen

        // get list training unit
        Set<CTrainingUnit> cTrainingUnitSet = syllabusDTO.getTrainingUnits();
        Set<TrainingUnit> trainingUnitSet = new HashSet<>();

        // list training content
        Set<TrainingContent> trainingContentSet = new HashSet<>();
        // Add new Training unit
        for(CTrainingUnit c : cTrainingUnitSet) {
            String unitCode = autoCreateUnitCode(c.getUnitName());
            TrainingUnit trainingUnit = new TrainingUnit(unitCode,c.getUnitName(),c.getDayNumber(),syllabus);
            trainingUnitSet.add(trainingUnit);
        }

        // save list to database
        trainingUnitService.addListTrainingUnit(trainingUnitSet,trainingContentSet,cTrainingUnitSet);

        //other screen
        CAssessmentScheme cAssessmentScheme = syllabusDTO.getAssessmentScheme();
        AssessmentScheme assessmentScheme = new AssessmentScheme(syllabus, cAssessmentScheme);

        //save assessment scheme
        assessmentSchemeService.addAssessmentSchemeService(assessmentScheme);

        // save training material
        List<CTrainingMaterial> listTraining = syllabusDTO.getTrainingMaterials();
        trainingMaterialService.createTrainingMaterial(syllabus,listTraining);

        return result;
    }
    public static String autoCreateUnitCode(String unitName) {
        String unitCode = "UNIT-";
        UUID uuid = UUID.randomUUID();
        unitCode +=  uuid.toString().toUpperCase().substring(0, 6);
        return unitCode;
    }
    public List<DResponseSyllabus> getSyllabus(String topicCode){
        List<DResponseSyllabus> syllabusGenerals = syllabusRepository.findByTopicCode(topicCode);
        return syllabusGenerals;
    }

    public List<String> getTopicName(String letter) {
        List<String> topicName = syllabusRepository.findTopicNameByTopicCodeOrTopicName(letter);
        return topicName;
    }
    @Transactional
    public List<Syllabus> searchByKeyword(String keyword) {
        return syllabusRepository.findByKeyword(keyword);
    }

    @Transactional
    public List<Syllabus> findSyllabusByCreateDate(Date createDate){
        return syllabusRepository.findSyllabusByCreateDate(createDate);
    }
}
