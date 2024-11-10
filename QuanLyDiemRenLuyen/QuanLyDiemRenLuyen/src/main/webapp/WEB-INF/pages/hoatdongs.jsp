<%-- 
    Document   : hoatdongs
    Created on : May 6, 2024, 7:11:12 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1 class="text-center text-info mt-1">Quản Lý Hoạt Động</h1>
<c:url value="/admin/hoatdongs" var="actions" />
<form:form action="${actions}" modelAttribute="hoatDong" method="post">
    <form:errors path="*" element="div" cssClass="alert alert-danger"></form:errors>
        <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" id="ten" placeholder="Nhập tên hoạt động" path="ten" />
        <label for="ten">Tên hoạt động</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" id="mota" placeholder="Nhập mô tả hoạt động" path="moTa" />
        <label for="mota">Mô tả hoạt động</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" id="diem" placeholder="Nhập điểm cho hoạt động" path="diem" />
        <label for="diem">Điểm</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:select class="form-select" id="dieu" path="dieuId">
            <c:forEach items="${dieus}" var="c">
                <c:choose>
                    <c:when test="${c.id==hoatDong.dieuId.id}">
                        <option value="${c.id}" selected>${c.dieu}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${c.id}">${c.dieu}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </form:select>
        <label for="dieu" class="form-label">Điều</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:select class="form-select" id="hocKiNamHocId" path="hocKiNamHocId">
            <c:forEach items="${hocKiNamHocs}" var="c">
                <c:choose>
                    <c:when test="${c.id==hoatDong.hocKiNamHocId.id}">
                        <option value="${c.id}" selected>Học kì: ${c.hocKiId.getHocKi()} - Năm học: ${c.namHocId.getNamHoc()}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${c.id}">Học kì: ${c.hocKiId.getHocKi()} - Năm học: ${c.namHocId.getNamHoc()}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </form:select>
        <label for="hocKiNamHocId" class="form-label">Học kì - Năm Học</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:select class="form-select" id="khoaId" path="khoaId">
            <c:forEach items="${khoas}" var="c">
                <c:choose>
                    <c:when test="${c.id==hoatDong.khoaId.id}">
                        <option value="${c.id}" selected="">${c.ten}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${c.id}">${c.ten}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </form:select>
        <label for="hocKiNamHocId" class="form-label">Khoa phụ trách</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:select class="form-select" id="troLyId" path="troLyId.id">
            <c:forEach items="${troLys}" var="c">
                <c:choose>
                    <c:when test="${c.id==hoatDong.troLyId.id}">
                        <option value="${c.id}" selected>${c.nguoiDung.getHo()} ${c.nguoiDung.getTen()}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${c.id}">${c.nguoiDung.getHo()} ${c.nguoiDung.getTen()}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </form:select>
        <label for="troLyId" class="form-label">Trợ lý</label>
    </div>

    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" id="phi" placeholder="$" path="phi" />
        <label for="diem">Phí</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <button class="btn btn-info" type="submit">
            <c:choose>
                <c:when test="${hoatDong.id > 0}">Cập nhật thông tin</c:when>
                <c:otherwise>Thêm hoạt động</c:otherwise>
            </c:choose>
        </button>
        <form:hidden path="id"/>
    </div>
</div>

</form:form>
