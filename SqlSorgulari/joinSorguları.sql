#ürünleri ve kategorilerini listeleyiniz
select p.productName, p.price, p.description, c.categoryName from product as p inner join category as c on p.categoryId = c.categoryId;
#Moda kategorisinde kaç adet ürün olduğunu listeleyiniz
select count(*) from product as p inner join category as c on p.categoryId = c.categoryId where c.categoryName='Moda';
#her kategoride kaç tane ürünün olduğunu listeleyiniz
select categoryId, count(productId) as ürün_adedi from product group by categoryId;


#kategori isimlerine göre kaç adet ürün olduğunu listeleyiniz
select c."categoryName", count(*) 
from "products" as p 
inner join categories as c 
on p."categoryId" = c."categoryId"
group by c."categoryName";

#hangi ürün hangi kategoride bulunmaktadır, artan categoryId ye göre sıralayınız
select p."productName", c."categoryName" 
from products as p inner join categories as c 
on p."categoryId" = c."categoryId" 
order by c."categoryName" desc;

#en fazla hangi kategoriye ait ürün olduğunu listeleyiniz --> 'limit' araştırın
select c."categoryName", count(p."productId") as UrunAdedi 
from categories as c 
inner join products as p 
on c."categoryId"=p."categoryId"
group by c."categoryName" 
order by UrunAdedi desc limit 1;

---her kategorideki en düþük ve en yüksek priceleri listeleyiniz
select products."categoryId", max("price") as "en_yuksek", min("price") as "en_dusuk" 
from products 
group by "categoryId" 
order by "categoryId";

#ürünlerin fiyatlarının ortalamasını ve her kategori için kaç adet ürün olduğunu listeleyiniz
SELECT c."categoryName", AVG(p."price") AS "avgPrice", COUNT(p."productId") AS "productCount"
FROM products p
INNER JOIN categories c
ON p."categoryId" = c."categoryId"
GROUP BY c."categoryName"

#ürünlerin fiyatlarının ortalamasının ürünün kendi fiyatından yüksek olduğu ürünleri listeleyiniz
SELECT p."productName", AVG(p."price") AS "avgPrice"
FROM products p
INNER JOIN categories c
ON p."categoryId" = c."categoryId"
GROUP BY p."productName"
HAVING AVG(p."price") > (SELECT AVG("price") FROM products)

#kategoriler içinde fiyatı 100 TL ve üzeri olan ürünlerin kategorilerini ve bu ürünlerin sayısını listeleyiniz
SELECT c.categoryName, COUNT(p.productId) AS productCount
FROM products p
INNER JOIN categories c
ON p.categoryId = c.categoryId
WHERE p.price >= 100
GROUP BY c.categoryName

#product açıklama alanında "a" harfi geçen ürünlerin kategorilerini ve bu ürünlerin sayısını listeleyiniz
SELECT c.categoryName, COUNT(p.productId) AS productCount
FROM products p
INNER JOIN categories c
ON p.categoryId = c.categoryId
WHERE p.description LIKE '%discount%'
GROUP BY c.categoryName

#kategoriler içinde en az üç ürün bulunan kategorilerin adlarını ve bu kategorideki ürün sayısını listeleyiniz
SELECT c.categoryName, COUNT(p.productId) AS productCount
FROM products p
INNER JOIN categories c
ON p.categoryId = c.categoryId
GROUP BY c.categoryName
HAVING COUNT(p.productId) >= 3

#kategoriler içinde ürünlerin ortalama açıklama uzunluğunun en yüksek olduğu kategori ve bu kategorideki ortalama açıklama uzunluğunu listeleyiniz
SELECT c.categoryName, AVG(LENGTH(p.description)) AS avgDescriptionLength
FROM products p
INNER JOIN categories c
ON p.categoryId = c.categoryId
GROUP BY c.categoryName
HAVING AVG(LENGTH(p.description)) = (SELECT MAX(AVG(LENGTH(description))) FROM products p INNER JOIN categories c ON p.categoryId = c.categoryId GROUP BY c.categoryName)