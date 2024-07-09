package aplikace.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "feeding")
@Getter
@Setter
public class FeedingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int time;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "keeper_id") // This column holds the foreign key to KeepersEntity
    private KeepersEntity keeper;

    @ManyToOne
    @JoinColumn(name = "animal_id") // This column holds the foreign key to AnimalEntity
    private AnimalEntity animal;
}

