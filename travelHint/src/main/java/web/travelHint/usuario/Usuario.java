package web.travelHint.usuario;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="USUARIO")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nome;

    private String sobrenome;

    private String email;

    private String senha;

    private Boolean emailConfirmado;

    private Boolean cadastroFinalizado;

    private Date dataNascimento;

    private String biografia;

    private String imagemUrl;

    private String genero;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    public void setEmailConfirmado(Boolean emailConfirmado) {
        this.emailConfirmado = emailConfirmado;
    }

    public Boolean getEmailConfirmado() {
        return emailConfirmado;
    }

    public void setCadastroFinalizado(Boolean cadastroFinalizado) {
        this.cadastroFinalizado = cadastroFinalizado;
    }

    public Boolean getCadastroFinalizado() {
        return cadastroFinalizado;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getGenero() {
        return genero;
    }

}
