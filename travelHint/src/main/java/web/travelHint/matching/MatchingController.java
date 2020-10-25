package web.travelHint.matching;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.travelHint.matching.service.MatchingService;

import java.util.List;

@RestController
@RequestMapping(value="/api")
public class MatchingController {

    @Autowired
    MatchingService matchingService;

    public MatchingController(MatchingService matchingService){
        this.matchingService = matchingService;
    }

    @GetMapping("/matchings")
    public List<Matching> listMatching(){
        return matchingService.listMatchings();
    }

    @GetMapping("/matching/{id}")
    public Matching findMatching(@PathVariable(value = "id") long id){
        return matchingService.findMatching(id);
    }
}
