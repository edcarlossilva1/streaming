# Projeto pós graduação | Tech challenge - parquimetro fase 3

Projeto Teche Challenge realizado para pós-graduação [FIAP](https://www.fiap.com.br/) do curso de [Arquitetura e desenvolvimentoJAVA](https://postech.fiap.com.br/curso/arquitetura-desenvolvimento-java) propõe na terceira fase do curso o desenvolvimento de um sistema WEB, com interfaces e APIS, para cadastro de cliente, endereços, veiculos e gerenciamneto de estacionamento - (Parquimetro), com a finalidade de calcular o consumo durante o periodo de utilização da vaga, assim como escolher formas de pagamentos entre PIX, cartão de crédito ou de débito. A API foi desenvolvida com as tecnologias Spring Boot, Java17, Maven e banco de dados interno h2. e banco de dados Postgres em nuvem no Docker o objetivo de uma solução pratica com a utilização de endpoints para realização de operações  de criação, atualização e recuperação de registros. 

## Índice

1. [Tecnologias](#tecnologias)
2. [Ferramentas](#ferramentas)
3. [Documentação](/DOCUMENTACAO.md)
4. [Jornada](#jornada)
5. [Autor](#autor)
6. [Licença](#licença)

## Tecnologias

Tecnologias utilizadas durante o desenvolvimento do projeto.

### [Java 17](https://docs.oracle.com/en/java/javase/17/docs/api/)
Linguagem de programação escolhida para implementar a lógica do sistema, garantindo confiabilidade, segurança e escalabilidade.

### [Spring Boot](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)
Utilizado como framework para agilizar o desenvolvimento da API, oferecendo recursos como injeção de dependências, mapeamento de URLs, tratamento de requisições HTTP e muito mais.

### [h2](https://www.postgresql.org/docs/)
Banco de dados utilizado para armazenar e gerenciar as informações relacionadas a eletrodomésticos, endereços e pessoas. O PostgreSQL é conhecido por sua robustez e confiabilidade, adequado para aplicações de larga escala.

### [PostgreSQL](https://www.postgresql.org/docs/)
Banco de dados utilizado para armazenar e gerenciar as informações relacionadas a eletrodomésticos, endereços e pessoas.

### [Maven](https://maven.apache.org/guides/index.html)
Gerenciador de dependências utilizado para facilitar a configuração e o gerenciamento das bibliotecas e dependências do projeto.


## Ferramentas

### [Eclipse IDE](https://eclipseide.org)
Ambiente de desenvolvimento integrado (IDE) utilizado para escrever, depurar e testar o código-fonte do projeto. O Eclipse possui recursos avançados de produtividade que facilitãoo desenvolvimento em Java e agiliza o processo de construção da API's.

### [Postman](https://www.postman.com/)
Plataforma de colaboração e testes de API que permite enviar e receber solicitações HTTP, testar os endpoints da API, verificar as respostas e realizar a depuração de forma eficiente.

### [Git](https://git-scm.com/doc)
Sistema de controle de versão utilizado para rastrear alterações no código-fonte, facilitando o trabalho em equipe, o versionamento e a colaboração no projeto.

### [GitHub](https://github.com/)
Plataforma de hospedagem de repositórios de controle de versão Git, utilizada para armazenar e gerenciar o código-fonte do projeto. O GitHub permite o trabalho colaborativo, controle de versões, rastreamento de alterações e facilita a integração com ferramentas de desenvolvimento.

#### [Docker](https://www.docker.com/products/docker-desktop/)
Software de conteinização para desenvolvedores, possibilitando o empacotamento de uma aplicação ou ambiente dentro de um container, se tornando portátil para qualquer outro host que contenha o Docker instalado. Então, você consegue criar, implantar, copiar e migrar de um ambiente para outro com maior flexibilidade.

###Estruturas de Bancos de dados utilizados no Projeto

## Modelo de Banco de dados h2 Executado ao Subir a aplicação no Eclipse.

1. Tabelas Criadas no banco de dados H2 após subir a aplicação no Eclipse
   <img width="686" alt="Criando Tabelas no Postgree" src="https://github.com/edcarlossilva1/parquimetro/assets/138680851/d8107fd3-4355-4e83-86d1-501e98eb7c94">

2. Consutas realizadas no banco de dados h2 após inserção de dados utilizando o metodo Post através do Postman
  
   ## Consulta de Clientes banco de dados h2
   <img width="686" alt="Consulta Cliente h2" src="https://github.com/edcarlossilva1/parquimetro/assets/138680851/6fcb56e4-aac1-4aa0-9ffd-caf72318b7d0">

   ## Consulta de Endereços banco de dados h2
   <img width="686" alt="Cosulta Endereço h2" src="https://github.com/edcarlossilva1/parquimetro/assets/138680851/abe88ee6-122d-4df6-ba5a-e95408633ab6">

   ## Consulta de Veiculos banco de dados h2
   <img width="686" alt="Consulta Veiculo h2 " src="https://github.com/edcarlossilva1/parquimetro/assets/138680851/a1c7c9e7-b635-4c97-8cc3-e524c48fc120">

   ## Consulta Parquimetro banco de dados h2
   <img width="686" alt="Consulta Parquimetro h2" src="https://github.com/edcarlossilva1/parquimetro/assets/138680851/8674ae79-2084-4d2c-a44c-7d931352b19c">

## Passos para a execução do projeto utilizando PostgreSQL

1. Instale o Docker Desktop e configure o PostgreSQL: 

#### *Script para subir meu servidor e banco postgres no docker via terminal powershell* <br/><br/>
```   
version: "3.7"
services:
  # ====================================================================================================================
  # POSTGRES SERVER
  # ====================================================================================================================
  pg-docker:
    image: postgres:14-alpine
    container_name: park-postgresql
    environment:
      POSTGRES_DB: mydatabase
      POSTGRES_PASSWORD: 1234567
    ports:
      - 5433:5432
    volumes:
      - ./.data/postgresql/data:/var/lib/postgresql/data
    networks:
      - ed-network
  # ====================================================================================================================
  # PGADMIN
  # ====================================================================================================================
  pgadmin-docker:
    image: dpage/pgadmin4
    container_name: park-pgadmin
    environment:
      PGADMIN_DEFAULT_EMAIL: me@example.com
      PGADMIN_DEFAULT_PASSWORD: 1234567
    ports:
      - 5050:80
    volumes:
      - ./.data/pgadmin:/var/lib/pgadmin
    depends_on:
      - pg-docker
    networks:
      - ed-network
# ======================================================================================================================
# REDE
# ======================================================================================================================
networks:
  ed-network:
    driver: bridge
```
#### *Passos para realizar após a execução do script pelo powershell* <br/><br/>

2. Execute e inicialize os serviços na sua máquina com o DockerDesktop 
   <img width="829" alt="Subindo serviços pgadmin e pgpostgres" src="https://github.com/edcarlossilva1/parquimetro/assets/138680851/84bfaf25-51f0-47dc-8518-e376801fa88e">

3. Execute o Postgres através do endereço![Logo do Markdown](img/markdown.png) http://localhost:5050/browser/
   <img width="829" alt="Acessando o pgAdmin Postgres" src="https://github.com/edcarlossilva1/parquimetro/assets/138680851/a38ab913-4749-4f53-953d-6e409dc425c4">

4. Criando Tabelas no banco de dados Postgres
   <img width="829" alt="Criando Tabelas no Postgree" src="https://github.com/edcarlossilva1/parquimetro/assets/138680851/ d8107fd3-4355-4e83-86d1-501e98eb7c94">

4. Visualizando Base, schemas, tabelas e relacionamentos.
   <img width="829" alt="RelacionamentoTabelasPostgree" src="https://github.com/edcarlossilva1/parquimetro/assets/138680851/9fb51570-baae-4da5-9de9-1d1fa1b677a5">

5. Consultas de tabelas no Postgres em nuvem pelo servidor PgAdmin. 
   
   ## Consulta de Clientes banco de dados Postgres
   <img width="829" alt="Consulta Cliente Postgres" src="https://github.com/edcarlossilva1/parquimetro/assets/138680851/3a2f3580-81e9-4d2a-ab38-f2780e6f7b80">

   ## Consulta de Endereços banco de dados Postgres
   <img width="829" alt="Consulta Endereco Postgres " src="https://github.com/edcarlossilva1/parquimetro/assets/138680851/9435ffda-bcf7-47ff-aa56-03371d1dbc01">

   ## Consulta de Veiculos banco de dados Postgres
   <img width="829" alt="Consulta Veiculo Postgres" src="https://github.com/edcarlossilva1/parquimetro/assets/138680851/c8ca16b1-8d17-493d-82b9-235f14a866c2">

   ## Consulta Parquimetro banco de dados Postgres
   <img width="829" alt="Consulta Parquimetro Postgres" src="https://github.com/edcarlossilva1/parquimetro/assets/138680851/2a4f1dc1-abf1-4b8e-bd04-96433da51ee4">



## Jornada

### Primeira fase

O desenvolvimento do projeto foi muito desafiador uma vez que não trabalho como programador utilizando a linguagem de programação JAVA e também por ter encarado o desafio sozinho, obtive conhecimento com as live's coda comigo e os videos da plataforma da Fiap e Alura. 
Para mim é tudo novo tenho o conhecimento bem superficial, espero ter atingido um pouco da espectiva do proposto no exercicio e pretendo aprimorar mais ainda com a continuidade da Segunda fase. 

### Segunda fase

Nesta segunda fase o desafio continua grande, estou aprendendo muito com as lives do coda comigo, tem me facilitado muito em alguns entendimentos e abordagens para aplicação em meu projeto. Prentendo evoluir mais o projeto na terceira fase.  

### Terceira fase

Nesta terceira fase consegui ter um melhor desenpenho no desenvolvimento do que foi proposto para o negócio, com mais clareza e entendimento nas lives do coda comigo, consegui melhorar minha aplicação e utilizar nos processo de CRUD os conceitos de relacionamento OneToOne, ManyToOne, OneToMany, ManyToMany, tanto no contexto unidirecional quanto no bidirecional, aplicando as camadas de segurança e realizando o tratamento das exceções, para garantira a validação de dados e a sua segurança. Para mim foi muito interessante essa troca de experincia e informações nas lives, em meu projeto estou conseguindo aplicar muitas dicas e aprendizados, agora consigo enteder melhor meu código e como funciona e para que servem os padrões de camadas, consegui aplicar a utilização do banco de dados em nuvem não requerendo consumo da máquina local, além de possibilitar o desenvolvimento em ambientes diferentes como ambiente de desenvolvimento, ambiente de teste e ambiente de produção para quando for o caso de colocar a aplicação em nuvem.

## Autor

- [Ed Carlos](email: rm349820@fiap.com.br)

Agradeço a minha esposa[Priscia Angelica da Silva] que continua contribuindo com o projeto me apoiando com as atividades pessoais em que não pude participar devido aos estudos.


## Licença

[Licença MIT](https://opensource.org/license/mit/): permite o uso, a modificação e a distribuição do software sem restrições significativas.

