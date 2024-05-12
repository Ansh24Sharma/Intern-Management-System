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
import com.yash.dao.TaskDao;
import com.yash.dao.TaskDaoImp;
import com.yash.model.Task;



@WebServlet("/SaveTaskServlet")
public class SaveTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TaskDao taskdao = new TaskDaoImp();
	private InternDao interndao = new InternDaoImp(); 
    
	
    public SaveTaskServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  Task task = new Task();
	      task.setTitle(request.getParameter("title"));
	      task.setDescription(request.getParameter("description"));
	      task.setProjectName(request.getParameter("projectName"));
	      task.setDueDate(request.getParameter("dueDate"));
	      task.setStatus(request.getParameter("status"));	
	      task.setIntern_id(Long.parseLong(request.getParameter("internId")));
	      try {
			taskdao.saveTask(task);
			request.getSession().setAttribute("internDetail",interndao.getDetails());
			RequestDispatcher dispatcher = request.getRequestDispatcher("intern-detail.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
