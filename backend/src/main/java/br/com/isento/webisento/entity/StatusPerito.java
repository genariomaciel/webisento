package br.com.isento.webisento.entity;

public enum StatusPerito {
    ATIVO("Ativo"),
    INATIVO("Inativo"),
    BLOQUEADO("Bloqueado");

    private final String descricao;

    StatusPerito(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
