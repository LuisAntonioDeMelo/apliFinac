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
    {icon:'assignment',nome:'Finanças Pessoais',rota:'painel-financas-pessoais'},
    {icon:'assignment',nome:'Gestão',rota:'painel-gestao'},
    {icon:'assignment',nome:'Investimentos',rota:'painel-investimentos'},
    {icon:'assignment',nome:'Config',rota:''}
  ];

}
