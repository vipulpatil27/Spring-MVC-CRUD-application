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
	<br>
	<br>
	<div class='up'>
		<form name='frm' action='xupdate' method='POST'>
			<input type='hidden' name='id' value='${id}'></input>
			<div>
				<input type='text' name='name' value='${name}' id='n'
					placeholder='enter name'></input><br>
				<br> <span id='p'></span>
			</div>
			<div>
				<input type='text' name='email' value='${email}' id='e'
					placeholder='email'></input><br>
				<br>
			</div>
			<div>
				<input type='text' name='contact' value='${contact}' id='c'
					placeholder='contact'></input><br>
				<br> <span id='s'></span>
			</div>
			<div>
				<input type='radio' name='gender' value='male' id='g' />Male <input
					type='radio' name='gender' value='female' id='g' />Female<br>
				<br> <span id='s'></span>
			</div>
			<div>
				<label for="course">Choose Department</label> <select>
					<option value="">--Please choose department--</option>
					<option value="HR">HR</option>
					<option value="Software Developer">Software Developer</option>
					<option value="Testing">Testing</option>
					<option value="Analytics">Analytics</option>
				</select>
			</div>
			<input type='submit' value='Update Record'></input>
		</form>
	</div>
</body>
</html>