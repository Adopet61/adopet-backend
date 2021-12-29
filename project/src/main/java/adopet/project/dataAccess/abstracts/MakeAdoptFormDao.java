package adopet.project.dataAccess.abstracts;

import adopet.project.entities.forms.MakeAdoptForm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MakeAdoptFormDao extends JpaRepository<MakeAdoptForm,Integer> {
    List<MakeAdoptForm> getByFirstName(String firstName);
    List<MakeAdoptForm> getByLastName(String lastName);
    List<MakeAdoptForm> getByPhoneNumber(String phoneNumber);
    List<MakeAdoptForm> getByEmail(String email);
    List<MakeAdoptForm> getByAnimalName(String animalName);
    List<MakeAdoptForm> getByAnimalType(String animalType);
    List<MakeAdoptForm> getByAnimalBreed(String animalBreed);
    List<MakeAdoptForm> getByVaccine(String vaccine);
    List<MakeAdoptForm> getByYearOfBirth(int yearOfBirth);
    List<MakeAdoptForm> getByAnimalSex(String animalSex);
    List<MakeAdoptForm> getByBarren(boolean barren);
    List<MakeAdoptForm> getByImageUrl(String imageUrl);

}
