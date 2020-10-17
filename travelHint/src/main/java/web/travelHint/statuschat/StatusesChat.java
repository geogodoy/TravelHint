package web.travelHint.statuschat;

public enum StatusesChat {

    ABERTO(1),
    FINALIZADO(2),
    CANCELADO(3);

    private Integer id;

    StatusesChat(Integer id) {
        this.id = id;
    }

    public Integer id() {
        return this.id;
    }
}
