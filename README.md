# CRUD on MySQL database with Java
    Application developed to interact with StoreDB, that has 4 tables:
        Customer;
        Product;
        Sale - This table receives an Customer_id and a Sale_Product_id;
        Sale_product - This table receives an Product_id and an Sale_id. 
        It's creation has been the solution to the necessity of 
        registering more than a single product per sale;

    Note: A Customer must be created before creating a sale.
    Note: A sale must be created prior to register a sale_product
    Note: A Product must be registered pior to creating an sale_product

    At the main menu, the user can choose which table he wants to manipulate.
    At any given option , the user is allowed to Create, list, update and delete.

# Project based on this database:
    https://github.com/bispo-daniel/SQL_Scripts/tree/main/StoreDB

# Screenshots

## `Main menu`
![all-text](https://github.com/bispo-daniel/CRUD_JavaStoreDB/blob/main/Screenshots/MainMenuScreenshot.png)
## `Product menu`
![all-text](https://github.com/bispo-daniel/CRUD_JavaStoreDB/blob/main/Screenshots/ProductsMenuScreenshot.png)