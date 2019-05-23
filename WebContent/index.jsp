<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<title>静静的论坛</title>
	</head>
	<link rel="stylesheet" href="layui/css/layui.css" />
	<style>
		.div-head {
			border: 1px dotted #DCDCDC;
			padding: 15px 20px 15px 15px;
		}
		
		.img {
			width: 150px;
		}
		
		.div-img {
			line-height: 130px;
			width: 150px;
			float: left;
		}
		
		.tit {
			width: 100%;
			height: 35px;
			line-height: 35px;
			z-index: 1;
			padding-left: 5px;
		}
		
		.course {
			font-weight: bold;
			font: bold 15px "microsoft yahei";
			margin-bottom: 6px;
			line-height: 22px;
			padding-top: 5px;
			padding-left: 15px;
			float: left;
			padding-left: 15px;
		}
		
		.msg {
			color: #999;
			font-size: 12px;
			width: 55%;
			line-height: 21px;
			float: left;
			display: inline-block;
			zoom: 1;
			overflow: hidden;
			text-overflow: ellipsis;
			white-space: nowrap;
			padding-left: 16px;
			height: 21px;
		}
		
		.span {
			float: left;
		}
		
		.a {
			float: right;
			margin-right: 8px;
			font-size: 13px;
			line-height: 15px;
			display: inline-block;
			padding: 6px 12px;
			margin-bottom: 0;
		}
	</style>

	<body>
		<ul class="layui-nav" lay-filter="">
			<li class="layui-nav-item ">
				<a href="sy.jsp">首页</a>
			</li>
			<li class="layui-nav-item  layui-this">
				<a href="index.jsp">论坛中心</a>
			</li>

			<li class="layui-nav-item" style="float: right;">
				<a href="javascript:;">${sessionScope.user.account}</a>
				<dl class="layui-nav-child">
					<!-- 二级菜单 -->
					<dd>
						<a href="">个人信息</a>
					</dd>
					<dd>
						<a href="">退出登录</a>
					</dd>

				</dl>
			</li>
		</ul>
		<div style="margin-left: auto;margin-right: auto;text-align: center;margin-top: 10px;margin-bottom: 20px;">
			<a href="addTitle.jsp"><button class="layui-btn" style="height: 40px; width: 85%;">发布帖子</button></a>
		</div>
		<c:forEach var="title" items="${sessionScope.titleList}">
			<div class="div-head div" style="height: 136px; width: 80%;margin-left: auto;margin-right: auto; padding-top: 20px">
				<div class="div" style="position: relative;">
					<div class="div-img">
						<img class="img" src="img/ewm.png">
					</div>
					<br />
					<div class="div tit" style="padding-top:20px ;">
						<span class="div course" style="width: 45%">
					<a href="titleDetail.jsp?id=${title.id}">${title.title}</a></span>
						<div style="float: right;">
						</div>
						<div style="float: right; margin-right: 10px;"></div>
					</div>
					<div class="div msg" style="padding-top: 10px">发帖人：&nbsp;&nbsp;静静</div>
					<div class="div msg">发帖时间：&nbsp;&nbsp;2019-5-21 14:21:43</div>

					<a href="#" class="a layui-icon">&#xe67b;&nbsp;&nbsp;收藏此帖</a>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href='titleDetail.jsp?id=${title.id}' class="a layui-icon">&#xe67b;&nbsp;&nbsp;查看详细</a>
				</div></div>
		</c:forEach>
		<script src="layui/layui.js"></script>
		<script src="layui/jquery-3.1.1.js"></script>
		<script>
			//注意：导航 依赖 element 模块，否则无法进行功能性操作
			layui.use(['element', 'carousel'], function() {
				var element = layui.element;
				var carousel = layui.carousel;
				//建造实例
				carousel.render({
					elem: '#test1',
					width: '80%',
					arrow: 'always',
					height: 400,
					interval: 2000
				});
			});
			$(function() {
				$(".div-head").mouseenter(function() {
					$(this).css("border-left", "3px solid #009688")
				})
				$(".div-head").mouseleave(function() {
					$(this).css("border-left", "none")
				})
			})
		</script>
	</body>

</html>
