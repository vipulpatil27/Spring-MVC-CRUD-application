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
			<form name='frm' action='xupdate' method='POST'>
				<input type='hidden' name='id' value='${emp.id}'></input>
				<div>
					Name:<input type='text' name='name' value='${emp.name}' id='n'></input>
					<br> <br> <span id='p'></span>
				</div>
				<div>
					Email:<input type='text' name='email' value='${emp.email}' id='e'></input>
					<br> <br>
				</div>
				<div>
					Contact:<input type='text' name='contact' value='${emp.contact}'
						id='c'></input> <br> <br> <span id='s'></span>
				</div>
				<div>
					<label>Gender:</label>
					<c:choose>
						<c:when test="${emp.gender=='male'}">
							<input type='radio' name='gender' value=${emp.gender='male'}
								checked='checked' />Male
	 				</c:when>
						<c:otherwise>
							<input type='radio' name='gender' value='male' />Male
	 				</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${emp.gender=='female'}">
							<input type='radio' name='gender' value=${emp.gender='female'}
								checked='checked' />Female
					</c:when>
						<c:otherwise>
							<input type='radio' name='gender' value='female' />Female
					</c:otherwise>
					</c:choose>
					<br> <br> <span id='s'></span>
				</div>
				<div>
					<label for='department'>Choose Department:</label> <select
						name='department'>
						<option value='${emp.deptname}'>${emp.deptname}</option>
						<option value='HR'>HR</option>
						<option value='Software Developer'>Software Developer</option>
						<option value='Testing'>Testing</option>
						<option value='Devops'>Devops</option>
						<option value='QA'>QA</option>
						<option value='Admin'>Admin</option>
					</select>
				</div>
				<br>

				<div>
 					${colors} 
 					<%-- <label>Favourite Color:</label><br>
					<c:forEach var="color" items="color">
						<c:choose>
							<c:when test="${color=='red' }">
								<input type="checkbox" name='color' value="red" checked="checked" /> Red				
						</c:when>
							<c:otherwise>
								<input type="checkbox" name='color' value="red" /> Red
									</c:otherwise>
						</c:choose>
					</c:forEach>
					<c:forEach var="color" items="colors">
						<c:choose>
							<c:when test="${color=='yellow' }">
								<input type="checkbox" name='color' value="yellow" checked="checked" /> Yellow													
						</c:when>
							<c:otherwise>
								<input type="checkbox" name='color' value="yellow" /> Yellow
									</c:otherwise>
						</c:choose>
					</c:forEach>
					<c:forEach var="color" items="colors">
						<c:choose>
							<c:when test="${color=='green' }">
								<input type="checkbox" name='color' value="green" checked="checked" /> Green													
						</c:when>
							<c:otherwise>
								<input type="checkbox" name='color' value="green" /> Green
									</c:otherwise>
						</c:choose>  
					</c:forEach>
					<c:forEach var="color" items="colors">
						<c:choose>
							<c:when test="${color=='pink' }">
								<input type="checkbox" name='color' value="pink" checked="checked" /> Pink				
						</c:when>
							<c:otherwise>
								<input type="checkbox" name='color' value="pink" />Pink
									</c:otherwise>
						</c:choose>
					</c:forEach>
 --%>		
						 <label for="cname"><b>Favourite Color:</b></label>
					<c:forEach var="color" items="${color}">
						<label>${color.cname}</label>
						<input type="checkbox" name="cname" value="${color.cid}">
						<c:forEach var="c" items="${emp.cname}">
							<c:if test="${c.cname == color.cname}">checked</c:if>
						</c:forEach>
					</c:forEach> 
				</div>



				<br> <input type='submit' value='Update Record'></input>
			</form>
	</div>
	</center>
</body>
</html>