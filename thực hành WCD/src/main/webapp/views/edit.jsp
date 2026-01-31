<%--
  Created by IntelliJ IDEA.
  User: sonst
  Date: 13/03/2024
  Time: 23:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
</head>
<body>
<%
    String employeeNameErr = (String)session.getAttribute("employeeNameErr");
    String phoneNumberErr = (String)session.getAttribute("phoneNumberErr");
    String emailErr = (String)session.getAttribute("emailErr");
%>
<div class="container mt-5">
    <form method="POST" action="update?id=${item.employeeId}">
<%--        <div class="mb-3">--%>
<%--            <label class="form-label">Mã khách hàng</label>--%>
<%--            <input type="text" class="form-control" name="maKhachHang" value="${maKhachHang}">--%>
<%--            <% if (maKhachHangErr != null) { %>--%>
<%--            <span style="color: red;"><%= maKhachHangErr %></span>--%>
<%--            <% } %>--%>
<%--        </div>--%>
        <div class="mb-3">
            <label class="form-label">Name</label>
            <input type="text" class="form-control" name="employeeName" value="${employeeName}">
            <% if (employeeNameErr != null) { %>
            <span style="color: red;"><%= employeeNameErr %></span>
            <% } %>
        </div>
        <div class="mb-3">
            <label class="form-label">Birthday</label>
            <input type="date" class="form-control" name="birthday" value="${birthday}">
        </div>
        <div class="mb-3">
            <label class="form-label">Phone number</label>
            <input type="text" class="form-control" name="phoneNumber" value="${phoneNumber}">
            <% if (phoneNumberErr != null) { %>
            <span style="color: red;"><%= phoneNumberErr %></span>
            <% } %>
        </div>
        <div class="mb-3">
            <label class="form-label">Email</label>
            <input type="text" class="form-control" name="email" value="${email}">
            <% if (emailErr != null) { %>
            <span style="color: red;"><%= emailErr %></span>
            <% } %>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
</html>