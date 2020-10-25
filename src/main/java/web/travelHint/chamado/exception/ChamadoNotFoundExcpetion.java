package web.travelHint.chamado.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ChamadoNotFoundExcpetion extends RuntimeException {

    public ChamadoNotFoundExcpetion(long chamadoId) {
        super(String.format("O chamado '%d' não foi encontrado", chamadoId));
    }

}
