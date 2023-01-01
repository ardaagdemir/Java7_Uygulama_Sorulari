use northwind;

#bir kodu tekrar tekrar yazmak yerine view oluşturruuz, bir sürü join yapmak yerine bir kere yapar kullanırız

#örnek
create view product_categoryies_view
as
select products.ProductName, categories.CategoryName 
from products inner join categories on categories.CategoryID = products.CategoryID;

select * from product_categoryies_view

#ürünlere göre tedarikçilere view oluþturalým, product name , contact, adress city country olsun
create view products_suppliers
as
select p.ProductName, s.ContactName, s.Address, s.City, s.Country 
from products as p join suppliers as s on p.SupplierID = s.SupplierID

select * from products_suppliers

#tabloyu kullanarak her ülkede kaç ürün var 
select country, count(product_name) from products_suppliers group by country;


#employee - customer siparis detaylarý  orderid, employeeid firstname lastname, customer id, country, order date, productname, quantity, unit price
create view employee_customer_order_products
AS
select o.OrderID, e.EmployeeID, e.FirstName, e.LastName, c.CustomerID,c.Country,
o.OrderDate, p.ProductName, ord.Quantity , p.Unit
FROM employees e 
inner join orders as o on o.EmployeeID = e.EmployeeID
inner join orderdetails as ord on ord.OrderID = o.OrderID
inner join customers as c on o.CustomerID = c.CustomerID
inner join products as p on ord.ProductID = p.ProductID;

#bu tablyu kullanarak her bir çalýþan kaç ürün satmýþ
select employeeID, sum(quantity) from employee_customer_order_products group by employeeID;

#50 den fazla satýþ adedi olan çalýþanlarý getiren srogu
select employeeId, count(orderId) from employee_customer_order_products 
group by employeeId having  count(orderId) >50;