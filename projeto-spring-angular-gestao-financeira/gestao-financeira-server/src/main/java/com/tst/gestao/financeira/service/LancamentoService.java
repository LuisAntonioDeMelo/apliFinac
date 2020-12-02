package com.tst.gestao.financeira.service;

import alga.server.api.model.TipoLancamento;
import com.tst.gestao.financeira.modelo.Lancamento;
import com.tst.gestao.financeira.modelo.Pessoa;
import com.tst.gestao.financeira.repository.LancamentoRepository;
import com.tst.gestao.financeira.repository.PessoaRepository;
import lombok.SneakyThrows;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.YearMonth;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.Temporal;
import java.util.List;
import java.util.Optional;

@Service
public class LancamentoService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private LancamentoRepository lancamentoRepository;

    public Lancamento salvar(Lancamento lancamento) {
        validarLancamento(lancamento);
        return lancamentoRepository.save(lancamento);
    }

    public Lancamento atualizar(Long codigo, Lancamento lancamento) {
        Lancamento lancamentoSalvo = buscarLancamentoExistente(codigo);
        if (!lancamento.getPessoa().equals(lancamentoSalvo.getPessoa())) {
            validarPessoa(lancamento);
        }
        BeanUtils.copyProperties(lancamento, lancamentoSalvo, "codigo");
        return lancamentoRepository.save(lancamentoSalvo);
    }

    private void validarPessoa(Lancamento lancamento) {
        Optional<Pessoa> pessoa = null;
        if (lancamento.getPessoa().getCodigo() != null) {
            pessoa = pessoaRepository.findById(lancamento.getPessoa().getCodigo());
        }
        if (pessoa.get() == null || pessoa.get().getAtivo() == false) {
            throw new RuntimeException();
        }
    }

    @SneakyThrows
    public void validarLancamento(Lancamento lancamento){
        validarPessoa(lancamento);
        if(!validarLancamentosDespesas(lancamento)) {
            throw new Exception
                    ("Não é possivel criar lançamento de DESPESA para o proximo mês.");
        }
        else if(validarLancamentosReceitas(lancamento)){
            throw new Exception
                    ("Não é possivel cadastrar lançamento com RECEITA após 3 mês da data do lançamento ");
            }
        validarDatasLancamentos (lancamento);
    }


    public boolean validarLancamentosDespesas(Lancamento lancamento){
         if(lancamento.getTipoLancamento() ==  TipoLancamento.DESPESA
                && lancamento.getDataVencimento().isBefore(YearMonth.now().atEndOfMonth())){
             return true;
         }
         return false;
    }

    public boolean validarLancamentosReceitas(Lancamento lancamento)  {
        if(lancamento.getTipoLancamento() == TipoLancamento.RECEITA  &&
               lancamento.getDataPagamento().isBefore(lancamento.getDataVencimento().plusMonths(3))){
            return true;
        }
        return false;
    }


    public void validarDatasLancamentos(Lancamento lancamento){
        if( lancamento.getTipoLancamento().equals(TipoLancamento.DESPESA) &&
                lancamento.getDataPagamento().isBefore(lancamento.getDataVencimento())){
            return;
        }
        throw new IllegalArgumentException
                ("Data do pagamento não pode ultrapassar a data do Vencimento");
    }

    public Double valorTotaldeDespesas(){
        Double valor =  0.0;
        List<Lancamento> lancamentos = lancamentoRepository.findAll();
        if(lancamentos.size() > 0){
            for(Lancamento lancamento : lancamentos){
                if(lancamento.getTipoLancamento() == TipoLancamento.DESPESA){
                    valor += lancamento.getValor().doubleValue();
                }
            }
        }
        return valor;
    }

    private Lancamento buscarLancamentoExistente(Long codigo) {
        Optional<Lancamento> lancamentoSalvo = lancamentoRepository.findById(codigo);
        if (!lancamentoSalvo.isPresent()) {
         throw new IllegalArgumentException();
        }
    return lancamentoSalvo.get();
    }

}
