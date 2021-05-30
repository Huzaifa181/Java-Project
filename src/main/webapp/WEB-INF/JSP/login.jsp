<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<style>

tr{
padding:10px;
border:none

}

td{
border:none!important;
font-size:18px;
}
input{
font-size:15px!important;
padding-left:15px;
}
h3{
text-align:center ;
font-size:32px;
font-weight:600;
margin-bottom:30px;
}
</style>
<body>
<div class="main">
<div class="col-1">
	<h3>Login</h3>

	<form:form id="form" method="post" commandName="user">
	<div class="table-responsive">
		<table class="table" style="width: 300px; margin:0px auto; border:none">
			
			<tr style="display:flex;align-items:center">
				<label>
				<td style="display:flex;align-items:center;  width:120px">Email :</td>
				<td><form:input type="email" path="email" placeholder="Enter Your Email" style="height:35px;width:200px"/></td>
				</label>
			</tr>
			<tr style="display:flex;align-items:center">
			<label>	
				<td style="display:flex;align-items:center;  width:120px">Password :</td>
				<td><form:input type="password" path="password" placeholder="Enter Your Passsword" style="height:35px;width:200px" /></td>
</label>
			</tr>
			<tr style="display:flex;align-items:center">
			<label>
			<td style="display:flex;align-items:center; width:120px">Login As :</td>
				<td>
				<form:select  path="type" id="select" onchange="myFunction()">
				<form:option onclick="myFunction()" value="None"></form:option>
					<form:option onclick="myFunction()" value="Admin"></form:option>
					<form:option onclick="myFunction()" value="Student"></form:option>
					<form:option onclick="myFunction()" value="Teacher"></form:option>
  					</form:select>
				</td>
			</label>
			</tr>
			<tr style="display:flex;align-item:center; margin: 0px auto">
				<td style="margin: 0px auto"><input style="text-align:center" class="btn btn-lg" type="submit" value="Login" style="width:60px"/></td>
			</tr>
		</table>
		</div>
	</form:form>
	</div>
	</div>
</body>
<script>
		var e = document.getElementById("select");
		if(e.value==="Teacher"){
			document.getElementById("form").action = "/CinemaProject/teacherDashboard"
		}
		else if(e.value==="Student"){
			document.getElementById("form").action = "/CinemaProject/studentDashboard"
		}
		else if(e.value==="Admin"){
			document.getElementById("form").action = "/CinemaProject/home"
		}
		function myFunction(){
			if(e.value==="Teacher"){
				document.getElementById("form").action = "/CinemaProject/teacherDashboard"
			}
			else if(e.value==="Student"){
				document.getElementById("form").action = "/CinemaProject/studentDashboard"
			}
			else if(e.value==="Admin"){
				document.getElementById("form").action = "/CinemaProject/home"
			}
		}
		
 </script> 

</html>