import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LancamentoComponent } from './lancamento/lancamento.component';
import { HomeComponent } from './static/home/home.component';

const routes: Routes = [
  {path:'',component:HomeComponent},
  {path:'lancamentos',component :LancamentoComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
