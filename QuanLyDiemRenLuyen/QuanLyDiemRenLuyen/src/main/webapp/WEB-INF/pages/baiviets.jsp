<%-- 
    Document   : baiviets
    Created on : Jun 16, 2024, 10:22:21 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec"
uri="http://www.springframework.org/security/tags" %> 
<script src="<c:url value="/js/script.js" />"></script>
    <p>Change language: 
        <a href="?lang=en">English</a> | 
        <a href="?lang=vi">Vietnamese</a> |
            <a href="?lang=jp">Japanese</a>

    </p>
    <div class="mt-3">
        <a href="<c:url value="/admin/baiviet" />" class="btn btn-info">${addPost}</a>
    </div>
    <!DOCTYPE html>
    <table class="table table-striped mt-3">
        <tr class="text-center">
            <th>ID</th>
            <th>${name}</th>
            <th>${createdDate}</th>
            <th>${content}</th>
            <th>${activity}</th>
            <th></th>
        </tr>

        <tbody>
            <c:forEach items="${baiViets}" var="c">
                <tr>
                    <td>${c.id}</td>
                    <td>${c.ten}</td>
                    <td>${c.ngayTao}</td>
                    <td>${c.noiDung}</td>
                    <td>${c.hoatDongId.ten}</td>
                    <c:url value="/admin/baiviets/${c.id}" var="url"/>
                    <td>
                        <a href="<c:url value="/admin/baiviet/${c.id}" />" class="btn btn-info">${update}</a>
                        <button onclick="deleteBaiViet('${url}')" class="btn btn-danger mt-3">${delete}</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

