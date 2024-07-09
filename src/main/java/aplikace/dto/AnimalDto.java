package aplikace.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnimalDto {
    Integer id;
    String name;
    String kind;
    LocalDate dateOfBirth;
}