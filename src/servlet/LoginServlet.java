package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Title;
import pojo.User;
import service.TitleService;
import service.TitleServiceImpl;
import service.UserServiceImpl;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		User user = new User(account, password);
		user = new UserServiceImpl().login(user);
		if (user.getAccount() != null && user.getPassword() != null) {
			TitleService ts = new TitleServiceImpl();
			List<Title> list = ts.findAllList();
			request.getSession().setAttribute("titleList", list);
			request.getSession().setAttribute("user", user);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			request.setAttribute("mess", "登陆失败");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
}