use northwind;

#prosedurelerde bir dönüþ tipi yoktur fonksiyonlarda vardır
DELIMITER $$
create procedure getAll()
begin
	select * from orders as o 
    inner join customers as c on o.customerID = c.customerID
    inner join employees as e on o.employeeID = e.employeeID 
    inner join shippers as s on o.shipperID = s.shipperID;
end $$
DELIMITER;

call getAll();

#kategori ekleme procedure
DELIMITER $$
create procedure categoryAdd(IN id int, IN name varchar(15), IN description varchar(50))
begin
	insert into categories (categoryId, categoryName, description) values(id, name, description);
END$$
DELIMITER;

call categoryAdd(null, 'deneme', 'deneme');

#kategori sil procedure
DELIMITER $$
create procedure categoryDelete(id int)
begin
	delete from categories where categoryId = id;
END$$
DELIMITER;

call categoryDelete(10);