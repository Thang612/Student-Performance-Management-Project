package com.drl.pojo;

import com.drl.pojo.HoatDong;
import com.drl.pojo.Lop;
import com.drl.pojo.TroLySinhVien;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-06-25T02:03:36")
@StaticMetamodel(Khoa.class)
public class Khoa_ { 

    public static volatile SetAttribute<Khoa, HoatDong> hoatDongSet;
    public static volatile SingularAttribute<Khoa, Integer> id;
    public static volatile SetAttribute<Khoa, TroLySinhVien> troLySinhVienSet;
    public static volatile SingularAttribute<Khoa, String> ten;
    public static volatile SetAttribute<Khoa, Lop> lopSet;

}