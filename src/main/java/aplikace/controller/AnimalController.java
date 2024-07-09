package aplikace.controller;

import aplikace.dto.AnimalDto;
import aplikace.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping
public class AnimalController {
    @Autowired
    private AnimalService animalService;
    @GetMapping({"/animal","/animal/"})
    public List<AnimalDto> getAnimal(){
        return animalService.getAnimal();
    }

    @GetMapping({"/animal/","animal/{id}"})
    public  AnimalDto getKeeper(@PathVariable Integer id){
        return animalService.getKeeper(id);
    }
    @PostMapping({"/animal","/animal/{id}"})
    public AnimalDto addKeeper(AnimalDto animalDto){
        return animalService.addKeeper(animalDto);
    }
    @PutMapping({"/animal","/animal/{id}"})
    public AnimalDto editKeeper(@PathVariable Integer id,@RequestBody AnimalDto animalDto ){
        return animalService.editKeeper(id,animalDto);
    }
    @DeleteMapping({"/animal","/animal/{id}"})
    public AnimalDto deleteKeeper(@PathVariable Integer id){
        return animalService.deletedKeeper((id));
    }
}
