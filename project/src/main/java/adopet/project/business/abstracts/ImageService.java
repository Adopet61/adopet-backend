package adopet.project.business.abstracts;

import adopet.project.core.utilities.results.DataResult;
import adopet.project.core.utilities.results.Result;
import adopet.project.entities.concretes.Image;
import adopet.project.entities.dtos.AnimalWithImageDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageService extends BaseEntityService<Image>{
    DataResult<Image> getByImageId(int imageId);
    DataResult<List<AnimalWithImageDto>> getAnimalWithImageUrl();
    Result upload(int animalId, MultipartFile file);
    Result add(Image image);
    Result delete(int imageId);
}