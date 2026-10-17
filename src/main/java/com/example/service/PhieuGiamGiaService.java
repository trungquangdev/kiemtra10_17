package com.example.service;

import com.example.entity.LoaiPhieuGiamGia;
import com.example.entity.PhieuGiamGia;
import com.example.repository.PhieuGiamGiaRepo;

import java.util.List;

public class PhieuGiamGiaService {
    private PhieuGiamGiaRepo phieuGiamGiaRepo = new PhieuGiamGiaRepo();

    public List<PhieuGiamGia> getAll() {

        return phieuGiamGiaRepo.getAll();
    }
public PhieuGiamGia getOne(Integer id){
        return phieuGiamGiaRepo.getOne(id);
}

    public void delete(Integer id){
        phieuGiamGiaRepo.delete(id);
    }
    public void add(PhieuGiamGia phieuGiamGia){
        phieuGiamGiaRepo.add(phieuGiamGia);
    }

}
