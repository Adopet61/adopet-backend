package adopet.project.business.abstracts;

import adopet.project.core.utilities.results.DataResult;
import adopet.project.entities.concretes.AnimalType;

public interface AnimalTypeService extends BaseEntityService<AnimalType>{
    DataResult<AnimalType> getByTypeId(int typeId);
}
