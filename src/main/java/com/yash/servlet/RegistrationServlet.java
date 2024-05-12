package com.yash.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.model.Intern;
import com.yash.dao.InternDao;
import com.yash.dao.InternDaoImp;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private InternDao interndao = new InternDaoImp();  
	
    public RegistrationServlet() {
        super();
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Intern intern = new Intern();
		intern.setName(request.getParameter("name"));
		intern.setEmail(request.getParameter("email"));
		intern.setMobileno(Long.parseLong(request.getParameter("mobileno")));
	    intern.setCoursename(request.getParameter("coursename"));
	    intern.setBranch(request.getParameter("branch"));
	    intern.setCollegename(request.getParameter("collegename"));
	    intern.setCollegelocation(request.getParameter("collegelocation"));
	    String referralname ="";
	    if(request.getParameter("hasReferral")!=null) {
	    	referralname = request.getParameter("referralname");
	    }
	    intern.setReferralname(referralname);
	    intern.setYop(request.getParameter("yop"));
	    intern.setCurrentsem(request.getParameter("currentsem"));
	    intern.setInterntech(request.getParameter("interntech"));
	    intern.setKnowntech(request.getParameter("knowntech"));
	    
	    String internshipduration = request.getParameter("internshipduration");
	    int durationInMonths = Integer.parseInt(internshipduration);  
	    LocalDate startDate = LocalDate.parse((request.getParameter("startDate")));
	    LocalDate endDate = startDate.plusMonths(durationInMonths);
        intern.setInternshipduration(durationInMonths);
	    
	    intern.setStartdate(startDate.toString());  
	    intern.setEnddate(endDate.toString());
	    
	    try {
	        interndao.saveIntern(intern);
	       response.sendRedirect("HomePage.jsp");
	      } catch (SQLException e) {
	        e.printStackTrace();
	      }
	}

}
