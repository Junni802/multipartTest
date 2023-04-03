package upload.multipart.fileupload.repository;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * upload.multipart.fileupload.repository MultipartRepository
 *
 * @author : junhyuk Park
 * @date : 2023.03.09
 * @tags :
 */

@Getter
@Setter
@NoArgsConstructor
public class MultipartRepository {

  private Map<Long, String> map;

  Long sequence = 0L;

}
