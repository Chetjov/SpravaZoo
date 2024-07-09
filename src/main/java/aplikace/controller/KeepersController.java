package aplikace.controller;



import aplikace.dto.KeepersDto;
import aplikace.service.KeepersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class KeepersController {
    @Autowired
    private KeepersService keepersService;
    @GetMapping({"/keepers","/keepers/"})
    public List<KeepersDto> getKeepers(){
        return keepersService.getKeepers();
    }

    @GetMapping({"/keepers/","keepers/{id}"})
    public  KeepersDto getKeeper(@PathVariable Integer id){
        return keepersService.getKeeper(id);
    }
    @PostMapping({"/keepers","/keepers/{id}"})
    public KeepersDto addKeeper(KeepersDto keepersDto){
        return keepersService.addKeeper(keepersDto);
    }
    @PutMapping({"/keepers","/keepers/{id}"})
    public KeepersDto editKeeper(@PathVariable Integer id,@RequestBody KeepersDto keepersDto ){
        return keepersService.editKeeper(id,keepersDto);
    }
    @DeleteMapping({"/keepers","/keepers/{id}"})
    public KeepersDto deleteKeeper(@PathVariable Integer id){
    return keepersService.deletedKeeper((id));
    }
}
