package com.tst.gestao.financeira.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class OrcamentoDetalhe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "orcamento_codigo")
    private Orcamento orcamento;

    @ManyToOne
    @JoinColumn(name = "funcionario_responsavel_codigo")
    private Funcionario funcionarioResponsavel;

    private String descricao;

    private Boolean ativo;

}
