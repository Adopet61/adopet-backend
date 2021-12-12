package adopet.project.business.concretes;

import adopet.project.business.abstracts.AnimalVaccineService;
import adopet.project.core.utilities.results.DataResult;
import adopet.project.core.utilities.results.SuccessDataResult;
import adopet.project.dataAccess.abstracts.AnimalVaccineDao;
import adopet.project.entities.concretes.AnimalVaccine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalVaccineManager implements AnimalVaccineService {

    private AnimalVaccineDao animalVaccineDao;

    @Autowired
    public AnimalVaccineManager(AnimalVaccineDao animalVaccineDao) {
        this.animalVaccineDao = animalVaccineDao;
    }


    @Override
    public DataResult<List<AnimalVaccine>> getAll() {
        return new SuccessDataResult<List<AnimalVaccine>>
                (this.animalVaccineDao.findAll(), "Hayvanlar ve yapıldıkları aşılar listelendi");
    }
}
