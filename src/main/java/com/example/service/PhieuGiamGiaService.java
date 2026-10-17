package com.example.service;

import com.example.entity.PhieuGiamGia;
import com.example.repository.PhieuGiamGiaRepo;

import java.util.List;

public class PhieuGiamGiaService {
    private PhieuGiamGiaRepo phieuGiamGiaRepo = new PhieuGiamGiaRepo();

    public List<PhieuGiamGia> getAll() {

        return phieuGiamGiaRepo.getAll();
    }

    public void delete(Integer id){
        phieuGiamGiaRepo.delete(id);
    }
    public void add(PhieuGiamGia phieuGiamGia){
        phieuGiamGiaRepo.add(phieuGiamGia);
    }

}
