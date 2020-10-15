package web.travelHint.usuario.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import web.travelHint.exception.TravelHintException;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ExpiredTokenException extends TravelHintException {

    public ExpiredTokenException() {
        super("Token Expirado");
    }

}
