package fa.trainning.controller;

import fa.trainning.dto.response.forlist.LResponseTrainingUnit;
import fa.trainning.dto.response.forlist.LResponseUserPermission;
import fa.trainning.services.template.ITrainingUnitService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "TrainingUnit", description = "TrainingUnit API's")
@RestController
@RequestMapping("/training-unit")
public class TrainingUnitController {
    @Autowired
    private ITrainingUnitService trainingUnitService;
    @RequestMapping(value = "/get-all", method = RequestMethod.GET)
    public ResponseEntity<List<LResponseTrainingUnit>> getAllTrainingUnit(Model model) {
        List<LResponseTrainingUnit> trainingUnits = trainingUnitService.findAllBy();
        return ResponseEntity.ok().body(trainingUnits);
    }
}
