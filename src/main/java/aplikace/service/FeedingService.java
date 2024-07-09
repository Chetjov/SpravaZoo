package aplikace.service;

import aplikace.dto.FeedingDto;
import aplikace.dto.KeepersDto;
import aplikace.entity.FeedingEntity;
import aplikace.entity.KeepersEntity;
import aplikace.mapper.FeedingMapper;
import aplikace.repository.AnimalRepository;
import aplikace.repository.FeedingRepository;
import aplikace.repository.KeepersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FeedingService {
    @Autowired
    FeedingRepository feedingRepository;
    @Autowired
    FeedingMapper feedingMapper;
    @Autowired
    KeepersRepository keeperRepository;
    @Autowired
    AnimalRepository animalRepository;

    public FeedingDto addFeeding(FeedingDto feedingDto) {
        FeedingEntity feedingToAdd = feedingMapper.toEntity(feedingDto);
        feedingToAdd.setAnimal(animalRepository.getReferenceById(feedingDto.getAnimalId()));
        feedingToAdd.setKeeper(keeperRepository.getReferenceById(feedingDto.getKeeperId()));
        return feedingMapper.toDto(feedingRepository.save(feedingToAdd));
    }

    public List<FeedingDto> getAllFeedings() {
        List<FeedingDto> allFeedings = new ArrayList<>();
        for (FeedingEntity feedingEntity : feedingRepository.findAll()) {
            allFeedings.add(feedingMapper.toDto(feedingEntity));
        }
        return allFeedings;
    }

    public FeedingDto getFeeding(int feedingId) {
        return feedingMapper.toDto(feedingRepository.getReferenceById(feedingId));
    }

    public FeedingDto editFeeding(int feedingId, FeedingDto feedingDto) {
        feedingDto.setId(feedingId);
        FeedingEntity feedingEntity = feedingRepository.getReferenceById(feedingId);
        feedingMapper.updateEntity(feedingDto, feedingEntity);
        feedingEntity.setAnimal(animalRepository.getReferenceById(feedingDto.getAnimalId()));
        feedingEntity.setKeeper(keeperRepository.getReferenceById(feedingDto.getKeeperId()));
        return feedingMapper.toDto(feedingRepository.save(feedingEntity));

    }

    public FeedingDto deleteFeeding(int feedingId) {
        FeedingEntity feedingEntity = feedingRepository.getReferenceById(feedingId);
        FeedingDto deletedFeeding = feedingMapper.toDto(feedingEntity);
        feedingRepository.deleteById(feedingId);
        return deletedFeeding;
    }
}
