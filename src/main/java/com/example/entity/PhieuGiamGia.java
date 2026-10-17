package com.example.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "phieu_giam_gia")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PhieuGiamGia {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "loai_phieu_id")
    //truyền khóa ngoại
    private LoaiPhieuGiamGia loaiPhieuGiamGia;

    @Column
    private String ma;

    @Column
    private String ten;

    @Column(name = "so_luong")
    private Integer soLuong;

    @Column(name = "loai_giam")
    private String loaiGiam;

    @Column(name = "dieu_kieu_toi_thieu")
    private String dieuKieuToiThieu;

    @Column(name = "gia_tri_toi_da")
    private String giaTriToiDa;
}
