package aplikace.controller;

import aplikace.dto.EnclosureDto;
import aplikace.service.EnclosureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EnclosureController {

    @Autowired
    EnclosureService enclosureService;
    @PostMapping({"/enclosure","/enclosure/{enclosureId}"})
    public EnclosureDto addEnclosure(@RequestBody EnclosureDto enclosureDto){
        return enclosureService.addEnclosure(enclosureDto);
    }
    @GetMapping({"/enclosure","/enclosure/{enclosureId}"})
    public List<EnclosureDto> getAll(){
        return enclosureService.getAllEnclosures();
    }
    @GetMapping({"/enclosure/{enclosureId}","/enclosure/"})
    public EnclosureDto getEnclosureById(@PathVariable int enclosureId){
        return enclosureService.getEnclosure(enclosureId);
    }
    @PutMapping({"/enclosure/{enclosureId}","/enclosure/"})
    public EnclosureDto editEnclosure(@PathVariable("enclosureId") int id,@RequestBody EnclosureDto enclosureDto){
        return enclosureService.editEnclosure(id,enclosureDto);
    }
    @DeleteMapping({"/enclosure/{enclosureId}","/enclosure/"})
    public EnclosureDto deleteGrade(@PathVariable int enclosureId){
        return enclosureService.deleteEnclosure(enclosureId);
    }
}
