package com.example.repository;

import com.example.entity.PhieuGiamGia;
import com.example.util.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PhieuGiamGiaRepo {
    public List<PhieuGiamGia>getAll(){
        try(Session session = Hibernate.getFactory().openSession()){
            return session.createQuery("from PhieuGiamGia ",PhieuGiamGia.class).list();
        }
    }

    public void add(PhieuGiamGia phieuGiamGia) {
        try (Session session = Hibernate.getFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist( phieuGiamGia);
            transaction.commit();
        }
    }

    public void delete(Integer id) {
        try (Session session = Hibernate.getFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            PhieuGiamGia phieuGiamGia=session.find(PhieuGiamGia.class, id);
            if ( phieuGiamGia !=null){
                session.delete( phieuGiamGia);
            }
            transaction.commit();
        }
    }
}
