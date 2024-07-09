package aplikace.mapper;

import aplikace.dto.FeedingDto;
import aplikace.entity.FeedingEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", uses = {AnimalMapper.class, KeepersMapper.class})
public interface FeedingMapper {

    @Mapping(target = "animal.id", source = "animalId")
    @Mapping(target = "keeper", source = "keeperId", qualifiedByName = "keeperIdToEntity")
    FeedingEntity toEntity(FeedingDto feedingDto);

    @Mapping(target = "animalId", source = "animal.id")
    @Mapping(target = "keeperId", source = "keeper.id")
    FeedingDto toDto(FeedingEntity feedingEntity);

    @Mapping(target = "animal.id", source = "animalId")
    @Mapping(target = "keeper", source = "keeperId", qualifiedByName = "keeperIdToEntity")
    FeedingEntity updateEntity(FeedingDto feedingDto, @MappingTarget FeedingEntity feedingEntity);
}
