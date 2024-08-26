package fa.trainning.controller;

import fa.trainning.dto.request.forcreate.CLearningObjective;
import fa.trainning.entities.LearningObjective;
import fa.trainning.services.template.ILearningObjectiveService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(tags = "ADMIN", description = "Learning Objective API's")
@RestController
@RequestMapping("/learning-objective")
public class LearningObjectiveController {
    @Autowired
    private ILearningObjectiveService learningObjective;
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Object> addLearningObjective(@Valid @RequestBody CLearningObjective learningObjectiveDTO) {
        LearningObjective result =  learningObjective.addLearningObjective(learningObjectiveDTO);
        return ResponseEntity.ok().body(result);
    }
}
