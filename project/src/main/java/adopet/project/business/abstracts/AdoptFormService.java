package adopet.project.business.abstracts;

import adopet.project.core.utilities.results.DataResult;
import adopet.project.core.utilities.results.Result;
import adopet.project.entities.forms.AdoptForm;
import java.util.List;

public interface AdoptFormService {
    DataResult<List<AdoptForm>> getAll();
    Result add(AdoptForm adoptForm);

    DataResult<List<AdoptForm>> getByFirstName(String firstName);
    DataResult<List<AdoptForm>> getByLastName(String lastName);
    DataResult<List<AdoptForm>> getByPhoneNumber(String phoneNumber);
    DataResult<List<AdoptForm>> getByEmail(String email);
    DataResult<List<AdoptForm>> getByHaveAPet(boolean haveAPet);
    DataResult<List<AdoptForm>> getByComment(String comment);
}
