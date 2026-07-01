import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ClienteDTO } from '../models/cliente.model';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {
  private apiUrl = '/api/clientes';

  constructor(private http: HttpClient) { }

  listarTodos(): Observable<ClienteDTO[]> {
    return this.http.get<ClienteDTO[]>(this.apiUrl);
  }

  obterPorId(id: number): Observable<ClienteDTO> {
    return this.http.get<ClienteDTO>(`${this.apiUrl}/${id}`);
  }

  listarPorStatus(status: string): Observable<ClienteDTO[]> {
    return this.http.get<ClienteDTO[]>(`${this.apiUrl}/status/${status}`);
  }

  buscarPorNome(nome: string): Observable<ClienteDTO[]> {
    return this.http.get<ClienteDTO[]>(`${this.apiUrl}/buscar/nome?nome=${nome}`);
  }

  buscarPorCidade(cidade: string): Observable<ClienteDTO[]> {
    return this.http.get<ClienteDTO[]>(`${this.apiUrl}/buscar/cidade?cidade=${cidade}`);
  }

  criar(cliente: ClienteDTO): Observable<ClienteDTO> {
    return this.http.post<ClienteDTO>(this.apiUrl, cliente);
  }

  atualizar(id: number, cliente: ClienteDTO): Observable<ClienteDTO> {
    return this.http.put<ClienteDTO>(`${this.apiUrl}/${id}`, cliente);
  }

  deletar(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
