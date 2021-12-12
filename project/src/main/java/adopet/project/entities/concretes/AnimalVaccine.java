package adopet.project.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "animal_vaccines")
public class AnimalVaccine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "animal_vaccines_id")
    private int animalVaccineId;

    @Column(name = "animal_id")
    private int animalId;

    @Column(name = "vaccine_id")
    private int vaccineId;

    @Column(name = "vaccination_date")
    private String vaccinationDate;

}
