package web.travelHint.proficiencia;

public enum Proficiencias {

    BASICO(1),
    INTERMEDIARIO(2),
    AVANCADO(3),
    FLUENTE(4);

    private Integer id;

    Proficiencias(Integer id) {
        this.id = id;
    }

    public Integer id() {
        return this.id;
    }
}
