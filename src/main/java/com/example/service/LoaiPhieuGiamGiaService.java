package com.example.service;

import com.example.entity.LoaiPhieuGiamGia;
import com.example.entity.PhieuGiamGia;
import com.example.repository.LoaiPhieuGiamGiaRepo;
import com.example.repository.PhieuGiamGiaRepo;

import java.util.List;

public class LoaiPhieuGiamGiaService {
    private LoaiPhieuGiamGiaRepo loaiPhieuGiamGiaRepo = new LoaiPhieuGiamGiaRepo();
    public List<LoaiPhieuGiamGia> getAll(){
        return loaiPhieuGiamGiaRepo.getAll();
    }
}
