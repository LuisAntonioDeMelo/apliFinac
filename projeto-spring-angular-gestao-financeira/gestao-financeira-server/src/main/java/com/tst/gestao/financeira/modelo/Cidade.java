package com.tst.gestao.financeira.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Cidade {

    @Id
    private Long codigo;

    private String nome;

    @ManyToOne
    @JoinColumn(name="codigo_estado")
    private Estado estado;
}
