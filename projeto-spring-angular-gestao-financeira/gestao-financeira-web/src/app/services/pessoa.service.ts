import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { url } from 'src/environments/environment';
import { Pessoa } from '../models/models';

@Injectable({
  providedIn: 'root'
})
export class PessoaService {

  constructor(private http:HttpClient) { }

  get():Observable<Pessoa[]> {
    return this.http.get<Pessoa[]>(`${url}/pessoas`)
  }
}
