package com.yash.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.dao.AdminDao;
import com.yash.dao.AdminDaoImp;
import com.yash.dao.InternDao;
import com.yash.dao.InternDaoImp;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	private AdminDao admindao = new AdminDaoImp();
	private InternDao interndao = new InternDaoImp();
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			try {
				if(admindao.getAdminByUsername(request.getParameter("username"))!=null && admindao.getAdminByUsername(request.getParameter("username")).getPassword()
						.equals(request.getParameter("password"))) {
//					System.out.println(internDao.getDetails().toString());
                    request.setAttribute("internDetail",interndao.getDetails());
                    RequestDispatcher dispatcher = request.getRequestDispatcher("intern-detail.jsp");
            		dispatcher.forward(request, response);
				} else {
					response.sendRedirect("Error.jsp");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
		
			String password = request.getParameter("password");

			if (password == null || password.isEmpty()) {
				response.sendRedirect("Error.jsp");
				return;
				}
		}
	}
}



