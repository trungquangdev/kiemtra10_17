package com.example.repository;

import com.example.entity.LoaiPhieuGiamGia;
import com.example.entity.PhieuGiamGia;
import com.example.util.Hibernate;
import org.hibernate.Session;

import java.util.List;

public class LoaiPhieuGiamGiaRepo {
    public List<LoaiPhieuGiamGia> getAll(){
        try(Session session = Hibernate.getFactory().openSession()){
            return session.createQuery("from LoaiPhieuGiamGia ",LoaiPhieuGiamGia.class).list();
        }
    }

    public LoaiPhieuGiamGia getOne(Integer id){
        try(Session session=Hibernate.getFactory().openSession()){
            return session.find(LoaiPhieuGiamGia.class,id);
        }
    }
}
