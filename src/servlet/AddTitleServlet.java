package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Title;
import service.TitleService;
import service.TitleServiceImpl;

@WebServlet(urlPatterns = "/addTitle")
public class AddTitleServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		Title t = new Title();
		t.setTitle(request.getParameter("title"));
		TitleService ts = new TitleServiceImpl();
		ts.addTitle(t);
		request.setAttribute("mess", "发布成功！");
		List<Title> list = ts.findAllList();
		request.getSession().setAttribute("titleList", list);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
		

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}

}
