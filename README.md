# Sistema de Cadastro de Alunos

Bem-vindo ao **Sistema de Cadastro de Alunos**!

Este projeto é uma aplicação com arquitetura em camadas, desenvolvida com **Spring Boot**, que permite o cadastro de alunos e seus respectivos cursos. Utiliza o banco de dados **H2** (em memória), **Flyway** para controle de migrações, e **Swagger** para documentação e teste das APIs. Segue boas práticas de desenvolvimento, como controle de versão com **Git** e hospedagem no **GitHub**.

---

## 📌 Visão Geral do Projeto

O sistema foi desenvolvido para gerenciar alunos e os cursos aos quais estão vinculados. Cada aluno pode ser associado a **um único curso**, enquanto um curso pode ter **vários alunos**.

### Funcionalidades:

- Cadastro de alunos com nome, idade, e-mail, endereço, CPF, telefone e curso.
- Atribuição de um curso a um aluno.
- Gerenciamento de cursos e dos alunos vinculados a eles.

---

## 🛠 Tecnologias Utilizadas

- **Spring Boot** – Criação da aplicação e gerenciamento de dependências.
- **Banco de Dados H2** – Banco em memória para desenvolvimento e testes.
- **Flyway** – Gerenciamento de migrações do banco de dados.
- **JPA (Java Persistence API)** – Mapeamento objeto-relacional (ORM).
- **Spring Data JPA** – Facilita a comunicação com o banco de dados.
- **Swagger** – Documentação interativa da API.
- **Maven** – Build e gerenciamento de dependências.
- **Git** – Controle de versão do código-fonte.
- **GitHub** – Hospedagem do repositório.
- **SQL** – Manipulação de dados no banco.

---

## 🗃 Design do Banco de Dados

### Entidades:

- **Aluno**
  - Atributos: `id`, `nome`, `e-mail`, `idade`, `endereço`, `CPF`, `telefone`.

- **Curso**
  - Atributos: `id`, `nome`, `carga horária`, `valor`, `modalidade`, `data de início`, `data de término`, `descrição`.

### Relacionamento:

- Um aluno está vinculado a **um único curso**.
- Um curso pode estar associado a **vários alunos**.

---

## 🚀 Como Executar o Projeto

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/RiqueISantos/CadastroDeAlunos.git
   ```

2. **Acesse o diretório do projeto:**
   ```bash
   cd CadastroDeAlunos
   ```

3. **Construa o projeto com o Maven:**
   ```bash
   mvn clean install
   ```

4. **Execute a aplicação:**
   ```bash
   mvn spring-boot:run
   ```

5. **Acesse no navegador:**
   ```
   http://localhost:8080
   ```

6. **Documentação da API (Swagger):**
   ```
   http://localhost:8080/swagger-ui.html
   ```

---

## 🤝 Contribuição

Sinta-se à vontade para contribuir com sugestões, melhorias ou reportar problemas através do repositório no GitHub.
