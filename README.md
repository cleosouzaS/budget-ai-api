# 🤖 Budget AI API

API inteligente de gerenciamento financeiro desenvolvida com **Java 17, Spring Boot, Spring AI, OpenAI e MariaDB**.

O projeto funciona como um assistente financeiro capaz de interpretar solicitações em linguagem natural, consultar e cadastrar transações financeiras no banco de dados e interagir com o usuário por meio de voz.

A aplicação utiliza **Inteligência Artificial e Tool Calling** para interpretar as solicitações do usuário e executar operações reais sobre os dados financeiros armazenados no MariaDB.

## 🎯 Objetivo

O objetivo do projeto é desenvolver um assistente financeiro inteligente capaz de interpretar solicitações do usuário utilizando Inteligência Artificial e executar operações reais sobre dados financeiros.

A aplicação permite que o usuário interaja com o sistema utilizando linguagem natural, sem precisar conhecer comandos específicos da API.

Por meio da integração entre **Spring AI, OpenAI, Tool Calling e MariaDB**, o sistema consegue interpretar solicitações, consultar informações financeiras e cadastrar novas transações.

Exemplos de solicitações:

- "Qual é o meu saldo?"
- "Quanto eu gastei?"
- "Quais transações eu tenho cadastradas?"
- "Cadastre uma despesa de 50 reais com alimentação."

## ✨ Funcionalidades

### 💰 Gerenciamento financeiro

- Cadastro de receitas.
- Cadastro de despesas.
- Consulta de transações cadastradas.
- Consulta do total de gastos.
- Consulta do total de receitas.
- Consulta do total de despesas.
- Consulta do saldo atual.
- Persistência das transações no MariaDB.

### 🤖 Inteligência Artificial

- Interpretação de solicitações utilizando linguagem natural.
- Integração com a OpenAI através do Spring AI.
- Utilização de Tool Calling.
- Execução de operações financeiras através de ferramentas específicas.
- Respostas baseadas nos dados armazenados no banco de dados.

### 🎤 Interação por voz

- Recebimento de arquivos de áudio.
- Conversão de áudio em texto.
- Processamento da solicitação utilizando IA.
- Execução das ferramentas financeiras através da solicitação por voz.
- Conversão da resposta da IA em áudio.
- Geração de arquivos de áudio em formato MP3.

## 🏗️ Arquitetura e Tool Calling

O projeto utiliza uma arquitetura em camadas para integrar a Inteligência Artificial às operações financeiras.

A IA interpreta a solicitação do usuário e utiliza ferramentas específicas para consultar ou cadastrar informações no banco de dados.

### 🔧 Tool Calling

As principais ferramentas utilizadas pelo projeto são:

```text
cadastrarTransacao()
consultarTransacoes()
consultarGastos()
consultarSaldo()
```

### 🔄 Fluxo da aplicação

```text
Usuário
   ↓
Solicitação em linguagem natural
   ↓
Spring Boot
   ↓
Spring AI + OpenAI
   ↓
Tool Calling
   ↓
TransacaoTools
   ↓
TransacaoRepository
   ↓
MariaDB
   ↓
Resultado
   ↓
IA
   ↓
Resposta ao usuário
```

### 💡 Exemplo

O usuário pode solicitar:

```text
"Cadastre uma despesa de 30 reais com transporte."
```

A IA interpreta a solicitação e utiliza a ferramenta `cadastrarTransacao()`.

O fluxo ocorre da seguinte forma:

```text
Usuário
   ↓
IA interpreta a solicitação
   ↓
cadastrarTransacao()
   ↓
TransacaoTools
   ↓
TransacaoRepository
   ↓
MariaDB
   ↓
Transação cadastrada
   ↓
IA gera a resposta
   ↓
Usuário recebe a confirmação
```
## 🎤 Interação por Voz

O projeto permite que o usuário envie uma solicitação por meio de um arquivo de áudio.

A aplicação utiliza processamento de voz para converter o áudio em texto, processar a solicitação com Inteligência Artificial e gerar uma resposta em áudio.

### 🗣️ Speech-to-Text

O áudio enviado pelo usuário é convertido em texto.

```text
Áudio do usuário
       ↓
Speech-to-Text
       ↓
Texto
       ↓
Spring AI + OpenAI
```

### 🔊 Text-to-Speech

