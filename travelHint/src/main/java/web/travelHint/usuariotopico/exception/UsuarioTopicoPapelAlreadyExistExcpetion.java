package web.travelHint.usuariotopico.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import web.travelHint.exception.TravelHintException;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UsuarioTopicoPapelAlreadyExistExcpetion extends TravelHintException {

    public UsuarioTopicoPapelAlreadyExistExcpetion(String topicoId, String papelId) {

        super(String.format("O tópico '%s' para esse papel '%s' já existe para esse usário", topicoId, papelId ));
    }

}
