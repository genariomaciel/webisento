import { Routes } from '@angular/router';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { ClienteListComponent } from './pages/cliente/cliente-list.component';
import { ClienteFormComponent } from './pages/cliente/cliente-form.component';

export const routes: Routes = [
  {
    path: '',
    component: DashboardComponent
  },
  {
    path: 'clientes',
    component: ClienteListComponent
  },
  {
    path: 'clientes/:id',
    component: ClienteFormComponent
  },
  {
    path: 'clientes/novo',
    component: ClienteFormComponent
  },
  {
    path: '**',
    redirectTo: ''
  }
];
