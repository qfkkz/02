<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<title>静静的论坛</title>
	</head>
	<link rel="stylesheet" href="layui/css/layui.css" />

	<body>
		<ul class="layui-nav" lay-filter="">
			<li class="layui-nav-item  layui-this">
				<a href="sy.jsp">首页</a>
			</li>
			<li class="layui-nav-item">
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
		<div class="layui-carousel" style="margin-left: auto;margin-right: auto;margin-top: 40px;" id="test1">
			<div carousel-item>
				<div><img src="img/11.jpg" width="100%"></div>
				<div><img src="img/22.jpg" width="100%"></div>
				<div><img src="img/33.jpg" width="100%"></div>
				<div><img src="img/44.jpg" width="100%"></div>
			</div>
		</div>
		<!-- 条目中可以是任意内容，如：<img src=""> -->
		<div class="layui-collapse" style="margin-left: auto;margin-right: auto;margin-top: 40px;width: 80%;">
			<div class="layui-colla-item">
				<h2 class="layui-colla-title">系统功能</h2>
				<div class="layui-colla-content layui-show">就是一个单纯的论坛，发帖回帖而已</div>
				<div class="layui-colla-content layui-show">首页就是想要好看点，没什么功能作用哦</div>
			</div>
			<div class="layui-colla-item">
				<h2 class="layui-colla-title">关于我们</h2>
				<div class="layui-colla-content ">静静：负责前端优化处理</div>
				<div class="layui-colla-content ">坤仔：负责后台业务处理</div>
			</div>
			<div class="layui-colla-item">
				<h2 class="layui-colla-title">温馨提示</h2>
				<div class="layui-colla-content ">本论坛已经与网警合作，请文明上网</div>
			</div>
		</div>

		<script src="layui/layui.js"></script>
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
		</script>
	</body>

</html>
