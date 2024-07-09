package aplikace.mapper;

import aplikace.dto.KeepersDto;
import aplikace.entity.KeepersEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface KeepersMapper {

    KeepersEntity toEntity(KeepersDto keeperDto);

    KeepersDto toDto(KeepersEntity keeperEntity);

    @Named("keeperIdToEntity")
    default KeepersEntity map(Integer keeperId) {
        if (keeperId == null) {
            return null;
        }
        KeepersEntity entity = new KeepersEntity();
        entity.setId(keeperId);
        return entity;
    }
}
