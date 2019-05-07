<%@ page language="java" import="java.util.*,pojo.*,service.*"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


<title>My JSP 'MyJsp.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<%
		int id = 0;
		String idde = request.getParameter("id");
		if (idde != null) {
			id = Integer.parseInt(idde);
		}
		Title t = new Title();
		t.setId(id);
		t = new TitleServiceImpl().findTitleById(t);
		List<Reply> list = new ReplyServiceImpl().getReplyById(t);
	%>
	<table border="1">
		<tr>
			<td>

				<h2>帖子标题</h2> <%=t.getTitle()%>
			</td>
		</tr>
		<%
			for (int i = 0; i < list.size(); i++) {
				out.print("<tr><td>" + "回复时间:" + list.get(i).getTime());
				out.print("<br>" + (i + 1) + "楼" + list.get(i).getAccount() + "回复：" + list.get(i).getMsg()
						+ "</td></tr>");
			}
		%>

	</table>
	<form action="addReply" method="post">
	<input type="hidden" name="titleId" value="<%=t.getId()%>" />
		回复：<br>
		<textarea name="reply" rows="5" cols="5">
	回复内容</textarea>
		<input type="submit" value="回复" />
	</form>

<a href="index.jsp">首页</a>
</body>
</html>
