package com.tst.gestao.financeira.modelo.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;


@AllArgsConstructor
public enum TipoConta {
    CORRENTE(1, "corrente"),
    POUPANCA(2, "poupança");

    @Getter
    private Integer valor;
    @Getter
    private String descricao;
}
