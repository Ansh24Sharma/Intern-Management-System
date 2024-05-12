<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Intern Management System</title>

<style>
body {
  font-family: "Open Sans", sans-serif; 
  margin: 0;
  padding: 20px;
  background-color: #f5f5f5; 
}

header {
  background: linear-gradient(to right, rgb(182, 244, 146), rgb(51, 139, 147));
  color: white;
  padding: 15px;
  text-align: center;
}

h1 {
  font-size: 28px;
  margin: 0;
}

main {
  max-width: 700px;
  margin: 0 auto;
  padding: 20px;
}

p {
  font-size: 18px;
  text-align: center;
}

.button-container {
  text-align: center;
}

button {
  background-color: #4CAF50; 
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 5px auto;
  cursor: pointer;
  border-radius: 5px;
  transition: all 0.2s ease-in-out;
}

button:hover {
  transform: scale(1.02); 
  background-color: #3e8e41; 
}

a {
  color: inherit;
  text-decoration: none;
}

a:hover {
  opacity: 0.8; 
}

</style>
</head>
<body>
<header>
    <h1>Intern Management System</h1>
  </header>
  <main>
<p>Welcome! Please choose an option to proceed:</p><br>

  <div class="button-container">

    <a href="Login.jsp">
      <button type="button">Login</button>
    </a>
    <br><br><br>
    <a href="registration.jsp">
      <button type="button">Register as Intern</button>
    </a>
  </div>
  </main>
</body>
</html>