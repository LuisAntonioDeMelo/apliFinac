package com.tst.gestao.financeira.modelo.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum TipoPessoa {

    CPF(1,"cpf"),
    CNPJ(2, "cnpj");

    private Integer codigo;
    private String valor;

}
