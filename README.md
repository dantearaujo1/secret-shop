# Sistema de Vendas de Loja de Maquiagem

Um sistema simples de vendas de loja de maquiagem feito para a disciplina de Banco de Dados 1 do Curso de Sistemas e Mídias Digitais - UFC.




## Pré-requisitos




* **Tenha o Docker instalado**

* **Tenha o Docker Compose Plugin instalado**

    Cenário 1: Não tem nada baixado, nem docker nem docker compose

    - Instale o [Docker Desktop][docker] ai ele ja vem com o Docker Compose

    Cenário 2: Tem o docker, mas n tem o docker compose

    - Instale o Plugin [Compose][docker-compose]


### Instalação

* Com docker Instalado:

    - Entre na pasta do projeto
    - Crie as variáveis de ambiente em um arquivo .env de acordo com o .env.example que
    deixei no projeto

    ```sh
    docker-compose up
    ```

    **Pronto**

    - O servidor backend está rodando em um container exposto na porta 6969

    - O banco de dados postgres em outro container exposto na porta 5431


## Uso

Acessando o back:

Link: [API]( http://locahost:6969/api/v1/product )

Prefere ver o swagger? Link: [Swagger UI]( http://localhost:6969/swagger-ui/index.html )

** Atenção: ** O Swagger contem todas as rotas da API


## Documentação adicional e agradecimento


#### Requisitos

---

| Requisito                          | Status   | ENDPOINT/DESC                   | METODO                                             |
|-----------                         |--------  |-----                            |-----                                               |
| 5 Tabelas                          | OK       |                                 |                                                    |
| 5 PK                               | OK       |                                 |                                                    |
| 3 FK                               | OK       |                                 |                                                    |
|-----------                         |--------  |-----                            |-----                                               |
| 5 SELECT                           | OK       |                                 |                                                    |
|-----------                         |--------  |-----                            |-----                                               |
| 1 SELECT VENDEDOR                  | OK       | /api/v1/seller                  | [ GET ]( http://localhost:6969/api/v1/seller )     |
| 1 SELECT VENDAL                    | OK       | /api/v1/sell                    | [ GET ]( http://localhost:6969/api/v1/sell )       |
| 1 SELECT PRODUTO                   | OK       | /api/v1/product                 | [ GET ]( http://localhost:6969/api/v1/product )    |
| 1 SELECT CLIENTE                   | OK       | /api/v1/client                  | [ GET ]( http://localhost:6969/api/v1/client )     |
| 1 SELECT FILIAL                    | OK       | /api/v1/branch                  | [ GET ]( http://localhost:6969/api/v1/branch )     |
|-----------                         |--------  |-----                            |-----                                               |
| 3 INSERT                           |          |                                 |                                                    |
|-----------                         |--------  |-----                            |-----                                               |
| 1 INSERT PRODUTO                   |  OK      | /api/v1/product/                | POST                                               |
| 1 INSERT FILIAL                    |  OK      | /api/v1/branch/                 | POST                                               |
|-----------                         |--------  |-----                            |-----                                               |
| 2 UPDATE                           |          |                                 |                                                    |
|-----------                         |--------  |-----                            |-----                                               |
| 1 UPDATE VENDEDOR                  |  --      | /api/v1/seller/{id}             | PATCH                                              |
| 1 UPDATE CLIENTE                   |  --      | /api/v1/client/{id}             | PATCH                                              |
|-----------                         |--------  |-----                            |-----                                               |
| 2 DELETE                           |          |                                 |                                                    |
|-----------                         |--------  |-----                            |-----                                               |
| 1 DELETE VENDEDOR                  |  OK      | /api/v1/seller/{id}             | DELETE                                             |
| 1 DELETE PRODUTO                   |  OK      | /api/v1/client/{id}             | DELETE                                             |


### Estrutura do projeto

```
.
├── backend
│   ├── backup
│   │   ├── maykdb2023-11-20.dump
│   │   └── maykdb.sql
│   ├── Dockerfile
│   ├── HELP.md
│   ├── mvnw
│   ├── mvnw.cmd
│   ├── pom.xml
│   ├── src
│   │   ├── main
│   │   │   ├── java
│   │   │   │   └── com
│   │   │   │       └── smd
│   │   │   │           └── umake
│   │   │   │               ├── controllers
│   │   │   │               │   ├── BranchController.java
│   │   │   │               │   ├── ClientController.java
│   │   │   │               │   ├── ProductController.java
│   │   │   │               │   ├── SaleController.java
│   │   │   │               │   └── SellerController.java
│   │   │   │               ├── dtos
│   │   │   │               │   ├── BranchDTO.java
│   │   │   │               │   ├── ClientDTO.java
│   │   │   │               │   ├── ProductDTO.java
│   │   │   │               │   ├── SaleDTO.java
│   │   │   │               │   └── SellerDTO.java
│   │   │   │               ├── entities
│   │   │   │               │   ├── Branch.java
│   │   │   │               │   ├── ClientContact.java
│   │   │   │               │   ├── Client.java
│   │   │   │               │   ├── ProductCat.java
│   │   │   │               │   ├── Product.java
│   │   │   │               │   ├── Sale.java
│   │   │   │               │   ├── SaleProduct.java
│   │   │   │               │   ├── SaleProductKey.java
│   │   │   │               │   ├── Seller.java
│   │   │   │               │   ├── Stock.java
│   │   │   │               │   └── StockKey.java
│   │   │   │               ├── exceptions
│   │   │   │               │   ├── ApplicationExceptionHandler.java
│   │   │   │               │   ├── ArgumentInvalidException.java
│   │   │   │               │   ├── EntityAlreadyExistsException.java
│   │   │   │               │   └── EntityNotFoundException.java
│   │   │   │               ├── repositories
│   │   │   │               │   ├── BranchRepository.java
│   │   │   │               │   ├── ClientRepository.java
│   │   │   │               │   ├── ProductCatRepository.java
│   │   │   │               │   ├── ProductRepository.java
│   │   │   │               │   ├── SaleProductRepository.java
│   │   │   │               │   ├── SaleRepository.java
│   │   │   │               │   ├── SellerRepository.java
│   │   │   │               │   └── StockRepository.java
│   │   │   │               ├── services
│   │   │   │               │   ├── BranchService.java
│   │   │   │               │   ├── ClientService.java
│   │   │   │               │   ├── ProductCategoryService.java
│   │   │   │               │   ├── ProductService.java
│   │   │   │               │   ├── SaleService.java
│   │   │   │               │   ├── SellerService.java
│   │   │   │               │   └── StockService.java
│   │   │   │               └── UmakeApplication.java
│   │   │   └── resources
│   │   │       ├── application.properties
│   │   │       ├── static
│   │   │       └── templates
│   │   └── test
│   │       └── java
│   │           └── com
│   │               └── smd
│   │                   └── umake
│   │                       └── UmakeApplicationTests.java
│   └── target
│       ├── classes
│       │   ├── application.properties
│       │   └── com
│       │       └── smd
│       │           └── umake
│       │               ├── controllers
│       │               │   ├── BranchController.class
│       │               │   ├── ClientController.class
│       │               │   ├── ProductController.class
│       │               │   ├── SaleController.class
│       │               │   └── SellerController.class
│       │               ├── dtos
│       │               │   ├── BranchDTO.class
│       │               │   ├── ClientDTO.class
│       │               │   ├── ProductDTO.class
│       │               │   ├── SaleDTO.class
│       │               │   └── SellerDTO.class
│       │               ├── entities
│       │               │   ├── Branch.class
│       │               │   ├── Client.class
│       │               │   ├── ClientContact.class
│       │               │   ├── ProductCat.class
│       │               │   ├── Product.class
│       │               │   ├── Sale.class
│       │               │   ├── SaleProduct.class
│       │               │   ├── SaleProductKey.class
│       │               │   ├── Seller.class
│       │               │   ├── Stock.class
│       │               │   └── StockKey.class
│       │               ├── exceptions
│       │               │   ├── ApplicationExceptionHandler.class
│       │               │   ├── ArgumentInvalidException.class
│       │               │   ├── EntityAlreadyExistsException.class
│       │               │   └── EntityNotFoundException.class
│       │               ├── repositories
│       │               │   ├── BranchRepository.class
│       │               │   ├── ClientRepository.class
│       │               │   ├── ProductCatRepository.class
│       │               │   ├── ProductRepository.class
│       │               │   ├── SaleProductRepository.class
│       │               │   ├── SaleRepository.class
│       │               │   ├── SellerRepository.class
│       │               │   └── StockRepository.class
│       │               ├── services
│       │               │   ├── BranchService.class
│       │               │   ├── ClientService.class
│       │               │   ├── ProductCategoryService.class
│       │               │   ├── ProductService.class
│       │               │   ├── SaleService.class
│       │               │   ├── SellerService.class
│       │               │   └── StockService.class
│       │               └── UmakeApplication.class
│       ├── generated-sources
│       │   └── annotations
│       ├── generated-test-sources
│       │   └── test-annotations
│       ├── maven-status
│       │   └── maven-compiler-plugin
│       │       └── compile
│       │           └── default-compile
│       │               ├── createdFiles.lst
│       │               └── inputFiles.lst
│       └── test-classes
│           └── com
│               └── smd
│                   └── umake
│                       └── UmakeApplicationTests.class
├── docker-compose.yml
├── README.md
└── tree.txt

```

[docker-compose]: https://docs.docker.com/compose/install/linux/#install-the-plugin-manually
[Docker]: https://docs.docker.com/engine/install/
