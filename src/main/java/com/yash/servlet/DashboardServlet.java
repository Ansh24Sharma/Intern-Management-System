package com.yash.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.dao.InternDao;
import com.yash.dao.InternDaoImp;
import com.yash.model.Intern;



@WebServlet("/DashboardServlet")
public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private InternDao interndao = new InternDaoImp();

       
    public DashboardServlet() {
        super();
    }
	
	protected void interns(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

        List<Intern> interns = interndao.getDetails();
		request.getSession().setAttribute("internDetail", interns);
		RequestDispatcher dispatcher = request.getRequestDispatcher("intern-detail.jsp");
		dispatcher.forward(request, response);
	  }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		interns(request, response);
		
		try {
			
			deleteIntern(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void deleteIntern(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		String name = request.getParameter("name");
		interndao.deleteIntern(name);
		RequestDispatcher dispatcher = request.getRequestDispatcher("intern-detail.jsp");
		dispatcher.forward(request, response);
	}
	
}
	
	

