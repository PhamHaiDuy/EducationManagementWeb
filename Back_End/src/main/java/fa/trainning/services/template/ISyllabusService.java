package fa.trainning.services.template;

import fa.trainning.dto.request.forcreate.CSyllabus;
import fa.trainning.dto.response.fordetail.DResponseSyllabus;
import fa.trainning.entities.Syllabus;

import java.sql.Date;
import java.util.List;

public interface ISyllabusService {
    Syllabus createSyllabus(CSyllabus syllabusDTO);
    List<DResponseSyllabus> getSyllabus(String topicCode);
    List<String> getTopicName(String letter);
    public List<Syllabus> searchByKeyword(String keyword);
    public List<Syllabus> findSyllabusByCreateDate(Date createDate);
}
