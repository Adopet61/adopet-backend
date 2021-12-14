package adopet.project.business.abstracts;

import adopet.project.core.utilities.results.DataResult;
import adopet.project.entities.concretes.Vaccine;

import java.util.List;

public interface VaccineService extends BaseEntityService<Vaccine>{
    DataResult<List<Vaccine>> getByVaccineId(int vaccineId);
}
