package web.travelHint.chamado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.travelHint.chamado.payload.ChamadoCreateRequest;
import web.travelHint.chamado.service.ChamadoService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="/api")
public class ChamadoController {

    @Autowired
    ChamadoService chamadoService;

    public ChamadoController(ChamadoService chamadoService){
        this.chamadoService = chamadoService;
    }

    @GetMapping("/chamados")
    public List<Chamado> listChamados(){
        return chamadoService.listChamados();
    }

    @GetMapping("/chamado/{id}")
    public Chamado findChamado(@PathVariable(value = "id") long id){
        return chamadoService.findChamado(id);
    }

    @PostMapping("/chamado")
    public Chamado createChamado(@Valid @RequestBody ChamadoCreateRequest chamadoCreateRequest){
        return chamadoService.createChamado(chamadoCreateRequest);
    }

    @PutMapping("/chamado/{id}")
    public void finishChamado(@PathVariable(value = "id") long id){
        Chamado chamado = chamadoService.findChamado(id);
        chamadoService.finishChamado(chamado);
    }

}
