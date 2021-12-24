package adopet.project.business.abstracts;

import adopet.project.core.utilities.results.Result;
import adopet.project.entities.concretes.AnimalVaccine;

public interface AnimalVaccineService extends BaseEntityService<AnimalVaccine>{
    Result delete(int animalVaccineId);
}
