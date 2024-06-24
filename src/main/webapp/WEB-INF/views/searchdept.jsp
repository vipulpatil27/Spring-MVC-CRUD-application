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
<form  action='deptname' class='form' method='GET'>
<input type='text' name='dname' value='' placeholder='enter department name'/><br><br>
<input type='submit' name='s' value='Search Department'/>
<br><br><br>
</form>
</div>
<center>
<table border=2px; width=50%; height=auto; border-collapse=collapse;>
	<tr>
		<th>DEPARTMENT ID</th>
		<th>DEPARTMENT NAME</th>
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
</center>
</body>
</html>