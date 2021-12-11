package adopet.project.business.abstracts;

import adopet.project.core.utilities.results.DataResult;
import adopet.project.entities.concretes.Animal;

import java.util.List;

public interface AnimalService {
    DataResult<List<Animal>> getAll();
    DataResult<Animal> getById(int animalId);

    DataResult<List<Animal>> getByGender(String gender);
    DataResult<List<Animal>> getByYearOfBirth(int yearOfBirth);
    DataResult<List<Animal>> getByInfertilityStatus(String infertilityStatus);
}
