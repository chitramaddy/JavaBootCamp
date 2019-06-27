 use northwind;
 
 /*What are the categories of products in the database?*/
 select products.category from products;
 
 /*What products are made by Dell?*/
 select * from northwind.products where products.product_name like 'Dell %';
 
 /*List all the orders shipped to Pennsylvania.*/
 select * from orders where orders.ship_state = 'Pennsylvania';
 
 /*List the first name and last name of all employees with last names that start with w*/
 select first_name, last_name from employees where last_name like 'w%';
 
 /*List all customers from zipcodes that start with 55*/
 select * from customers where postal_code like '55%';
 
 /*List all customers from zipcodes that end with 0*/
  select * from customers where postal_code like '%0';
  
  /*List the first name, last name, and email for all customers with a .org email address*/
  select first_name, last_name, email from customers where email like '%.org';
  
  /*List the first name, last name, and phone number for all customers from the 202 area code*/
 select first_name"First Name", last_name "Last Name", phone "Phone" from customers where phone like '___202%';
 
 /*List the order id for each order placed by George Wilson. For this we first pull all the customers that has orders,
 find the record that matches the search criteria*/
 select orders.id, customers.first_name, customers.last_name 
 from customers inner join orders 
 on customers.id = orders.customer_id
 where customers.first_name = 'George' and customers.last_name = 'Wilson';

update products set product_name = 'Samsung Note' where id = '609';
 
 /*List all the products and quantities associated with order 4003*/
select 
	order_details.order_id "Order ID",
	products.product_name "Product Name",
    order_details.quantity "Quantity"
from products
inner join order_details on products.id = order_details.product_id
where order_id = '4003';
 

 