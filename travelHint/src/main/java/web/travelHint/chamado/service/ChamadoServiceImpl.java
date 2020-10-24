package web.travelHint.chamado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.travelHint.chamado.Chamado;
import web.travelHint.chamado.ChamadoRepository;
import web.travelHint.chamado.exception.ChamadoNotFoundExcpetion;
import web.travelHint.chamado.payload.ChamadoCreateRequest;
import web.travelHint.matching.payload.MatchingRequest;
import web.travelHint.matching.service.MatchingService;
import web.travelHint.residencia.Residencia;
import web.travelHint.residencia.service.ResidenciaService;
import web.travelHint.topico.Topicos;
import web.travelHint.usuario.Usuario;
import web.travelHint.usuario.service.UsuarioService;

import java.util.Date;
import java.util.List;

@Service
public class ChamadoServiceImpl implements ChamadoService{

    private static final String topicos[] = {String.valueOf(Topicos.COMIDA_E_BEBIDA),
            String.valueOf(Topicos.COMPRAS),
            String.valueOf(Topicos.AR_LIVRE),
            String.valueOf(Topicos.HISTORICOS),
            String.valueOf(Topicos.PARQUES_E_PRAIAS),
            String.valueOf(Topicos.EVENTOS),
            String.valueOf(Topicos.TRANSPORTE),
            String.valueOf(Topicos.AJUDA)};

    @Autowired
    ChamadoRepository chamadoRepository;
    MatchingService matchingService;
    ResidenciaService residenciaService;
    UsuarioService usuarioService;

    public ChamadoServiceImpl(ChamadoRepository chamadoRepository,
                              MatchingService matchingService,
                              ResidenciaService residenciaService,
                              UsuarioService usuarioService){
    this.chamadoRepository = chamadoRepository;
    this.matchingService = matchingService;
    this.residenciaService = residenciaService;
    this.usuarioService = usuarioService;
    }

    @Override
    public List<Chamado> listChamados() {
        return chamadoRepository.findAll();
    }

    @Override
    public Chamado findChamado(long id) {
        Chamado chamado = chamadoRepository.findById(id);

        if(chamado == null) {
            throw new ChamadoNotFoundExcpetion(id);
        }else{
            return chamado;
        }
    }

    @Override
    public Chamado createChamado(ChamadoCreateRequest chamadoCreateRequest) {
        Chamado chamado = new Chamado();
        Usuario usuario = usuarioService.findUsuario(chamadoCreateRequest.getViajanteId());

        chamado.setUsuario(usuario);

        chamado.setTopicoId(setTopico(chamadoCreateRequest.getTopicoId()));
        chamado.setCoordX(chamadoCreateRequest.getCoordX());
        chamado.setCoordY(chamadoCreateRequest.getCoordY());
        chamado.setAlcance(chamadoCreateRequest.getAlcance());
        chamado.setDistancia(chamadoCreateRequest.getDistancia());
        chamado.setMensagem(chamadoCreateRequest.getMensagem());
        chamado.setDataCriacao(new Date(System.currentTimeMillis()));
        chamado.setAtivo(true);

        chamado = chamadoRepository.save(chamado);

        createMatching(chamado);

        return chamado;
    }

    private void createMatching(Chamado chamado) {
        MatchingRequest matchingRequest = new MatchingRequest();

        Residencia residencia = residenciaService.findByUsuario(chamado.getUsuario().getId());

        matchingRequest.setChamadoId(chamado.getId());
        matchingRequest.setTopicoId(chamado.getTopicoId());
        matchingRequest.setViajanteId(chamado.getUsuario().getId());
        matchingRequest.setCidade(residencia.getCidade());

        matchingService.createMatching(matchingRequest);
    }

    private String setTopico(String topicoId) {
        for(String topico : topicos){
            if (topico.equals(topicoId)){
                return topico;
            }
        }
        return null;
    }

    @Override
    public void finishChamado(Chamado chamado) {
        chamado.setAtivo(false);
        chamadoRepository.save(chamado);
    }
}
