package adopet.project.business.abstracts;

import adopet.project.core.utilities.results.DataResult;
import adopet.project.core.utilities.results.Result;
import adopet.project.entities.forms.MakeAdoptForm;
import java.util.List;

public interface MakeAdoptFormService {
    DataResult<List<MakeAdoptForm>> getAll();
    Result add(MakeAdoptForm makeAdoptForm);
    Result delete(int id);

    DataResult<List<MakeAdoptForm>> getByFirstName(String firstName);
    DataResult<List<MakeAdoptForm>> getByLastName(String lastName);
    DataResult<List<MakeAdoptForm>> getByPhoneNumber(String phoneNumber);
    DataResult<List<MakeAdoptForm>> getByEmail(String email);
    DataResult<List<MakeAdoptForm>> getByAnimalName(String animalName);
    DataResult<List<MakeAdoptForm>> getByAnimalType(String animalType);
    DataResult<List<MakeAdoptForm>> getByAnimalBreed(String animalBreed);
    DataResult<List<MakeAdoptForm>> getByVaccine(String vaccine);
    DataResult<List<MakeAdoptForm>> getByYearOfBirth(int yearOfBirth);
    DataResult<List<MakeAdoptForm>> getByAnimalSex(String animalSex);
    DataResult<List<MakeAdoptForm>> getByBarren(boolean barren);
    DataResult<List<MakeAdoptForm>> getByImageUrl(String imageUrl);
}
