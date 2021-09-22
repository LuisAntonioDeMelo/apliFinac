package com.tst.gestao.financeira.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name="funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "cargo_id")
    private Cargo cargo;

    @OneToOne
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;

    private LocalDateTime dataCadastro;

    private Boolean ativo;

}
