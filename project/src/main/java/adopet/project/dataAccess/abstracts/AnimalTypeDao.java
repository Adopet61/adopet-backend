package adopet.project.dataAccess.abstracts;

import adopet.project.entities.concretes.AnimalType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalTypeDao extends JpaRepository<AnimalType, Integer> {
    AnimalType getByTypeId(int typeId);
}
