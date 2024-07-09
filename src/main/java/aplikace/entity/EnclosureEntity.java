package aplikace.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "enclosure")
@Getter
@Setter
public class EnclosureEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "keeper_id") // This column holds the foreign key to KeepersEntity
    private KeepersEntity keeper;

    @OneToOne
    @JoinColumn(name = "animal_id") // This column holds the foreign key to AnimalEntity
    private AnimalEntity animal;

    private String type;
    private Integer time;
    private Integer numOfKeepers;
}
