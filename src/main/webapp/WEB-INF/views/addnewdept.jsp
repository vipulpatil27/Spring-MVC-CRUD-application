<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add new Department</title>
 <link href="<c:url value="/resources/CSS/style.css"/>" rel="stylesheet">
     
</head>  
<body>
<jsp:include page="home.jsp"/>
<br><br>
	<div>
	<form name='frm' action='savedept' method='POST' class='form1'>
	Dept ID   :<input type='text' name="did" value='' placeholder='Dept ID' class='control'/>
	<br><br>
        <label for='department'>Choose Department:</label>
        	<select name='dname'>
            	<option value=''>--Please choose department--</option>
            	<option value='HR'>HR</option>
            	<option value='Software Developer'>Software Developer</option>
            	<option value='Testing'>Testing</option>
            	<option value='Devops'>Devops</option>
            	<option value='QA'>QA</option>
            	<option value='Analytics'>Analytics</option>
        	</select>
    	<br><br>
	<input type='submit' name='s' value='Add New Department' class='control'/><br><br>
	${m}
	</div>
	</form>
</body>
</html>