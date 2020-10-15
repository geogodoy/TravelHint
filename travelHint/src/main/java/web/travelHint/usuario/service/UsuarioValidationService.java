package web.travelHint.usuario.service;

import web.travelHint.usuario.payload.UsuarioRequest;

public interface UsuarioValidationService {

    void checkUsuarioEmail(UsuarioRequest usuario);
}
