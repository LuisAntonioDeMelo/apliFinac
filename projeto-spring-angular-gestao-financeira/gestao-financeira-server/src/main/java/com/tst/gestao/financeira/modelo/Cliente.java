package com.tst.gestao.financeira.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name="cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn
    @OneToOne(fetch = FetchType.LAZY)
    private Pessoa pessoa;

    private Double limite;

    private Integer diaVencimento;

    private Boolean cheques;

    private LocalDateTime dataCadastro;

    @OneToOne
    @JoinColumn(name = "conta_cliente_id")
    private ContaCliente contaCliente;

    @PrePersist
    protected void prePersist(){
        dataCadastro = LocalDateTime.now();
    }

}
