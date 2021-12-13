package adopet.project.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "vaccines")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Vaccine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vaccine_id")
    private int vaccineId;

    @Column(name = "vaccine_name")
    private String vaccineName;

    @Column(name = "weekly_validity_period")
    private int weeklyValidityPeriod;

    @JsonIgnore
    @OneToMany(mappedBy = "vaccine")
    private List<AnimalVaccine> animalVaccines;
}