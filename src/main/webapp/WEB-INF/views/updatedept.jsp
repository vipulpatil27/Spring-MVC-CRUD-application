<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update page</title>
<link href="<c:url value="/resources/CSS/style.css"/>" rel="stylesheet">
</head>
<body>
	<jsp:include page="home.jsp" />
	<div class='up'>
	<center class="center">
	<h3>Update Details</h3>
		<form name='frm' action='xupdept' method='POST'>
			<input type='hidden' name='did' value='${did}'></input>
			<input type='text' name='dname' value='${dname}'></input>
			<br>
			<%-- <div>
				<label for='department'>Choose Department</label> 
				<select name='department'>
					<option value='${department}'>${department}</option>
					<option value="HR">HR</option>
					<option value="Software Developer">Software Developer</option>
					<option value="Testing">Testing</option>
					<option value="Devops">Devops</option>
					<option value="QA">QA</option>
					<option value="Admin">Admin</option>
				</select>
			</div> --%>
			<br>
			<input type='submit' value='Update Record'></input>
		</form>
	</div>
	</center>
	</div>
</body>
</html>