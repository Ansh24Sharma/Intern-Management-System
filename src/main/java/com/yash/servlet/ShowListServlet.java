package com.yash.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.dao.InternDao;
import com.yash.dao.InternDaoImp;


@WebServlet("/ShowListServlet")
public class ShowListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private InternDao interndao = new InternDaoImp(); 
       
    public ShowListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
    
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			 
	           showList(request, response);
			
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

	
    private void showList(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {

		String name = request.getParameter("update");
		request.getSession().setAttribute("internList",interndao.getInternDetailsByName(name));
    	RequestDispatcher dispatcher = request.getRequestDispatcher("editIntern.jsp");
    	System.out.println(interndao.getInternDetailsByName(name).toString());
    	
		dispatcher.forward(request, response);

	}
    
   

}
