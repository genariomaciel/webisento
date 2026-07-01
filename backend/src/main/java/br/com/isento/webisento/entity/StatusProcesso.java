package br.com.isento.webisento.entity;

public enum StatusProcesso {
    PENDENTE("Pendente"),
    EM_ANALISE("Em Análise"),
    APROVADA("Aprovada"),
    REPROVADA("Reprovada"),
    CANCELADA("Cancelada");

    private final String descricao;

    StatusProcesso(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
