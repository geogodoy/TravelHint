package web.travelHint.matching.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.travelHint.chamado.Chamado;
import web.travelHint.chamado.ChamadoRepository;
import web.travelHint.chamado.service.ChamadoService;
import web.travelHint.matching.Matching;
import web.travelHint.matching.MatchingRepository;
import web.travelHint.matching.exception.MatchingNotFoundExcpetion;
import web.travelHint.matching.payload.MatchingRequest;
import web.travelHint.usuario.Usuario;
import web.travelHint.usuario.service.UsuarioService;

import java.util.List;

@Service
public class MatchingServiceImpl implements MatchingService{

    @Autowired
    ChamadoRepository chamadoRepository;
    MatchingRepository matchingRepository;
    UsuarioService usuarioService;

    public MatchingServiceImpl(ChamadoRepository chamadoRepository,
                               MatchingRepository matchingRepository,
                               UsuarioService usuarioService){
        this.chamadoRepository = chamadoRepository;
        this.matchingRepository = matchingRepository;
        this.usuarioService = usuarioService;
    }

    @Override
    public List<Matching> listMatchings() {
        return matchingRepository.findAll();
    }

    @Override
    public Matching findMatching(long id) {
        Matching matching = matchingRepository.findById(id);

        if(matching == null) {
            throw new MatchingNotFoundExcpetion(id);
        }else{
            return matching;
        }
    }

    @Override
    public Matching createMatching(MatchingRequest matchingRequest) {

        long usuarios[] = usuarioService.findMatchingViajante(matchingRequest.getTopicoId(), matchingRequest.getViajanteId(), matchingRequest.getCidade());

        for(long residenteId: usuarios){
            Matching matching = new Matching();

            Usuario residente = usuarioService.findUsuario(residenteId);
            Chamado chamado = chamadoRepository.findById(matchingRequest.getChamadoId());
            Usuario usuario = usuarioService.findUsuario(matchingRequest.getViajanteId());
            matching.setResidente(residente);
            matching.setChamado(chamado);
            matching.setViajante(usuario);

            matchingRepository.save(matching);
        }

        return null;
    }
}
