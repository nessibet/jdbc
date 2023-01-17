<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<%@page isELIgnored="false" %>
<title>Course Management System</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css?version=1">

</head>


<body>
<div class="container">
<h2>COURSE MANAGEMENT SYSTEM</h2>
<p><a class="normal" href="${pageContext.request.contextPath}/courses">List Course</a></p>
<p><a class="normal" href="${pageContext.request.contextPath}/courses/form">Add Course</a></p>
</div>
</body>
</html>
