package aplikace.mapper;

import aplikace.dto.EnclosureDto;
import aplikace.entity.EnclosureEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring",uses = {AnimalMapper.class, KeepersMapper.class})
public interface EnclosureMapper {
    EnclosureEntity toEntity(EnclosureDto enclosureDto);
    @Mapping(target = "animalId",source = "animal.id")
    @Mapping(target = "keeperId",source = "keeper.id")
    EnclosureDto toDto(EnclosureEntity enclosureEntity);

    EnclosureEntity updateEntity (EnclosureDto enclosureDto,@MappingTarget EnclosureEntity enclosureEntity);
}
