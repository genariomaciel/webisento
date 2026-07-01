package br.com.isento.webisento.entity;

public enum StatusSolicitacao {
    PENDENTE("Pendente"),
    EM_ANALISE("Em Análise"),
    APROVADA("Aprovada"),
    REPROVADA("Reprovada"),
    CANCELADA("Cancelada");

    private final String descricao;

    StatusSolicitacao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
