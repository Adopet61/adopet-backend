package adopet.project.dataAccess.abstracts;

import adopet.project.entities.forms.AdoptForm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdoptFormDao extends JpaRepository<AdoptForm,Integer> {
    List<AdoptForm> getByFirstName(String firstName);
    List<AdoptForm> getByLastName(String lastName);
    List<AdoptForm> getByPhoneNumber(String phoneNumber);
    List<AdoptForm> getByEmail(String email);
    List<AdoptForm> getByHaveAPet(boolean haveAPet);
    List<AdoptForm> getByComment(String comment);
}
