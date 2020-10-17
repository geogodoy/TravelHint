package web.travelHint.topico;

public enum Topicos {

    RESTAURANTES(1),
    MUSEUS(2),
    BALADAS(3),
    CAFES(4);

    private Integer id;

    Topicos(Integer id) {
        this.id = id;
    }

    public Integer id() {
        return this.id;
    }
}
