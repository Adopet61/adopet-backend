package adopet.project.business.abstracts;

import adopet.project.core.utilities.results.DataResult;
import adopet.project.core.utilities.results.Result;
import adopet.project.entities.concretes.Image;
import adopet.project.entities.dtos.AnimalWithImageDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageService {
    DataResult<List<Image>> getAll();
    DataResult<Image> getByImageId(int imageId);
    DataResult<Image> getByAnimal_AnimalId(int animalId);
    DataResult<List<AnimalWithImageDto>> getAnimalWithImageUrl();
    DataResult<List<AnimalWithImageDto>> getAnimalWithImageUrlByAnimal_AnimalType_TypeId(int typeId);
    Result upload(int animalId, MultipartFile file);
    Result add(Image image);
    Result delete(int imageId);
}