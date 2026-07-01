package br.com.isento.webisento.entity;

public enum StatusProcurador {
    ATIVO("Ativo"),
    INATIVO("Inativo"),
    BLOQUEADO("Bloqueado");

    private final String descricao;

    StatusProcurador(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
