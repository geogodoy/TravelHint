package web.travelHint.residencia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import web.travelHint.exception.TravelHintException;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ResidenciaAlreadyExistExcpetion extends TravelHintException {

    public ResidenciaAlreadyExistExcpetion(long usuarioId) {

        super(String.format("Já existe uma residência atual para o usuário '%d'.", usuarioId ));
    }

}

