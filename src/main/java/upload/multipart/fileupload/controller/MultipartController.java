package upload.multipart.fileupload.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import upload.multipart.fileupload.service.MultipartService;

import java.io.IOException;
import java.util.List;

/**
 * upload.multipart.fileupload.controller MultipartController
 *
 * @author : junhyuk Park
 * @date : 2023.03.09
 * @tags :
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/fileupload")
public class MultipartController {

  private final MultipartService multipartService;

  @PostMapping(path = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  public void uploadFile(@RequestPart List<MultipartFile> multipartFiles,
    @RequestParam List<String> fileName) throws IOException {
    multipartService.uploadDirFile(multipartFiles, fileName);
  }

}
