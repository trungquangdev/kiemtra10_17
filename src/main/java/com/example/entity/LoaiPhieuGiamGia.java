package com.example.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "loai_phieu_giam_gia")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LoaiPhieuGiamGia {
    @Id
    @Column
    private Integer id;

    @Column
    private String ma;
    @Column
    private String ten;
}
