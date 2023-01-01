use bilgeadam_uygulama;
#kategori olarak  otomobil, yapimarket, kitap, müzik, spor&outdoor

#kategorisi elektronik, spor ve yapımarket olan ürünleri listeleyiniz
select * from product where productCategory='Elektronik' or productCategory='Spor&Outdoor' or productCategory = 'Yapımarket';
#t harf ile başlayan ürünleri listeleyiniz
select * from product where productName like 't%';
#içerisinde a harfi geçen ürünleri listeleyiniz
select * from product where productName like '%t%';
#ürün fiyatlarını artan ve azalana göre sıralayarak listeleyiniz(desc --> azalan, asc --> artan)
select * from product order by price desc;
#ürün fiyatı 500 ile 3000 arasında olanları listeleyiniz
select * from product where price>500 and price <3000;
select * from product where price between 500 and 3000;
#kategorisi otomobil olan ürünlerin fiyatlarının ortalamasını alınız
select avg(price) from product where productCategory='Otomobil';
#belirli bir kategoriye ait kaç adet ürün olduğunu listeleyiniz
select count(*) from product where productCategory='Elektronik';
#product listinde bulunan kategorilerin her birinden kaçar adet olduğunu listeleyin
select productCategory, count(*) as Adet from product group by productCategory;
#fiyatı 15000 üstünde olan ürünleri siliniz
delete from product where price>15000;
#varsa id' si 20 ile 25 arasındaki ürünleri siliniz
delete from product where productId between 20 and 25


