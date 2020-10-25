package web.travelHint.residencia.service;

import web.travelHint.residencia.Residencia;
import web.travelHint.residencia.payload.ResidenciaCreateRequest;
import web.travelHint.residencia.payload.ResidenciaUpdateRequest;
import web.travelHint.usuario.Usuario;
import web.travelHint.usuario.payload.UsuarioCreateRequest;
import web.travelHint.usuario.payload.UsuarioLogin;

import java.util.List;

public interface ResidenciaService {

    List<Residencia> listResidencias();

    Residencia findResidencia(long id);

    Residencia findByUsuario(long usuarioId);

    Residencia createResidencia(ResidenciaCreateRequest residenciaCreateRequest);

    void deleteResidencia(Residencia residencia);

    Residencia updateResidencia (Residencia residencia, ResidenciaUpdateRequest residenciaUpdateRequest);

}
