<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>VinaEnter EDU - Đã học là làm được</title>
	<meta name="description" content="Thiet ke website, dao tap lap trinh">
	<meta name="keywords" content="thiet ke website, dao tap lap trinh">
	<link href="css/style.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="js/jquery-3.5.1.min.js"></script>
</head>
<body>
	<div id="header">
		<div id="header-status">
			<div class="container_12">
				<div class="grid_4">
					<ul class="user-pro">
						<li>Logout</li>
						<li>Chào, admin</li>
					</ul>
				</div>
			</div>
			<div style="clear: both;"></div>
		</div>

		<div id="header-main">
			<div class="container_12">
				<div class="grid_12">
					<div id="logo">
						<ul id="nav">
							<li id="current"><a href="#">Quản trị</a></li>
							<li><a href="#">Tài khoản</a></li>
						</ul>
					</div>
				</div>
				<div style="clear: both;"></div>
			</div>
		</div>
		<div style="clear: both;"></div>
		<div id="subnav">
			<div class="container_12">
				<div class="grid_12">
					<ul>
						<li><a href="<%=request.getContextPath()%>/trang-chu">Danh sách sản phẩm</a></li>
					</ul>
				</div>
			</div>
			<div style="clear: both;"></div>
		</div>
	</div>