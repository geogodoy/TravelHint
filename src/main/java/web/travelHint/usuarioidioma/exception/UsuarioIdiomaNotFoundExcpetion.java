package web.travelHint.usuarioidioma.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UsuarioIdiomaNotFoundExcpetion extends RuntimeException {

    public UsuarioIdiomaNotFoundExcpetion(long usuarioIdiomaId) {
        super(String.format("O usuário idioma '%d' não foi encontrado", usuarioIdiomaId));
    }

}
