<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container mt-5">
    <div class="mb-2">
        <h3 class="text-center">ABC Company's Empolyee List</h3>
    </div>
    <div style="display: flex; justify-content: space-between">
        <div>
            <a class="btn btn-primary nb-2" href="create">Add New</a>
        </div>
        <form method="POST" action="search">
            <div style="display: flex;">
                <input type="text" class="form-control" name="search" style="margin-right: 20px"> <button type="submit">Search</button>
            </div>
        </form>
    </div>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">No</th>
            <th scope="col">Employee Id</th>
            <th scope="col">Employee Name</th>
            <th scope="col">Birthday</th>
            <th scope="col">Phone Number</th>
            <th scope="col">Email</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${ dataList }" var="el" varStatus="status">
            <tr>
                <td>${ status.index }</td>
                <td>${ el.employeeId }</td>
                <td>${ el.employeeName }</td>
                <td>${ el.birthday }</td>
                <td>${ el.phoneNumber }</td>
                <td>${ el.email }</td>
                <td>
                    <a class="btn btn-primary" href="/Exam_02_war_exploded/edit?id=${el.employeeId}">Update</a>
                    <a onclick="return confirm('Bạn có chắc chắn muốn xóa?')" class="btn btn-danger"
                       href="/Exam_02_war_exploded/delete?id=${el.employeeId}">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>