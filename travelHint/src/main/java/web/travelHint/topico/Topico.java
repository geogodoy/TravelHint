package web.travelHint.topico;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="TOPICO")
public class Topico implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nome;

    private String imagemUrl;

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

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }
}
