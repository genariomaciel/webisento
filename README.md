# WebIsento

Aplicação Web para Insenção de Impostos na Compra de Veículo

**Migração de**: [isencao](https://github.com/genariomaciel/isencao) (C# Windows Forms)

---

## 📋 Índice

- [Stack Tecnológico](#stack-tecnológico)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [URLs Importantes](#urls-importantes)
- [Banco de Dados](#banco-de-dados)
- [Quick Start](#quick-start)
- [Build para Produção](#build-para-produção)
- [Docker](#docker)
- [API Documentation](#api-documentation)
- [Recursos Principais](#recursos-principais)
- [Contribuindo](#contribuindo)
- [Licença](#licença)

---

## Stack Tecnológico

| Componente | Tecnologia | Versão |
|-----------|-----------|--------|
| **Backend** | Java + Spring Boot | 21 / 3.2.0 |
| **Frontend** | Angular | 17+ |
| **Database (Dev)** | H2 | Latest |
| **Database (Prod)** | PostgreSQL | 15+ |
| **Build** | Maven | 3.9+ |
| **Container** | Docker | Latest |
| **Node** | Node.js | 20+ |
| **Package Manager** | npm | 10+ |

---

## Estrutura do Projeto

```
webisento/
├── backend/                           # Spring Boot Application
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/br/com/isento/webisento/
│   │   │   │   ├── WebIsentoApplication.java
│   │   │   │   ├── config/
│   │   │   │   │   ├── SecurityConfig.java
│   │   │   │   │   └── OpenApiConfig.java
│   │   │   │   ├── controller/
│   │   │   │   │   ├── SolicitacaoController.java
│   │   │   │   │   └── HealthController.java
│   │   │   │   ├── service/
│   │   │   │   │   └── SolicitacaoService.java
│   │   │   │   ├── repository/
│   │   │   │   │   └── SolicitacaoRepository.java
│   │   │   │   ├── entity/
│   │   │   │   │   ├── Solicitacao.java
│   │   │   │   │   └── StatusSolicitacao.java
│   │   │   │   └── dto/
│   │   │   │       └── SolicitacaoDTO.java
│   │   │   └── resources/
│   │   │       ├── application.properties
│   │   │       └── application-prod.properties
│   │   └── test/
│   │       └── java/br/com/isento/webisento/
│   ├── pom.xml
│   └── Dockerfile
│
├── frontend/                          # Angular Application
│   ├── src/
│   │   ├── app/
│   │   │   ├── app.component.ts
│   │   │   ├── app.component.html
│   │   │   ├── app.component.scss
│   │   │   ├── app.config.ts
│   │   │   ├── app.routes.ts
│   │   │   └── pages/
│   │   │       └── dashboard/
│   │   │           ├── dashboard.component.ts
│   │   │           ├── dashboard.component.html
│   │   │           └── dashboard.component.scss
│   │   ├── index.html
│   │   ├── styles.scss
│   │   ├── main.ts
│   │   └── assets/
│   ├── angular.json
│   ├── tsconfig.json
│   ├── package.json
│   ├── Dockerfile
│   ├── .gitignore
│   └── proxy.conf.json
│
├── docker-compose.yml
├── build.sh
├── build.bat
├── ARCHITECTURE.md
├── README.md
└── .gitignore
```

---

## URLs Importantes

### 🌐 Desenvolvimento Local

| Descrição | URL | Porta |
|-----------|-----|-------|
| **Frontend** | http://localhost:4200 | 4200 |
| **Backend API** | http://localhost:8080 | 8080 |
| **API Base Path** | http://localhost:8080/api | 8080 |
| **Swagger UI** | http://localhost:8080/swagger-ui.html | 8080 |
| **OpenAPI JSON** | http://localhost:8080/v3/api-docs | 8080 |
| **H2 Console** | http://localhost:8080/h2-console | 8080 |
| **Health Check** | http://localhost:8080/api/public/health | 8080 |

### 📡 Endpoints da API

#### Health & Status
```
GET  /api/public/health                          # Health check da API
```

#### Solicitações (CRUD)
```
GET    /api/solicitacoes                         # Listar todas as solicitações
GET    /api/solicitacoes/{id}                    # Obter solicitação por ID
GET    /api/solicitacoes/status/{status}         # Filtrar por status
POST   /api/solicitacoes                         # Criar nova solicitação
PUT    /api/solicitacoes/{id}                    # Atualizar solicitação
DELETE /api/solicitacoes/{id}                    # Deletar solicitação
```

#### Status Válidos
- `PENDENTE` - Solicitação criada, aguardando análise
- `EM_ANALISE` - Solicitação em análise
- `APROVADA` - Solicitação aprovada
- `REPROVADA` - Solicitação reprovada
- `CANCELADA` - Solicitação cancelada

### 🔐 Credentials (Desenvolvimento)

**H2 Database**
- URL: http://localhost:8080/h2-console
- JDBC URL: `jdbc:h2:mem:testdb`
- User: `sa`
- Password: (deixar em branco)

---

## Banco de Dados

### Tabela: `solicitacoes`

Armazena todas as solicitações de insenção de impostos para compra de veículos.

#### Estrutura Completa

| Campo | Tipo | Constraints | Descrição |
|-------|------|-------------|-----------|
| `id` | BIGINT | PK, AUTO_INCREMENT | Identificador único da solicitação |
| `nome_requerente` | VARCHAR(255) | NOT NULL | Nome completo do requerente |
| `cpf` | VARCHAR(11) | NOT NULL, UNIQUE | CPF do requerente (sem formatação) |
| `placa_veiculo` | VARCHAR(50) | NOT NULL | Placa do veículo (ex: ABC-1234) |
| `marca_veiculo` | VARCHAR(100) | NOT NULL | Marca do veículo (ex: Toyota, Volkswagen) |
| `modelo_veiculo` | VARCHAR(100) | NOT NULL | Modelo do veículo (ex: Corolla, Golf) |
| `ano_veiculo` | INT | NOT NULL | Ano de fabricação do veículo |
| `tipo_veiculo` | VARCHAR(50) | NOT NULL | Tipo do veículo (ex: Carro, Moto, Caminhão) |
| `valor_veiculo` | DECIMAL(19,2) | NULL | Valor do veículo em reais |
| `status` | ENUM | NOT NULL, DEFAULT=PENDENTE | Status atual da solicitação |
| `observacoes` | TEXT | NULL | Observações adicionais |
| `data_criacao` | TIMESTAMP | NOT NULL, IMMUTABLE | Data/hora da criação |
| `data_atualizacao` | TIMESTAMP | NOT NULL | Data/hora da última atualização |

#### Índices
- `id` - Chave primária
- `cpf` - Índice único (uma solicitação por CPF)
- `status` - Índice para buscas por status

#### Exemplo de Registro

```json
{
  "id": 1,
  "nomeRequerente": "João da Silva",
  "cpf": "12345678901",
  "placaVeiculo": "ABC-1234",
  "marcaVeiculo": "Toyota",
  "modeloVeiculo": "Corolla",
  "anoVeiculo": 2023,
  "tipoVeiculo": "Automóvel",
  "valorVeiculo": 150000.00,
  "status": "PENDENTE",
  "observacoes": "Solicitação de isenção de IPI",
  "dataCriacao": "2024-01-15T10:30:00",
  "dataAtualizacao": "2024-01-15T10:30:00"
}
```

### Script SQL de Inicialização (H2)

```sql
-- Criação da tabela
CREATE TABLE solicitacoes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome_requerente VARCHAR(255) NOT NULL,
    cpf VARCHAR(11) NOT NULL UNIQUE,
    placa_veiculo VARCHAR(50) NOT NULL,
    marca_veiculo VARCHAR(100) NOT NULL,
    modelo_veiculo VARCHAR(100) NOT NULL,
    ano_veiculo INT NOT NULL,
    tipo_veiculo VARCHAR(50) NOT NULL,
    valor_veiculo DECIMAL(19, 2),
    status VARCHAR(20) NOT NULL DEFAULT 'PENDENTE',
    observacoes TEXT,
    data_criacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Índices
CREATE INDEX idx_status ON solicitacoes(status);
CREATE UNIQUE INDEX idx_cpf ON solicitacoes(cpf);
```

---

## Quick Start

### Pré-requisitos

- **Java 21** ou superior
- **Node.js 20+** e **npm 10+**
- **Maven 3.9+**
- **Git**

### Desenvolvimento (Com Hot Reload)

#### Terminal 1: Backend

```bash
# Clone o repositório
git clone https://github.com/genariomaciel/webisento.git
cd webisento/backend

# Instale as dependências e execute
mvn clean install
mvn spring-boot:run
```

Backend disponível em: **http://localhost:8080**

#### Terminal 2: Frontend

```bash
cd webisento/frontend

# Instale as dependências
npm install

# Inicie o servidor de desenvolvimento
npm start
# ou
ng serve
```

Frontend disponível em: **http://localhost:4200**

### Verificar Status

```bash
# Health Check
curl http://localhost:8080/api/public/health

# Resposta esperada
{
  "status": "UP",
  "application": "WebIsento",
  "version": "1.0.0"
}
```

---

## Build para Produção

O frontend Angular será compilado e empacotado como um recurso estático dentro do JAR do Spring Boot.

### Linux / macOS

```bash
# Dar permissão de execução
chmod +x build.sh

# Executar build
./build.sh

# Resultado
# ✓ WebIsento build completed successfully!
# 
# To run the application:
# java -jar backend/target/webisento-*.jar
```

### Windows

```bash
# Executar build
build.bat

# Resultado
# Build completed successfully!
# 
# To run the application:
# java -jar backend/target/webisento-*.jar
```

### Executar JAR Compilado

```bash
java -jar backend/target/webisento-1.0.0.jar
```

Aplicação disponível em: **http://localhost:8080**

### Configuração para Produção

Configure variáveis de ambiente:

```bash
export DATABASE_URL=jdbc:postgresql://seu-servidor:5432/webisento
export DATABASE_USER=seu_usuario
export DATABASE_PASSWORD=sua_senha
export SPRING_PROFILES_ACTIVE=prod

java -jar backend/target/webisento-*.jar
```

Ou via arquivo `.env`:

```properties
DATABASE_URL=jdbc:postgresql://seu-servidor:5432/webisento
DATABASE_USER=seu_usuario
DATABASE_PASSWORD=sua_senha
SPRING_PROFILES_ACTIVE=prod
```

---

## Docker

### Docker Compose (Desenvolvimento)

```bash
# Iniciar todos os serviços
docker-compose up -d

# Verificar status
docker-compose ps

# Visualizar logs
docker-compose logs -f

# Parar serviços
docker-compose down
```

Serviços disponíveis:
- Frontend: http://localhost:4200
- Backend: http://localhost:8080
- API Docs: http://localhost:8080/swagger-ui.html

### Build de Imagens Individuais

#### Backend

```bash
cd backend

# Build da imagem
docker build -t webisento-backend:1.0.0 .

# Executar container
docker run -d \
  -p 8080:8080 \
  -e SPRING_PROFILES_ACTIVE=dev \
  --name webisento-api \
  webisento-backend:1.0.0
```

#### Frontend

```bash
cd frontend

# Build da imagem
docker build -t webisento-frontend:1.0.0 .

# Executar container
docker run -d \
  -p 4200:4200 \
  --name webisento-ui \
  webisento-frontend:1.0.0 \
  npm start
```

### Docker Network

```bash
# Criar rede customizada
docker network create webisento-net

# Conectar containers à rede
docker network connect webisento-net webisento-api
docker network connect webisento-net webisento-ui

# Backend no container pode acessar: http://webisento-api:8080
# Frontend no container pode acessar: http://webisento-ui:4200
```

---

## API Documentation

### Swagger UI

Acesse: **http://localhost:8080/swagger-ui.html**

Interface interativa para testar todos os endpoints da API.

### OpenAPI JSON

Acesse: **http://localhost:8080/v3/api-docs**

Documentação em formato OpenAPI 3.0 para integração com ferramentas externas.

### Exemplo de Requisição com cURL

#### Criar Solicitação

```bash
curl -X POST http://localhost:8080/api/solicitacoes \
  -H "Content-Type: application/json" \
  -d '{
    "nomeRequerente": "João da Silva",
    "cpf": "12345678901",
    "placaVeiculo": "ABC-1234",
    "marcaVeiculo": "Toyota",
    "modeloVeiculo": "Corolla",
    "anoVeiculo": 2023,
    "tipoVeiculo": "Automóvel",
    "valorVeiculo": 150000.00,
    "observacoes": "Solicitação de isenção de IPI"
  }'
```

#### Listar Solicitações

```bash
curl http://localhost:8080/api/solicitacoes
```

#### Filtrar por Status

```bash
curl http://localhost:8080/api/solicitacoes/status/PENDENTE
```

#### Obter Solicitação por ID

```bash
curl http://localhost:8080/api/solicitacoes/1
```

#### Atualizar Solicitação

```bash
curl -X PUT http://localhost:8080/api/solicitacoes/1 \
  -H "Content-Type: application/json" \
  -d '{
    "nomeRequerente": "João da Silva",
    "cpf": "12345678901",
    "placaVeiculo": "ABC-1234",
    "marcaVeiculo": "Toyota",
    "modeloVeiculo": "Corolla",
    "anoVeiculo": 2023,
    "tipoVeiculo": "Automóvel",
    "valorVeiculo": 150000.00,
    "status": "APROVADA",
    "observacoes": "Solicitação aprovada"
  }'
```

#### Deletar Solicitação

```bash
curl -X DELETE http://localhost:8080/api/solicitacoes/1
```

---

## Recursos Principais

- [x] Estrutura base com Spring Boot e Angular
- [x] API REST CRUD para Solicitações
- [x] Banco de dados com JPA/Hibernate
- [x] Swagger/OpenAPI Documentation
- [x] CORS configurado
- [x] Health Check Endpoint
- [x] Frontend embarcado no JAR
- [x] Docker Compose para desenvolvimento
- [ ] Autenticação JWT
- [ ] Validação robusta de dados
- [ ] Cálculo automático de impostos
- [ ] Módulo de relatórios
- [ ] Testes unitários e integração
- [ ] CI/CD (GitHub Actions)
- [ ] Cache com Redis
- [ ] Logging centralizado

---

## Variáveis de Ambiente

### Desenvolvimento

```properties
# backend/src/main/resources/application.properties
spring.application.name=webisento
server.port=8080
spring.datasource.url=jdbc:h2:mem:testdb
spring.h2.console.enabled=true
```

### Produção

```bash
export DATABASE_URL=jdbc:postgresql://host:5432/webisento
export DATABASE_USER=seu_usuario
export DATABASE_PASSWORD=sua_senha
export SPRING_PROFILES_ACTIVE=prod
export SERVER_PORT=8080
```

---

## Troubleshooting

### Frontend não conecta ao Backend

1. Verificar se ambos serviços estão rodando
2. Verificar proxy configuration em `frontend/src/proxy.conf.json`
3. Verificar CORS em `backend/src/main/java/br/com/isento/webisento/config/SecurityConfig.java`

### Erro de Porta em Uso

```bash
# Linux/Mac - Verificar qual processo usa a porta
lsof -i :8080
lsof -i :4200

# Windows
netstat -ano | findstr :8080
netstat -ano | findstr :4200

# Matar processo (Linux/Mac)
kill -9 <PID>

# Matar processo (Windows)
taskkill /PID <PID> /F
```

### Banco de Dados H2 não inicializa

1. Deletar cache: `rm -rf .h2db`
2. Limpar Maven: `mvn clean`
3. Reiniciar aplicação

---

## Repositório

- **GitHub**: https://github.com/genariomaciel/webisento
- **Visibilidade**: Privado
- **Branch Principal**: main
- **Issues**: https://github.com/genariomaciel/webisento/issues
- **Pull Requests**: https://github.com/genariomaciel/webisento/pulls

---

## Contribuindo

Este é um repositório privado. Acesso restrito.

Para contribuir:
1. Clone o repositório
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

---

## Licença

Privado - Genário Maciel

---

## Suporte

Para dúvidas ou problemas:
- 📧 Email: [seu-email@exemplo.com]
- 💬 Discussions: https://github.com/genariomaciel/webisento/discussions
- 🐛 Issues: https://github.com/genariomaciel/webisento/issues

---

**Última atualização**: 01 de Julho de 2026
