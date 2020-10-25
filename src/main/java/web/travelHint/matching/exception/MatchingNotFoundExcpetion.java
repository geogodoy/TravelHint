package web.travelHint.matching.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MatchingNotFoundExcpetion extends RuntimeException {

    public MatchingNotFoundExcpetion(long matchingId) {
        super(String.format("O matching  '%d' não foi encontrado", matchingId));
    }

}
