package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReplyDao;
import pojo.Reply;
import pojo.User;
import service.ReplyService;
import service.ReplyServiceImpl;

@WebServlet(urlPatterns = "/addReply")
public class AddReplyServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String text = request.getParameter("reply");
		int titleId = Integer.parseInt(request.getParameter("titleId"));
		User user = (User) request.getSession().getAttribute("user");
		String account = user.getAccount();
		Reply r = new Reply();
		r.setAccount(account);
		r.setMsg(text);
		r.setTitleId(titleId);
		r.setTime();
		ReplyService rs = new ReplyServiceImpl();
		rs.addReply(r);
		request.getRequestDispatcher("/titleDetail.jsp?id=" + titleId).forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
