package aplikace.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeedingDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    int time;
    int quantity;
    Integer keeperId;
    Integer animalId;

}

