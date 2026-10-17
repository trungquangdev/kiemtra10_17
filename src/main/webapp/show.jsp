<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>

<form action="/phieu-giam-gia/add" method="post">

<%--    <select name="loaiSanPham"> //name tự đặt--%>
<%--        <c:forEach items="${showlsp}" var="i">--%>
<%--            <option value="${i.id}">${i.ma}</option>--%>
<%--            //id của entity gôc--%>
<%--        </c:forEach>--%>
<%--    </select>--%>
<%--    viet trong table hienthi--%>
<%--    <td>${s.loaiSanPham.ma}</td>--%>
<%--    loaiSanPham cái này là tên thuộc tính được khai báo trong Class có ManyToOne gốc--%>

    <select name="maLoaiPhieu">
        <c:forEach items="${showL}" var="sl">
            <option value="id">${sl.ma}</option>
        </c:forEach>
    </select>

    <input type="number" name="id" placeholder="Id" required>
    <input type="text" name="ma" placeholder="Mã">
    <input type="text" name="ten" placeholder="Tên">
    <input type="number" name="soLuong" placeholder="soLuong">
    <input type="text" name="loaiGiam" placeholder="loaiGiam">
    <input type="text" name="dieuKieuToiThieu" placeholder="dieuKieuToiThieu">
    <input type="text" name="giaTriToiDa" placeholder="giaTriToiDa">
    <button type="submit" onclick="return confirm('Thêm thành công')">Thêm</button>
</form>
<table border="1" cellspacing="6" cellpadding="6">
    <thead>
        <tr>
            <th>ma loai phieu</th>
            <th>maPGG</th>
            <th>ten</th>
            <th>so luong</th>
            <th>loai giam</th>
            <th>dieu kien toi thieu</th>
            <th>gia tri toi da</th>
            <th>action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${show}" var="s">
            <tr>
                <td>${s.loai_phieu_giam_gia.ma}</td>
                <td>${s.ma}</td>
                <td>${s.ten}</td>
                <td>${s.soLuong}</td>
                <td>${s.loaiGiam}</td>
                <td>${s.dieuKieuToiThieu}</td>
                <td>${s.giaTriToiDa}</td>
                <td>
                    <a href="/phieu-giam-gia/remove?id=${s.id}">delete</a>

                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>