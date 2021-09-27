# springWeb
## Requirements
* Java 11
* Maven 3.8.1
* Spring 2.4.9
* mysql 8.0.26
* IntelliJ


## Project overview

A web-site for a coffe-shop where customers can choose products and submit an order for delivery. The web-page is checking the inserted data from the customer is correct and ask a customer to add the missing data or correct the payment details in case of incorrect card number. Order as well as customer details are written down to MySQL database using Spring Data JPA.

The main - page:
![alt text](https://github.com/OlgaYatsenko/springWeb/blob/master/src/main/resources/static/images/Web_page1.png)

Menu:
![alt text](https://github.com/OlgaYatsenko/springWeb/blob/master/src/main/resources/static/images/Menu.png)

The page to insert order details:
![alt text](https://github.com/OlgaYatsenko/springWeb/blob/master/src/main/resources/static/images/order_details.png)

Validation alarms:
![alt text](https://github.com/OlgaYatsenko/springWeb/blob/master/src/main/resources/static/images/SubmittingIncOrder.png)

## MySQL DBstructure

**Connections between tables:**
1) Orders and Product - One to Many (One order can consists of many Products)
2) Orders and Customer - One to one (Every time somenone submits an order he needs to enter his details (like address, card for payment). No possibility to have a registered account on the shop web-page) 

![alt text](https://github.com/OlgaYatsenko/springWeb/blob/master/src/main/resources/static/images/shopDB.png)

