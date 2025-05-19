# Features

## Gestão de estoque

* Cadastramento de item/itens no estoque
  > POST: /v1/product
  * Request Body: 
    ```json
    {
      "sku": String, //UIID -> Necessário para não ocorrer colisão com outro produto
      "quantity": integer, //Ver se faz sentido manter quantidade, porque estamos definindo um produto aqui. Talvez possa ser interessante colocar em um outro endpoint 
      "price": integer,
      "categories": [
         integer, 
         integer, 
         ...
       ], 
      "name": String,
      "dimensions": [
        "width": integer,
        "height": integer,
        "depth": integer
      ], 
      "weight": integer, 
      "image": String //Link para a imagem

    ```
  * Response Body:
    * Status code: 201
    ```json
    {
      "message": "Product created", 
      "productId": integer
    }
    ```
    * Status code: 422
    ```json
    {
      "message": "Invalid request body"
    }
    ```
    * Status code: 409
    ```json
    {
      "message": "the following SKU is already registered",
      "sku": integer
    }
    ```
    > DELETE: /v1/product/{id}
    * Status code: 200
    ```json
    {
      "message": "The {productName} was deleted from stock",
      "sku": integer 
    }
    ```
* A opção de listar a quantidade de determinado produto
* Avisar quando um determinado item está acabando
* Lembrete para reabastecimento de itens
* Listar produtos por categoria
