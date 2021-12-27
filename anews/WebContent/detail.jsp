<%@page import="model.bean.News"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="inc/header.jsp" %>
			<div class="content-left fl">
				<%@include file="inc/left_bar.jsp" %>
			</div>
			<div class="content-right fr">
				<%
					if(request.getAttribute("objNews") != null){
						News objNews = (News)request.getAttribute("objNews");
					
				%>
				<h3><%=objNews.getName() %></h3>
				<div class="main-content">
					<p><%=objNews.getDetail() %></p>
				</div>
				<%
					}
				%>
			</div>
<%@include file="inc/footer.jsp" %>