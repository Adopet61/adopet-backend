package adopet.project.business.abstracts;

import adopet.project.core.utilities.results.DataResult;
import adopet.project.entities.concretes.AnimalType;

import java.util.List;

public interface AnimalTypeService {
    DataResult<List<AnimalType>> getAll();
    DataResult<List<AnimalType>> getByTypeId(int typeId);
}
