package adopet.project.business.abstracts;

import adopet.project.core.utilities.results.DataResult;
import adopet.project.entities.concretes.AnimalVaccine;

import java.util.List;

public interface AnimalVaccineService {
    DataResult<List<AnimalVaccine>> getAll();
}
