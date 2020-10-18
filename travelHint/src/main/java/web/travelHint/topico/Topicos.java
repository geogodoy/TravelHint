package web.travelHint.topico;

public enum Topicos {

    COMIDA_E_BEBIDA(1),
    COMPRAS(2),
    AR_LIVRE(3),
    HISTORICOS(4),
    PARQUES_E_PRAIAS(5),
    EVENTOS(6),
    TRANSPORTE(7),
    AJUDA(8),;

    private Integer id;

    Topicos(Integer id) {
        this.id = id;
    }

    public Integer id() {
        return this.id;
    }
}
