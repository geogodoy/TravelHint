package web.travelHint.residencia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ResidenciaNotFoundExcpetion extends RuntimeException {

    public ResidenciaNotFoundExcpetion(long residenciaId) {
        super(String.format("A residência '%d' não foi encontrada", residenciaId));
    }

}
