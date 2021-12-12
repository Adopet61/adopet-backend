package adopet.project.business.concretes;

import adopet.project.business.abstracts.AnimalBreedService;
import adopet.project.core.utilities.results.DataResult;
import adopet.project.core.utilities.results.ErrorDataResult;
import adopet.project.core.utilities.results.SuccessDataResult;
import adopet.project.dataAccess.abstracts.AnimalBreedDao;
import adopet.project.entities.concretes.AnimalBreed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalBreedManager implements AnimalBreedService {

    private AnimalBreedDao animalBreedDao;

    @Autowired
    public AnimalBreedManager(AnimalBreedDao animalBreedDao) {
        this.animalBreedDao = animalBreedDao;
    }

    @Override
    public DataResult<List<AnimalBreed>> getAll() {
        return new SuccessDataResult<List<AnimalBreed>>
                (this.animalBreedDao.findAll(),"Irklar listelendi");
    }

    @Override
    public DataResult<List<AnimalBreed>> getByBreedId(int breedId) {
        if (this.animalBreedDao.getByBreedId(breedId).isEmpty()) {
            return new ErrorDataResult<List<AnimalBreed>>("Girdiğiniz sayıda hayvan ırkı yoktur");
        }else {
            return new SuccessDataResult<List<AnimalBreed>>
                    (this.animalBreedDao.getByBreedId(breedId), "Id'sine göre ırk listelendi");
        }
    }

    @Override
    public DataResult<List<AnimalBreed>> getByAnimalType_TypeId(int typeId) {
        if (this.animalBreedDao.getByAnimalType_TypeId(typeId).isEmpty()) {
            return new ErrorDataResult<List<AnimalBreed>>("Girdiğiniz sayıda hayvan türü yoktur");
        }else {
            return new SuccessDataResult<List<AnimalBreed>>
                    (this.animalBreedDao.getByAnimalType_TypeId(typeId), "Türüne göre ırklar listelendi");
        }
    }
}
