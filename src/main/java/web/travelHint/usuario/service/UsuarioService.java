package web.travelHint.usuario.service;

import web.travelHint.usuario.Usuario;
import web.travelHint.usuario.payload.UsuarioLogin;
import web.travelHint.usuario.payload.UsuarioCreateRequest;
import web.travelHint.usuario.payload.UsuarioUpdateRequest;

import java.util.List;

public interface UsuarioService {

    List<Usuario> listUsuarios();

    Usuario findUsuario(long id);

    Usuario findUsuarioToken(long id);

    Usuario createUsuario(UsuarioCreateRequest usuarioCreateRequest);

    void deleteUsuario(Usuario usuario);

    Usuario updateUsuario(Usuario usuario, UsuarioUpdateRequest usuarioUpdateRequest);

    Usuario authenticate(UsuarioLogin usuarioLogin, String token);

    Boolean authenticate(String token);

    Usuario findByEmail(String email);

    long[] findMatchingViajante(String topicoId, long usuarioId, String cidade);
}
