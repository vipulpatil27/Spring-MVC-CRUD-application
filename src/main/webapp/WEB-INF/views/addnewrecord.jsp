<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add new record</title>
 <link href="<c:url value="/resources/CSS/style.css"/>" rel="stylesheet">
</head>  
<body>
<jsp:include page="home.jsp"/>
<br><br> 
	<form name='frm' action='save' method='POST' class='form1'>
	Name   :<input type='text' name="name" value=''  placeholder='enter name' class='control'  /><br><br>
	Email  :<input type='text' name="email" value='' placeholder='enter email' class='control'/><br><br>
	Contact:<input type='text' name="contact" value='' placeholder='enter contact' class='control'/><br><br> 
	<div>
		<label>Gender:</label>
		<input type='radio' name='gender' value='male' >Male
		<input type='radio' name='gender' value='female'>Female
		<br><br>	
	</div>
	       <div> 
	       Choose color:
  		   <c:forEach var='list' items='${color}' >
       	   	<label><input type="checkbox" name='colid' value="${list.getCid()}" />${list.getCname()}</label><br>     				 
       	   </c:forEach><br>
   		   </div>  		    	
   		    <div>
            <label for='department'>Choose Department:</label>
        	<select name='did'>
        	<c:forEach var='d' items='${dms}'>
            	<option value='${d.getDid()}'>${d.getDname()}</option>
         	</c:forEach>
        	</select>
    	</div> 
    	<br><br>
	<input type='submit' name='s' value='Add New Employee' class='control'/><br><br>
	${msg}
	</form>
</body>
</html>