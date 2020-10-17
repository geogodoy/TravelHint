package web.travelHint.usuarioidioma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.travelHint.usuarioidioma.payload.UsuarioIdiomaCreateRequest;
import web.travelHint.usuarioidioma.payload.UsuarioIdiomaUpdateRequest;
import web.travelHint.usuarioidioma.service.UsuarioIdiomaService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="/api")
public class UsuarioIdiomaController {

    @Autowired
    UsuarioIdiomaService usuarioIdiomaService;

    public UsuarioIdiomaController(UsuarioIdiomaService usuarioIdiomaService){
        this.usuarioIdiomaService = usuarioIdiomaService;
    }


    @GetMapping("/usuario/idiomas")
    public List<UsuarioIdioma> listUsuarioIdiomas(){
        return usuarioIdiomaService.listUsuarioIdiomas();
    }

    @GetMapping("/usuario/idioma/{id}")
    public UsuarioIdioma findUsuario(@PathVariable(value = "id") long id){
        return usuarioIdiomaService.findUsuarioIdioma(id);
    }

    @PostMapping("/usuario/idioma")
    public UsuarioIdioma createUsuario(@Valid @RequestBody UsuarioIdiomaCreateRequest usuarioIdiomaCreateRequest){
        return usuarioIdiomaService.createUsuarioIdioma(usuarioIdiomaCreateRequest);

    }

    @DeleteMapping("/usuario/idioma/{id}")
    public void deleteUsuario(@PathVariable(value = "id") long id){
        UsuarioIdioma usuarioIdioma = usuarioIdiomaService.findUsuarioIdioma(id);
        usuarioIdiomaService.deleteUsuarioIdioma(usuarioIdioma);
    }

    @PutMapping("/usuario/idioma/{usuarioId}")
    public UsuarioIdioma updateUsuario(@PathVariable(value = "usuarioId") long usuarioId,
                                       @RequestBody UsuarioIdiomaUpdateRequest usuarioIdiomaUpdateRequest){
        UsuarioIdioma usuarioIdioma = usuarioIdiomaService.findUsuarioIdiomaByUsuario(usuarioId);

        return usuarioIdiomaService.updateUsuarioIdioma(usuarioIdioma, usuarioIdiomaUpdateRequest);
    }

}
