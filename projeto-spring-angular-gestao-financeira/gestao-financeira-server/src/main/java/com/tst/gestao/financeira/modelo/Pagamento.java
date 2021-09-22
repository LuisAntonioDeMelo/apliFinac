package com.tst.gestao.financeira.modelo;

import com.tst.gestao.financeira.modelo.enums.TipoPagamento;
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
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private TipoPagamento tipoPagamento;

    private LocalDateTime dataPagamento;

    private Double valorPago;

    private Boolean isParcelado;

    private Integer parcelas;

    private Double jurosParcela;

    @OneToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
