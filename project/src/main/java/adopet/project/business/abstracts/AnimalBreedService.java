package adopet.project.business.abstracts;

import adopet.project.core.utilities.results.DataResult;
import adopet.project.core.utilities.results.Result;
import adopet.project.entities.concretes.AnimalBreed;

import java.util.List;

public interface AnimalBreedService extends BaseEntityService<AnimalBreed>{
    DataResult<AnimalBreed> getByBreedId(int breedId);
    DataResult<List<AnimalBreed>> getByAnimalType_TypeId(int typeId);
    Result delete(int breedId);
}
