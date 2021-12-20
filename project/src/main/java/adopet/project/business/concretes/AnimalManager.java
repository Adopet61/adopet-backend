package adopet.project.business.concretes;

import adopet.project.business.abstracts.AnimalService;
import adopet.project.core.utilities.results.DataResult;
import adopet.project.core.utilities.results.ErrorDataResult;
import adopet.project.core.utilities.results.SuccessDataResult;
import adopet.project.dataAccess.abstracts.AnimalDao;
import adopet.project.entities.concretes.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
        if (this.animalDao.findById(animalId).isEmpty()){
            return new ErrorDataResult<Animal>("Bu Id'ye ait bir kayıt yoktur");
        }else {
            return new SuccessDataResult<Animal>(this.animalDao.getById(animalId), "animalId'ye göre data listelendi");
        }
    }

    @Override
    public DataResult<List<Animal>> getByGender(String gender) {
        if (this.animalDao.getByGender(gender).isEmpty()){
            return new ErrorDataResult<List<Animal>>("Cinsiyeti yanlış yazdınız. Male ya da Female olarak yazınız");
        }else {
            return new SuccessDataResult<List<Animal>>
                    (this.animalDao.getByGender(gender), "Cinsiyete göre data listelendi");
        }
    }

    @Override
    public DataResult<List<Animal>> getByYearOfBirth(int yearOfBirth) {
        if (this.animalDao.getByYearOfBirth(yearOfBirth).isEmpty()){
            return new ErrorDataResult<List<Animal>>("Bu yılda doğan kayıt yoktur");
        }else {
            return new SuccessDataResult<List<Animal>>
                    (this.animalDao.getByYearOfBirth(yearOfBirth), "Doğum yılına göre listelendi");
        }
    }

    @Override
    public DataResult<List<Animal>> getByInfertilityStatus(String infertilityStatus) {
        if (this.animalDao.getByInfertilityStatus(infertilityStatus).isEmpty()){
            return new ErrorDataResult<List<Animal>>
                    ("Kısırlık durumunu yanlış yazdınız. Kısır veya Kısır değil diyerek aratabilirsiniz");
        }else {
            return new SuccessDataResult<List<Animal>>
                    (this.animalDao.getByInfertilityStatus(infertilityStatus), "Kısırlık durumuna göre listelendi");
        }
    }

    @Override
    public DataResult<List<Animal>> getAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1, pageSize);
        return new SuccessDataResult<List<Animal>> (this.animalDao.findAll(pageable).getContent());
    }

    @Override
    public DataResult<List<Animal>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.DESC, "animalName");
        return new SuccessDataResult<List<Animal>>(this.animalDao.findAll(sort), "Başarılı");
    }

    @Override
    public DataResult<List<Animal>> getByAnimalNameContains(String animalName) {
        if (this.animalDao.getByAnimalNameContains(animalName).isEmpty()){
            return new ErrorDataResult<List<Animal>>("İçinde aradığınız kelime geçen veri yoktur");
        }else {
            return new SuccessDataResult<List<Animal>>
                    (this.animalDao.getByAnimalNameContains(animalName), "İçinde geçen kelimeye göre data listelendi");
        }
    }

    @Override
    public DataResult<List<Animal>> getByAnimalNameStartsWith(String animalName) {
        if (this.animalDao.getByAnimalNameStartsWith(animalName).isEmpty()) {
            return new ErrorDataResult<List<Animal>>("Adı yazdığınız kelime ile başlayan veri yoktur");
        }else {
            return new SuccessDataResult<List<Animal>>
                    (this.animalDao.getByAnimalNameStartsWith(animalName), "Adı yazdığınızla başlayan data listelendi");
        }
    }

    @Override
    public DataResult<List<Animal>> getByAnimalBreed_AnimalType_TypeId(int typeId) {
        if (this.animalDao.getByAnimalBreed_AnimalType_TypeId(typeId).isEmpty()) {
            return new ErrorDataResult<List<Animal>>("Girdiğiniz sayıda hayvan türü yoktur");
        }else {
            return new SuccessDataResult<List<Animal>>
                    (this.animalDao.getByAnimalBreed_AnimalType_TypeId(typeId), "Türüne göre hayvanlar listelendi");
        }
    }

    @Override
    public DataResult<List<Animal>> getByAnimalBreed_BreedId(int breedId) {
        if (this.animalDao.getByAnimalBreed_BreedId(breedId).isEmpty()) {
            return new ErrorDataResult<List<Animal>>("Girdiğiniz sayıdaki ırka ait hayvan kaydı yoktur");
        }else {
            return new SuccessDataResult<List<Animal>>
                    (this.animalDao.getByAnimalBreed_BreedId(breedId), "Irklara göre hayvanlar listelendi");
        }
    }
}
