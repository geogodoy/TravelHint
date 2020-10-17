package web.travelHint.usuarioidioma.service;

import web.travelHint.usuarioidioma.UsuarioIdioma;
import web.travelHint.usuarioidioma.payload.UsuarioIdiomaCreateRequest;
import web.travelHint.usuarioidioma.payload.UsuarioIdiomaUpdateRequest;

import java.util.List;

public interface UsuarioIdiomaService {

    List<UsuarioIdioma> listUsuarioIdiomas();

    UsuarioIdioma findUsuarioIdioma(long id);

    UsuarioIdioma findUsuarioIdiomaByUsuario(long usuarioId);

    UsuarioIdioma createUsuarioIdioma(UsuarioIdiomaCreateRequest usuarioIdiomaCreateRequest);

    void deleteUsuarioIdioma(UsuarioIdioma usuarioIdioma);

    UsuarioIdioma updateUsuarioIdioma(UsuarioIdioma usuarioIdioma,
                                      UsuarioIdiomaUpdateRequest usuarioIdiomaUpdateRequest);
}
