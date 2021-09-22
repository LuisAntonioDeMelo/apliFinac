import { PainelInvestimentosComponent } from './static/home/painel-investimentos/painel-investimentos.component';
import { PainelGestaoComponent } from './static/home/painel-gestao/painel-gestao.component';
import { PainelFinancasPessoaisComponent } from './static/home/painel-financas-pessoais/painel-financas-pessoais.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LancamentoComponent } from './lancamento/lancamento.component';
import { HomeComponent } from './static/home/home.component';

const routes: Routes = [
  {path:'',component:HomeComponent},
  {path: 'lancamentos',component :LancamentoComponent},
  {path: 'painel-financas-pessoais', component: PainelFinancasPessoaisComponent },
  {path: 'painel-gestao', component: PainelGestaoComponent},
  {path: 'painel-investimentos', component: PainelInvestimentosComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