A resposta gerada pela IA pode ser convertida novamente em áudio.

```text
Resposta da IA
       ↓
Text-to-Speech
       ↓
Arquivo MP3
```

### 🔄 Fluxo completo

```text
🎤 Usuário
       ↓
Áudio
       ↓
Speech-to-Text
       ↓
Texto
       ↓
Spring AI + OpenAI
       ↓
Tool Calling
       ↓
MariaDB
       ↓
Resultado
       ↓
Resposta da IA
       ↓
Text-to-Speech
       ↓
🔊 Arquivo MP3
```

### 💡 Exemplo

O usuário pode enviar um áudio contendo:

```text
"Qual é o meu saldo?"
```

A aplicação converte a fala em texto, processa a pergunta utilizando a IA, consulta os dados financeiros e gera uma resposta.

Exemplo:

```text
Seu saldo atual é R$ 2.850,00.
Receitas: R$ 3.000,00.
Despesas: R$ 150,00.
```

A resposta também pode ser convertida em áudio e disponibilizada como arquivo MP3.


## 🛠️ Tecnologias utilizadas

| Tecnologia | Utilização |
|---|---|
| **Java 17** | Linguagem principal do projeto |
| **Spring Boot 4.0.7** | Desenvolvimento da API e gerenciamento da aplicação |
| **Spring AI 2.0.0** | Integração da aplicação com Inteligência Artificial |
| **OpenAI API** | Processamento das solicitações utilizando IA |
| **Spring Data JPA** | Persistência e acesso aos dados |
| **MariaDB** | Banco de dados relacional |
| **Maven** | Gerenciamento de dependências e build |
| **REST API** | Comunicação entre cliente e aplicação |
| **Jakarta Validation** | Validação dos dados recebidos pela API |
| **Speech-to-Text** | Conversão de áudio em texto |
| **Text-to-Speech** | Conversão de texto em áudio |

## 📁 Estrutura do projeto

```text
budget-ai-api/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/cleosouza/budget_ai_api/
│   │   │       │
│   │   │       ├── audio/
│   │   │       │   ├── AudioService.java
│   │   │       │   └── TtsService.java
│   │   │       │
│   │   │       ├── controller/
│   │   │       │   ├── AudioController.java
│   │   │       │   ├── IAController.java
│   │   │       │   ├── TransacaoController.java
│   │   │       │   └── TtsController.java
│   │   │       │
│   │   │       ├── entity/
│   │   │       │   └── Transacao.java
│   │   │       │
│   │   │       ├── enums/
│   │   │       │   └── TipoTransacao.java
│   │   │       │
│   │   │       ├── exception/
│   │   │       │   └── GlobalExceptionHandler.java
│   │   │       │
│   │   │       ├── repository/
│   │   │       │   └── TransacaoRepository.java
│   │   │       │
│   │   │       ├── service/
│   │   │       │   └── IAService.java
│   │   │       │
│   │   │       ├── tool/
│   │   │       │   └── TransacaoTools.java
│   │   │       │
│   │   │       └── BudgetAiApiApplication.java
│   │   │
│   │   └── resources/
│   │       └── application.properties
│   │
│   └── test/
│       └── java/
│
├── .gitignore
├── pom.xml
├── mvnw
├── mvnw.cmd
├── HELP.md
└── README.md
```

### 📦 Organização dos componentes

- **`audio/`** — Responsável pelo processamento de áudio e conversão de texto em voz.
- **`controller/`** — Contém os endpoints da API REST.
- **`entity/`** — Representa as entidades persistidas no banco de dados.
- **`enums/`** — Contém os tipos utilizados pela aplicação, como receita e despesa.
- **`exception/`** — Responsável pelo tratamento global de exceções.
- **`repository/`** — Responsável pelo acesso aos dados utilizando Spring Data JPA.
- **`service/`** — Contém a lógica relacionada ao processamento da Inteligência Artificial.
- **`tool/`** — Contém as ferramentas utilizadas pelo mecanismo de Tool Calling.
- **`resources/`** — Contém as configurações da aplicação.

## ⚙️ Pré-requisitos

Antes de executar o projeto, é necessário ter instalado:

- **Java 17 ou superior**
- **Maven**
- **MariaDB**
- **Git**
- Uma **chave da OpenAI API**

### 🔎 Verificando o Java

