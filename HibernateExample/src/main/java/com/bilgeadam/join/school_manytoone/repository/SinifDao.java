package com.bilgeadam.join.school_manytoone.repository;

import com.bilgeadam.join.school_manytoone.entity.Sinif;
import com.bilgeadam.join.school_manytoone.utils.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import java.util.List;

public class SinifDao {

    public void save(Sinif sinif){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.save(sinif);
            session.getTransaction().commit();
            session.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.out.println("Kayıt başarısız");
        }
    }

    public void getAll(){
        List<Object[]> list = null;
        try{
            EntityManager entityManager = com.bilgeadam.join.school.utils.HibernateUtil.getSessionFactory().createEntityManager();
            String query = "select o.okuladi, s.siniflokasyon, l.lablokasyon, d.dolapno from sinif as s \n" +
                    "inner join lab as l on l.labid = s.lab_labid\n" +
                    "inner join okul as o on o.id = s.okul_id\n" +
                    "\n" +
                    "inner join sinif_dolap as sd on sd.sinif_id = s.id\n" +
                    "inner join dolap as d on d.id = sd.dolaplar_id";
            list = entityManager.createNativeQuery(query).getResultList();
            for (Object[] item : list){
                System.out.println(
                        "Okul Adı: " + item[0] + ", "
                                + "Sınıf Lokasyonu: " + item[1] + ", "
                                + "Lab Lokasyonu: " + item[2] + ", "
                                + "Sınıf Dolap Sayıyı: " + item[3] + ", "
                );
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
