import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, NgForm, Validators } from '@angular/forms';

import { LancamentoService } from '../services/lancamento.service'
import { CategoriaService } from '../services/categoria.service'
import { PessoaService } from '../services/pessoa.service'
import { Lancamento, Categoria,  Pessoa, TipoLancamento} from '../models/models';
import { Subject } from 'rxjs';
import { MatSnackBar } from '@angular/material/snack-bar';
import { takeUntil } from 'rxjs/operators';
import { OnDestroy } from '@angular/core';

@Component({
  selector: 'app-lancamento',
  templateUrl: './lancamento.component.html',
  styleUrls: ['./lancamento.component.css']
})
export class LancamentoComponent implements OnInit,OnDestroy{
  lancamentos: Lancamento[];
  categorias: Categoria[];
  pessoas: Pessoa[];
  tipoLancamento: typeof TipoLancamento = TipoLancamento

  @ViewChild('form') form: NgForm

  private unsubscribed$:Subject<any> = new Subject();

  displayedColumns: string[] = [
    'codigo',
    'descricao',
    'dataPagamento',
    'dataVencimento',
    'valor',
    'categoria',
    'pessoa',
    'observação',
    'editar',
    'excluir'
    ];
  dataSource = [];
  
  lancamentoForm:FormGroup = this.fb.group({
    codigo: [null,[]],
    tipoLancamento: [null,[Validators.required]],
    dataVencimento: [null,[Validators.required]],
    dataPagamento: [null,[Validators.required]],
    descricao: ['',[Validators.required]],
    valor: [null,[Validators.required]],
    categoria: ['',[Validators.required]],
    pessoa: ['',[Validators.required]],
    observacao: ['',[Validators.required]]
  })

  constructor (
    private fb:FormBuilder,
    private lancamentoService: LancamentoService,
    private categoriaService: CategoriaService,
    private pesssoaService: PessoaService,
    private snack: MatSnackBar
    ) {}

  ngOnInit(): void {
    this.lancamentoService.get()
    .pipe(takeUntil(this.unsubscribed$))
    .subscribe(
      lancamentos => {
        this.lancamentos = lancamentos
        this.dataSource = lancamentos
      }
    );

    this.categoriaService.get().subscribe(
      categorias => this.categorias = categorias
    );

    this.pesssoaService.get().subscribe(
         pessoas => this.pessoas = pessoas
    );
  }

  public pesquisa() {
    this.lancamentoService.get()
    .pipe(takeUntil(this.unsubscribed$))
    .subscribe(
      lancamentos => {
        this.lancamentos = lancamentos
        this.dataSource = lancamentos
      });
  }

  public salvar() {
    if(this.lancamentoForm.valid){
      let values = this.lancamentoForm.value;
      this.lancamentoService.add(values).subscribe(ok => {
          this.notificacao('Lançamento Salvo com Sucesso.');
         },
         error => {
          console.log(error);  
          this.notificacao('Erro ao Salvar - :'+ error.message)
         });
    }
    this.limpar();
    this.pesquisa();
  }

  public limpar() {
    this.lancamentoForm.patchValue({
      tipoLancamento: '',
      dataVencimento: '',
      dataPagamento: '',
      descricao: '',
      valor: '',
      categoria: '',
      pessoa: '',
      observacao: '',
    })
    this.lancamentoForm.reset();
    this.form.resetForm();
  }

  editar(lancamento: Lancamento){
    this.lancamentoForm.setValue(lancamento);
  }
  
  excluir(lancamento: Lancamento) {
    this.lancamentoService.delete(lancamento.codigo)
      .subscribe(ok => {
        this.notificacao('Foi excluido com sucesso.')
      },
        error => this.notificacao(error.message));
  }


  notificacao(msg:string){
    this.snack.open(msg,"ok",{duration:3000})
  }

  ngOnDestroy(): void {
   this.unsubscribed$.next()
  }


}
