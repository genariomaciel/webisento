package br.com.isento.webisento.entity;

public enum StatusCondutor {
    ATIVO("Ativo"),
    INATIVO("Inativo");

    private final String descricao;

    StatusCondutor(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
