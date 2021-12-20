package adopet.project.business.abstracts;

import adopet.project.core.utilities.results.DataResult;
import adopet.project.entities.concretes.Vaccine;

public interface VaccineService extends BaseEntityService<Vaccine>{
    DataResult<Vaccine> getByVaccineId(int vaccineId);
}
