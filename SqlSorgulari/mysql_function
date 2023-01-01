#product tablosunda ürün fiyatlarının kdvsini hesaplayan bir fonksiyon yazalım

DELIMITER $$
create function kdvHesapla(fiyat INTEGER)
returns real
DETERMINISTIC
BEGIN 
SET fiyat = fiyat * 1.18;
return fiyat;
end $$
DELIMITER;

select productName, price, kdvHesapla(price) as kdvli_fiyat from products;


#employee id ye göre kaç parça urun sattýgýný bulan fonksiyonu yazalým

DELIMITER $$
create function getByEmployeeId(id integer)
returns integer
DETERMINISTIC
begin
declare toplam INT;
set toplam = 0;
select sum(ecop.quantity) into toplam
from employee_customer_order_products as ecop group by ec.employeeId having ec.employeeId=id;
return toplam;
end; $$
DELIMITER;

select getByEmployeeId(1)


#process # thread
#process --> Bir program bellekten, işlemci(cpu --> centrel processing unit(merkezi işlem birimi)) aracılığı ile çalıştırıldığında bu programın çalışır haldeki sürecine process denir. Bu süreç işlemci tarafından yönetilir.
#thread --> Bir programın process ortamına geçmesiyle arka planda bir thread(iş parçacığı) oluşturulur ve bu thread' e -main thread- denir. Artık program bu thread ile yürütülür.
#multi thread --> Process ortamındaki işin birden çok thread ile parçalara ayrılarak daha kısa sürede daha çok işlem yapabilmeye yarıyor.
