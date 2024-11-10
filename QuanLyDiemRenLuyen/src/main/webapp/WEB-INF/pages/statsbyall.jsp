<%-- 
    Document   : stats
    Created on : May 9, 2024, 12:04:53 AM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
           uri="http://www.springframework.org/security/tags" %> 
<script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/2.5.1/jspdf.umd.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/html2canvas/1.4.1/html2canvas.min.js" integrity="sha512-BNaRQnYJYiPSqHHDb58B0yaPfCu+Wgds8Gp/gU33kqBtgNS4tSPHuGibyoeqMV/TJlSKda6FXzoEyYGjTe+vXA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<!DOCTYPE html>
<p>Change language: 
    <a href="?lang=en">English</a> | 
    <a href="?lang=vi">Vietnamese</a> |
    <a href="?lang=jp">Japanese</a>

</p>
<h1 class="text-center text-info">${statistic}</h1>
<div class="row">
    <div class="col-mt-5 col-12">
        <table class="table">
            <tr>
                <th>ID</th>
                <th>${lastname}</th>
                <th>${firstname}</th>
                <th>${lop}</th>
                <th>${department}</th>
                <th>${point}</th>
                <th></th>
            </tr>
            <c:forEach items="${statsTheoKhoa}" var="c"> 
                <tr>
                    <td>${c[0]}</td>                 
                    <td>${c[1]}</td>
                    <td>${c[2]}</td>
                    <td>${c[3]}</td>
                    <td>${c[4]}</td>
                    <td>${c[5]}</td>
                    <td><a class="btn  btn-success" href="<c:url value="/sinhvien/${c[0]}" />">${detail}</a></td>    
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

<hr>
<h3 id="statsbytruong" class="text-center text-info">${statisticbydepartment}</h3>
<div class="row">
    <div class="col-md-5 col-12">
        <form>
            <div class="form-floating">
                <select class="form-select" id="THANHTHICH" name="thanhtich">
                    <option value="XUATSAC" >${excellent}</option>
                    <option value="GIOI">${verygood}</option>
                    <option value="KHA" >${good}</option>
                    <option value="TRUNGBINH" >${trungbinh}</option>
                    <option value="YEU">${yeu}</option>
                    <option value="KEM" >${kem}</option>
                </select>
                <label for="THANHTHICH" class="form-label">${choose} ${achievement}</label>
            </div>
            <div class="form-floating">
                <select class="form-select" id="namHoc-khoa" name="namHoc">
                    <c:forEach items="${namHocs}" var="c">
                        <option value="${c.namHoc}" >${c.namHoc}</option>
                    </c:forEach>
                </select>
                <label for="namHoc-khoa" class="form-label">${choose} ${year}</label>
            </div>
            <div class="form-floating">
                <select class="form-select" id="hocKi-khoa" name="hocKi">
                    <c:forEach items="${hocKis}" var="c">
                        <option value="${c.hocKi}" >${c.hocKi}</option>
                    </c:forEach>
                </select>
                <label for="hocKi-khoa" class="form-label">${choose} ${semester}</label>
            </div>
            <div class="form-floating mb-3 mt-3">
                <button class='btn btn-success'>${filter}</button>
            </div>
        </form>
        <table class="table" id="data-table1"> 
            <tr>
                <th>${department}</th>
                <th>${number}</th>
            </tr>
            <c:forEach items="${statsTheoThanhTichVaTheoKhoa}" var="c">
                <tr>
                    <td>${c[0]}</td>
                    <td>${c[1]}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="col-md-7 col-12">
        <canvas id="myChart"></canvas>
    </div>
</div>
<button class="btn btn-success mb-3" onclick="convertToImageAndGeneratePDF1()">${xuat} PDF</button>



<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="<c:url value="/js/script.js" />"></script>
<script>
    let labels = [];
    let data = [];
    <c:forEach items="${statsTheoThanhTichVaTheoKhoa}" var="c">
    labels.push('${c[0]}');
    data.push('${c[1]}');

    </c:forEach>


    window.onload = function () {
        let ctx1 = document.getElementById("myChart");





        drawChartTheoKhoa(ctx1, labels, data, "THỐNG KÊ TOÀN TRƯỜNG");





    };
    async function convertToImageAndGeneratePDF1() {
        const {jsPDF} = window.jspdf;

        const pdf = new jsPDF();
        const table = document.getElementById('data-table1');
        const chart = document.getElementById('myChart');
        const statisticHeader = document.getElementById('statsbytruong');

        // Chụp nội dung từ <h3 id="statsbylop">${staticsticbyclass}</h3>
        const headerCanvas = await html2canvas(statisticHeader);
        const headerImage = headerCanvas.toDataURL('image/png');

        // Chụp bảng dưới dạng hình ảnh
        const tableCanvas = await html2canvas(table);
        const tableImage = tableCanvas.toDataURL('image/png');

        // Chụp biểu đồ dưới dạng hình ảnh
        const chartCanvas = await html2canvas(chart);
        const chartImage = chartCanvas.toDataURL('image/png');

        pdf.addImage(headerImage, 'PNG', 10, 10, 180, headerCanvas.height * 180 / headerCanvas.width);

        // Thêm hình ảnh bảng vào PDF
        pdf.addImage(tableImage, 'PNG', 10, headerCanvas.height + 20, 180, tableCanvas.height * 180 / tableCanvas.width);

        // Thêm trang mới cho biểu đồ và thêm hình ảnh biểu đồ vào PDF
        pdf.addImage(chartImage, 'PNG', 10, headerCanvas.height + tableCanvas.height + 30, 180, chartCanvas.height * 180 / chartCanvas.width);

        // Lưu PDF
        pdf.save('report.pdf');
    }





</script>