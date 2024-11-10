package com.drl.pojo;

import com.drl.pojo.HoatDong;
import com.drl.pojo.HocKi;
import com.drl.pojo.NamHoc;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-06-25T02:03:36")
@StaticMetamodel(HocKiNamHoc.class)
public class HocKiNamHoc_ { 

    public static volatile SetAttribute<HocKiNamHoc, HoatDong> hoatDongSet;
    public static volatile SingularAttribute<HocKiNamHoc, NamHoc> namHocId;
    public static volatile SingularAttribute<HocKiNamHoc, Integer> id;
    public static volatile SingularAttribute<HocKiNamHoc, HocKi> hocKiId;

}