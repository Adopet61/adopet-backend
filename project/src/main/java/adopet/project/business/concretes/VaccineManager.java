package adopet.project.business.concretes;

import adopet.project.business.abstracts.VaccineService;
import adopet.project.core.utilities.results.DataResult;
import adopet.project.core.utilities.results.ErrorDataResult;
import adopet.project.core.utilities.results.SuccessDataResult;
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
    public DataResult<List<Vaccine>> getByVaccineId(int vaccineId) {
        if (this.vaccineDao.getByVaccineId(vaccineId).isEmpty()) {
            return new ErrorDataResult<List<Vaccine>>("Girdiğiniz sayıda aşı yoktur");
        }else {
            return new SuccessDataResult<List<Vaccine>>
                    (this.vaccineDao.getByVaccineId(vaccineId), "Id'sine göre aşı listelendi");
        }
    }
}
