package fa.trainning.services.template;

import fa.trainning.entities.SyllabusObjective;

import java.util.Set;

public interface ISyllabusObjectiveService {
    void addSyllabusObjective(SyllabusObjective syllabusObjective);
    void addListSyllabusObjective(Set<SyllabusObjective> syllabusObjectiveSet);
}
