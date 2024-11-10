<%-- 
    Document   : troly
    Created on : May 16, 2024, 3:18:45 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%-- 
    Document   : troly
    Created on : May 16, 2024, 2:37:55 PM
    Author     : DELL
--%>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<h1 class="text-center text-info mt-1">Thêm trợ lý sinh viên</h1>
<c:url value="/admin/troly" var="actions" />

<form:form action="${actions}" modelAttribute="nguoidung" method="post" enctype="multipart/form-data">
        <form:errors path="*" element="div" cssClass="alert alert-danger"></form:errors>

    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" id="ho" placeholder="Nhập họ trợ lý" path="ho" />
        <label for="ho">Họ trợ lý</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" id="ten" placeholder="Nhập tên trợ lý" path="ten" />
        <label for="ten">Tên trợ lý</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" id="namsinh" placeholder="YYYY-MM-DD" path="namSinh"  />
        <label for="namsinh">Ngày sinh</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:select class="form-select" id="gioitinh" path="gioiTinh">
            <option value="0" selected>Nam</option>
            <option value="1">Nữ</option>
        </form:select>
        <label for="gioitinh" class="form-label">Giới tính</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" id="email" placeholder="Nhập email" path="email" />
        <label for="email">Email</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" id="username" placeholder="Nhập username" path="username" />
        <label for="username">Username</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="password" class="form-control" id="password" placeholder="Nhập password" path="password" />
        <label for="password">Password</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:select class="form-select" id="userRole" path="userRole">
            <option value="ROLE_TROLY" selected>Trợ lý khoa</option>
        </form:select>
        <label for="userRole">Trợ lý khoa</label>
    </div>

    <div class="form-floating mb-3 mt-3">
        <select class="form-select"  name="khoaId">
            <c:forEach items="${khoas}" var="c">
                <option value="${c.id}" selected="">${c.ten}</option>
            </c:forEach>
         
        </select>
        <label for="khoaId" class="form-label">Khoa phụ trách</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="file" class="form-control" id="image" path="file" />
        <label for="image">Ảnh đại diện</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <button class="btn btn-info" type="submit">Thêm</button>
        
    </div>

</form:form>

