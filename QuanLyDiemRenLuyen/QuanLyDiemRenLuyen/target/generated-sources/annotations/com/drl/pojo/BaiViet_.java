package com.drl.pojo;

import com.drl.pojo.Comment;
import com.drl.pojo.HoatDong;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-06-25T02:03:36")
@StaticMetamodel(BaiViet.class)
public class BaiViet_ { 

    public static volatile SetAttribute<BaiViet, Comment> commentSet;
    public static volatile SingularAttribute<BaiViet, HoatDong> hoatDongId;
    public static volatile SingularAttribute<BaiViet, Integer> id;
    public static volatile SingularAttribute<BaiViet, String> ten;
    public static volatile SingularAttribute<BaiViet, String> noiDung;
    public static volatile SingularAttribute<BaiViet, Date> ngayTao;

}