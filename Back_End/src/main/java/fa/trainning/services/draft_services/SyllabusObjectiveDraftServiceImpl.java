package fa.trainning.services.draft_services;

import fa.trainning.entities.SyllabusObjective;
import fa.trainning.entities.draft.SyllabusObjectiveDraft;
import fa.trainning.repositories.draft.SyllabusObjectiveDraftRepository;
import fa.trainning.services.draft_services.template.ISyllabusObjectiveDraftService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SyllabusObjectiveDraftServiceImpl implements ISyllabusObjectiveDraftService {
    @Autowired
    private SyllabusObjectiveDraftRepository syllabusObjectiveDraftRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public void addSyllabusObjective(SyllabusObjectiveDraft syllabusObjectiveDraft) {
        syllabusObjectiveDraftRepository.save(syllabusObjectiveDraft);
    }

    @Override
    public void addListSyllabusDraftObjective(Set<SyllabusObjectiveDraft> syllabusObjectiveSet) {
        for(SyllabusObjectiveDraft s : syllabusObjectiveSet) {
            syllabusObjectiveDraftRepository.save(s);
        }
    }
}
