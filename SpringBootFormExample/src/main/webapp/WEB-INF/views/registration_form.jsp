<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration Form</title>
<style type="text/css">
    label{
        display:inline-block;
        width:200px;
        margin:5px;
        text-align:left;
    }
    button{
       margin:10px;
       padding:10px;
    }
    
    input[type="text"],input[type="password"],select{
    width:200px;
    }
    
    input[type="radio"]{
    display:inline-block;
    margin-left:45px;
    }
    
    input[type="checkbox"]{
    display:inline-block;
    margin-right:190px;
    }
    
    #main_form{
    background-color:rgb(200,200,240);
    padding-top:15px;
    padding-bottom:25px;
    width:50%;
    align:center;
    margin:auto;
    }
    h3{
    color:red;
    }
    
</style>
</head>
<body>
	<div align="center" style="border" id="main_form">
		<h2>User Registration</h2>
		<h3>${message}</h3>
		<form:form action="register" method="post" modelAttribute="user" >
			<form:label path="name">Full Name: </form:label>
			<form:input path="name" placeholder="Full Name"/>
			<br />
			<form:label path="email">Email: </form:label>
			<form:input path="email" placeholder="Email"/>
			<br />
			<form:label path="password">Password: </form:label>
			<form:password path="password" placeholder="Password" />
			<br />
            <form:label path="birthday">Birthday (yyyy-mm-dd): </form:label>
			<form:input path="birthday" placeholder="Birthday (yyyy-mm-dd)" />
			<br />
			<form:label path="profession">Profession: </form:label>
			<form:select path="profession" items="${professionList}"></form:select>
			<br />
			<form:label path="gender">Gender: </form:label>
			<form:radiobutton path="gender" value="Male" />Male
			<form:radiobutton path="gender" value="Female" />Female
			<br />
			<form:label path="married">Married?</form:label>
			<form:checkbox path="married"/>
			<br />
			<form:label path="note">Note:</form:label>
			<form:textarea path="note" rows="5" cols="25" placeholder="Enter something.."/>
			<br />
			<form:button>Register</form:button>
			<form:button type="reset">Reset</form:button>

		</form:form>
	</div>
</body>
</html>