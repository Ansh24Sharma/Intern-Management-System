package com.yash.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.dao.TaskDao;
import com.yash.dao.TaskDaoImp;


@WebServlet("/AssignTaskServlet")
public class AssignedTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TaskDao taskdao = new TaskDaoImp();
  
    public AssignedTaskServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		assignTask(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void assignTask(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   long id = Long.parseLong(request.getParameter("internId"));
		   request.getSession().setAttribute("taskDetail", taskdao.getDetailsById(id));
		   RequestDispatcher dispatcher = request.getRequestDispatcher("taskAssigned.jsp");
		   dispatcher.forward(request, response);
		}

}
