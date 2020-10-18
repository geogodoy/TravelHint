package web.travelHint.idioma;

public enum Idiomas {

    INGLES(1),
    ESPANHOL(2),
    ITALIANO(3),
    FRANCES(4),
    PORTUGUES(5),
    COREANO(6),
    CHINES(7),
    JAPONES(8),
    ALEMAO(9);

    private Integer id;

    Idiomas(Integer id) {
        this.id = id;
    }

    public Integer id() {
        return this.id;
    }
}
