package fa.trainning.controller;

import fa.trainning.services.template.IFileService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Api(tags = "ADMIN", description = "Syllabus's API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/file")
public class FileController {
    @Autowired
    private IFileService fileService;
    @PostMapping("/profile/pic")
    public Object upload(@RequestParam("file") MultipartFile multipartFile) {
        return fileService.uploadFile(multipartFile);
    }
}
