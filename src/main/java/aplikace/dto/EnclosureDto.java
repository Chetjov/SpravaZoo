package aplikace.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnclosureDto {
    private Integer id;
    private Integer keeperId;
    private AnimalDto animal;
    private KeepersDto keeper;
    private Integer animalId;
    private String type;
    private Integer time;
    private Integer numOfKeepers;
}
