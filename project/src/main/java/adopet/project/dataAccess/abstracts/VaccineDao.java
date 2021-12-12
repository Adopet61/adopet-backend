package adopet.project.dataAccess.abstracts;

import adopet.project.entities.concretes.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VaccineDao extends JpaRepository<Vaccine, Integer> {
    List<Vaccine> getByVaccineId(int vaccineId);
}
