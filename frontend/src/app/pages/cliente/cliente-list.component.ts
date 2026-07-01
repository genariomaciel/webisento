import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { ClienteService } from '../../services/cliente.service';
import { ClienteDTO } from '../../models/cliente.model';

@Component({
  selector: 'app-cliente-list',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule],
  templateUrl: './cliente-list.component.html',
  styleUrls: ['./cliente-list.component.scss']
})
export class ClienteListComponent implements OnInit {
  clientes: ClienteDTO[] = [];
  searchTerm: string = '';
  filterStatus: string = 'ATIVO';
  loading: boolean = false;
  error: string = '';
  successMessage: string = '';

  constructor(private clienteService: ClienteService) { }

  ngOnInit(): void {
    this.carregarClientes();
  }

  carregarClientes(): void {
    this.loading = true;
    this.error = '';
    this.clienteService.listarTodos().subscribe({
      next: (data) => {
        this.clientes = data;
        this.loading = false;
      },
      error: (err) => {
        this.error = 'Erro ao carregar clientes';
        this.loading = false;
      }
    });
  }

  buscar(): void {
    if (this.searchTerm.trim() === '') {
      this.carregarClientes();
      return;
    }
    this.loading = true;
    this.clienteService.buscarPorNome(this.searchTerm).subscribe({
      next: (data) => {
        this.clientes = data;
        this.loading = false;
      },
      error: (err) => {
        this.error = 'Erro na busca';
        this.loading = false;
      }
    });
  }

  deletar(id?: number): void {
    if (!id) return;
    if (confirm('Tem certeza que deseja deletar este cliente?')) {
      this.clienteService.deletar(id).subscribe({
        next: () => {
          this.successMessage = 'Cliente deletado com sucesso!';
          this.carregarClientes();
          setTimeout(() => this.successMessage = '', 3000);
        },
        error: (err) => {
          this.error = 'Erro ao deletar cliente';
        }
      });
    }
  }
}
