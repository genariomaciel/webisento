# WebIsento

Aplicação Web para Insenção de Impostos na Compra de Veículo

**Migração de**: [isencao](https://github.com/genariomaciel/isencao) (C# Windows Forms)

---

## 📋 Índice

- [Stack Tecnológico](#stack-tecnológico)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Módulos Implementados](#módulos-implementados)
- [URLs Importantes](#urls-importantes)
- [Banco de Dados](#banco-de-dados)
- [API Endpoints](#api-endpoints)
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
│   │   │   │   │   ├── ClienteController.java
│   │   │   │   │   ├── SolicitacaoController.java
│   │   │   │   │   └── HealthController.java
│   │   │   │   ├── service/
│   │   │   │   │   ├── ClienteService.java
│   │   │   │   │   └── SolicitacaoService.java
│   │   │   │   ├── repository/
│   │   │   │   │   ├── ClienteRepository.java
│   │   │   │   │   └── SolicitacaoRepository.java
│   │   │   │   ├── entity/
│   │   │   │   │   ├── Cliente.java
│   │   │   │   │   ├── StatusCliente.java
│   │   │   │   │   ├── Solicitacao.java
│   │   │   │   │   └── StatusSolicitacao.java
│   │   │   │   └── dto/
│   │   │   │       ├── ClienteDTO.java
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
│   │   │   ├── services/
│   │   │   │   ├── cliente.service.ts
│   │   │   │   └── solicitacao.service.ts
│   │   │   ├── models/
│   │   │   │   ├── cliente.model.ts
│   │   │   │   └── solicitacao.model.ts
│   │   │   └── pages/
│   │   │       ├── dashboard/
│   │   │       │   ├── dashboard.component.ts
│   │   │       │   ├── dashboard.component.html
│   │   │       │   └── dashboard.component.scss
│   │   │       └── cliente/
│   │   │           ├── cliente-list.component.ts
│   │   │           ├── cliente-list.component.html
│   │   │           ├── cliente-list.component.scss
│   │   │           ├── cliente-form.component.ts
│   │   │           ├── cliente-form.component.html
│   │   │           └── cliente-form.component.scss
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

## Módulos Implementados

### ✅ Módulo de Clientes (CRUD Completo)

**Descrição**: Cadastro de clientes/requerentes com todos os dados pessoais, endereço, contato e representante.

**Funcionalidades**:
- ✅ Listar todos os clientes
- ✅ Criar novo cliente
- ✅ Editar cliente existente
- ✅ Deletar cliente
- ✅ Buscar por nome
- ✅ Filtrar por status (ATIVO, INATIVO, BLOQUEADO)
- ✅ Buscar por cidade
- ✅ Validação de CPF obrigatório e único
- ✅ Validação de campos obrigatórios

**Campos do Cliente** (30 atributos):
- **Pessoais**: Nome, CPF, RG, INSS, CNH, Regime Contribuição, Tipo Segurado, Datas
- **Representante**: Nome, CPF, RG, Condomínio
- **Endereço**: Tipo Logradouro, Logradouro, Número, Complemento, Bairro, Cidade, Estado, CEP
- **Contato**: DDD, Telefone, Celular, Email
- **Status**: ATIVO, INATIVO, BLOQUEADO

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

### 🔗 Frontend Routes

| Rota | Descrição |
|------|-----------|
| `/` | Dashboard |
| `/clientes` | Lista de clientes |
| `/clientes/novo` | Novo cliente |
| `/clientes/:id` | Editar cliente |

---

## Banco de Dados

### Tabela: `clientes`

Armazena todos os clientes/requerentes com dados pessoais, endereço, contato e representante.

#### Estrutura Completa

| Campo | Tipo | Constraints | Descrição |
|-------|------|-------------|-----------|
| `id` | BIGINT | PK, AUTO_INCREMENT | Identificador único |
| `nome` | VARCHAR(255) | NOT NULL | Nome completo do cliente |
| `cpf` | VARCHAR(11) | NOT NULL, UNIQUE | CPF (sem formatação) |
| `numero_rg` | VARCHAR(20) | - | Número do RG |
| `codigo_orgao_expedidor` | VARCHAR(10) | - | Órgão expedidor do RG |
| `data_expedicao` | DATE | - | Data de expedição do RG |
| `data_cadastro` | DATE | - | Data de cadastro |
| `numero_cnh` | VARCHAR(20) | - | Número da CNH |
| `data_emissao_cnh` | DATE | - | Data de emissão da CNH |
| `data_validade_cnh` | DATE | - | Data de validade da CNH |
| `numero_inss` | VARCHAR(20) | - | Número do INSS |
| `codigo_regime_contribuicao` | INT | - | Código do regime |
| `codigo_tipo_segurado` | INT | - | Código do tipo segurado |
| `nome_representante` | VARCHAR(255) | - | Nome do representante |
| `cpf_representante` | VARCHAR(11) | - | CPF do representante |
| `numero_rg_representante` | VARCHAR(20) | - | RG do representante |
| `nome_condominio` | VARCHAR(255) | - | Nome do condomínio |
| `codigo_tipo_logradouro` | INT | - | Tipo de logradouro |
| `nome_logradouro` | VARCHAR(255) | - | Nome do logradouro |
| `numero_logradouro` | INT | - | Número do logradouro |
| `complemento` | VARCHAR(255) | - | Complemento do endereço |
| `bairro` | VARCHAR(100) | - | Bairro |
| `cidade` | VARCHAR(100) | - | Cidade |
| `codigo_estado` | INT | - | Código do estado |
| `cep` | VARCHAR(10) | - | CEP |
| `ddd` | VARCHAR(5) | - | DDD |
| `telefone` | VARCHAR(15) | - | Telefone |
| `celular` | VARCHAR(15) | - | Celular |
| `email` | VARCHAR(100) | - | Email |
| `status` | ENUM | NOT NULL, DEFAULT=ATIVO | Status (ATIVO, INATIVO, BLOQUEADO) |
| `data_criacao_registro` | TIMESTAMP | NOT NULL, IMMUTABLE | Data/hora de criação |
| `data_atualizacao_registro` | TIMESTAMP | NOT NULL | Data/hora de atualização |

#### Índices
- `id` - Chave primária
- `cpf` - Índice único
- `status` - Índice para filtros

#### Exemplo de Registro

```json
{
  "id": 1,
  "nome": "João Silva",
  "cpf": "12345678901",
  "numeroRG": "123456789",
  "codigoOrgaoExpedidor": "SSP",
  "dataExpedicao": "2020-01-15",
  "dataCadastro": "2024-01-15",
  "numeroCNH": "9876543210",
  "dataEmissaoCNH": "2019-05-20",
  "dataValidadeCNH": "2029-05-20",
  "numeroINSS": "123456789",
  "codigoRegimeContribuicao": 1,
  "codigoTipoSegurado": 1,
  "nomeRepresentante": "Maria Silva",
  "cpfRepresentante": "98765432101",
  "numeroRGRepresentante": "987654321",
  "nomeCondominio": "Condomínio Exemplo",
  "codigoTipoLogradouro": 1,
  "nomeLogradouro": "Rua das Flores",
  "numeroLogradouro": 123,
  "complemento": "Apto 42",
  "bairro": "Centro",
  "cidade": "São Paulo",
  "codigoEstado": 25,
  "cep": "01310100",
  "ddd": "11",
  "telefone": "33334444",
  "celular": "987654321",
  "email": "joao@example.com",
  "status": "ATIVO",
  "dataCriacaoRegistro": "2024-01-15T10:30:00",
  "dataAtualizacaoRegistro": "2024-01-15T10:30:00"
}
```

### Tabela: `solicitacoes`

Armazena todas as solicitações de insenção de impostos para compra de veículos.

#### Estrutura

| Campo | Tipo | Constraints | Descrição |
|-------|------|-------------|-----------|
| `id` | BIGINT | PK, AUTO_INCREMENT | Identificador único |
| `nome_requerente` | VARCHAR(255) | NOT NULL | Nome do requerente |
| `cpf` | VARCHAR(11) | NOT NULL, UNIQUE | CPF (sem formatação) |
| `placa_veiculo` | VARCHAR(50) | NOT NULL | Placa do veículo |
| `marca_veiculo` | VARCHAR(100) | NOT NULL | Marca do veículo |
| `modelo_veiculo` | VARCHAR(100) | NOT NULL | Modelo do veículo |
| `ano_veiculo` | INT | NOT NULL | Ano de fabricação |
| `tipo_veiculo` | VARCHAR(50) | NOT NULL | Tipo de veículo |
| `valor_veiculo` | DECIMAL(19,2) | - | Valor do veículo |
| `status` | ENUM | NOT NULL, DEFAULT=PENDENTE | Status da solicitação |
| `observacoes` | TEXT | - | Observações |
| `data_criacao` | TIMESTAMP | NOT NULL, IMMUTABLE | Data de criação |
| `data_atualizacao` | TIMESTAMP | NOT NULL | Data de atualização |

---

## API Endpoints

### Health & Status

```
GET  /api/public/health                          # Health check da API
```

### Clientes (CRUD)

```
GET    /api/clientes                             # Listar todos os clientes
GET    /api/clientes/{id}                        # Obter cliente por ID
GET    /api/clientes/status/{status}             # Filtrar por status
GET    /api/clientes/buscar/nome?nome={nome}    # Buscar por nome
GET    /api/clientes/buscar/cidade?cidade={cidade} # Buscar por cidade
POST   /api/clientes                             # Criar novo cliente
PUT    /api/clientes/{id}                        # Atualizar cliente
DELETE /api/clientes/{id}                        # Deletar cliente
```

**Status Válidos**: `ATIVO`, `INATIVO`, `BLOQUEADO`

### Solicitações (CRUD)

```
GET    /api/solicitacoes                         # Listar todas
GET    /api/solicitacoes/{id}                    # Obter por ID
GET    /api/solicitacoes/status/{status}         # Filtrar por status
POST   /api/solicitacoes                         # Criar nova
PUT    /api/solicitacoes/{id}                    # Atualizar
DELETE /api/solicitacoes/{id}                    # Deletar
```

**Status Válidos**: `PENDENTE`, `EM_ANALISE`, `APROVADA`, `REPROVADA`, `CANCELADA`

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

### Exemplo de Requisições com cURL

#### Criar Cliente

```bash
curl -X POST http://localhost:8080/api/clientes \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "João Silva",
    "cpf": "12345678901",
    "email": "joao@example.com",
    "cidade": "São Paulo",
    "status": "ATIVO"
  }'
```

#### Listar Clientes

```bash
curl http://localhost:8080/api/clientes
```

#### Buscar Cliente por Nome

```bash
curl http://localhost:8080/api/clientes/buscar/nome?nome=João
```

#### Filtrar por Status

```bash
curl http://localhost:8080/api/clientes/status/ATIVO
```

#### Obter Cliente por ID

```bash
curl http://localhost:8080/api/clientes/1
```

#### Atualizar Cliente

```bash
curl -X PUT http://localhost:8080/api/clientes/1 \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "João da Silva",
    "cpf": "12345678901",
    "email": "joao.silva@example.com",
    "cidade": "Rio de Janeiro",
    "status": "ATIVO"
  }'
```

#### Deletar Cliente

```bash
curl -X DELETE http://localhost:8080/api/clientes/1
```

---

## Recursos Principais

### Implementados ✅

- [x] Estrutura base com Spring Boot e Angular
- [x] CRUD de Clientes com 30 campos
- [x] CRUD de Solicitações
- [x] Banco de dados com JPA/Hibernate
- [x] Swagger/OpenAPI Documentation
- [x] CORS configurado
- [x] Health Check Endpoint
- [x] Frontend embarcado no JAR
- [x] Docker Compose para desenvolvimento
- [x] Listagem com paginação
- [x] Busca e filtros
- [x] Validação de dados
- [x] Componentes reutilizáveis

### Em Desenvolvimento 🚧

- [ ] Autenticação JWT
- [ ] Upload de documentos
- [ ] Cálculo automático de impostos
- [ ] Módulo de relatórios
- [ ] Testes unitários e integração
- [ ] CI/CD (GitHub Actions)
- [ ] Cache com Redis
- [ ] Logging centralizado
- [ ] Exportação para PDF
- [ ] Notificações por email

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

**Última mudança**: Adição do Módulo de Clientes com CRUD completo (17 arquivos)
