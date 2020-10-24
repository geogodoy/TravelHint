package web.travelHint.chamadoidioma.service;

import web.travelHint.chamado.Chamado;
import web.travelHint.chamado.payload.ChamadoCreateRequest;
import web.travelHint.chamadoidioma.ChamadoIdioma;
import web.travelHint.chamadoidioma.payload.ChamadoIdiomaCreateRequest;
import web.travelHint.chamadoidioma.payload.ChamadoIdiomaUpdateRequest;

import java.util.List;

public interface ChamadoIdiomaService {

    List<ChamadoIdioma> listChamadoIdiomas();

    ChamadoIdioma findChamadoIdioma(long id);

    ChamadoIdioma createChamadoIdioma(ChamadoIdiomaCreateRequest chamadoIdiomaCreateRequest);

    ChamadoIdioma updateChamadoIdioma(ChamadoIdioma chamadoIdioma, ChamadoIdiomaUpdateRequest chamadoIdiomaUpdateRequest);

}
