package fa.trainning.controller;

import fa.trainning.dto.request.forcreate.CSyllabus;
import fa.trainning.dto.request.forcreate.draft.CSyllabusDraft;
import fa.trainning.dto.response.fordetail.DResponseSyllabus;
import fa.trainning.entities.Syllabus;
import fa.trainning.entities.draft.SyllabusDraft;
import fa.trainning.services.draft_services.template.ISyllabusDraftService;
import fa.trainning.services.template.IFileService;
import fa.trainning.services.template.ISyllabusService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Date;
import java.util.List;

@Api(tags = "Syllabus", description = "Syllabus's API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/syllabus")
public class SyllabusController {
    @Autowired
    private ISyllabusService syllabusService;
    @Autowired
    private ISyllabusDraftService syllabusDraftService;
    @Autowired
    private IFileService fileService;
    @RequestMapping(value = "/create-syllabus", method = RequestMethod.POST)
    public ResponseEntity<Object> createSyllabus(@Valid @RequestBody CSyllabus syllabusDTO) {
        Syllabus result = syllabusService.createSyllabus(syllabusDTO);
        return ResponseEntity.ok().body(result);
    }
    @RequestMapping(value = "/create-syllabus-draft", method = RequestMethod.POST)
    public ResponseEntity<Object> createSyllabusDraft(@Valid @RequestBody CSyllabusDraft syllabusDTO) {
        SyllabusDraft result = syllabusDraftService.createSyllabusDraft(syllabusDTO);
        return ResponseEntity.ok().body(result);
    }

    @RequestMapping(value = "/duplicate/{topicCode}", method = RequestMethod.GET)
    public ResponseEntity<List<DResponseSyllabus>> duplicateSyllabus(@PathVariable("topicCode") String topicCode) {
        List<DResponseSyllabus> syllabus = syllabusService.getSyllabus(topicCode);
        return ResponseEntity.ok().body(syllabus);
    }
    @RequestMapping(value = "/search/{letter}", method = RequestMethod.GET)
    public ResponseEntity<List<String>> searchSyllabus(@PathVariable("letter") String letter) {
        List<String> syllabusGeneral = syllabusService.getTopicName(letter);
        return ResponseEntity.ok().body(syllabusGeneral);
    }

    @RequestMapping(value = "/search/",method = RequestMethod.POST)
    private ResponseEntity<Object> search(@Valid @RequestBody String keyword) {
        List<Syllabus> list = syllabusService.searchByKeyword(keyword);
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value = "/searchByCreatedDate/",method = RequestMethod.POST)
    private ResponseEntity<Object> searchByCreatedDate(@Valid @RequestBody Date createdDate) {
        List<Syllabus> list = syllabusService.findSyllabusByCreateDate((java.sql.Date) createdDate);
        return ResponseEntity.ok().body(list);
    }
}
