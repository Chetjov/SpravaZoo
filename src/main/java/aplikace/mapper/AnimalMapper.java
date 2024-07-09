package aplikace.mapper;

import aplikace.dto.AnimalDto;
import aplikace.entity.AnimalEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AnimalMapper {

    AnimalEntity toEntity(AnimalDto animalDto);
    AnimalDto toDto(AnimalEntity AnimalEntity);


}
