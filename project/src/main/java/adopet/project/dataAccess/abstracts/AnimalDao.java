package adopet.project.dataAccess.abstracts;

import adopet.project.entities.concretes.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalDao  extends JpaRepository<Animal, Integer> {
}
