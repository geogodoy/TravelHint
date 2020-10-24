package web.travelHint.residencia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import web.travelHint.exception.TravelHintException;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ResidenciaCodigoPostalAlreadyExistExcpetion extends TravelHintException {

    public ResidenciaCodigoPostalAlreadyExistExcpetion(long usuarioId, String codigoPostal) {

        super(String.format("Já existe uma residência com o código postal '%s' para o usuário '%d'.", codigoPostal, usuarioId ));
    }

}

