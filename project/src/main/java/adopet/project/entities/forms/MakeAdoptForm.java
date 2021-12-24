package adopet.project.entities.forms;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "make_adopt_forms")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})

public class MakeAdoptForm {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int formId;

    @Column(name = "fname")
    private String firstNAme;

    @Column(name = "lname")
    private String lastNAme;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "pname")
    private String animalName;

    @Column(name = "type")
    private String animalType;

    @Column(name = "breed")
    private String animalBreed;

    @Column(name = "vaccine")
    private String vaccine;

    @Column(name = "year_of_birth")
    private int yearOfBirth;

    @Column(name = "sex")
    private String animalSex;

    @Column(name = "barren")
    private boolean barren;

    @Column(name = "image_url")
    private String imageUrl;
}
