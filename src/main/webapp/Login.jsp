<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Intern Task Management System</title>
<!-- <link rel="stylesheet" href="style.css"> -->
<style>
body {
  font-family: Arial, sans-serif;
  margin: 0;
  padding: 20px;
  background-color: #f5f5f5; 
}

h1 {
  background: linear-gradient(to right, rgb(182, 244, 146), rgb(51, 139, 147));
  color: white;
  padding: 15px;
  text-align: center;
}

.error {
  color: red;
  font-weight: bold;
  margin-bottom: 15px;
}

a {
     position: absolute;
    left: calc(100% - 750px); 
    color: #3498db; 
  text-decoration: none;
}

a:hover {
  opacity: 0.8; 
}

form {
  max-width: 300px;
  margin: 0 auto; 
  padding: 60px;
  border: 2px solid #ddd;
  border-radius: 5px;
  background-color: #fff; 
}

label {
  display: block;
  margin-bottom: 7px;
}

input[type="text"], input[type="password"] {
  width: 100%;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 3px;
  margin-bottom: 15px;
}

input[type="submit"] {
  background-color: #4CAF50;
  border: none;
  color: white;
  padding: 10px 20px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  cursor: pointer;
  border-radius: 5px;
  transition: all 0.2s ease-in-out;
}

input[type="submit"]:hover {
  transform: scale(1.02); 
  background-color: #3e8e41; 
}

</style>
</head>
<body>
<h1>Admin Login</h1>

<a href="SignUp.jsp">Don't have an account? Sign up here</a>
<br>
<br>
<form action="LoginServlet" method="post">
  
  
  <label for="username">User name:</label>
  <input type="text" id="username" name="username" required><br><br>
 
  <label for="password">Password:</label>
  <input type="password" id="password" name="password" required><br><br>
  <input type="submit" value="Login">
<c:if test="${param.error != null}">
  <p style="color: blue;">Invalid credentials. Please try again.</p>
</c:if>
</form>
<br>
<a href="HomePage.jsp"> Back to Home</a>
</body>
</html>