package adopet.project.business.concretes;

import adopet.project.business.abstracts.MakeAdoptFormService;
import adopet.project.core.utilities.results.DataResult;
import adopet.project.core.utilities.results.Result;
import adopet.project.core.utilities.results.SuccessDataResult;
import adopet.project.core.utilities.results.SuccessResult;
import adopet.project.dataAccess.abstracts.MakeAdoptFormDao;
import adopet.project.entities.forms.MakeAdoptForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MakeAdoptFormManager implements MakeAdoptFormService {

    private MakeAdoptFormDao makeAdoptFormDao;

    @Autowired
    public MakeAdoptFormManager(MakeAdoptFormDao makeAdoptFormDao) {
        super();
        this.makeAdoptFormDao = makeAdoptFormDao;
    }

    @Override
    public DataResult<List<MakeAdoptForm>> getAll() {
        return new SuccessDataResult<List<MakeAdoptForm>>(this.makeAdoptFormDao.findAll(),"Data listelendi");
    }

    @Override
    public Result add(MakeAdoptForm makeAdoptForm) {
        this.makeAdoptFormDao.save(makeAdoptForm);
        return new SuccessResult("Form eklendi");
    }

    @Override
    public Result delete(int id){
        this.makeAdoptFormDao.deleteById(id);
        return new SuccessResult("Form silindi");
    }

    @Override
    public DataResult<List<MakeAdoptForm>> getByFirstName(String firstName) {
        return new SuccessDataResult<List<MakeAdoptForm>>(this.makeAdoptFormDao.getByFirstName(firstName),"Data listelendi");
    }

    @Override
    public DataResult<List<MakeAdoptForm>> getByLastName(String lastName) {
        return new SuccessDataResult<List<MakeAdoptForm>>(this.makeAdoptFormDao.getByLastName(lastName),"Data listelendi");
    }

    @Override
    public DataResult<List<MakeAdoptForm>> getByPhoneNumber(String phoneNumber) {
        //kısıtlamalar buraya yazılacak
        return new SuccessDataResult<List<MakeAdoptForm>>(this.makeAdoptFormDao.getByPhoneNumber(phoneNumber),"Data listelendi");
    }

    @Override
    public DataResult<List<MakeAdoptForm>> getByEmail(String email) {
        return new SuccessDataResult<List<MakeAdoptForm>>(this.makeAdoptFormDao.getByEmail(email),"Data listelendi");
    }

    @Override
    public DataResult<List<MakeAdoptForm>> getByAnimalName(String animalName) {
        return new SuccessDataResult<List<MakeAdoptForm>>(this.makeAdoptFormDao.getByAnimalName(animalName),"Data listelendi");
    }

    @Override
    public DataResult<List<MakeAdoptForm>> getByAnimalType(String animalType) {
        return new SuccessDataResult<List<MakeAdoptForm>>(this.makeAdoptFormDao.getByAnimalType(animalType),"Data listelendi");
    }

    @Override
    public DataResult<List<MakeAdoptForm>> getByAnimalBreed(String animalBreed) {
        return new SuccessDataResult<List<MakeAdoptForm>>(this.makeAdoptFormDao.getByAnimalBreed(animalBreed),"Data listelendi");
    }

    @Override
    public DataResult<List<MakeAdoptForm>> getByVaccine(String vaccine) {
        return new SuccessDataResult<List<MakeAdoptForm>>(this.makeAdoptFormDao.getByVaccine(vaccine),"Data listelendi");
    }

    @Override
    public DataResult<List<MakeAdoptForm>> getByYearOfBirth(int yearOfBirth) {
        return new SuccessDataResult<List<MakeAdoptForm>>(this.makeAdoptFormDao.getByYearOfBirth(yearOfBirth),"Data listelendi");
    }

    @Override
    public DataResult<List<MakeAdoptForm>> getByAnimalSex(String animalSex) {
        return new SuccessDataResult<List<MakeAdoptForm>>(this.makeAdoptFormDao.getByAnimalSex(animalSex),"Data listelendi");
    }

    @Override
    public DataResult<List<MakeAdoptForm>> getByBarren(boolean barren) {
        return new SuccessDataResult<List<MakeAdoptForm>>(this.makeAdoptFormDao.getByBarren(barren),"Data listelendi");
    }

    @Override
    public DataResult<List<MakeAdoptForm>> getByImageUrl(String imageUrl) {
        return new SuccessDataResult<List<MakeAdoptForm>>(this.makeAdoptFormDao.getByImageUrl(imageUrl),"Data listelendi");
    }
}
