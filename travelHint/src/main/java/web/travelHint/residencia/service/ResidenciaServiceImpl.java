package web.travelHint.residencia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.travelHint.residencia.Residencia;
import web.travelHint.residencia.ResidenciaRepository;
import web.travelHint.residencia.exception.ResidenciaAlreadyExistExcpetion;
import web.travelHint.residencia.exception.ResidenciaNotDeleteExcpetion;
import web.travelHint.residencia.exception.ResidenciaNotFoundExcpetion;
import web.travelHint.residencia.payload.ResidenciaCreateRequest;
import web.travelHint.residencia.payload.ResidenciaUpdateRequest;
import web.travelHint.usuario.Usuario;
import web.travelHint.usuario.service.UsuarioService;

import java.util.Date;
import java.util.List;

@Service
public class ResidenciaServiceImpl implements ResidenciaService{

    @Autowired
    ResidenciaRepository residenciaRepository;
    UsuarioService usuarioService;

    public ResidenciaServiceImpl(ResidenciaRepository residenciaRepository,
                                 UsuarioService usuarioService){
        this.residenciaRepository = residenciaRepository;
        this.usuarioService = usuarioService;
    }

    @Override
    public List<Residencia> listResidencias() {
        return residenciaRepository.findAll();
    }

    @Override
    public Residencia findResidencia(long id) {
        Residencia residencia = residenciaRepository.findById(id);

        if(residencia == null) {
            throw new ResidenciaNotFoundExcpetion(id);
        }else{
            return residencia;
        }
    }

    @Override
    public Residencia findByUsuario(long usuarioId) {
        return residenciaRepository.findByUsuarioId(usuarioId);
    }

    @Override
    public Residencia createResidencia(ResidenciaCreateRequest residenciaCreateRequest) {
        Residencia residencia = new Residencia();
        Usuario usuario = usuarioService.findUsuario(residenciaCreateRequest.getUsuarioId());

        verifyIsAtual(residencia, residenciaCreateRequest.getDataFinal(),residenciaCreateRequest.getUsuarioId());

        residencia.setUsuario(usuario);
        residencia.setCoordX(residenciaCreateRequest.getCoordX());
        residencia.setCoordY(residenciaCreateRequest.getCoordY());
        residencia.setCidade(residenciaCreateRequest.getCidade());
        residencia.setPais(residenciaCreateRequest.getPais());
        residencia.setDataInicial(residenciaCreateRequest.getDataInicial());
        residencia.setObservacao(residenciaCreateRequest.getObservacao());


        return residenciaRepository.save(residencia);
    }

    private void verifyIsAtual(Residencia residencia,
                               Date dataFinal,
                               long usuarioId) {
        Residencia residenciaExiste = residenciaRepository
                .findByUsuarioIdAndAtual(usuarioId,true);

        if((dataFinal == null && residenciaExiste == null)) {
            residencia.setDataFinal(dataFinal);
            residencia.setAtual(true);
        }else if((dataFinal == null && residenciaExiste != null)){
            throw new ResidenciaAlreadyExistExcpetion(usuarioId);
        }else{
            residencia.setDataFinal(dataFinal);
            residencia.setAtual(false);
        }
    }

    @Override
    public void deleteResidencia(Residencia residencia) {
        verifuisResidenciaAtual(residencia);
        residenciaRepository.delete(residencia);
    }

    private void verifuisResidenciaAtual(Residencia residencia) {
        Residencia residenciaAtualExiste = residenciaRepository
                .findByIdAndAtual(residencia.getId(), true);
        if(residenciaAtualExiste != null){
            throw new ResidenciaNotDeleteExcpetion(residencia.getId(),residencia.getUsuario().getId());
        }
    }

    @Override
    public Residencia updateResidencia(Residencia residencia, ResidenciaUpdateRequest residenciaUpdateRequest) {
        verifyIsAtual(residencia, residenciaUpdateRequest.getDataFinal(), residenciaUpdateRequest.getUsuarioId());

        residencia.setDataFinal(residenciaUpdateRequest.getDataFinal());
        residencia.setAtual(false);

        return residenciaRepository.save(residencia);
    }
}
