<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Edit Intern Details</title>
  
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

button[type="submit"]{
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
  
<form action="UpdateInternServlet" method="post" class="form-container">

  <c:if test="${internList!=null}">
    <h1>Edit Intern Details</h1> 
      <c:forEach items="${internList}" var="obj">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${obj.name}"> <br>  
        <label for="email">Email:</label> 
        <input type="email" id="email" name="email" value="${obj.email}"> <br>
        <label for="mobileno">Mobile Number:</label>
        <input type="tel" id="mobileno" name="mobileno" value="${obj.mobileno}"><br>
        <label for="coursename">Course Name:</label>
        <input type="text" id="coursename" name="coursename" value="${obj.coursename}"> <br>
        <label for="branch">Branch:</label>
        <input type="text" id="branch" name="branch" value="${obj.branch}"> <br>
        <label for="collegename">College Name:</label>
        <input type="text" id="collegename" name="collegename" value="${obj.collegename}"> <br>
        <label for="collegelocation">College Location:</label>
        <input type="text" id="collegelocation" name="collegelocation" value="${obj.collegelocation}"> <br>
        <label for="referralname">Referral Name:</label>
        <input type="text" id="referralname" name="referralname" value="${obj.referralname}"> <br>
        <label for="yop">Year of Passing:</label>
        <input type="text" id="yop" name="yop" value="${obj.yop}"> <br>
        <label for="currentsem">Current Semester:</label>
        <input type="text" id="currentsem" name="currentsem" value="${obj.currentsem}"> <br>
        <label for="interntech">Internship in Technologies:</label>
        <select id ="interntech" name="interntech">
        <option value="Java">Java</option>
        <option value="Python">Python</option>
        <option value="Power BI">Power BI</option>
        <option value="Sales Force">Sales Force</option>
        </select>
        <label for="knowntech">Known Technologies:</label>
        <input type="text" id="knowntech" name="knowntech" value="${obj.knowntech }"> <br>
        <label for="internshipduration">Internship Duration (Months):</label>
        <input type="number" id="internshipduration" name="internshipduration" min="0" max="6" value="${obj.internshipduration}"> <br>
        <label for="startdate">Start Date:</label>
        <input type="date" name="startdate" value="${obj.startdate}"><br>
        <label for="enddate">End Date:</label>
        <input type="date" name="enddate" value="${obj.enddate}"> <br>
        <br>
        <button type="submit">Save</button>
        
      </c:forEach>
  </c:if>
  <c:if test="${internList==null}">
    <p>Error: Intern not found.</p>
  </c:if>
</form>
</body>
</html>
