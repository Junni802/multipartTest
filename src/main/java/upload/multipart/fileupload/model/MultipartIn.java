package upload.multipart.fileupload.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

/**
 * upload.multipart.fileupload.model MultipartIn
 *
 * @author : junhyuk Park
 * @date : 2023.03.09
 * @tags :
 */

@Getter
@Setter
@NoArgsConstructor
public class MultipartIn {

  private MultipartFile multipartFile;

  private String filename;

}
