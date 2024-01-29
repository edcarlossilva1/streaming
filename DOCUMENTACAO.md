# Documentação

Esta documentação tem como objetivo listar, descrever e exemplificar os endpoints de todas as APIs do projeto de forma a facilitar o consumo da API pelos clientes.

### **Índice**
:
👥 [Cliente](#-api-de-clientes) \
🌎 [Endereços](#-api-de-enderecos) \
🚗 [Veiculos](#-api-de-veiculos) \
🎌 [Parquimetro](#-api-de-parquimetro)
<br />


# 👥 API de Clientes
A API de clientes consiste em um conjunto de endpoints para gerenciar os clientes. Ela dispõe de métodos para criação, edição, busca e listagem de clientes. <br /><br />

📌
### 🟢 **POST** http://localhost:81/cliente
\
Cria um cliente através dos dados recebidos via JSON no corpo da requisição.

#### *Exemplo de inserção* <br /><br />
```
        {
            "nome": "Ed Carlos",
            "nascimento": "2023-11-03",
            "sexo":"Masculino",
            "email":"edcarlos.1@java.com"
        }

        {
            "nome": "Priscila ",
            "nascimento": "2023-10-02",
            "sexo":"Feminino",
            "email":"priscila.1@java.com"
        }
```
<br />

📌
### 🔵 **GET** http://localhost:81/cliente
\
Lista todos os clientes contidos na base de dados.

#### *Exemplo de requisição* <br /><br />

```
        {
            "id_cliente": 2,
            "nome": "Priscila ",
            "dtcriacao": "2023-11-15T15:54:39.025836Z",
            "nascimento": "2023-10-02",
            "sexo": "Feminino",
            "email": "priscila.1@java.com",
            "endereco": []
        },
        {
            "id_cliente": 1,
            "nome": "Ed Carlos",
            "dtcriacao": "2023-11-15T12:48:34.151570Z",
            "nascimento": "2023-11-03",
            "sexo": "Masculino",
            "email": "edcarlos.1@java.com",
            "endereco": []
        }
```
<br />


📌
### 🔵 **GET** http://localhost:81/cliente/1
\
Lista um cliente especifico passando o seu ID.

#### *Exemplo de requisição por ID* <br /><br />

```
            {
            "id_cliente": 1,
            "nome": "Ed Carlos",
            "dtcriacao": "2023-11-15T12:48:34.151570Z",
            "nascimento": "2023-11-03",
            "sexo": "Masculino",
            "email": "edcarlos.1@java.com",
            "endereco": []
            }
```
<br />

📌
### 🟡 **PUT** http://localhost:81/cliente/1
\
Atualizando informações de um cliente especifico passando o seu ID.

#### *Exemplo de atualização por ID* <br />
#### *Neste caso atualizamos a data de nascimento*<br/>
```
   {
    "nome": "Ed Carlos",
    "nascimento":" 1989-11-03",
    "sexo":"Masculino",
    "email":"edcarlos.1@java.com"
   }
```
#### *Resultado antes de atualizar a informação*
```
            {
            "id_cliente": 1,
            "nome": "Ed Carlos",
            "dtcriacao": "2023-11-15T12:48:34.151570Z",
            "nascimento": "2023-11-03",
            "sexo": "Masculino",
            "email": "edcarlos.1@java.com",
            "endereco": []
            }
```
#### *Resultado após a atualização* 
```
    {
        "id_cliente": 1,
        "nome": "Ed Carlos",
        "dtcriacao": "2023-11-15T12:48:34.151570Z",
        "email": "edcarlos.1@java.com",
        "nascimento": "1989-11-03",
        "sexo": "Masculino"
    }
```

📌
### 🔴 **DELETE** http://localhost:81/cliente/1
\
Deletando um cliente especifico passando o seu ID.

#### *Exemplo de exclusão de dados do Cliente por ID* <br /><br />
```
    Retorno: 204 No Content 

    Exclusão Realizada com Sucesso!
```
#### *Resultado utilizando o metodo GET por ID após a exclusão* 
🔵 **GET** http://localhost:81/cliente/1
```
    {
        "timestamp": "2023-11-15T19:57:35.575214800Z",
        "status": 404,
        "error": "Entidade não encontrada",
        "message": "Cliente não encontrado",
        "path": "/cliente/1"
    }
```
<br />

# 🌎 API de Endereços
A API de endereços consiste em um conjunto de endpoints para gerenciar os endereços. Ela dispõe de métodos para criação, edição, busca e listagem de endereços. <br /><br />

📌
### 🟢 **POST** http://localhost:81/endereco
\
Cria um Endereço através dos dados recebidos via JSON no corpo da requisição.

#### *Exemplo de inserção* <br /><br />
```
        {
            "endereco": "Rua Analia Franco",
            "numero": 346,
            "bairro":"Vila Buarque",
            "cidade":"São Paulo",
            "estado":"SP",
            "cep":"02180059",
           "cliente":
            {
                "id_cliente": 1
            }
        }
```
<br />

📌
### 🔵 **GET** http://localhost:81/endereco
\
Lista todos os endereços contidos na base de dados.

#### *Exemplo de requisição* <br /><br />

```
     {
            "id_endereco": 2,
            "endereco": "Rua Elzebio Matozo",
            "numero": 321,
            "bairro": "Vila Sonia",
            "cidade": "02180090",
            "estado": "São Paulo",
            "cep": "SP",
            "cliente": {
                "id_cliente": 2,
                "nome": "Priscila ",
                "dtcriacao": "2023-11-16T02:42:14.871390Z",
                "email": "priscila.1@java.com",
                "nascimento": "2023-10-02",
                "sexo": "Feminino"
            }
        },
        {
            "id_endereco": 1,
            "endereco": "Rua Analia Franco",
            "numero": 346,
            "bairro": "Vila Buarque",
            "cidade": "02180059",
            "estado": "São Paulo",
            "cep": "SP",
            "cliente": {
                "id_cliente": 1,
                "nome": "Ed Carlos",
                "dtcriacao": "2023-11-16T02:36:21.227514Z",
                "email": "edcarlos.1@java.com",
                "nascimento": "2023-11-03",
                "sexo": "Masculino"
            }
        }
```
<br />


📌
### 🔵 **GET** http://localhost:81/endereco/1
\
Lista um endereco especifico passando o seu ID.

#### *Exemplo de requisição por ID* <br /><br />

```
            {
                "id_endereco": 1,
                "endereco": "Rua Analia Franco",
                "numero": 346,
                "bairro": "Vila Buarque",
                "cidade": "02180059",
                "estado": "São Paulo",
                "cep": "SP",
                "cliente": {
                    "id_cliente": 1,
                    "nome": "Ed Carlos",
                    "dtcriacao": "2023-11-16T02:36:21.227514Z",
                    "email": "edcarlos.1@java.com",
                    "nascimento": "2023-11-03",
                    "sexo": "Masculino"
                }
            }
```
<br />

📌
### 🟡 **PUT** http://localhost:81/endereco/1
\
Atualizando informações de um endereco especifico passando o seu ID.

#### *Exemplo de atualização por ID* <br />
#### *Neste caso atualizamos o cep*<br/>
```
        {
            "endereco": "Rua Analia Franco",
            "numero": 346,
            "bairro":"Vila Buarque",
            "cidade":"São Paulo",
            "estado":"SP",
            "cep":"02180399",
           "cliente":
            {
                "id_cliente": 1
            }
        }
```
#### *Resultado antes de atualizar a informação*
```
        {
            "id_endereco": 1,
            "endereco": "Rua Analia Franco",
            "numero": 346,
            "bairro": "Vila Buarque",
            "cidade": "02180059",
            "estado": "São Paulo",
            "cep": "SP",
            "cliente": {
                "id_cliente": 1,
                "nome": "Ed Carlos",
                "dtcriacao": "2023-11-16T02:36:21.227514Z",
                "email": "edcarlos.1@java.com",
                "nascimento": "2023-11-03",
                "sexo": "Masculino"
            }
        }
```
#### *Resultado após a atualização* 
```
        {
            "id_endereco": 1,
            "endereco": "Rua Analia Franco",
            "numero": 346,
            "bairro": "Vila Buarque",
            "cidade": "02180399",
            "estado": "São Paulo",
            "cep": "SP",
            "cliente": {
                "id_cliente": 1,
                "nome": "Ed Carlos",
                "dtcriacao": "2023-11-16T02:36:21.227514Z",
                "email": "edcarlos.1@java.com",
                "nascimento": "2023-11-03",
                "sexo": "Masculino"
            }
        }
```

📌
### 🔴 **DELETE** http://localhost:81/endereco/1
\
Deletando um endereço especifico passando o seu ID.

#### *Exemplo de exclusão de dados do Endereço por ID* <br /><br />
```
    Retorno: 204 No Content 

    Exclusão Realizada com Sucesso!
```
#### *Resultado utilizando o metodo GET por ID após a exclusão* 
🔵 **GET** http://localhost:81/endereco/1
```
    {
        "timestamp": "2023-11-16T02:51:59.599603Z",
        "status": 404,
        "error": "Entidade não encontrada",
        "message": "Endereco não encontrado",
        "path": "/endereco/1"
    }
```
<br />

# 🚗 API de Veiculos
A API de veiculos consiste em um conjunto de endpoints para gerenciar os veiculos. Ela dispõe de métodos para criação, edição, busca e listagem de veiculos. <br /><br />

📌
### 🟢 **POST** http://localhost:81/veiculo
\
Cria um Veiculo através dos dados recebidos via JSON no corpo da requisição.

#### *Exemplo de inserção* <br /><br />
```
    {
        "ds_modelo":"718 BOXTER",
        "ds_marca":"PORSCHE",
        "cor":"PRETO",
        "placa":"FZT9195",
        "cliente":
        {
            "id_cliente": 1
        }
    }
```
<br />

📌
### 🔵 **GET** http://localhost:81/veiculo
\
Lista todos os veiculo contidos na base de dados.

#### *Exemplo de requisição* <br /><br />

```
      {
            "id_veiculo": 2,
            "ds_modelo": "718 BOXTER",
            "ds_marca": "PORSCHE",
            "cor": "PRETO",
            "placa": "FZT9195",
            "cliente": {
                "id_cliente": 1,
                "nome": "Ed Carlos",
                "dtcriacao": "2023-11-16T03:02:41.810842Z",
                "email": "edcarlos.1@java.com",
                "nascimento": "1989-11-03",
                "sexo": "Masculino"
            }
        },
        {
            "id_veiculo": 3,
            "ds_modelo": "VALHALLA",
            "ds_marca": "ASTON MARTIN",
            "cor": "PRATA",
            "placa": "FZT9165",
            "cliente": {
                "id_cliente": 2,
                "nome": "Priscila ",
                "dtcriacao": "2023-11-16T03:03:01.926371Z",
                "email": "priscila.1@java.com",
                "nascimento": "2023-10-02",
                "sexo": "Feminino"
            }
        },
        {
            "id_veiculo": 1,
            "ds_modelo": "HURACAN",
            "ds_marca": "LAMBORGHINI",
            "cor": "PRATA",
            "placa": "FZT9105",
            "cliente": {
                "id_cliente": 1,
                "nome": "Ed Carlos",
                "dtcriacao": "2023-11-16T03:02:41.810842Z",
                "email": "edcarlos.1@java.com",
                "nascimento": "1989-11-03",
                "sexo": "Masculino"
            }
        }
```
<br />


📌
### 🔵 **GET** http://localhost:81/veiculo/1
\
Lista um veiculo especifico passando o seu ID.

#### *Exemplo de requisição por ID* <br /><br />

```
        {
            "id_veiculo": 1,
            "ds_modelo": "HURACAN",
            "ds_marca": "LAMBORGHINI",
            "cor": "PRATA",
            "placa": "FZT9105",
            "cliente": {
                "id_cliente": 1,
                "nome": "Ed Carlos",
                "dtcriacao": "2023-11-16T03:02:41.810842Z",
                "email": "edcarlos.1@java.com",
                "nascimento": "1989-11-03",
                "sexo": "Masculino"
            }
        }
```
<br />

📌
### 🟡 **PUT** http://localhost:81/veiculo/1
\
Atualizando informações de um veiculo especifico passando o seu ID.

#### *Exemplo de atualização por ID* <br />
#### *Neste caso atualizamos a placa*<br/>
```
        {
            "ds_modelo":"HURACAN",
            "ds_marca":"LAMBORGHINI",
            "cor":"PRATA",
            "placa":"FZT9105",
            "cliente":
            {
                "id_cliente": 1
            }
        }
```
#### *Resultado antes de atualizar a informação*
```
        {
            "id_veiculo": 1,
            "ds_modelo": "HURACAN",
            "ds_marca": "LAMBORGHINI",
            "cor": "PRATA",
            "placa": "FZT9105",
            "cliente": {
                "id_cliente": 1,
                "nome": "Ed Carlos",
                "dtcriacao": "2023-11-16T03:02:41.810842Z",
                "email": "edcarlos.1@java.com",
                "nascimento": "1989-11-03",
                "sexo": "Masculino"
            }
        }
```
#### *Resultado após a atualização* 
```
        {
            "id_veiculo": 1,
            "ds_modelo": "HURACAN",
            "ds_marca": "LAMBORGHINI",
            "cor": "PRATA",
            "placa": "ZZT9105",
            "cliente": {
                "id_cliente": 1,
                "nome": "Ed Carlos",
                "dtcriacao": "2023-11-16T03:02:41.810842Z",
                "email": "edcarlos.1@java.com",
                "nascimento": "1989-11-03",
                "sexo": "Masculino"
            }
        }
```

📌
### 🔴 **DELETE** http://localhost:81/veiculo/1
\
Deletando um veiculo especifico passando o seu ID.

#### *Exemplo de exclusão de dados do Veiculo por ID* <br /><br />
```
    Retorno: 204 No Content 

    Exclusão Realizada com Sucesso!
```
#### *Resultado utilizando o metodo GET por ID após a exclusão* 
🔵 **GET** http://localhost:81/veiculo/1
```
        {
            "timestamp": "2023-11-16T03:23:42.091771Z",
            "status": 404,
            "error": "Entidade não encontrada",
            "message": "Veiculo não encontrado",
            "path": "/veiculo/1"
        }
```
<br />

# 🎌 API de Parquimetro
A API de veiculos consiste em um conjunto de endpoints para gerenciar os veiculos que estacionam. Ela dispõe de métodos para criação, edição, busca e listagem de veiculos estacionados. <br /><br />

📌
### 🟢 **POST** http://localhost:81/parquimetro
\
Cria um cadastrp de estacionamento do veiculo através dos dados recebidos via JSON no corpo da requisição.

#### *Exemplo de inserção* <br /><br />
```
        {
            "tipoTempo":2,
            "opcaoDePagamento":1,
            "dataHoraInicial":"2023-11-08T08:00:00",
            "dataHoraFinal":"2023-11-08T09:43:00",
            "cliente":
            {
                "id_cliente": 1
            }
        }
```
<br />

📌
### 🔵 **GET** http://localhost:81/parquimetro
\
Lista todos os veiculo de clientes com registros de estacionamentos contidos na base de dados.

#### *Exemplo de requisição* <br /><br />

```
     {
            "id_parquimetro": 1,
            "tipoTempo": 2,
            "opcaoDePagamento": 1,
            "dataHoraInicial": "2023-11-08T10:00:00",
            "dataHoraFinal": "2023-11-08T13:43:00",
            "cliente": {
                "id_cliente": 1,
                "nome": "Ed Carlos",
                "dtcriacao": "2023-11-17T00:17:01.627079Z",
                "email": "edcarlos.1@java.com",
                "nascimento": "2023-11-03",
                "sexo": "Masculino"
            }
        },
        {
            "id_parquimetro": 2,
            "tipoTempo": 2,
            "opcaoDePagamento": 1,
            "dataHoraInicial": "2023-11-08T08:00:00",
            "dataHoraFinal": "2023-11-08T09:43:00",
            "cliente": {
                "id_cliente": 2,
                "nome": "Priscila ",
                "dtcriacao": "2023-11-17T00:17:34.231798Z",
                "email": "priscila.1@java.com",
                "nascimento": "2023-10-02",
                "sexo": "Feminino"
            }
        }
```
<br />


📌
### 🔵 **GET** http://localhost:81/parquimetro/1
\
Lista um veiculo com registros de estacionamento passando o seu ID.

#### *Exemplo de requisição por ID* <br /><br />

```
        {
            "id_parquimetro": 1,
            "tipoTempo": 2,
            "opcaoDePagamento": 1,
            "dataHoraInicial": "2023-11-08T10:00:00",
            "dataHoraFinal": "2023-11-08T13:43:00",
            "cliente": {
                "id_cliente": 1,
                "nome": "Ed Carlos",
                "dtcriacao": "2023-11-17T00:17:01.627079Z",
                "email": "edcarlos.1@java.com",
                "nascimento": "2023-11-03",
                "sexo": "Masculino"
            }
        }
```
<br />

📌
### 🟡 **PUT** http://localhost:81/parquimetro/1
\
Atualizando informações de um veiculo com registro de estacionamento passando o seu ID.

#### *Exemplo de atualização por ID* <br />
#### *Neste caso atualizamos a forma de pagamento*<br/>
```
        {
            "id_parquimetro": 1,
            "tipoTempo":2,
            "opcaoDePagamento":3,
            "dataHoraInicial":"2023-11-08T10:00:00",
            "dataHoraFinal":"2023-11-08T13:43:00",
            "cliente":
            {
                "id_cliente": 1
            }
        }
```
#### *Resultado antes de atualizar a informação*
```
        {
            "id_parquimetro": 1,
            "tipoTempo": 2,
            "opcaoDePagamento": 1,
            "dataHoraInicial": "2023-11-08T10:00:00",
            "dataHoraFinal": "2023-11-08T13:43:00",
            "cliente": {
                "id_cliente": 1,
                "nome": "Ed Carlos",
                "dtcriacao": "2023-11-17T00:17:01.627079Z",
                "email": "edcarlos.1@java.com",
                "nascimento": "2023-11-03",
                "sexo": "Masculino"
            }
        }
```
#### *Resultado após a atualização* 
```
        {
            "id_parquimetro": 1,
            "tipoTempo": 2,
            "opcaoDePagamento": 3,
            "dataHoraInicial": "2023-11-08T10:00:00",
            "dataHoraFinal": "2023-11-08T13:43:00",
            "cliente": {
                "id_cliente": 1,
                "nome": "Ed Carlos",
                "dtcriacao": "2023-11-17T00:17:01.627079Z",
                "email": "edcarlos.1@java.com",
                "nascimento": "2023-11-03",
                "sexo": "Masculino"
            }
        }
```

📌
### 🔴 **DELETE** http://localhost:81/parquimetro/1
\
Deletando o registro de estacionamento de um veiculo e cliente especifico passando o seu ID.

#### *Exemplo de exclusão de dados do registro de estacionamento por ID* <br /><br />
```
    Retorno: 204 No Content 

    Exclusão Realizada com Sucesso!
```
#### *Resultado utilizando o metodo GET por ID após a exclusão* 
🔵 **GET** http://localhost:81/parquimetro/1
```
        {
            "timestamp": "2023-11-17T00:34:53.500891200Z",
            "status": 404,
            "error": "Entidade não encontrada",
            "message": "Registro de  estacionamento não encontrado",
            "path": "/parquimetro/1"
        }
```
<br />
