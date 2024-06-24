
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<form name='frm' action='save' method='POST' class='form1'>
	<input type='text' name="name" value='' placeholder='enter name' class='control'/><br><br>
	<input type='text' name="email" value='' placeholder='enter email' class='control'/><br><br>
	<input type='text' name="contact" value='' placeholder='enter contact' class='control'/><br><br> 
	<label>Gender:</label>
	<input type='radio' name='gender' value='male'>Male
	<input type='radio' name='gender' value='female'>Female
	<br><br>
	<div>
        <label for='department'>Choose Department</label>
        	<select id='department'>
            	<option value=''>--Please choose department--</option>
            	<option value='HR'>HR</option>
            	<option value='Software Developer'>Software Developer</option>
            	<option value='Testing'>Testing</option>
            	<option value='Analytics'>Analytics</option>
        	</select>
    	</div>
	<br><br>
	<input type='submit' name='s' value='Add New Employee' class='control'/><br><br>
	${msg}
	</form>
</body>
</html>