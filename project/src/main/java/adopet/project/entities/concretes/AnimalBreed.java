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
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "animal_breeds")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class AnimalBreed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "breed_id")
    private int breedId;

    @Column(name = "breed_name")
    private String breedName;

    @JsonIgnore
    @OneToMany(mappedBy = "animalBreed")
    private List<Animal> animals;

    @ManyToOne()
    @JoinColumn(name = "type_id")
    private AnimalType animalType;
}
