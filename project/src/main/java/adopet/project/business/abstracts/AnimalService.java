package adopet.project.business.abstracts;

import adopet.project.core.utilities.results.DataResult;
import adopet.project.entities.concretes.Animal;

import java.util.List;

public interface AnimalService extends BaseEntityService<Animal>{
    DataResult<Animal> getById(int animalId);
    DataResult<List<Animal>> getAllSorted();
    DataResult<List<Animal>> getAll(int pageNo, int pageSize);

    DataResult<List<Animal>> getByGender(String gender);
    DataResult<List<Animal>> getByYearOfBirth(int yearOfBirth);
    DataResult<List<Animal>> getByInfertilityStatus(String infertilityStatus);

    DataResult<List<Animal>> getByAnimalNameContains(String animalName);
    DataResult<List<Animal>> getByAnimalNameStartsWith(String animalName);

    DataResult<List<Animal>> getByAnimalBreed_AnimalType_TypeId(int typeId);
    DataResult<List<Animal>> getByAnimalBreed_BreedId(int breedId);
}
