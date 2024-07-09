package aplikace.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity(name = "animal")
@Getter
@Setter
public class AnimalEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Id
    Integer id;
    String name;
    LocalDate dateOfBirth;
    String kind;



}