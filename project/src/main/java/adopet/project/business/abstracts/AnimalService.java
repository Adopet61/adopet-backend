package adopet.project.business.abstracts;

import adopet.project.entities.concretes.Animal;

import java.util.List;

public interface AnimalService {
    List<Animal> getAll();
}
