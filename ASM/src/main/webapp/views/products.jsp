<%--
  Created by IntelliJ IDEA.
  User: starx
  Date: 1/31/2026
  Time: 8:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.sql.*"%>
<html>
<head>
    <title>Products</title>
</head>
<body>
<a href="products/logout">Logout</a>
<h2>Product List</h2>
<table border="1">
    <tr>
        <th>Name</th>
        <th>Amount</th>
        <th>Price</th>
    </tr>
    <p>${products}</p>
    <c:forEach var="p" items="${products}">
        <tr>
            <td>${p.name}</td>
            <td>${p.amount}</td>
            <td>${p.price}</td>
        </tr>
    </c:forEach>
</table>
