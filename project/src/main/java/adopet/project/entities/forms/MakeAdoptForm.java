package adopet.project.entities.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
@Entity
@Data
@Table(name = "make_adopt_forms")
@NoArgsConstructor
@AllArgsConstructor

public class MakeAdoptForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int formId;

    @Column(name = "fname")
    @NotBlank
    @NotNull
    @Size(max = 20,message = "İsim uzunluğu en fazla 20 olabilir.")
    private String firstName;

    @Column(name = "lname")
    @NotBlank
    @NotNull
    @Size(max = 20,message = "Soyisim uzunluğu en fazla 20 olabilir.")
    private String lastName;

    @Column(name = "phone_number")
    @NotBlank
    @NotNull
    @Pattern(regexp ="[0-9//s]{10}",message = "Geçersiz numara!")
    private String phoneNumber;

    @Column(name = "email")
    @Email
    private String email;

    @Column(name = "pname")
    @Size(max = 20,message = "İsim uzunluğu en fazla 20 olabilir.")
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