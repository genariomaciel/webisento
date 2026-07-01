# WebIsento

Aplicação Web para Insenção de Impostos na Compra de Veículo

**Migração de**: [isencao](https://github.com/genariomaciel/isencao) (C# Windows Forms)

## Stack Tecnológico

- **Backend**: Java 21 + Spring Boot 3.x
- **Frontend**: Angular 17+
- **Banco de Dados**: H2 (desenvolvimento) / PostgreSQL (produção)
- **Build**: Maven
- **Containerização**: Docker

## Estrutura do Projeto

```
webisento/
├── backend/                 # Spring Boot Application
│   ├── src/
│   ├── pom.xml
│   └── Dockerfile
├── frontend/                # Angular Application
│   ├── src/
│   ├── angular.json
│   ├── package.json
│   └── Dockerfile
├── docker-compose.yml
└── README.md
```

## Quick Start

### Backend

```bash
cd backend
mvn clean install
mvn spring-boot:run
```

A API estará disponível em `http://localhost:8080`

### Frontend

```bash
cd frontend
npm install
ng serve
```

A aplicação estará disponível em `http://localhost:4200`

## Build para Produção

O frontend Angular será compilado e empacotado como um recurso estático dentro do JAR do Spring Boot.

```bash
./build.sh
```

## Docker

```bash
docker-compose up -d
```

## API Documentation

A documentação da API estará disponível em `http://localhost:8080/swagger-ui.html`

## Recursos Principais

- [ ] Cadastro de Solicitação de Isenção
- [ ] Validação de Dados do Veículo
- [ ] Cálculo de Impostos
- [ ] Geração de Documentos
- [ ] Autenticação e Autorização
- [ ] Dashboard com Relatórios

## Contribuindo

Este é um repositório privado. Acesso restrito.

## Licença

Privado - Genário Maciel
