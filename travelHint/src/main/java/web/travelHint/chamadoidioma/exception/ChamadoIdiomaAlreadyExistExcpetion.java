package web.travelHint.chamadoidioma.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import web.travelHint.exception.TravelHintException;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ChamadoIdiomaAlreadyExistExcpetion extends TravelHintException {

    public ChamadoIdiomaAlreadyExistExcpetion(String idiomaId) {

        super(String.format("O idioma '%s'  já existe para esse configuração de cadastro", idiomaId ));
    }

}
