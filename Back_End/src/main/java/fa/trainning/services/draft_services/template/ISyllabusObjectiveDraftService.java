package fa.trainning.services.draft_services.template;

import fa.trainning.entities.SyllabusObjective;
import fa.trainning.entities.draft.SyllabusObjectiveDraft;

import java.util.Set;

public interface ISyllabusObjectiveDraftService {
    void addSyllabusObjective(SyllabusObjectiveDraft syllabusObjectiveDraft);
    void addListSyllabusDraftObjective(Set<SyllabusObjectiveDraft> syllabusObjectiveSet);
}
