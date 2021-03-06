package adopet.project.entities.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Data
@Table(name="adoption_forms")
@NoArgsConstructor
@AllArgsConstructor

public class AdoptForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int formId;

    @Column(name = "fname")
    @NotBlank //boş geçilemez
    @NotNull //veri gelmeden olmaz
    @Size(max = 20,message = "İsim uzunluğu en fazla 20 olabilir.")
    private String firstName;

    @Column(name = "lname")
    @NotBlank
    @NotNull
    @Size(max = 20, message = "Soyisim uzunluğu en fazla 20 olabilir.")
    private String lastName;

    @Column(name = "phone_number")
    @NotBlank
    @NotNull
    @Pattern(regexp ="[0-9//s]{10}",message = "Geçersiz numara!")
    private String phoneNumber;

    @Column(name = "email")
    @Email
    private String email;

    @Column(name = "havepet")
    private boolean haveAPet;

    @Column(name = "comment")
    private String comment;
}