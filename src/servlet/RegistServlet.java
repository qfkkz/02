package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.User;
import service.UserServiceImpl;

@WebServlet(urlPatterns = "/regist")
public class RegistServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		User user = new User(account, password);
		int i = new UserServiceImpl().regist(user);
		if (i != 0) {
			request.setAttribute("mess", "注册成功");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			request.setAttribute("mess", "注册失败");
			request.getRequestDispatcher("regist.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}

}
