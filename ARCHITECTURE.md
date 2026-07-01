# WebIsento - Arquitetura

## Visão Geral

WebIsento é uma aplicação monolítica web com separação clara entre backend (Java/Spring Boot) e frontend (Angular).

## Componentes Principais

### Backend (Java 21 + Spring Boot 3.x)

**Camadas:**
- **Controller**: `SolicitacaoController` - Endpoints REST
- **Service**: `SolicitacaoService` - Lógica de negócio
- **Repository**: `SolicitacaoRepository` - Acesso a dados
- **Entity**: `Solicitacao` - Modelo de domínio
- **DTO**: `SolicitacaoDTO` - Transferência de dados

**Características:**
- Spring Data JPA para persistência
- Spring Security com CORS configurado
- Swagger/OpenAPI para documentação
- H2 Database (dev) / PostgreSQL (prod)

### Frontend (Angular 17)

**Estrutura:**
- **Components**: Componentes reutilizáveis
- **Services**: Comunicação com a API
- **Routes**: Navegação entre páginas
- **Styles**: SCSS para estilização

**Recursos:**
- Standalone components
- HttpClient para chamadas API
- Proxy configuration para desenvolvimento

## Fluxo de Build

```
1. Frontend Build
   - npm install → npm run build
   - Saída: frontend/dist/webisento-frontend/browser

2. Maven Process Resources
   - Copia arquivos do frontend para backend/target/classes/static

3. Backend Build
   - mvn clean package
   - Resultado: JAR executável com frontend embutido
```

## Deployment

**Desenvolvimento:**
```bash
# Terminal 1
cd backend
mvn spring-boot:run

# Terminal 2
cd frontend
ng serve
```

**Produção:**
```bash
./build.sh
java -jar backend/target/webisento-*.jar
```

## Banco de Dados

**Tabelas:**
- `solicitacoes`: Registra todas as solicitações de isenção

**Campos:**
- `id` (Long, PK)
- `nomeRequerente` (String, obrigatório)
- `cpf` (String, obrigatório, único)
- `placaVeiculo` (String, obrigatório)
- `marcaVeiculo` (String, obrigatório)
- `modeloVeiculo` (String, obrigatório)
- `anoVeiculo` (Integer, obrigatório)
- `tipoVeiculo` (String, obrigatório)
- `valorVeiculo` (Double)
- `status` (Enum: PENDENTE, EM_ANALISE, APROVADA, REPROVADA, CANCELADA)
- `observacoes` (Text)
- `dataCriacao` (LocalDateTime)
- `dataAtualizacao` (LocalDateTime)

## APIs Disponíveis

### Health Check
- `GET /api/public/health` - Verificar status da API

### Solicitações
- `POST /api/solicitacoes` - Criar nova solicitação
- `GET /api/solicitacoes` - Listar todas
- `GET /api/solicitacoes/{id}` - Obter por ID
- `GET /api/solicitacoes/status/{status}` - Filtrar por status
- `PUT /api/solicitacoes/{id}` - Atualizar
- `DELETE /api/solicitacoes/{id}` - Deletar

### Documentação
- `GET /swagger-ui.html` - Swagger UI
- `GET /v3/api-docs` - OpenAPI JSON

## Próximos Passos

- [ ] Implementar autenticação JWT
- [ ] Adicionar validações mais robustas
- [ ] Implementar cálculo de impostos
- [ ] Criar módulo de relatórios
- [ ] Adicionar testes unitários e integração
- [ ] Configurar CI/CD (GitHub Actions)
- [ ] Implementar cache com Redis
- [ ] Adicionar logging centralizado
