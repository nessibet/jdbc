<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <!-- jstl  -->
<!--jstl-- jsp içinde daha az java kodu yazmamızı sağlayan bir yapı -->
<!DOCTYPE html>
<html>
<head>
<%@ page isELIgnored="false" %>
<meta charset="UTF-8">
<title>course-project</title>

<link rel="stylesheet"  href="${pageContext.request.contextPath}/resources/css/style.css?version=1">
</head>
<body>
	<div class="container">
		<h2>Courses</h2>
		<table>

			<tr style="background-color: #6e41b7; color:white">
				<th>ID</th>
				<th>Course Name</th>
				<th>Prefix</th>
				<th>Code</th>
				<th>Update/Delete</th>
			</tr>

			<c:forEach items="${courses}" var="course" varStatus="status">

				<!-- create an "update" link with Course id -->
				<c:url var="updateLink" value="/courses/update">
					<c:param name="id" value="${course.id}" />
				</c:url>

				<!-- create an "delete" link with Course id -->
				<c:url var="deleteLink" value="/courses/delete">
					<c:param name="id" value="${course.id}" />
				</c:url>

				<tr
					style="background-color:${status.index % 2==0? 'lightgray':'#9484d5'}">
					<td>${course.id}</td>
					<td>${course.coursename}</td>
					<td>${course.prefix}</td>
					<td>${course.code}</td>

					<td>
						<!-- show the links -->

						<a class="update" href="${updateLink}">Update</a>
						<a class="delete" href="${pageContext.request.contextPath}/courses/delete/${course.id}">Delete</a>
						<!--   <a class="delete" href="${deleteLink}"> Delete</a>-->
					</td>

				</tr>
			</c:forEach>
		</table>
		<p><a class="normal" href="${pageContext.request.contextPath}/courses/form">Add Course</a>
	</div>
</body>
</html>