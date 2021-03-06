package adopet.project.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "animals")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
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
    private Integer yearOfBirth;

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

    @JsonIgnore
    @OneToOne(mappedBy = "animal")
    private Image image;

    @JsonIgnore
    @OneToMany(mappedBy = "animal")
    private List<AnimalVaccine> animalVaccines;
}
