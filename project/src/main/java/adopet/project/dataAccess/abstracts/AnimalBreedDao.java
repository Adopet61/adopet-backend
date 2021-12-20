package adopet.project.dataAccess.abstracts;

import adopet.project.entities.concretes.AnimalBreed;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalBreedDao extends JpaRepository<AnimalBreed, Integer> {
    AnimalBreed getByBreedId(int breedId);
    List<AnimalBreed> getByAnimalType_TypeId(int typeId);
}
