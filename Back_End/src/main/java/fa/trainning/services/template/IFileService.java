package fa.trainning.services.template;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public interface IFileService {
    String uploadFile(File file, String fileName)throws IOException;
    File convertToFile(MultipartFile multipartFile, String fileName) throws IOException;
    String getExtension(String fileName);
    Object uploadFile(MultipartFile multipartFile);
}
