package adopet.project.business.abstracts;

import adopet.project.core.utilities.results.DataResult;
import adopet.project.entities.concretes.Image;
import adopet.project.entities.dtos.AnimalWithImageDto;

import java.util.List;

public interface ImageService extends BaseEntityService<Image>{
    DataResult<List<Image>> getByImageId(int imageId);
    DataResult<List<AnimalWithImageDto>> getAnimalWithImageUrl();
}
