package adopet.project.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "animals")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","animals"})
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "animal_id")
    private int animalId;

    @Column(name = "animal_name")
    private String animalName;

    @Column(name = "description")
    private String description;

    @Column(name = "year_of_birth")
    private int yearOfBirth;

    @Column(name = "gender")
    private String gender;

    @Column(name = "infertility_status")
    private String infertilityStatus;

    @ManyToOne()
    @JoinColumn(name = "type_id")
    private AnimalType animalType;

    @ManyToOne()
    @JoinColumn(name = "breed_id")
    private AnimalBreed animalBreed;
}
