package fa.trainning.services;

import fa.trainning.entities.SyllabusObjective;
import fa.trainning.repositories.SyllabusObjectiveRepository;
import fa.trainning.services.template.ISyllabusObjectiveService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SyllabusObjectiveServiceImpl implements ISyllabusObjectiveService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private SyllabusObjectiveRepository syllabusObjectiveRepository;
    @Override
    public void addSyllabusObjective(SyllabusObjective syllabusObjective) {
        syllabusObjectiveRepository.save(syllabusObjective);
    }

    @Override
    public void addListSyllabusObjective(Set<SyllabusObjective> syllabusObjectiveSet) {
        for(SyllabusObjective s : syllabusObjectiveSet) {
            syllabusObjectiveRepository.save(s);
        }
    }
}
