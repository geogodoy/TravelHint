package web.travelHint.usuariotopico.service;

import web.travelHint.usuariotopico.UsuarioTopico;
import web.travelHint.usuariotopico.payload.UsuarioTopicoCreateRequest;

import java.util.List;

public interface UsuarioTopicoService {

    List<UsuarioTopico> listUsuarioTopicos();

    UsuarioTopico findUsuarioTopico(long id);

    UsuarioTopico createUsuarioTopico(UsuarioTopicoCreateRequest usuarioTopicoCreateRequest);

    void deleteUsuarioTopico(UsuarioTopico usuarioTopico);
}
