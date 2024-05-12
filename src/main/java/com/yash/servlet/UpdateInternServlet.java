package com.yash.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.dao.InternDao;
import com.yash.dao.InternDaoImp;
import com.yash.model.Intern;

@WebServlet("/UpdateInternServlet")
public class UpdateInternServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private InternDao interndao = new InternDaoImp();
       
   
    public UpdateInternServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			updateInternList(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	 private void updateInternList(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		 
	    	
	    	String name =request.getParameter("name");
	    	String email =request.getParameter("email");
	    	long mobileno =Long.parseLong(request.getParameter("mobileno"));
	    	String coursename= request.getParameter("coursename");    
	    	String branch= request.getParameter("branch");
	    	String collegename=request.getParameter("collegename");
	    	String collegelocation = request.getParameter("collegelocation");
	    	String referralname =request.getParameter("referralname");
	    	String yop =request.getParameter("yop");
	    	String currentsem =request.getParameter("currentsem");
	    	String knowntech =request.getParameter("knowntech");
	    	String interntech =request.getParameter("interntech");
	    	int internshipduration=Integer.parseInt(request.getParameter("internshipduration"));
	    	String startdate=request.getParameter("startdate");
	    	String enddate =request.getParameter("enddate");
	    	Intern intern = new Intern(mobileno, email, name, coursename, branch, collegename, collegelocation, referralname, yop, currentsem, knowntech, interntech, internshipduration,startdate, enddate);
	    	request.getSession().setAttribute("internList",interndao.getInternDetailsByName(name));
			System.out.println(interndao.updateIntern(intern));
			request.getSession().setAttribute("internDetail",interndao.getDetails());
			response.sendRedirect("intern-detail.jsp");
		}

}
