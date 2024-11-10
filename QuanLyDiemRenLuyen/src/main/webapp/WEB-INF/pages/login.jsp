<%-- 
    Document   : login
    Created on : May 17, 2024, 3:53:15 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1>ĐĂNG NHẬP</h1>
<c:url value="/login" var="action" />
<form method="post" action="${action}">
    <div class="form-group mt-3">
        <label for="username">Username</label>
        <input type="text" id="username" name="username" class="form-control">
    </div>
    <div class="form-group mt-3">
        <label for="password">Password</label>
        <input type="password" id="password" name="password" class="form-control">
    </div>
    <div class="mt-3">
        <input class="btn btn-info" type="submit" value="Đăng nhập">
    </div>
</form>