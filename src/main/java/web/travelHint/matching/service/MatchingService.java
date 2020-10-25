package web.travelHint.matching.service;

import web.travelHint.chamadoidioma.ChamadoIdioma;
import web.travelHint.chamadoidioma.payload.ChamadoIdiomaCreateRequest;
import web.travelHint.matching.Matching;
import web.travelHint.matching.payload.MatchingRequest;

import java.util.List;

public interface MatchingService {

    List<Matching> listMatchings();

    Matching findMatching(long id);

    Matching createMatching(MatchingRequest matchingRequest);
}
