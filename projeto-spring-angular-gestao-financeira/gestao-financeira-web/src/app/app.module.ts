import {HomeComponent} from './static/home/home.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MaterialModule } from './material.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { LancamentoComponent } from './lancamento/lancamento.component';
import { MAT_DATE_LOCALE } from '@angular/material/core';
import { CategoriaComponent } from './categoria/categoria.component';
import { CargoComponent } from './cargo/cargo.component';
import { DepartamentoComponent } from './departamento/departamento.component';
import { ClienteComponent } from './cliente/cliente.component';
import { FornecedorComponent } from './fornecedor/fornecedor.component';
import { FuncionarioComponent } from './funcionario/funcionario.component';
import { ContasComponent } from './contas/contas.component';
import { PainelFinancasPessoaisComponent } from './static/home/painel-financas-pessoais/painel-financas-pessoais.component';
import { PainelInvestimentosComponent } from './static/home/painel-investimentos/painel-investimentos.component';
import { PainelGestaoComponent } from './static/home/painel-gestao/painel-gestao.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LancamentoComponent,
    CategoriaComponent,
    CargoComponent,
    DepartamentoComponent,
    ClienteComponent,
    FornecedorComponent,
    FuncionarioComponent,
    ContasComponent,
    PainelFinancasPessoaisComponent,
    PainelInvestimentosComponent,
    PainelGestaoComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MaterialModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    BrowserAnimationsModule
  ],
  providers: [
    { provide: MAT_DATE_LOCALE, useValue: 'pt-BR' }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
