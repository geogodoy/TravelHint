package web.travelHint.alcance;

public enum Alcances {

    DISTANCIA(1),
    BAIRRO(2),
    CIDADE(3),
    PAIS(4);

    private Integer id;

    Alcances(Integer id) {
        this.id = id;
    }

    public Integer id() {
        return this.id;
    }
}
