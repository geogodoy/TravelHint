package web.travelHint.genero;

public enum Generos {

    FEMININO(1),
    MASCULINO(2),
    OUTRO(3);

    private Integer id;

    Generos(Integer id) {
        this.id = id;
    }

    public Integer id() {
        return this.id;
    }
}
