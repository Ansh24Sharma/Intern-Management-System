package com.yash.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.dao.AdminDao;
import com.yash.dao.AdminDaoImp;
import com.yash.model.Admin;

@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  
	private AdminDao admindao = new AdminDaoImp();

    public SignUpServlet() {
        super();
    }

      @Override
      protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {

        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        String username = request.getParameter("username"); 
        String name  = request.getParameter("name");

      
        if (!password.equals(confirmPassword)) {
         
          response.sendRedirect("Password not matched");
          return;
        }
        
        Admin admin = new Admin(name,username,password);
        
        

        try {
				admindao.saveAdmin(admin);
				response.sendRedirect("Login.jsp?success=Manager+created+successfully");
          
        } catch (Exception e) {
          e.printStackTrace(); 
          response.sendRedirect("Sign up failed");
        }
      }

    }



