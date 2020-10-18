package web.travelHint.usuariotopico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.travelHint.usuarioidioma.UsuarioIdioma;
import web.travelHint.usuarioidioma.payload.UsuarioIdiomaCreateRequest;
import web.travelHint.usuarioidioma.payload.UsuarioIdiomaUpdateRequest;
import web.travelHint.usuarioidioma.service.UsuarioIdiomaService;
import web.travelHint.usuariotopico.payload.UsuarioTopicoCreateRequest;
import web.travelHint.usuariotopico.service.UsuarioTopicoService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="/api")
public class UsuarioTopicoController {

    @Autowired
    UsuarioTopicoService usuarioTopicoService;

    public UsuarioTopicoController(UsuarioTopicoService usuarioTopicoService){
        this.usuarioTopicoService = usuarioTopicoService;
    }

    @GetMapping("/usuario/topicos")
    public List<UsuarioTopico> listUsuarioTopicos(){
        return usuarioTopicoService.listUsuarioTopicos();
    }

    @GetMapping("/usuario/topico/{id}")
    public UsuarioTopico findUsuarioTopico(@PathVariable(value = "id") long id){
        return usuarioTopicoService.findUsuarioTopico(id);
    }

    @PostMapping("/usuario/topico")
    public UsuarioTopico createUsuarioTopico(@Valid @RequestBody UsuarioTopicoCreateRequest usuarioTopicoCreateRequest){
        return usuarioTopicoService.createUsuarioTopico(usuarioTopicoCreateRequest);

    }

    @DeleteMapping("/usuario/topico/{id}")
    public void deleteUsuarioTopico(@PathVariable(value = "id") long id){
        UsuarioTopico usuarioTopico = usuarioTopicoService.findUsuarioTopico(id);
        usuarioTopicoService.deleteUsuarioTopico(usuarioTopico);
    }


}
