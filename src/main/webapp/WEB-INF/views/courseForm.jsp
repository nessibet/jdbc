<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<%@ page isELIgnored="false" %>
<meta charset="UTF-8">
<title>Add Course</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css?version=1">
</head>
<body>
	<div class="container">
		<div align="center">
			<h2>Add / Update Course</h2>
			<table>
				<form:form modelAttribute="course" action="saveCourse" method="post">
					<form:hidden path="id" />
					<tr>
						<td class="courseprop">CourseName:</td>
						<td><form:input path="coursename" size="30" /></td>
						<td><form:errors path="coursename" class="error" /></td>
					</tr>

					<tr>
						<td class="courseprop">Prefix:</td>
						<td><form:input path="prefix" size="30" /></td>
						<td><form:errors path="prefix" class="error" /></td>
					</tr>

					<tr>
						<td class="courseprop">Code:</td>
						<td><form:input path="code" size="30" /></td>
						<td><form:errors path="code" class="error" /></td>
					</tr>

					<tr>
						<td></td>
						<td align="center"><form:button>Submit</form:button></td>
						<td></td>
					</tr>
				</form:form>
			</table>
		</div>
	</div>
</body>
</html>