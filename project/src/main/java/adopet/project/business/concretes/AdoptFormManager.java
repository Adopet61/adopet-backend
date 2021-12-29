package adopet.project.business.concretes;

import adopet.project.business.abstracts.AdoptFormService;
import adopet.project.core.utilities.results.DataResult;
import adopet.project.core.utilities.results.Result;
import adopet.project.core.utilities.results.SuccessDataResult;
import adopet.project.core.utilities.results.SuccessResult;
import adopet.project.dataAccess.abstracts.AdoptFormDao;
import adopet.project.entities.forms.AdoptForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdoptFormManager implements AdoptFormService {

    private AdoptFormDao adoptFormDao;

    @Autowired
    public AdoptFormManager(AdoptFormDao adoptFormDao) {
        super();
        this.adoptFormDao = adoptFormDao;
    }

    @Override
    public DataResult<List<AdoptForm>> getAll() {
        return new SuccessDataResult<List<AdoptForm>>(this.adoptFormDao.findAll(),"Data listelendi");
    }

    @Override
    public Result add(AdoptForm adoptForm) {
        this.adoptFormDao.save(adoptForm); //save ekleme ve güncelleme yapmaya yarar
        return new SuccessResult("Form eklendi");
    }

    @Override
    public DataResult<List<AdoptForm>> getByFirstName(String firstName) {
        return new SuccessDataResult<List<AdoptForm>>(this.adoptFormDao.getByFirstName(firstName),"Data listelendi");
    }

    @Override
    public DataResult<List<AdoptForm>> getByLastName(String lastName) {
        return new SuccessDataResult<List<AdoptForm>>(this.adoptFormDao.getByLastName(lastName),"Data listelendi");
    }

    @Override
    public DataResult<List<AdoptForm>> getByPhoneNumber(String phoneNumber) {
        return new SuccessDataResult<List<AdoptForm>>(this.adoptFormDao.getByPhoneNumber(phoneNumber),"Data listelendi");
    }

    @Override
    public DataResult<List<AdoptForm>> getByEmail(String email) {
        return new SuccessDataResult<List<AdoptForm>>(this.adoptFormDao.getByEmail(email),"Data listelendi");
    }

    @Override
    public DataResult<List<AdoptForm>> getByHaveAPet(boolean haveAPet) {
        return new SuccessDataResult<List<AdoptForm>>(this.adoptFormDao.getByHaveAPet(haveAPet),"Data listelendi");
    }

    @Override
    public DataResult<List<AdoptForm>> getByComment(String comment) {
        return new SuccessDataResult<List<AdoptForm>>(this.adoptFormDao.getByComment(comment),"Data listelendi");
    }
}
