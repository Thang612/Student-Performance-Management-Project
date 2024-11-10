package com.drl.pojo;

import com.drl.pojo.BaiViet;
import com.drl.pojo.Dieu;
import com.drl.pojo.HocKiNamHoc;
import com.drl.pojo.Khoa;
import com.drl.pojo.SinhVienHoatDong;
import com.drl.pojo.TroLySinhVien;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-06-25T02:03:36")
@StaticMetamodel(HoatDong.class)
public class HoatDong_ { 

    public static volatile SingularAttribute<HoatDong, Long> phi;
    public static volatile SingularAttribute<HoatDong, Integer> diem;
    public static volatile SingularAttribute<HoatDong, TroLySinhVien> troLyId;
    public static volatile SetAttribute<HoatDong, BaiViet> baiVietSet;
    public static volatile SingularAttribute<HoatDong, Integer> id;
    public static volatile SingularAttribute<HoatDong, Dieu> dieuId;
    public static volatile SetAttribute<HoatDong, SinhVienHoatDong> sinhVienHoatDongSet;
    public static volatile SingularAttribute<HoatDong, String> ten;
    public static volatile SingularAttribute<HoatDong, String> moTa;
    public static volatile SingularAttribute<HoatDong, HocKiNamHoc> hocKiNamHocId;
    public static volatile SingularAttribute<HoatDong, Khoa> khoaId;

}