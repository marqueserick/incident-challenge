# Incident API
## Esse projeto é a solução para o desafio de criar uma API Rest para inserir, atualizar, ler e deletar dados de incidentes.
### O projeto foi desenvolvido utilizando Spring Framework e as seguintes bibliotecas/módulos:
* **H2 Database**: Banco de dados embarcado para testar a persistência de dados.
* **Spring Data JPA**: 	Para implementar as interfaces de camadas de acessos de dados.
* **Spring Web**: Para criação da aplicação RESTful, possibilitando a comunicação da aplicação via web.
* **Lombok**: Utilizada para criação de getters, setters e construtores por meio de anotações providas pela biblioteca.
* **SpringFox**: Biblioteca responsável por documentar a API, explicitando seus endpoints, parâmetros e respostas das requisições.

### Requisitos para compilação
#### Você vai precisar ter instalado:
* **Java 11** - [Clique aqui para baixar](https://download.java.net/java/GA/jdk11/13/GPL/openjdk-11.0.1_windows-x64_bin.zip) 
* **Maven 3** - [Clique aqui para baixar](https://dlcdn.apache.org/maven/maven-3/3.8.7/binaries/apache-maven-3.8.7-bin.zip)
* **IncidentAPI** - [Clique aqui para baixar](https://github.com/marqueserick/incident-challenge/archive/refs/heads/main.zip)

### Compilando o projeto
#### Após descompactar os arquivos, no diretório de sua preferência, siga os passos abaixo para compilar o projeto
1. Clique com o botão direito do mouse em Este Computador no Explorador de Arquivos do Windows. Selecione a opção Propriedades e depois em Configurações Avançadas do Sistema, no lado direito.
1. Ao abrir uma nova janela, clique em Variáveis de Ambiente e depois clique em Novo, na parte superior. Crie uma variável de ambiente com o nome MAVEN_HOME usando o caminho do diretório onde está descompactado o Maven como valor para a variável.
Ex: 
`C:\Users\seu_user\Downloads\apache-maven-3.8.7`
1. Selecione a variável Path e clique em Editar depois em Novo e adicione o seguinte valor: `%MAVEN_HOME%\bin`
1. Após criar esse novo valor, clique em Novo e adicione o caminho do diretório onde está descompactado a pasta bin do Java.
Ex: `C:\Users\seu_user\Downloads\jdk-11.0.1\bin`. 
1.Agora, com Java e Maven configurados na sua máquina, abra o Prompt de Comando e navegue até o diretório onde está salvo o projeto.
Você pode copiar o caminho onde está salvo o IncidentAPI e executar o seguinte comando `cd caminho\do\projeto`. Certifique-se de que está acessando a raiz do projeto. 
Ex: `C:\Users\seu_user\Downloads\incident-challenge-main`
1. Execute o seguinte comando: 
```
mvn spring-boot:run
```
O Maven vai baixar as dependências, compilar e executar o projeto.
1. Entre em `http://localhost:8080/swagger-ui.html` pelo navegador de sua preferência para acessar os endpoints da API por meio do Swagger.