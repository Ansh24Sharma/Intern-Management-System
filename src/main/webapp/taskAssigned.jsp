<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Task Assigned</title>
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
  width: 127%
}

table {
  border-collapse: collapse; 
  width: 130%; 
}

th, td {
  padding: 10px;
  border: 1px solid #ddd; 
  text-align: center; 
}

th {
  background-color: #f5f5f5; 
  font-weight: bold;
}

tbody tr:nth-child(even) {
  background-color: #f0f0f0; 
}

button[type="submit"] {
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

</style>
</head>
<body>
<h1>Task Details</h1>
   
<c:if test="${not empty taskDetail}">
    <table>
    <thead>
      <tr>
        <th>Title</th>
        <th>Project Name</th>
        <th>Description</th>
        <th>Due Date</th>
        <th>Status</th>
        <th>Action</th>
      </tr>
    </thead>
    <tbody>
        <c:forEach items="${taskDetail}" var="obj">
           <tr>
					<td><c:out value="${obj.title}"/></td>
					<td><c:out value="${obj.projectName}"/></td>
					<td><c:out value="${obj.description}"/></td>
					<td><c:out value="${obj.dueDate}"/></td>
					<td><c:out value="${obj.status}"/></td>
					<td><form action="DeleteTaskServlet" method="post">
                        <input type="hidden" name="title" value="${obj.title}"> <button type="submit">Delete</button>
                        </form> &nbsp;&nbsp;</td>
           <tr>
	   </c:forEach>
    </tbody>
</table>
</c:if>
<c:if test="${empty taskDetail}">
    <p>There are no task available.</p>
</c:if>
<br>
<a href="Login.jsp"> Back to Login</a>
</body>
</html>