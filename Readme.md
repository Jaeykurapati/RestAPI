- This is a Spring Boot project to build REST API using Java.
- Project Structure is according to the industry recommendation and can be easily understandable.
- Please load the file that create database and inserts the data into tables before running the project.

API Endpoints that I builded are

** Customer related end points

1. for getting all the customer
  * `/customers`
  * `/customers/all`
2. for getting customer with customerId
  * `/customers/{customerId}`
3. for getting orders that the customer placed
  * `/customers/{customerId}/orders`
-------------------
** Order Related End Points
  
1. for getting all orders
  * `/orders`
  * `/orders/all`
2. for getting particular order with ordrer id
  * `/orders/{orderId}`
3. getting products in the order with orderId
  * `/orders/{orderId}/products`
4. getting all the orders places in the year. 
  * `/orders/year={year}`
5. getting recent placed order
  * `/orders/recent`
6. getting oldest order
  * `/orders/older`
7. getting orders depending on the status (available status are Shipped, On Hold, Disputed, In Process, Resolved
  * `/orders/status={status}`
--------------------
** Products related endpoints

1. for getting all the products
  * `/products`
  * `/products/all`
2. for getting products in a particular order
  * `/products/orderId={orderId}`
