package aplikace.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class KeepersDto {
     Integer id;
    String firstName;
    String lastName;
    LocalDate dateOfBirth;
    String education;
}
