<%-- 
    Document   : baothieu
    Created on : Jun 17, 2024, 2:13:49 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="<c:url value="/js/script.js" />"></script>
    <p>Change language: 
        <a href="?lang=en">English</a> | 
        <a href="?lang=vi">Vietnamese</a> |
            <a href="?lang=jp">Japanese</a>

    </p>
            <form>
            <div class="form-floating">
                <select class="form-select" id="hockinamhoc" name="hocKiNamHocId">
                    <c:forEach items="${hocKiNamHocs}" var="c">
                        <option value="${c.id}" >Học kì : ${c.hocKiId.getHocKi()} - Năm Học : ${c.namHocId.getNamHoc()}</option>
                    </c:forEach>
                </select>
                <label for="hockinamhoc" class="form-label">CHỌN HỌC KÌ - NĂM HỌC</label>
            </div>
            <div class="form-floating mb-3 mt-3">
                <button class='btn btn-success'>${filter}</button>
            </div>
        </form>
    
    
<table class="table table-striped mt-3">
    <tr class="text-center">
        <th>ID</th>
        <th>${fullname}</th>
        <th>${activity}</th>
        <th>${status}</th>
        <th></th>
    </tr>

    <tbody>
        <c:forEach items="${baoThieus}" var="c">
            <tr class="text-center">
                <td>${c.id}</td>
                <td>${c.sinhVienHoatDongId.sinhVienId.nguoiDung.ho} ${c.sinhVienHoatDongId.sinhVienId.nguoiDung.ten}</td>
                <td>${c.sinhVienHoatDongId.hoatDongId.ten}</td>
                <td>
                    <c:choose>
                        <c:when test="${c.active == 1}">
                            ${process}
                        </c:when>
                        <c:otherwise>
                            ${done}
                        </c:otherwise>
                    </c:choose>
                </td>
                <c:url value="/admin/baothieus/${c.id}" var="url"/>
                <td>

                    <button onclick="updateBaoThieu('${url}')" class="btn btn-danger mt-3">${accept}</button>
                    <button onclick="deleteBaoThieu('${url}')" class="btn btn-danger mt-3">${delete}</button>

                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
