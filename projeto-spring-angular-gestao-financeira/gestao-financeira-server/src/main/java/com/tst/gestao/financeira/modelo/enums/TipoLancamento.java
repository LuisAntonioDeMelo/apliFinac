package com.tst.gestao.financeira.modelo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum TipoLancamento {

    DESPESA("despesa"),
    RECEITA("receita");

    @Getter
    private final String descricao;

}
