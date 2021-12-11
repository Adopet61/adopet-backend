package adopet.project.dataAccess.abstracts;

import adopet.project.entities.concretes.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalDao  extends JpaRepository<Animal, Integer> {
    List<Animal> getByGender(String gender);
    List<Animal> getByYearOfBirth(int yearOfBirth);
    List<Animal> getByInfertilityStatus(String infertilityStatus);

    List<Animal> getByAnimalNameContains(String animalName);
    List<Animal> getByAnimalNameStartsWith(String animalName);
}
