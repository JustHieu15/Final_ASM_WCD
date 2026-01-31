<%--<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>--%>
<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>JSP - Hello World</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h1><%= "Hello World!" %>--%>
<%--</h1>--%>
<%--<br/>--%>
<%--<a href="hello-servlet">Hello Servlet</a>--%>
<%--<h2>Login</h2>--%>

<%--<form action="${pageContext.request.contextPath}/" method="post">--%>
<%--    Username: <input type="text" name="username"/><br/>--%>
<%--    Password: <input type="password" name="password"/><br/>--%>
<%--    <input type="submit" value="Login"/>--%>
<%--</form>--%>

<%--<c:if test="${not empty error}">--%>
<%--    <p style="color:red">${error}</p>--%>
<%--</c:if>--%>
<%--</body>--%>
<%--</html>--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Exam 01</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 40px;
            background-color: #f4f4f9;
        }
        .container {
            max-width: 700px;
            margin: auto;
            padding: 30px;
            background: white;
            border-radius: 10px;
            box-shadow: 0 0 15px rgba(0,0,0,0.1);
        }
        h1 {
            color: #2c3e50;
            text-align: center;
        }
        .form-group {
            margin: 20px 0;
        }
        input[type="text"], input[type="submit"], input[type="password"] {
            padding: 10px;
            font-size: 16px;
        }
        input[type="submit"] {
            background: #3498db;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background: #2980b9;
        }
        .result {
            margin-top: 30px;
            padding: 15px;
            background: #e8f4f8;
            border-left: 5px solid #3498db;
        }
    </style>
</head>
<body>

<div class="container">
    <h1>Login page</h1>

    <form action="login" method="post">
        <div class="form-group">
            <label>Username:</label><br>
            <input type="text" name="username" required style="width: 300px;">
        </div>
        <div class="form-group">
            <label>Password:</label><br>
            <input type="password" name="password" required style="width: 300px;">
        </div>

        <div class="form-group">
            <input type="submit" value="Gửi →">
        </div>
    </form>

    <%-- Hiển thị kết quả từ Servlet nếu có --%>
    <%
        String message = (String) request.getAttribute("message");
        if (message != null) {
    %>
    <div class="result">
        <strong>Kết quả từ Server:</strong><br>
        <%= message %>
    </div>
    <%
        }
    %>

</div>

</body>
</html>