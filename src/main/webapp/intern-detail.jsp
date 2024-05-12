<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Intern Details</title>
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
<h1>Intern Detail</h1>
<form action="SearchServlet" method="post">
<label for="name">Search Intern:</label>
  <input type="text" id="name" name="name" placeholder="Enter Intern Name">
  <button type="submit">Search</button><br><br>
  </form>
<table>
    <thead>
      <tr>
<!--         <th>Id</th> -->
        <th>Mobile Number</th>
        <th>Email</th>
        <th>Name</th>
        <th>Course Name</th>
        <th>Branch</th>
        <th>College Name</th>
        <th>College Location</th>
        <th>Referral</th>
        <th>Year of Passing</th>
        <th>Current Semester</th>
        <th>Internship in Technologies</th>
        <th>Known Technologies</th>
        <th>Intern Duration</th>
        <th>Start Date</th>
        <th>End Date</th>
        <th>Actions</th>
      </tr>
    </thead>
    <tbody>
        <c:forEach items="${internDetail}" var="obj">
           <tr>
<%--            			<td><c:out value="${obj.id}"/></td> --%>
					<td><c:out value="${obj.mobileno}"/></td>
					<td><c:out value="${obj.email}"/></td>
					<td><c:out value="${obj.name}"/></td>
					<td><c:out value="${obj.coursename}"/></td>
					<td><c:out value="${obj.branch}"/></td>
					<td><c:out value="${obj.collegename}"/></td>
					<td><c:out value="${obj.collegelocation}"/></td>
					<td><c:out value="${obj.referralname}"/></td>
					<td><c:out value="${obj.yop}"/></td>
					<td><c:out value="${obj.currentsem}"/></td>
					<td><c:out value="${obj.interntech}"/></td>
					<td><c:out value="${obj.knowntech}"/></td>
					<td><c:out value="${obj.internshipduration}"/></td>
					<td><c:out value="${obj.startdate}"/></td>
					<td><c:out value="${obj.enddate}"/></td>
					<td><form action="ShowListServlet" method="post">
                          <input type="hidden" name="update" value="${obj.name}"> <button type="submit">Edit</button>
                        </form> &nbsp;&nbsp;&nbsp;&nbsp;
                        <form action="DashboardServlet" method="post">
                          <input type="hidden" name="name" value="${obj.name}"> <button type="submit">Delete</button>
                        </form> &nbsp;&nbsp;&nbsp;&nbsp;
                        
                        <button type="button" onclick="window.location.href='assignTask.jsp?id=${obj.id}'" style="background-color: #4CAF50; color: white; padding: 10px 20px; border: none; cursor: pointer; border-radius: 4px;">Assign Task</button>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <form action="AssignTaskServlet" method="post">
                        <input type="hidden" name="internId" value="${obj.id}"> <button type="submit">View Task</button>
                        </form>
                    </td>
			  </tr>
	 </c:forEach>
    </tbody>
</table>
</body>
</html>