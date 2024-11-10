<%-- 
    Document   : baiviet
    Created on : Jun 15, 2024, 9:56:44 PM
    Author     : DELL
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<c:url value="/admin/baiviet" var="actions" />
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1 class="text-center text-info mt-1">Quản Lý Bài Viết</h1>

    <p>Change language: 
        <a href="?lang=en">English</a> | 
        <a href="?lang=vi">Vietnamese</a>
            <a href="?lang=jp">Japanese</a>

    </p>
<div class="container">
    <form:form action="${actions}"  method="post" modelAttribute="baiViet">
        <div class="form-group">
            <label for="ten">${name}</label>
            <form:input type="text" class="form-control" id="ten" name="ten" placeholder="Nhập tên" path="ten"/>
        </div>
        <div class="form-group">
            <label for="noiDung">${content}</label>
            <form:textarea class="form-control" id="noiDung" name="noiDung" rows="5" placeholder="Nhập nội dung" path="noiDung" />
        </div>
        
        <div class="form-group">
            <label for="hoatDongId">${activity} :</label>
            <form:select class="form-select" path="hoatDongId">
                <c:forEach items="${hoatdongs}" var="c">
                    <c:choose>
                        <c:when test="${c.id==baiViet.hoatDongId.id}">
                            <option value="${c.id}" selected="">${c.ten}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${c.id}">${c.ten}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>


            </form:select>
        </div>
        <button type="submit" class="btn btn-primary mt-3 mb-3">
            <c:choose>
                <c:when test="${baiViet.id > 0}">${update}</c:when>
                <c:otherwise>${addPost}</c:otherwise>
            </c:choose>
        </button>
        <form:hidden path="id"/>

    </form:form>
</div>
