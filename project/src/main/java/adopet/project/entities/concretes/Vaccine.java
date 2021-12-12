package adopet.project.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "vaccines")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vaccine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vaccine_id")
    private int vaccineId;

    @Column(name = "vaccine_name")
    private String vaccineName;

    @Column(name = "weekly_validity_period")
    private int weeklyValidityPeriod;

}