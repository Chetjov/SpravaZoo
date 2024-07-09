package aplikace.service;

import aplikace.dto.KeepersDto;
import aplikace.entity.KeepersEntity;
import aplikace.mapper.KeepersMapper;
import aplikace.repository.KeepersRepository;
import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KeepersService {
    @Autowired
    private KeepersRepository keepersRepository;
    @Autowired
    private KeepersMapper keepersMapper;
    public List<KeepersDto> getKeepers(){
       List<KeepersEntity> keepersEntities =  keepersRepository.findAll();
       List<KeepersDto> keepersDtos = new ArrayList<>();
        for (KeepersEntity keepersEntity : keepersEntities) {
            keepersDtos.add(keepersMapper.toDto(keepersEntity));
        }
        return keepersDtos;
    }

    public KeepersDto addKeeper(KeepersDto keepersDto){
        KeepersEntity keepersEntity = keepersMapper.toEntity(keepersDto);
        KeepersEntity savedEntity = keepersRepository.save(keepersEntity);
        return keepersMapper.toDto(savedEntity);
    }
    public KeepersDto getKeeper(Integer id){
       KeepersEntity keepersEntity = keepersRepository.findById(id).orElseThrow(EntityExistsException::new);
//        if (!keepersRepository.existsById(id)){
//            throw new EntityExistsException();
//        }
//        KeepersEntity keepersEntity = keepersRepository.getReferenceById(id);
        return keepersMapper.toDto(keepersEntity);
    }
    public KeepersDto editKeeper(Integer  id, KeepersDto keepersDto){
        if (!keepersRepository.existsById(id)){
            throw new EntityExistsException();
        };
        KeepersEntity keepersEntity =keepersMapper.toEntity(keepersDto);
        keepersEntity.setId(id);
        KeepersEntity savedKeeper = keepersRepository.save((keepersEntity));
        return keepersMapper.toDto(savedKeeper);
    }
    public KeepersDto deletedKeeper(Integer id){
        KeepersEntity keepersToDelete = keepersRepository
                .findById(id)
                .orElseThrow(EntityExistsException::new);
        KeepersDto deletedKeeper = keepersMapper.toDto(keepersToDelete);
        keepersRepository.delete(keepersToDelete);
        return deletedKeeper;
    }
}
