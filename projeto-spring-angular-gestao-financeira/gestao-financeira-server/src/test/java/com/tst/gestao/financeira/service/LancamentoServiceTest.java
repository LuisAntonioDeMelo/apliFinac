package com.tst.gestao.financeira.service;

import com.tst.gestao.financeira.modelo.enums.TipoLancamento;
import com.tst.gestao.financeira.modelo.Categoria;
import com.tst.gestao.financeira.modelo.Lancamento;
import com.tst.gestao.financeira.modelo.Pessoa;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.time.LocalDate;

@RunWith(SpringJUnit4ClassRunner.class)
class LancamentoServiceTest {

    private LancamentoService service = Mockito.mock(LancamentoService.class);

    private Lancamento lancamento;

    @Before
    public void init() {
        lancamento = new Lancamento(
                1L,"Conta de Luz",  LocalDate.now(),LocalDate.of(2020,12,31),
                new Pessoa(),new Categoria(1l,"Financeiro"),
                new BigDecimal("200"),"Lancamento Responsavel por contas", TipoLancamento.DESPESA);;
    }

    @Test
    void validarLancamentosDespesas() {
        Boolean validaDespesa = service.validarLancamentosDespesas(lancamento);
        Assert.assertEquals(validaDespesa,true);
    }

    @Test
    void validarLancamentosReceitas() {
        lancamento = buildLancamento1();
        Boolean validaReceita = service.validarLancamentosReceitas(lancamento);
        Assert.assertEquals(validaReceita,false);
    }

    @Test
    void validarDatasLancamentos()  throws IllegalArgumentException {
        try {
            service.validarDatasLancamentos(lancamento);
        }catch (Exception ex){
            Assert.fail(ex.getMessage());
        }
    }

    public Lancamento buildLancamento1() {
        return Lancamento.builder()
                .valor(new BigDecimal("1200"))
                .descricao("Pagamento Fatura")
                .observacao("Lancamento Responsavel por contas a Receber")
                .tipoLancamento(TipoLancamento.RECEITA)
                .dataPagamento(LocalDate.of(2021,2,10))
                .dataVencimento(LocalDate.of(2020,12,31))
                .categoria(new Categoria(1l,"Fatura Trimestral"))
                .pessoa(new Pessoa())
                .build();
    }

}