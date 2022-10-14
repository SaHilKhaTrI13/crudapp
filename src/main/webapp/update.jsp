<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 
	<form align="center" action ='update'>
		<div>
			<h2>Add detail</h2>
		</div>
		<div>
			<label>Enter your Name</label><br>
			<input type="text" name="name" required></input><br>
		</div>
		<div>
			<label>Enter Your Email</label><br>
			<input type="email" name="email" required></input><br>
		</div>
		<div>
			<label>Enter Your Age</label><br>
			<input type="number" name="age" required ></input><br>
		</div>
		<div>
			<input type="hidden" name="id" value="<%=request.getParameter("id")%>"/> 
		</div>
		<div>
			<button type="submit">Update</button>
		</div>

	</form>
</body>
</html>