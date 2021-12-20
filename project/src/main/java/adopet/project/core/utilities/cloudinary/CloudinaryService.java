package adopet.project.core.utilities.cloudinary;

import adopet.project.core.utilities.results.DataResult;
import org.springframework.web.multipart.MultipartFile;

public interface CloudinaryService {
    DataResult<?> upload(MultipartFile multipartFile);
    DataResult<?> delete(String publicIdOfImage);
}
