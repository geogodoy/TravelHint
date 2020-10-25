package web.travelHint.usuario.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import web.travelHint.exception.TravelHintException;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UsuarioNotFoundExcpetion extends RuntimeException {

    public UsuarioNotFoundExcpetion(long usuarioId) {
        super(String.format("O usuário '%d' não foi encontrado", usuarioId));
    }

}
