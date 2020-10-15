package web.travelHint.usuario.dto;

import lombok.Getter;
import lombok.Setter;
import web.travelHint.usuario.Usuario;

@Getter
@Setter
public class UsuarioAuthenticateDTO {

    private String tipo;
    private String email;
    private String nome;
    private String token;

    public UsuarioAuthenticateDTO(String email, String nome, String token, String tipo){
        this.email = email;
        this.nome = nome;
        this.token = token;
        this.tipo = tipo;
    }

    public UsuarioAuthenticateDTO(){

    }

    public static  UsuarioAuthenticateDTO toDTO(Usuario usuario, String tipo){
        return new UsuarioAuthenticateDTO(usuario.getEmail(), usuario.getNome(),usuario.getToken(), tipo);
    }
}
