package adopet.project.business.concretes;

import adopet.project.business.abstracts.AnimalService;
import adopet.project.core.utilities.results.DataResult;
import adopet.project.core.utilities.results.SuccessDataResult;
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
    public DataResult<List<Animal>> getAll() {
        return new SuccessDataResult<List<Animal>>(this.animalDao.findAll(), "Data listelendi");
    }

    @Override
    public DataResult<Animal> getById(int animalId) {
        return new SuccessDataResult<Animal>(this.animalDao.getById(animalId),"animalId'ye göre data listelendi");
    }

    @Override
    public DataResult<List<Animal>> getByGender(String gender) {
        return new SuccessDataResult<List<Animal>>
                (this.animalDao.getByGender(gender),"Cinsiyete göre data listelendi");
    }

    @Override
    public DataResult<List<Animal>> getByYearOfBirth(int yearOfBirth) {
        return new SuccessDataResult<List<Animal>>
                (this.animalDao.getByYearOfBirth(yearOfBirth),"Doğum yılına göre listelendi");
    }

    @Override
    public DataResult<List<Animal>> getByInfertilityStatus(String infertilityStatus) {
        return new SuccessDataResult<List<Animal>>
                (this.animalDao.getByInfertilityStatus(infertilityStatus), "Kısırlık durumuna göre listelendi");
    }
}
