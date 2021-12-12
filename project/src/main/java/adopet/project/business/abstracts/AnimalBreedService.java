package adopet.project.business.abstracts;

import adopet.project.core.utilities.results.DataResult;
import adopet.project.entities.concretes.AnimalBreed;

import java.util.List;

public interface AnimalBreedService {
    DataResult<List<AnimalBreed>> getAll();
    DataResult<List<AnimalBreed>> getByBreedId(int breedId);
    DataResult<List<AnimalBreed>> getByAnimalType_TypeId(int typeId);
}
