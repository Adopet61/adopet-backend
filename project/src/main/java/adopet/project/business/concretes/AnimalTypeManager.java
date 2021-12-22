package adopet.project.business.concretes;

import adopet.project.business.abstracts.AnimalTypeService;
import adopet.project.core.utilities.results.*;
import adopet.project.dataAccess.abstracts.AnimalTypeDao;
import adopet.project.entities.concretes.AnimalType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalTypeManager implements AnimalTypeService {

    private AnimalTypeDao animalTypeDao;

    @Autowired
    public AnimalTypeManager(AnimalTypeDao animalTypeDao) {
        this.animalTypeDao = animalTypeDao;
    }

    @Override
    public DataResult<List<AnimalType>> getAll() {
        return new SuccessDataResult<List<AnimalType>>
                (this.animalTypeDao.findAll(),"Hayvan türleri listelendi");
    }

    @Override
    public DataResult<AnimalType> getByTypeId(int typeId) {
        if (this.animalTypeDao.findById(typeId).isEmpty()) {
            return new ErrorDataResult<AnimalType>("Girdiğiniz sayıda hayvan türü yoktur");
        }else {
            return new SuccessDataResult<AnimalType>
                    (this.animalTypeDao.getByTypeId(typeId), "Id'sine göre tür listelendi");
        }
    }
    @Override
    public Result add(AnimalType animalType) {
        this.animalTypeDao.save(animalType);
        return new SuccessResult("Tür eklendi");
    }
}
