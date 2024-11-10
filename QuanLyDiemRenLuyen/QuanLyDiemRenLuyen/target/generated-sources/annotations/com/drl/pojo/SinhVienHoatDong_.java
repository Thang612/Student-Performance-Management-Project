package com.drl.pojo;

import com.drl.pojo.BaoThieu;
import com.drl.pojo.HoatDong;
import com.drl.pojo.SinhVien;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-06-25T02:03:36")
@StaticMetamodel(SinhVienHoatDong.class)
public class SinhVienHoatDong_ { 

    public static volatile SetAttribute<SinhVienHoatDong, BaoThieu> baoThieuSet;
    public static volatile SingularAttribute<SinhVienHoatDong, Boolean> trangThai;
    public static volatile SingularAttribute<SinhVienHoatDong, SinhVien> sinhVienId;
    public static volatile SingularAttribute<SinhVienHoatDong, HoatDong> hoatDongId;
    public static volatile SingularAttribute<SinhVienHoatDong, Integer> id;

}