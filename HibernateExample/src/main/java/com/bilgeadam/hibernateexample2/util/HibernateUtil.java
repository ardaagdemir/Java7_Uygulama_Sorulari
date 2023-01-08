package com.bilgeadam.hibernateexample2.util;

import com.bilgeadam.hibernateexample2.entity.Ogretmen;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

/*
util --> projerede bir kere oluşturulup devamlı olarak farklı paket veya classlar tarafından kullanılacak aksiyonların bulunduğu pakettir.
Burada sınıf oluşturulur ve içerisi ihityaca göre doldurulur. Ve devamlı kullanılır.
* */
public class HibernateUtil {
    //hibernate.cfg.xml kullanmadan hibernate framework' ünün sağladığı kütüphanelerden yararlanarak veritabanı işlemleri

    /*
    Temel amacı 'session' örneklerinin oluşturulmasını sağlamaktır.
    session --> Uygulama ile veri tabloları arasındaki ilişki (Ogretmen class <--> ogretmen tablosu(postgresql))
    SessionFactory sınıfı, nesne ile ilişki kurmaya yarayan tüm metadaları içerir.
    Geliştiricinin isteklerine karşılık veren thread(iş parçacığı), oluşturulan session örneklerini gelip buradan alır.
    * */
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {

        if (sessionFactory == null){
            try{
                /*
                Hibernate' i ön yüklemek için bir nesne oluşturuyor.
                Buradaki amaç bütün işlemleri tek bir yerde yapıp ardından SessionFactory' yi tek adımda oluşturmaktır.
                Bu yapıda tutulan konfigürasyon ve eşleme kaynakları SessionFactory oluşana kadar burada tutulur.
                */
                Configuration configuration = new Configuration();

                /*Properties sınıfı kalıcı özellik kümesidir(hibernate.cfg.xml --> değerlerinin tanımlandığı sınıf)
                Burada anahtar ve değer mantığı vardır.
                Hashtable'dan inherit olduğu için put metodunu kullarak içerisinde anahtar değer çifti tutulabilir.
                 */
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "org.postgresql.Driver");
                settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/hibernate_ogretmen");
                settings.put(Environment.USER, "admin");
                settings.put(Environment.PASS, "arda10021");

                settings.put(Environment.HBM2DDL_AUTO, "create");
                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.FORMAT_SQL, "true");

                configuration.setProperties(settings);

                //ORM mapping işlemine tabi tutulacak anostasyon içeren sınıflar burada tanımlanır.
                configuration.addAnnotatedClass(Ogretmen.class);

                //En temel olarak servis hizmetlerini barındırır. Ve bu hizmetlerin bağımlılıklarını yönetir.
                //Hibernate-database bağlantısının arka tarafta bir service aracılığıyla gerçekleşmesini sağlar.
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
