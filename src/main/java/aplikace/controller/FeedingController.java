package aplikace.controller;

import aplikace.dto.FeedingDto;
import aplikace.service.FeedingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class FeedingController {
    @Autowired
    FeedingService feedingService;
    @PostMapping({"/feeding","/feeding/{feedingId}"})
    public FeedingDto addFeeding(@RequestBody FeedingDto feedingDto){
        return feedingService.addFeeding(feedingDto);
    }
    @GetMapping({"/feeding","/feeding/{feedingId}"})
    public List<FeedingDto> getAll(){
        return feedingService.getAllFeedings();
    }
    @GetMapping({"/feeding/{feedingId}","/feeding/"})
    public FeedingDto getFeedingById(@PathVariable int feedingId){
        return feedingService.getFeeding(feedingId);
    }
    @PutMapping({"/feeding/{feedingId}","/feeding/"})
    public FeedingDto editFeeding(@PathVariable("feedingId") int id,@RequestBody FeedingDto feedingDto){
        return feedingService.editFeeding(id,feedingDto);
    }
    @DeleteMapping({"/feeding/{feedingId}","/feeding/"})
    public FeedingDto deleteGrade(@PathVariable int feedingId){
        return feedingService.deleteFeeding(feedingId);
    }
}
