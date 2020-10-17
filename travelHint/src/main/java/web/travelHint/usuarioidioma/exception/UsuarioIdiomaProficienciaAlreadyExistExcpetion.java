package web.travelHint.usuarioidioma.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import web.travelHint.exception.TravelHintException;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UsuarioIdiomaProficienciaAlreadyExistExcpetion extends TravelHintException {

    public UsuarioIdiomaProficienciaAlreadyExistExcpetion(String idiomaId, String proficienciaId) {

        super(String.format("O idioma '%s' e a proficiência '%s' já existem para esse usário", idiomaId, proficienciaId ));
    }

}
