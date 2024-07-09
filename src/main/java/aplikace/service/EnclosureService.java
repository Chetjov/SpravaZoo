package aplikace.service;

import aplikace.dto.EnclosureDto;
import aplikace.dto.KeepersDto;
import aplikace.entity.EnclosureEntity;
import aplikace.entity.KeepersEntity;
import aplikace.mapper.EnclosureMapper;
import aplikace.repository.AnimalRepository;
import aplikace.repository.EnclosureRepository;
import aplikace.repository.KeepersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnclosureService {
    @Autowired
    EnclosureRepository enclosureRepository;
    @Autowired
    EnclosureMapper enclosureMapper;
    @Autowired
    KeepersRepository keeperRepository;
    @Autowired
    AnimalRepository animalRepository;

    public EnclosureDto addEnclosure(EnclosureDto enclosureDto) {
        EnclosureEntity enclosureToAdd = enclosureMapper.toEntity(enclosureDto);
        enclosureToAdd.setAnimal(animalRepository.getReferenceById(enclosureDto.getAnimalId()));
        enclosureToAdd.setKeeper(keeperRepository.getReferenceById(enclosureDto.getKeeperId()));
        return enclosureMapper.toDto(enclosureRepository.save(enclosureToAdd));
    }

    public List<EnclosureDto> getAllEnclosures() {
        List<EnclosureDto> allEnclosures = new ArrayList<>();
        for (EnclosureEntity enclosureEntity : enclosureRepository.findAll()) {
            allEnclosures.add(enclosureMapper.toDto(enclosureEntity));
        }
        return allEnclosures;
    }

    public EnclosureDto getEnclosure(int enclosureId) {
        return enclosureMapper.toDto(enclosureRepository.getReferenceById(enclosureId));
    }

    public EnclosureDto editEnclosure(int enclosureId, EnclosureDto enclosureDto) {
        enclosureDto.setId(enclosureId);
        EnclosureEntity enclosureEntity = enclosureRepository.getReferenceById(enclosureId);
        enclosureMapper.updateEntity(enclosureDto, enclosureEntity);
        enclosureEntity.setAnimal(animalRepository.getReferenceById(enclosureDto.getAnimalId()));
        enclosureEntity.setKeeper(keeperRepository.getReferenceById(enclosureDto.getKeeperId()));
        return enclosureMapper.toDto(enclosureRepository.save(enclosureEntity));

    }

    public EnclosureDto deleteEnclosure(int enclosureId) {
        EnclosureEntity enclosureEntity = enclosureRepository.getReferenceById(enclosureId);
        EnclosureDto deletedEnclosure = enclosureMapper.toDto(enclosureEntity);
        enclosureRepository.deleteById(enclosureId);
        return deletedEnclosure;
    }
}
