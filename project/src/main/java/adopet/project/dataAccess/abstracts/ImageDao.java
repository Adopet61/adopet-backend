package adopet.project.dataAccess.abstracts;

import adopet.project.entities.concretes.Image;
import adopet.project.entities.dtos.AnimalWithImageDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ImageDao extends JpaRepository<Image, Integer> {
    Image getByImageId(int imageId);

    @Query("Select new adopet.project.entities.dtos.AnimalWithImageDto(a.animalId, a.animalName, i.url) From Image i Inner Join i.animal a")
    List<AnimalWithImageDto> getAnimalWithImageUrl();
}
