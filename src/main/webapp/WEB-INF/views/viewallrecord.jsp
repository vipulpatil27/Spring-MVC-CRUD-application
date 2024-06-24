<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<div>
<table>
	<tr>
		<th>NAME</th>
		<th>EMAIL</th>
		<th>CONTACT</th>
		<th>GENDER</th>
		<th>DEPARTMENT</th>
		<th>COLOR</th>
		<th>DELETE</th>
		<th>UPDATE</th>
	</tr>
	<c:forEach var="s" items="${emp}">
	<tr>
		<td>${s.getName()}</td>
		<td>${s.getEmail()}</td>
	 	<td>${s.getContact()}</td>	
		<td>${s.getGender()}</td>	
		<td>${s.getDeptname()}</td>
		<td><c:forEach items='${s.getColname()}' var='item'>
			<c:out value='${item}' />
		</c:forEach></td>
		<td><a href='delete?userId=${s.getId()}'>Delete</a></td>
		<td><a href='upd?id=${s.getId()}&name=${s.getName()}&email=${s.getEmail()}&contact=${s.getContact()}&gender=${s.getGender()}&deptname=${s.getDeptname()}'>Update</a></td>
	</tr>
	</c:forEach>
</table>
</div>
</body>
</html>