<%-- 
    Document   : header
    Created on : May 7, 2024, 2:54:16 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
           uri="http://www.springframework.org/security/tags" %> 
<c:if test="${param.error !=null}">
    <div class="alert-danger">
        Đã có lỗi, vui lòng quay lại sau!
    </div>
</c:if>
<c:if test="${param.accessDenied !=null}">
    <div class="alert-danger">
        Bạn không có quyền
    </div>
</c:if>
<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand""><img width="100px" src="<c:url value="/images/logo.jpg" />"></a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="mynavbar">
            <ul class="navbar-nav me-auto">
                <c:forEach items="${dieus}" var="c">
                    <li class="nav-item">
                        <c:url var="myUrl" value="/">
                            <c:param name="dieuId" value="${c.id}"/>
                        </c:url>
                        <a class="nav-link" href="${myUrl}">${ruleMessage} ${c.dieu}</a>
                    </li>
                </c:forEach>




            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">${statistic}</a>
                <ul class="dropdown-menu">
                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <li><a class="dropdown-item" href="<c:url value='/admin/statsbyall' />">Thống kê theo toàn trường</a></li>
                    </sec:authorize>

                    <li><a class="dropdown-item" href="<c:url value='/admin/statsbyfaculty' />">Thống kê theo khoa</a></li>
                    <li><a class="dropdown-item" href="<c:url value='/admin/statsbyclass' />">Thống kê theo lớp</a></li>
                </ul>
            </li>
            
            </li>
            
            
            

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">${featureMessage}</a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="<c:url value="/admin/baiviets" />">Bảng tin</a></li>
                        <li><a class="dropdown-item" href="<c:url value="/admin/baothieus" />">Báo thiếu</a></li>



                </li>
                <li><a class="dropdown-item" href="<c:url value="/admin/napdiem" />">Nạp điểm</a></li>
                    <sec:authorize access="hasRole('ROLE_ADMIN')">

                    <li><a class="dropdown-item" href="<c:url value="/admin/troly" />">Tạo trợ lý</a></li>
                    </sec:authorize>


            </ul>
            </li>


            <c:if test="${pageContext.request.userPrincipal.name == null}">
                <li class="nav-item">
                    <a class="nav-link text-info" href="<c:url value='/login'/>">Đăng nhập</a>
                </li>
            </c:if>
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <li class="nav-item">
                    <a class="nav-link text-info" href="<c:url value='/'/>">${pageContext.request.userPrincipal.name}</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-info" href="<c:url value='/logout'/>">Logout</a>
                </li>
            </c:if>

            </ul>
            <form action="<c:url value="/" />" class="d-flex">
                <input class="form-control me-2" name="kw" type="text" placeholder="Search">
                <button class="btn btn-primary" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>

