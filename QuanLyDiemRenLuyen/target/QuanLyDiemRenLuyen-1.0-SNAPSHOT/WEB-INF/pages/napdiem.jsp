<%-- 
    Document   : napdiem
    Created on : May 28, 2024, 4:07:21 PM
    Author     : DELL
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/admin/napdiem" var="actions" />

<form method="post" enctype="multipart/form-data" action="${actions}">
    <input type="file" name="file" accept=".csv, .xls, .xlsx" />
    <button type="submit">Upload</button>
</form>
