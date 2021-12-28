package adopet.project.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

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

    @Column(name = "vaccination_date")
    private Date vaccinationDate;

    @ManyToOne()
    @JoinColumn(name = "vaccine_id")
    private Vaccine vaccine;

    @ManyToOne()
    @JoinColumn(name = "animal_id")
    private Animal animal;
}
