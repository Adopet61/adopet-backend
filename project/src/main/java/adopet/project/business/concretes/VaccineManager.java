package adopet.project.business.concretes;

import adopet.project.business.abstracts.VaccineService;
import adopet.project.core.utilities.results.*;
import adopet.project.dataAccess.abstracts.VaccineDao;
import adopet.project.entities.concretes.Vaccine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaccineManager implements VaccineService {

    private VaccineDao vaccineDao;

    @Autowired
    public VaccineManager(VaccineDao vaccineDao) {
        this.vaccineDao = vaccineDao;
    }

    @Override
    public DataResult<List<Vaccine>> getAll() {
        return new SuccessDataResult<List<Vaccine>>(this.vaccineDao.findAll(),"Aşılar listelendi");
    }

    @Override
    public DataResult<Vaccine> getByVaccineId(int vaccineId) {
        if (this.vaccineDao.findById(vaccineId).isEmpty()) {
            return new ErrorDataResult<Vaccine>("Girdiğiniz sayıda aşı yoktur");
        }else {
            return new SuccessDataResult<Vaccine>
                    (this.vaccineDao.getByVaccineId(vaccineId), "Id'sine göre aşı listelendi");
        }
    }
    @Override
    public Result add(Vaccine vaccine) {
        this.vaccineDao.save(vaccine);
        return new SuccessResult("Aşı eklendi");
    }
}
