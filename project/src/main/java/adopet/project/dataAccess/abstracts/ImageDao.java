package adopet.project.dataAccess.abstracts;

import adopet.project.entities.concretes.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageDao extends JpaRepository<Image, Integer> {
    List<Image> getByImageId(int imageId);
}
