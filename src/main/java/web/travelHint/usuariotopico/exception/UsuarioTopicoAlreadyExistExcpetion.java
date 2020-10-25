package web.travelHint.usuariotopico.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import web.travelHint.exception.TravelHintException;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UsuarioTopicoAlreadyExistExcpetion extends TravelHintException {

    public UsuarioTopicoAlreadyExistExcpetion(String idiomaId) {

        super(String.format("O tópico '%s'  já existe para esse usário", idiomaId ));
    }

}
