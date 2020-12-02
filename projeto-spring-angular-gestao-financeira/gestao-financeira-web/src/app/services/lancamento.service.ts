import {tap} from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { url } from 'src/environments/environment';
import { Lancamento } from '../models/models';
import { BehaviorSubject } from 'rxjs/internal/BehaviorSubject';

@Injectable({
  providedIn: 'root'
})
export class LancamentoService {
  private lancamentosSubject$ :BehaviorSubject<Lancamento[]> = new BehaviorSubject<Lancamento[]>([]);
  private isCarregado: boolean = false;

  constructor(private http:HttpClient) {
    this.lancamentosSubject$.asObservable().subscribe(ok => {
      console.log(ok);
    })
   }
  
  get():Observable<Lancamento[]> {
    if(!this.isCarregado){
      this.http.get<Lancamento[]>(`${url}/lancamentos`).subscribe(this.lancamentosSubject$);
      this.isCarregado = true;
    }
    return this.lancamentosSubject$.asObservable();
  }

  add(lancamento:Lancamento):Observable<Lancamento> {
    return this.http.post<Lancamento>(`${url}/lancamentos`,lancamento)
     .pipe(
      tap((lan )=> {
        console.log(lan)
        this.lancamentosSubject$.getValue().push(lancamento)
      })
     );
  }

  delete(codigo: number):Observable<any> {
    return this.http.delete(`${url}/lancamentos/${codigo}`)
    .pipe(
      tap(() =>{
        let lancamentos = this.lancamentosSubject$.getValue();
        let index = lancamentos.findIndex(lanc => lanc.codigo === codigo);
        if(index >= 0){
          lancamentos.splice(index,1);
        }
      })
    )
  }
  
}
