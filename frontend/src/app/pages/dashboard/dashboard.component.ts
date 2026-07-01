import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {
  apiStatus = 'Verificando...';
  statusColor = '#FFA500';

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.checkApiHealth();
  }

  checkApiHealth(): void {
    this.http.get<any>('/api/public/health').subscribe(
      (response) => {
        this.apiStatus = 'API Online ✓';
        this.statusColor = '#4CAF50';
        console.log('API Health:', response);
      },
      (error) => {
        this.apiStatus = 'API Offline ✗';
        this.statusColor = '#F44336';
        console.error('API Error:', error);
      }
    );
  }
}
