<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<title>Intern Management System</title>
<style>
body {
  font-family: Arial, sans-serif;
  margin: 0;
  padding: 20px;
  background-color: #f0f0f0; 
}

h1 {
  background: linear-gradient(to right, rgb(182, 244, 146), rgb(51, 139, 147));
  color: white;
  padding: 15px;
  text-align: center;
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
  max-width: 350px; 
  margin: 0 auto; 
  padding: 60px;
  border: 2px solid #ddd;
  border-radius: 5px;
  background-color: #fff; 
}

label {
  display: block;
  margin-bottom: 5px;
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

<h1>Admin Sign Up</h1>
<a href="Login.jsp">Already have an account? Login here</a><br><br>
<form action="signup" method="post">
  <label for="name">Name:</label>
  <input type="text" id="name" name="name" required><br><br>
  <label for="username">User Name:</label>
  <input type="text" id="username" name="username" required><br><br>
  <label for="password">Password:</label>
  <input type="password" id="password" name="password" required><br><br>
  <label for="confirmPassword">Confirm Password:</label>
  <input type="password" id="confirmPassword" name="confirmPassword" required><br><br>
  <input type="submit" value="Signup">
</form>
<br>
<a href="HomePage.jsp"> Back to Home</a>
</body>
</html>
