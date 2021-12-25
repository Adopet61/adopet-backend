package adopet.project.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalWithImageDto {

    private int animalId;
    private String animalName;
    private String typeName;
    private String breedName;
    private String url;
}
