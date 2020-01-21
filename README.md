# Desafio-Bolton
Desenvolvimento do desafio proposto pela Arquivei, denominado Desafio Bolton.

## Descrição do Projeto

O projeto tem como objetivo consumir uma API disponibilizada pela Arquivei salvando em um banco de dados relacional todos os registros das notas fiscais retornados pelo end-point. Salvando apenas seu código de acesso (access_key) e o valor total da nota fiscal (amount).

Após realizar a integração dos dados com o end-point, será possível realizar a busca de todos os registros salvos como também buscar apenas um registro informando seu código de acesso (access_key) para a aplicação.

Algumas das tecnologias utilizadas no desenvolvimento foram:
* Java 8 com Spring-Boot
* MySql
* Lombok
* FlyWay
* Jackson - fasterxml
* Docker

Seguindo os conceitos da arquitetura em camadas e delegando apenas as responsabilidades necessárias para cada classe do sistema.

## Executar a Aplicação

Como a aplicação utiliza o docker, para executar a aplicação deverá seguir os seguintes passos:

Primeiramente deverá realizar o clone do projeto pelo link:
```
https://github.com/WhislleyWillianSilva/Desafio-Bolton.git
```

Feito isso, na raiz do projeto, executar o seguinte comando para realizar a criação do banco de dados e subir o container da aplicação:

```
sudo docker-compose up -d
```

Para verificar se o container está funcional, basta executar:

```
sudo docker ps
```

Com o container em execução podemos agora iniciar a nossa aplicação do backend com os seguintes comandos na raiz do projeto:

```
./mvnw clean package

./mvnw spring-boot:run
```

À partir deste momento será iniciado a nossa aplicação e o Flyway irá criar a tabela `invoices` automaticamente no banco de dados que será utilizada pela aplicação.

Com a nossa aplicação e o container do docker em execução, é possível utilizarmos os end-points de consulta e de integração com a API da Arquivei.

Para encerrar o container do docker, executar o seguinte comando:

```
sudo docker-compose down
```

### End-points

* Integração com a API da Arquivei: `GET http://localhost:8080/api/v1/nfe/integrate-invoices`

* Consulta de todos os registros: `GET http://localhost:8080/api/v1/nfe`

* Consulta de um único registro passando como parâmetro o **access_key**: `GET http://localhost:8080/api/v1/nfe/accesskey/{access_key}` --> onde o {access_key} é alterado pela **chave de acesso** da nota fiscal.