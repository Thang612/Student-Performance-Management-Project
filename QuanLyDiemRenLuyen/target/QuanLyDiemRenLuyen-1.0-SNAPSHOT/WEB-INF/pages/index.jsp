<%-- 
    Document   : index
    Created on : May 5, 2024, 1:05:13 AM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
           uri="http://www.springframework.org/security/tags" %> 
<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_TROLY')">
    <div class="mt-1">
        <h1>${greetingMessage}</h1>
        <p>Change language: 
            <a href="?lang=en">English</a> | 
            <a href="?lang=vi">Vietnamese</a> |
            <a href="?lang=jp">Japanese</a>

        </p>
        <div>
            <a href="<c:url value="/admin/hoatdongs" />" class="btn btn-info">${addMessage}</a>
        </div>
        <form class="mt-3">
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

        <table class="table table-striped mt-1">

            <tr>
                <th>ID</th>
                <th>${name}</th>
                <th>${content}</th>
                <th>${point}</th>
                <th>${rule}</th>
                <th>${department}</th>
                <th>${semester}</th>
                <th>${year}</th>
                <th>${fee} ($)</th>
                <th>${owner}</th>
                <th></th>
            </tr>

            <tbody>
                <c:forEach items="${hoatDongs}" var="c">
                    <tr>
                        <td>${c.id}</td>
                        <td>${c.ten}</td>
                        <td>${c.moTa}</td>
                        <td>${c.diem}</td>
                        <td>${c.dieuId.getDieu()}</td>
                        <td>${c.khoaId.getTen()}</td>
                        <td>${c.hocKiNamHocId.getHocKiId().getHocKi()}</td>
                        <td>${c.hocKiNamHocId.getNamHocId().getNamHoc()}</td>        
                        <td>${c.phi == null ? "Miễn phí" : c.phi}</td>

                        <td>${c.troLyId.getNguoiDung().getHo()}  ${c.troLyId.getNguoiDung().getTen()}</td>
                        <c:url value="/hoatdongs/${c.id}" var="url"/>
                        <td>
                            <a href="<c:url value="/admin/hoatdongs/${c.id}" />" class="btn btn-info">${update}</a>
                            <button onclick="deleteHoatDong('${url}')" class="btn btn-danger">${delete}</button>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>


        <ul class="pagination">
            <li class="page-item"><a class="page-link" href="#">Previous</a></li>
            <li class="page-item">            <a class="page-link active" href="?page=1">1</a></li>
            <li class="page-item"> <a class="page-link" href="?page=2">2</a></li>
            <li class="page-item"><a class="page-link" href="?page=3">3</a></li>
            <li class="page-item"><a class="page-link" href="?page=4">4</a></li>
            <li class="page-item"><a class="page-link" href="?page=5">5</a></li>
            <li class="page-item"><a class="page-link" href="?page=6">6</a></li>
            <li class="page-item"><a class="page-link" href="#">Next</a></li>
        </ul>
    </div>
</sec:authorize>

<script src="<c:url value="/js/script.js" />"></script>


