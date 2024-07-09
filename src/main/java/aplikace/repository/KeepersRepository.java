package aplikace.repository;

import aplikace.entity.KeepersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeepersRepository extends JpaRepository<KeepersEntity,Integer> {
}
//Jparepository