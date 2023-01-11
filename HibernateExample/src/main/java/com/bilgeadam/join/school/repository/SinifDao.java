package com.bilgeadam.join.school.repository;

import com.bilgeadam.join.school.entity.Sinif;
import com.bilgeadam.join.school.utils.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import java.util.List;


public class SinifDao implements ICrud<Sinif> {

    @Override
    public void save(Sinif sinif) {
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(sinif);
            session.getTransaction().commit();
            session.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void getAll(){
        List<Object[]> list = null;
        try{
            EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
            String query = "select o.okuladi, s.siniflokasyon, l.lablokasyon, d.dolapno from sinif as s \n" +
                    "\n" +
                    "inner join sinif_okul as so on so.sinif_id = s.id\n" +
                    "inner join okul as o ON o.id = so.okul_id\n" +
                    "\n" +
                    "inner join sinif_dolap as sd ON sd.sinif_id = s.id\n" +
                    "inner join dolap as d ON d.id = sd.dolaplar_id\n" +
                    "\n" +
                    "inner join lab as l on s.lab_labid = l.labid";
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
