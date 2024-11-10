package com.drl.pojo;

import com.drl.pojo.ChuyenVienCtsv;
import com.drl.pojo.Comment;
import com.drl.pojo.SinhVien;
import com.drl.pojo.TroLySinhVien;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-06-25T02:03:36")
@StaticMetamodel(NguoiDung.class)
public class NguoiDung_ { 

    public static volatile SingularAttribute<NguoiDung, SinhVien> sinhVien;
    public static volatile SingularAttribute<NguoiDung, String> ho;
    public static volatile SingularAttribute<NguoiDung, ChuyenVienCtsv> chuyenVienCtsv;
    public static volatile SingularAttribute<NguoiDung, Short> gioiTinh;
    public static volatile SingularAttribute<NguoiDung, String> avatar;
    public static volatile SingularAttribute<NguoiDung, Date> namSinh;
    public static volatile SingularAttribute<NguoiDung, String> password;
    public static volatile SetAttribute<NguoiDung, Comment> commentSet;
    public static volatile SingularAttribute<NguoiDung, Integer> id;
    public static volatile SingularAttribute<NguoiDung, TroLySinhVien> troLySinhVien;
    public static volatile SingularAttribute<NguoiDung, String> ten;
    public static volatile SingularAttribute<NguoiDung, String> userRole;
    public static volatile SingularAttribute<NguoiDung, String> email;
    public static volatile SingularAttribute<NguoiDung, String> username;

}