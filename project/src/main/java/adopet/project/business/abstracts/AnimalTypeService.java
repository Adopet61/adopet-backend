package adopet.project.business.abstracts;

import adopet.project.core.utilities.results.DataResult;
import adopet.project.entities.concretes.AnimalType;

import java.util.List;

public interface AnimalTypeService extends BaseEntityService<AnimalType>{
    DataResult<List<AnimalType>> getByTypeId(int typeId);
}
