package com.drl.pojo;

import com.drl.pojo.HocKiNamHoc;
import com.drl.pojo.SinhVien;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-06-25T02:03:36")
@StaticMetamodel(NamHoc.class)
public class NamHoc_ { 

    public static volatile SetAttribute<NamHoc, HocKiNamHoc> hocKiNamHocSet;
    public static volatile SetAttribute<NamHoc, SinhVien> sinhVienSet;
    public static volatile SingularAttribute<NamHoc, Integer> id;
    public static volatile SingularAttribute<NamHoc, Integer> namHoc;

}