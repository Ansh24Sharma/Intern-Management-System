<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Intern Registration Form</title>
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

      
        
    <h1>Intern Registration Form</h1>

    <% String errorMessage = (String) request.getAttribute("errorMessage"); %>
    <% if (errorMessage != null) { %>
        <p class="error"><%= errorMessage %></p>
    <% } %>

    <form id="intern-registration-form" action="RegistrationServlet" method="post" class="form-container">

        <label for="email">Email Address:</label>
        <input type="email" id="email" name="email" required>
        <br>

        <label for="name">Full Name:</label>
        <input type="text" id="name" name="name" required>
        <br>
        
        <label for="mobileno">Mobile Number:</label>
        <input type="tel" id="mobileno" name="mobileno" required>
        <br>

        <label for="coursename">Course Name:</label>
        <input type="text" id="coursename" name="coursename" required>
        <br>

        <label for="branch">Branch:</label>
        <input type="text" id="branch" name="branch" required>
        <br>

        <label for="collegename">College Name:</label>
        <input type="text" id="collegename" name="collegename" required>
        <br>

        <label for="collegelocation">College Location:</label>
        <input type="text" id="collegelocation" name="collegelocation" required>
        <br>
        
        <label for="hasReferral">Has Referral?</label>
        <input type="checkbox" id="hasReferral" name="hasReferral">
        <br>

        <label for="referralname">Referral Name (Optional):</label>
        <input type="text" id="referralname" name="referralname" disabled>
        <br>
        
  <script>
        const hasReferralCheckbox = document.getElementById("hasReferral");
        const referralNameInput = document.getElementById("referralname");

        hasReferralCheckbox.addEventListener("change", function() {
          referralNameInput.disabled = !this.checked;
          referralNameInput.style.display = this.checked ? "block" : "none";
        });
        function showUndergraduateForm() {
        	  document.getElementById("undergraduateFormPopup").style.display = "block";
        	}
        function showSemesterInput() {
            var isYesSelected = document.getElementById("yes").checked;
            document.getElementById("semesterInput").style.display = isYesSelected ? "block" : "none";
          }
        
        function hideSemesterInput() {
        	  document.getElementById("semesterInput").style.display = "none";
        	}
      
         function calculateEndDate() {
            var durationInput = document.getElementById("internshipduration").value = (document.getElementById("internshipduration").value || 0);
            var startDateInput = document.getElementById("startDate");
            var endDateOutput = document.getElementById("endDate");

            var duration = parseInt(durationInput.value);
            var startDate = new Date(startDateInput.value); 


            if (!isNaN(duration) && !isNaN(startDate.getTime())) {
              var endDate = new Date(startDate.getTime());
              endDate.setMonth(endDate.getMonth() + duration); 
              endDateOutput.value = endDate.toISOString().substring(0, 10); 
            } else {
              alert("Please enter a valid duration and start date.");
            }
          }
 
        </script>
        
        <label for="yop">Year of Passing:</label>
        <input type="text" id="yop" name="yop" onclick ="showUndergraduateForm()">
        <div id="undergraduateFormPopup" style="display: none;">
        <h3>Are you an undergraduate student?</h3>
        <input type="radio" id="yes" name="undergraduate" value="yes" onclick="showSemesterInput()"> Yes<br>
        <input type="radio" id="no" name="undergraduate" value="no" onclick="hideSemesterInput()"> No<br>
        <div id="semesterInput" style="display: none;">
          <label for="currentsem">Current Semester:</label>
          <input type="text" id="currentsem" name="currentsem">
        </div>
        </div>
        <br>
        
        
        <label for="interntech">Internship in technologies </label>
        <select id ="interntech" name="interntech">
        <option value="Java">Java</option>
        <option value="Python">Python</option>
        <option value="Power BI">Power BI</option>
        <option value="Sales Force">Sales Force</option>
        </select>
        <br>

        <label for="knowntech">Known Technologies:</label>
        <input type="text" id="knowntech" name="knowntech" required>
        <br>
        
        <label for="internshipduration">Internship Duration (Months):</label>
        <input type="number" id="internshipduration" name="internshipduration" min="0" max="6" onchange="calculateEndDate()" >
        
        <br>
        <br>

        <label for="startDate">Start Date:</label>
        <input type="date" name="startDate" onchange="calculateEndDate()" >
        
        <br>
        <br>
        
        <button type="submit">Submit Registration</button>&nbsp;&nbsp;
        <input type="reset" value="Reset"> 
        
    </form>
</body>
</html>
