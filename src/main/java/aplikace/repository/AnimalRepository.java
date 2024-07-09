package aplikace.repository;

import aplikace.entity.AnimalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


    public interface AnimalRepository extends JpaRepository<AnimalEntity,Integer>{
        Optional<AnimalEntity> findByName(String name);
    }

