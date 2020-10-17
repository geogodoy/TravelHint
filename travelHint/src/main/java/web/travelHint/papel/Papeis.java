package web.travelHint.papel;

public enum Papeis {

    VIAJANTE(1),
    RESIDENTE(2);

    private Integer id;

    Papeis(Integer id) {
        this.id = id;
    }

    public Integer id() {
        return this.id;
    }
}
