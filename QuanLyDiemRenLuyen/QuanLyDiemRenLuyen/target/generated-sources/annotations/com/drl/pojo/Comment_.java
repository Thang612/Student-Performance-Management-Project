package com.drl.pojo;

import com.drl.pojo.BaiViet;
import com.drl.pojo.Comment;
import com.drl.pojo.NguoiDung;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-06-25T02:03:36")
@StaticMetamodel(Comment.class)
public class Comment_ { 

    public static volatile SetAttribute<Comment, Comment> commentSet;
    public static volatile SingularAttribute<Comment, Comment> commentId;
    public static volatile SingularAttribute<Comment, Integer> id;
    public static volatile SingularAttribute<Comment, String> noiDung;
    public static volatile SingularAttribute<Comment, BaiViet> baiVietId;
    public static volatile SingularAttribute<Comment, NguoiDung> nguoiDungId;
    public static volatile SingularAttribute<Comment, Date> thoiGian;

}