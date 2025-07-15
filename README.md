# e-commerce-api
Contribuição para o desafio de projeto do bootcamp
```mermaid
classDiagram
    direction LR

    class User {
        +Long id
        +String nome
        +String email
        +String senhaHash
        +Timestamp dataCadastro
        +Timestamp ultimoLogin
        +String telefone
        +UserType tipoUsuario
        +boolean ativo
    }

    class Product {
        +Long id
        +String nome
        +String descricao
        +BigDecimal preco
        +Integer estoque
        +String sku
        +String urlImagemPrincipal
        +Timestamp dataCriacao
        +Timestamp dataAtualizacao
        +boolean ativo
    }

    class Category {
        +Long id
        +String nome
        +String descricao
    }

    class ShoppingCart {
        +Long id
        +Timestamp dataCriacao
        +Timestamp ultimaAtualizacao
    }

    class CartItem {
        +Long id
        +Integer quantidade
        +Timestamp dataAdicao
    }

    %% Relacionamentos

    User "1" -- "1" ShoppingCart : tem

    Product "1" -- "N" CartItem : está_em

    Category "1" -- "N" Product : categoriza
    Product "N" -- "N" Category : pertence_a

    ShoppingCart "1" -- "N" CartItem : contém
```
