package web.travelHint.chamadoidioma.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ChamadoIdiomaNotFoundExcpetion extends RuntimeException {

    public ChamadoIdiomaNotFoundExcpetion(long chamadoIdiomaId) {
        super(String.format("O chamado idioma '%d' não foi encontrado", chamadoIdiomaId));
    }

}
