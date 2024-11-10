package com.drl.pojo;

import com.drl.pojo.HoatDong;
import com.drl.pojo.Khoa;
import com.drl.pojo.NguoiDung;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-06-25T02:03:36")
@StaticMetamodel(TroLySinhVien.class)
public class TroLySinhVien_ { 

    public static volatile SetAttribute<TroLySinhVien, HoatDong> hoatDongSet;
    public static volatile SingularAttribute<TroLySinhVien, Integer> id;
    public static volatile SingularAttribute<TroLySinhVien, NguoiDung> nguoiDung;
    public static volatile SingularAttribute<TroLySinhVien, Khoa> khoaId;

}