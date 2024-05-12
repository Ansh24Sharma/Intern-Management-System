<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>Assign Task</title>
  <style>
     
body {
  font-family: Arial, sans-serif;
  margin: 0;
  padding: 20px;
}

h1 {
  background: linear-gradient(to right, rgb(182, 244, 146), rgb(51, 139, 147));
  color: white;
  padding: 15px;
  text-align: center;
}


.form-container {
  width: 1000px;
  margin: 0 auto;
  padding: 30px;
  border: 2px solid #ccc;
  border-radius: 5px;
}


label {
  display: block;
  margin-bottom: 5px;
}

input[type="text"], input[type="email"], input[type="password"] {
  width: 100%;
  padding: 10px;
  border: 2px solid #ccc;
  border-radius: 3px;
  margin-bottom: 15px;
}


select {
  width: 100%;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 3px;
  margin-bottom: 15px;
}

textarea {
  width: 100%;
  height: 100px; 
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 3px;
  margin-bottom: 15px;
}


.checkbox-container, .radio-container {
  display: inline-block;
  margin-right: 15px;
  vertical-align: middle;
}

input[type="checkbox"], input[type="radio"] {
  margin-right: 5px;
}


button[type="submit"],[type="reset"] {
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

button[type="submit"]:hover {
  transform: scale(1.02); 
  background-color: #3e8e41; 
}


.error {
  color: red;
  font-weight: bold;
  margin-bottom: 10px;
}
            
    </style>
  
</head>
<body>

  <h1>Assign Task</h1>

  <c:if test="${not empty errorMessage}">
    <p style="color: red;">${errorMessage}</p>
  </c:if>

  <form action="SaveTaskServlet" method="post" class="form-container">
    <label for="title">Title:</label>
    <input type="text" id="title" name="title" required> <br>

    <label for="description">Description:</label>
    <textarea id="description" name="description" rows="5" required></textarea> <br>

    <label for="projectName">Project Name:</label>
    <input type="text" id="projectName" name="projectName" required> <br>

    <label for="dueDate">Due Date:</label>
    <input type="date" id="dueDate" name="dueDate" required> <br>
    
<!--     <label for="internId">Intern Id</label> -->
    <input type="hidden" name="internId" value="${param.id}">

    <label for="status">Status:</label>
    <select id="status" name="status" required>
      <option value="Open">Open</option>
      <option value="In Progress">In Progress</option>
      <option value="Completed">Completed</option>
    </select> <br>


    <button type="submit">Assign Task</button>
  </form>

</body>
</html>