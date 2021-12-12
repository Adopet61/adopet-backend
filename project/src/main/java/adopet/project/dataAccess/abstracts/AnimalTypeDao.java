package adopet.project.dataAccess.abstracts;

import adopet.project.entities.concretes.AnimalType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalTypeDao extends JpaRepository<AnimalType, Integer> {
    List<AnimalType> getByTypeId(int typeId);
}
