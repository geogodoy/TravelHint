package web.travelHint.tipomensagem;

public enum TiposMensagem {

    TEXTO(1),
    IMAGEM(2);

    private Integer id;

    TiposMensagem(Integer id) {
        this.id = id;
    }

    public Integer id() {
        return this.id;
    }
}
