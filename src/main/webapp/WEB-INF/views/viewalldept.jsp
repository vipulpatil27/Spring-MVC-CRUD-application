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
	    <th>Department ID</th> 
		<th>Department Name</th>
		<th>DELETE</th>
		<th>UPDATE</th>
	</tr>
	<c:forEach var="s" items="${map}">
	<tr>
		<td>${s.getDid()}</td>
		<td>${s.getDname()}</td>
		<td><a href='deleteDept?did=${s.getDid()}'>Delete</a></td>
		<td><a href='updept?did=${s.getDid()}&dname=${s.getDname()}'>Update</a></td>
	</tr>
	</c:forEach>
</table>
</div>
</body>
</html>