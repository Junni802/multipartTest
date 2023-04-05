package upload.multipart.fileupload.service;

import jakarta.servlet.http.Part;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

/**
 * upload.multipart.fileupload.service MultipartService
 *
 * @author : junhyuk Park
 * @date : 2023.03.09
 * @tags :
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class MultipartService {

  @Value("${file.dir}")
  private String fileDir;

  public void uploadDirFile(List<MultipartFile> multipartFiles, List<String> filename) throws IOException {
    for (MultipartFile multipartFile : multipartFiles) {
      String fileType = getFileType(multipartFile);
      Path path = Paths.get(fileDir + filename.get(multipartFiles.indexOf(multipartFile)) + fileType);

      log.info("==== Multopart Start ====");
      log.info("multipartFile.getName={}", multipartFile.getName());
      log.info("multipartFile.getContentType={}", multipartFile.getContentType());
      log.info("multipartFile.getOriginalFilename={}", multipartFile.getOriginalFilename());
      log.info("multipartFile.getResource={}", multipartFile.getResource());


//      Files.copy(multipartFile.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
      multipartFile.transferTo(path);
    }
  }

  public String getFileType(MultipartFile multipartFile) {
    return multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().indexOf("."));
  }

}
