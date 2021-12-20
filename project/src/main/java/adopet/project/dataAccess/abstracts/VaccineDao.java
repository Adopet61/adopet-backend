package adopet.project.dataAccess.abstracts;

import adopet.project.entities.concretes.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccineDao extends JpaRepository<Vaccine, Integer> {
    Vaccine getByVaccineId(int vaccineId);
}
