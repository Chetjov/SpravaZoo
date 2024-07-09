package aplikace.service;

import aplikace.dto.AnimalDto;
import aplikace.entity.AnimalEntity;
import aplikace.mapper.AnimalMapper;
import aplikace.repository.AnimalRepository;
import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnimalService {
    @Autowired
    private AnimalRepository animalRepository;
    @Autowired
    private AnimalMapper animalMapper;
    public List<AnimalDto> getAnimal(){
        List<AnimalEntity> animalEntities =  animalRepository.findAll();
        List<AnimalDto> animalDtos = new ArrayList<>();
        for (AnimalEntity animalEntity : animalEntities) {
            animalDtos.add(animalMapper.toDto(animalEntity));
        }
        return animalDtos;
    }

    public AnimalDto addKeeper(AnimalDto animalDto){
        AnimalEntity animalEntity = animalMapper.toEntity(animalDto);
        AnimalEntity savedEntity = animalRepository.save(animalEntity);
        return animalMapper.toDto(savedEntity);
    }
    public AnimalDto getKeeper(Integer id){
        AnimalEntity animalEntity = animalRepository.findById(id).orElseThrow(EntityExistsException::new);
//        if (!animalRepository.existsById(id)){
//            throw new EntityExistsException();
//        }
//        AnimalEntity animalEntity = animalRepository.getReferenceById(id);
        return animalMapper.toDto(animalEntity);
    }
    public AnimalDto editKeeper(Integer  id, AnimalDto animalDto){
        if (!animalRepository.existsById(id)){
            throw new EntityExistsException();
        };
        AnimalEntity animalEntity =animalMapper.toEntity(animalDto);
        animalEntity.setId(id);
        AnimalEntity savedKeeper = animalRepository.save((animalEntity));
        return animalMapper.toDto(savedKeeper);
    }
    public AnimalDto deletedKeeper(Integer id){
        AnimalEntity animalToDelete = animalRepository
                .findById(id)
                .orElseThrow(EntityExistsException::new);
        AnimalDto deletedKeeper = animalMapper.toDto(animalToDelete);
        animalRepository.delete(animalToDelete);
        return deletedKeeper;
    }
}
