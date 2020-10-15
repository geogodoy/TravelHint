package web.travelHint.usuario.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import web.travelHint.exception.TravelHintException;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UsuarioEmailNotFoundExcpetion extends TravelHintException {

    public UsuarioEmailNotFoundExcpetion(String email) {
        super(String.format("O email '%s' não foi encontrado", email));
    }

}
