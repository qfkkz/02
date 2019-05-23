<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%--<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>--%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'index.jsp' starting page</title>
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
用户：<c:out value="${sessionScope.user.account}"></c:out> <br>
 <table border="1">
<c:forEach var="title" items="${sessionScope.titleList}">
<c:out value="<td>${title.id}</td>" escapeXml="false">帖子序号</c:out>
<c:out value="<td>${title.title}</td>" escapeXml="false">帖子标题</c:out>
<c:out value="<td><a href='titleDetail.jsp?id=${title.id}'></a></td></tr>" escapeXml="false">查看</c:out>
</c:forEach>
</table>
<a href="addTitle.jsp">发布帖子</a>
</body>
</html>
