import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Categoria } from '../models/models'
import { url } from '../../environments/environment'

@Injectable({
  providedIn: 'root'
})
export class CategoriaService {

  constructor(private http:HttpClient) { }

  get():Observable<Categoria[]> {
    return this.http.get<Categoria[]>(`${url}/categorias`)
  }
}
