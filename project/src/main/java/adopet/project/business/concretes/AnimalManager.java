package adopet.project.business.concretes;

import adopet.project.business.abstracts.AnimalService;
import adopet.project.dataAccess.abstracts.AnimalDao;
import adopet.project.entities.concretes.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalManager implements AnimalService {

    private AnimalDao animalDao;

    @Autowired
    public AnimalManager(AnimalDao animalDao) {
        this.animalDao = animalDao;
    }

    @Override
    public List<Animal> getAll() {
        return this.animalDao.findAll();
    }

    @Override
    public Animal getById(int animalId) {
        return this.animalDao.getById(animalId);
    }
}
