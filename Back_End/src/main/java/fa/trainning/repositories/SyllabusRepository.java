package fa.trainning.repositories;

import fa.trainning.dto.response.fordetail.DResponseSyllabus;
import fa.trainning.entities.Syllabus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface SyllabusRepository extends JpaRepository<Syllabus, String> {
    @Query("select s " +
            "from Syllabus s " +
            "where s.topicCode = :topicCode")
    List<DResponseSyllabus> findByTopicCode(@Param("topicCode") String topicCode);

    @Query("select s.topicName from Syllabus s where s.topicCode like concat('%',:letter,'%') or s.topicName like concat('%',:letter,'%')")
    List<String> findTopicNameByTopicCodeOrTopicName(@Param("letter")String letter);

//    Syllabus findByTopicCode(String topicCode);

    @Query("SELECT s FROM Syllabus s WHERE s.topicCode = :keyword OR s.topicName =:keyword")
    List<Syllabus> findByKeyword(@Param("keyword") String keyword );

    @Query("SELECT s FROM Syllabus s WHERE DATE(s.createDate) = DATE(:createDate)")
    List<Syllabus> findSyllabusByCreateDate(@Param("createDate") Date createDate);
}
