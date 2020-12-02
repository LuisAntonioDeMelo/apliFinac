package com.tst.gestao.financeira.modelo;

import com.sun.istack.NotNull;
import lombok.*;
import alga.server.api.model.TipoLancamento;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lancamento")
@EqualsAndHashCode
@Builder
public class Lancamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    private String descricao;

    @NotNull
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "data_lancamento")
    private LocalDate dataPagamento;

    @NotNull
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "data_vencimento")
    private LocalDate dataVencimento;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "codigo_pessoa")
    private Pessoa pessoa;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "codigo_categoria")
    private Categoria categoria;

    @NotNull
    private BigDecimal valor;

    private String observacao;

    @NotNull
    private TipoLancamento tipoLancamento;
}