```bash
java -version
```

O projeto foi desenvolvido utilizando **Java 17**.

### 🔎 Verificando o Maven

```bash
mvn -version
```

### 🗄️ Verificando o MariaDB

Verifique se o serviço do MariaDB está em execução:

```bash
sudo systemctl status mariadb
```

Caso necessário:

```bash
sudo systemctl start mariadb
```

---

## 📥 Instalação

Clone o repositório:

```bash
git clone URL_DO_REPOSITORIO
```

Entre na pasta do projeto:

```bash
cd budget-ai-api
```

Compile o projeto:

```bash
mvn clean compile
```

Se a compilação for concluída com sucesso, deverá aparecer:

```text
BUILD SUCCESS
```

---

## ▶️ Executando a aplicação

Execute:

```bash
mvn spring-boot:run
```

A aplicação será iniciada na porta:

```text
http://localhost:8080
```

Quando o Spring Boot estiver funcionando, será exibida uma mensagem semelhante a:

```text
Tomcat started on port 8080
```

E:

```text
Started BudgetAiApiApplication
```

## 🔐 Configuração da OpenAI e MariaDB

### 🤖 Configuração da OpenAI

A aplicação utiliza uma chave da OpenAI para acessar os recursos de Inteligência Artificial.

Por segurança, a chave **não deve ser colocada diretamente no código ou publicada no GitHub**.

Configure a chave como variável de ambiente:

```bash
export OPENAI_API_KEY="SUA_CHAVE_AQUI"
```

Para verificar se a variável foi configurada:

```bash
echo ${OPENAI_API_KEY:+CONFIGURADA}
```

Se estiver configurada, o terminal exibirá:

```text
CONFIGURADA
```

> **Importante:** nunca publique sua chave real da OpenAI no `README.md`, no código-fonte ou no GitHub.

### 🗄️ Configuração do MariaDB

O projeto utiliza o **MariaDB** para armazenar as transações financeiras.

É necessário criar um banco de dados para a aplicação.

Exemplo:

```sql
CREATE DATABASE budget_ai;
```

As configurações de conexão devem ser definidas no arquivo:

```text
src/main/resources/application.properties
```

Exemplo de configuração:

```properties
spring.datasource.url=jdbc:mariadb://localhost:3306/budget_ai
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA
```

As credenciais reais do banco de dados também não devem ser publicadas no GitHub.


## 📡 Endpoints e testes

A API disponibiliza endpoints para interação com as funcionalidades financeiras e de inteligência artificial.

### 🤖 Consulta utilizando IA

Endpoint:

```text
GET /ia
```

Exemplo:

```bash
curl "http://localhost:8080/ia?pergunta=Qual%20%C3%A9%20o%20meu%20saldo%3F"
```

Exemplo de resposta:

```text
Seu saldo atual é R$ 2.850,00.
- Receitas: R$ 3.000,00
- Despesas: R$ 150,00
```

### 📋 Consulta de transações

Exemplo:

```bash
curl "http://localhost:8080/ia?pergunta=Quais%20transa%C3%A7%C3%B5es%20eu%20tenho%20cadastradas%3F"
```

A IA consulta as transações armazenadas no MariaDB e apresenta os dados ao usuário.

### 🎤 Consulta por áudio

Endpoint:

```text
POST /audio
```

Exemplo:

```bash
curl -X POST \
  -F "arquivo=@$HOME/Downloads/pergunta.wav" \
  http://localhost:8080/audio
```

O áudio é convertido em texto, processado pela IA e utilizado para gerar a resposta.

### 🔊 Conversão de texto em áudio

Endpoint:

```text
GET /audio/voz
```

Exemplo:

```bash
curl -G "http://localhost:8080/audio/voz" \
  --data-urlencode "texto=Seu saldo atual é dois mil oitocentos e cinquenta reais" \
  -o "$HOME/Downloads/resposta.mp3"
```

O resultado é um arquivo de áudio no formato MP3.

### ✅ Teste de compilação

Para verificar se o projeto está compilando corretamente:

```bash
mvn clean compile
```

Resultado esperado:

```text
BUILD SUCCESS
```

### 🚀 Teste da aplicação

Após iniciar a aplicação:

```bash
mvn spring-boot:run
```

É possível testar a API utilizando `curl` ou ferramentas como Postman.
