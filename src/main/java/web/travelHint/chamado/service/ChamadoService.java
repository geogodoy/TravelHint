package web.travelHint.chamado.service;

import web.travelHint.chamado.Chamado;
import web.travelHint.chamado.payload.ChamadoCreateRequest;

import java.util.List;

public interface ChamadoService {

    List<Chamado> listChamados();

    Chamado findChamado(long id);

    Chamado createChamado(ChamadoCreateRequest chamadoCreateRequest);

    void finishChamado(Chamado chamado);
}
