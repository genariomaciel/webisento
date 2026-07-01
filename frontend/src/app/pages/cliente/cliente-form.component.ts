import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { ClienteService } from '../../services/cliente.service';
import { ClienteDTO } from '../../models/cliente.model';

@Component({
  selector: 'app-cliente-form',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule],
  templateUrl: './cliente-form.component.html',
  styleUrls: ['./cliente-form.component.scss']
})
export class ClienteFormComponent implements OnInit {
  cliente: ClienteDTO = {
    nome: '',
    cpf: '',
    status: 'ATIVO'
  };

  clienteId: number | null = null;
  isNew: boolean = true;
  loading: boolean = false;
  error: string = '';
  successMessage: string = '';

  // Enums
  statusOptions = ['ATIVO', 'INATIVO', 'BLOQUEADO'];
  regimeContribuicaoOptions = [
    { id: 1, nome: 'Contribuinte Individual' },
    { id: 2, nome: 'Microempreendedor Individual' },
    { id: 3, nome: 'Empregado' }
  ];
  tipoSeguradoOptions = [
    { id: 1, nome: 'Pessoa Física' },
    { id: 2, nome: 'Pessoa Jurídica' }
  ];
  tipoLogradouroOptions = [
    { id: 1, nome: 'Rua' },
    { id: 2, nome: 'Avenida' },
    { id: 3, nome: 'Praça' },
    { id: 4, nome: 'Estrada' }
  ];
  estadoOptions = [
    { id: 1, nome: 'AC' }, { id: 2, nome: 'AL' }, { id: 3, nome: 'AP' },
    { id: 4, nome: 'AM' }, { id: 5, nome: 'BA' }, { id: 6, nome: 'CE' },
    { id: 7, nome: 'DF' }, { id: 8, nome: 'ES' }, { id: 9, nome: 'GO' },
    { id: 10, nome: 'MA' }, { id: 11, nome: 'MT' }, { id: 12, nome: 'MS' },
    { id: 13, nome: 'MG' }, { id: 14, nome: 'PA' }, { id: 15, nome: 'PB' },
    { id: 16, nome: 'PR' }, { id: 17, nome: 'PE' }, { id: 18, nome: 'PI' },
    { id: 19, nome: 'RJ' }, { id: 20, nome: 'RN' }, { id: 21, nome: 'RS' },
    { id: 22, nome: 'RO' }, { id: 23, nome: 'RR' }, { id: 24, nome: 'SC' },
    { id: 25, nome: 'SP' }, { id: 26, nome: 'SE' }, { id: 27, nome: 'TO' }
  ];

  constructor(
    private clienteService: ClienteService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id && id !== 'novo') {
      this.clienteId = +id;
      this.isNew = false;
      this.carregarCliente();
    }
  }

  carregarCliente(): void {
    if (!this.clienteId) return;
    this.loading = true;
    this.clienteService.obterPorId(this.clienteId).subscribe({
      next: (data) => {
        this.cliente = data;
        this.loading = false;
      },
      error: (err) => {
        this.error = 'Erro ao carregar cliente';
        this.loading = false;
      }
    });
  }

  salvar(): void {
    if (!this.validar()) return;

    this.loading = true;
    const operacao = this.isNew ?
      this.clienteService.criar(this.cliente) :
      this.clienteService.atualizar(this.cliente.id!, this.cliente);

    operacao.subscribe({
      next: () => {
        this.successMessage = this.isNew ? 'Cliente criado com sucesso!' : 'Cliente atualizado com sucesso!';
        this.loading = false;
        setTimeout(() => this.router.navigate(['/clientes']), 2000);
      },
      error: (err) => {
        this.error = err.error?.message || 'Erro ao salvar cliente';
        this.loading = false;
      }
    });
  }

  validar(): boolean {
    if (!this.cliente.nome?.trim()) {
      this.error = 'Nome é obrigatório';
      return false;
    }
    if (!this.cliente.cpf?.trim()) {
      this.error = 'CPF é obrigatório';
      return false;
    }
    if (!this.validarCPF(this.cliente.cpf)) {
      this.error = 'CPF inválido';
      return false;
    }
    this.error = '';
    return true;
  }

  validarCPF(cpf: string): boolean {
    // Remove caracteres não numéricos
    const cpfLimpo = cpf.replace(/\D/g, '');
    if (cpfLimpo.length !== 11) return false;
    // Validação básica - pode ser expandida
    return true;
  }

  voltar(): void {
    this.router.navigate(['/clientes']);
  }

  limpar(): void {
    this.cliente = {
      nome: '',
      cpf: '',
      status: 'ATIVO'
    };
    this.error = '';
  }
}
