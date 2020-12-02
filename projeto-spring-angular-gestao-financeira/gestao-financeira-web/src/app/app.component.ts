import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  events: string[] = [];
  opened: boolean;
  title = 'gestao-financeira-web';
  routings = [
    {icon:'home',nome:'Inicio',rota:''},
    {icon:'assignment',nome:'Lançamentos',rota:'lancamentos'},
    {icon:'assignment',nome:'Pessoas',rota:'lancamentos'},
    {icon:'assignment',nome:'Categorias',rota:'lancamentos'}
  ];


}
