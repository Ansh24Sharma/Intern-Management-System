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


@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private InternDao interndao = new InternDaoImp();
    public SearchServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			searchIntern(request, response);
		} catch (SQLException | IOException | ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}
	

	private void searchIntern(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		String name = request.getParameter("name").toLowerCase();
		if (name.isEmpty()) {
			  request.setAttribute("errorMessage", "Please enter a name to search.");
			} else {
			  List<Intern> internDetail = interndao.getInternDetailsByName(name);
			  if (internDetail != null) {
			    request.getSession().setAttribute("internDetail", internDetail);
			  } else {
			    request.setAttribute("errorMessage", "No intern found with the name '" + name + "'.");
			  }
			}
		//request.getSession().setAttribute("internDetail", interndao.getInternDetailsByName(name));
		RequestDispatcher dispatcher = request.getRequestDispatcher("intern-detail.jsp");
		dispatcher.forward(request, response);
	}

}
