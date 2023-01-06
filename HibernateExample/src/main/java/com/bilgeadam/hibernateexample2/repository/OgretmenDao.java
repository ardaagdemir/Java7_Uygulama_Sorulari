package com.bilgeadam.hibernateexample2.repository;

import com.bilgeadam.hibernateexample1.repository.ICrud;
import com.bilgeadam.hibernateexample2.entity.Ogretmen;
import com.bilgeadam.hibernateexample2.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/*
DAO --> Data Access Object(Veri Erişim Nesnesi)

repository katmanı --> crud işlemlerinin yapıldığı katman,
 genellikle class isimlendirmeleri "entity class'ının adı+Repository/Dao" şeklindedir(OgretmenDao/OgretmenRepository). */
public class OgretmenDao implements ICrud<Ogretmen> {


    @Override
    public void save(Ogretmen ogretmen) {

        //Bir Transaction basitçe bir iş birimini(thread) temsil eder. Session ilişkilendirilerek kullanılır.
        //SessionFactory' de tanımlanan yapılandırma ayarları ile session üzerinden yapılacak işlemleri(save,update,delete) biribirnden soyutlar.
        //Bu sayede yapılacak olan işlem arka tarafta bağımlılığından ayrılıyor ve yalnızca yapılacak işlem gerçekleşiyor.
        //Session, transaction' dan daha kapsamlı olduğu için tek bir session üzerinden birden çok transaction yönetilebilir.
        Transaction transaction = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(ogretmen);
            transaction.commit();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
        }
    }

    @Override
    public void update(Ogretmen ogretmen) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void delete(Ogretmen ogretmen) {

    }

    @Override
    public List<Ogretmen> getAll() {
        return null;
    }

    @Override
    public Ogretmen getById(int id) {
        return null;
    }
}
