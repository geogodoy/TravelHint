package web.travelHint.usuarioidioma.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import web.travelHint.exception.TravelHintException;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UsuarioIdiomaAlreadyExistExcpetion extends TravelHintException {

    public UsuarioIdiomaAlreadyExistExcpetion(String idiomaId) {

        super(String.format("O idioma '%s'  já existe para esse usário", idiomaId ));
    }

}
