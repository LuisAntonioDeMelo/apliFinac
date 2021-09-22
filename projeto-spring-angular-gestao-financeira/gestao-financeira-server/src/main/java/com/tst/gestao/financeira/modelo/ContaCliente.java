package com.tst.gestao.financeira.modelo;

import com.tst.gestao.financeira.modelo.enums.TipoConta;
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
public class ContaCliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    private String banco;
    private String numeroConta;
    private Double saldo;
    private Double limitePagamento;
    private Double debitoPedente;
    private TipoConta conta;
}
