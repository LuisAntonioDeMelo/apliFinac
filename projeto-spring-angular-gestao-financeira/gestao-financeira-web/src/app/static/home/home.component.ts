import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  itemsCard = [
    {nome:'Finanças Pessoais', link: 'painel-financas-pessoais',
      submenu: [
        {titulo:'Lançamentos'},
        {titulo: 'Contas Cliente'},+
        {titulo: 'Relatorio Clientes'}
      ]
    },
    {nome:'Gestão', link: 'painel-gestao'},
    {nome:'Investimentos', link: 'painel-investimentos'}
  ]

  constructor() { }

  ngOnInit(): void {
  }

}


