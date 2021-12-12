package adopet.project.dataAccess.abstracts;

import adopet.project.entities.concretes.AnimalVaccine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalVaccineDao extends JpaRepository<AnimalVaccine, Integer> {
}
