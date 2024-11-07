# Sistema de Gerenciamento de Funcionários

Este projeto é uma aplicação web para gerenciamento de funcionários, permitindo o cadastro, listagem, edição e exclusão de funcionários. A aplicação foi desenvolvida utilizando o framework Spring Boot, Thymeleaf para renderização de templates, e DataTables para a funcionalidade de busca e paginação na lista de funcionários.

## Funcionalidades

- **Cadastro de Funcionários**: O usuário pode cadastrar um novo funcionário preenchendo nome, função, data de admissão e salário.
- **Listagem de Funcionários**: A aplicação permite visualizar uma lista de todos os funcionários cadastrados, com opções para edição e exclusão.
- **Edição de Funcionários**: O usuário pode editar os dados de um funcionário existente.
- **Exclusão de Funcionários**: O usuário pode excluir um funcionário existente.
- **Busca e Paginação**: A aplicação permite buscar funcionários por nome ou função, além de paginar os resultados utilizando DataTables.

## Tecnologias Utilizadas

- **Java**: Linguagem principal de desenvolvimento.
- **Spring Boot**: Framework para construção de aplicações web baseadas em Java.
  - **Spring Data JPA**: Utilizado para persistência de dados.
  - **Spring MVC**: Utilizado para o controle da aplicação.
  - **Spring Boot DevTools**: Para recarregamento automático durante o desenvolvimento.
- **Thymeleaf**: Motor de templates para renderização das páginas HTML.
- **Bootstrap**: Utilizado para o layout e design responsivo.
- **DataTables (jQuery Plugin)**: Utilizado para implementar busca, paginação e ordenação na tabela de funcionários.
- **H2 Database**: Banco de dados em memória utilizado para desenvolvimento local.

## Estrutura do Projeto

### 1. **Controller**

O controlador principal é o `FuncionarioController.java`, responsável por mapear as rotas de criação, edição, listagem e exclusão de funcionários. O controlador interage com o serviço `FuncionarioService` para acessar a lógica de negócio.

- **Rotas principais**:
  - `/funcionario/listagem`: Lista todos os funcionários, com busca e paginação.
  - `/funcionario`: Exibe o formulário de criação de funcionário.
  - `/funcionario/formFuncionario`: Exibe o formulário de edição de funcionário.
  - `/funcionario`: POST request para salvar ou atualizar um funcionário.
  - `/funcionario`: DELETE request para excluir um funcionário.

### 2. **Service**

A camada de serviço implementada em `FuncionarioServiceImpl.java` contém a lógica de negócio para salvar, atualizar, excluir e buscar funcionários.

- **Métodos principais**:
  - `salvarOuAtualizar(Funcionario funcionario)`: Salva ou atualiza um funcionário.
  - `listarTodos(Pageable pageable)`: Lista todos os funcionários com paginação.
  - `buscarPorNomeEFuncao(String nome, String funcao, Pageable pageable)`: Busca funcionários por nome e/ou função.
  - `buscarPorId(Long id)`: Retorna um funcionário pelo seu ID.
  - `excluir(Long id)`: Exclui um funcionário pelo seu ID.

### 3. **Repository**

O repositório `FuncionarioRepository.java` estende `JpaRepository`, o que permite operações de CRUD automáticas no banco de dados sem a necessidade de escrever queries SQL.

### 4. **View (Thymeleaf)**

Os templates HTML estão localizados na pasta `src/main/resources/templates`. Os principais arquivos de view são:

- `listagem.html`: Exibe a lista de funcionários com busca e paginação.
- `formFuncionario.html`: Formulário para cadastro e edição de funcionários.

### 5. **Front-end**

- **DataTables**: Integrado no arquivo `listagem.html` para fornecer busca em tempo real e paginação.
- **Bootstrap**: Utilizado para estilizar os formulários e botões, tornando a interface mais agradável.

### 6. **Banco de Dados**

Para o ambiente de desenvolvimento, o banco de dados H2 foi utilizado, rodando em memória. O banco de dados armazena os registros de funcionários, e é possível acessá-lo pela interface web H2.

A configuração do H2 está no arquivo `application.properties`:

```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.h2.console.enabled=true
spring.jpa.hibernate.ddl-auto=update
spring.datasource.platform=h2
