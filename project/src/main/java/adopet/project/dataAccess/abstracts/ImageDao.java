package adopet.project.dataAccess.abstracts;

import adopet.project.entities.concretes.Image;
import adopet.project.entities.dtos.AnimalWithImageDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ImageDao extends JpaRepository<Image, Integer> {
    Image getByImageId(int imageId);
    Image getByAnimal_AnimalId(int animalId);

    //DTO işlemlerinde hayvan ve resim bilgilerini birlikte göstermek için yazılan sorgu
    @Query("Select new adopet.project.entities.dtos.AnimalWithImageDto(a.animalId, a.animalName, a.animalType.typeId, a.animalType.typeName, a.animalBreed.breedName, i.url) From Image i Inner Join i.animal a")
    List<AnimalWithImageDto> getAnimalWithImageUrl();

    //Hayvan ve resim bilgilerini hayvan türlerine göre getirme işlemi yapmak için yazılan sorgu
    @Query("Select new adopet.project.entities.dtos.AnimalWithImageDto(a.animalId, a.animalName, a.animalType.typeId, a.animalType.typeName, a.animalBreed.breedName, i.url) From Image i Inner Join i.animal a where a.animalType.typeId=:typeId")
    List<AnimalWithImageDto> getAnimalWithImageUrlByAnimal_AnimalType_TypeId(int typeId);
}
