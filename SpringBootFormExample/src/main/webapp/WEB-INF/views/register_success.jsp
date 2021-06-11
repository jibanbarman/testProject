<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Success</title>
<style type="text/css">
    span{
       display:inline-block;
       width:150px;
       text-align:left; 
       
    }
     #main_form{
    background-color:rgb(170,170,220);
    padding-top:15px;
    padding-bottom:25px;
    width:50%;
    align:center;
    margin:auto;
    border-width:2px;
    }
</style>
</head>
<body>

	<div align="center" id="main_form">
		<h2>Registration Succeeded !</h2>
		
		<span>Full Name:</span> <span>${user.name}</span><br/>
		<span>Email:</span> <span>${user.email}</span><br/>
		<span>Password:</span> <span>${user.password}</span><br/>
		<span>Birthday:</span> <span>${user.birthday}</span><br>
		<span>Profession:</span> <span>${user.profession}</span><br>
		<span>Gender:</span> <span>${user.gender}</span><br>
		<span>Married:</span> <span>${user.married}</span><br>
		<span>Note:</span> <span>${user.note}</span><br>
	</div>

</body>
</html>