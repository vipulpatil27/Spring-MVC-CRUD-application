<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
		<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<c:url value="/resources/CSS/style.css"/>" rel="stylesheet">
</head>
<body>
<jsp:include page="home.jsp"/>
<br><br>

<div class='search'>
<form  action='viewName' class='form'>
<input type='text' name='name' value='' placeholder='enter name'/><br><br>
<input type='submit'/>
<br><br><br>
</form>
</div>

<center>
<table border=2px; width=50%; height=auto; border-collapse=collapse;>
	<tr>
		<th>NAME</th>
		<th>EMAIL</th>
		<th>CONTACT</th>
		<th>GENDER</th>
		<th>DEPARTMENT</th>		
		<th>Delete</th>
		<th>Update</th>
	</tr>
	<c:forEach var="s" items="${emp}">
	<tr>
		<td>${s.getName()}</td>
		<td>${s.getEmail()}</td>
		<td>${s.getContact()}</td>
		<td>${s.getGender()}</td>
		<td>${s.getDepartment()}</td>
		<td><a href='delete?userId=${s.getId()}'>Delete</a></td>
		<td><a href='upd?userId=${s.getId()}&name=${s.getName()}&email=${s.getEmail()}&contact=${s.getContact()}&gender=${s.getGender()}&department=${s.getDepartment()}'>Update</a></td>
	</tr>
	</c:forEach>
</table>
</center>
</body>
</html>