<%@page import="model.bean.News"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="inc/header.jsp" %>
			<div class="content-left fl">
				<%@include file="inc/left_bar.jsp" %>
			</div>
			<div class="content-right fr">
				<h3>Tin tức</h3>
				<div class="main-content items-new">
					<ul>
							<%
								if(request.getAttribute("listNews") != null){
									ArrayList<News> listNews = (ArrayList<News>)request.getAttribute("listNews");
									if(listNews.size() > 0){
										for(News objNews : listNews){
	
							%>
						<li>
							<h2>
								<a href="<%=request.getContextPath() %>/chi-tiet?id=<%=objNews.getId() %>" title=""><%=objNews.getName() %></a>
							</h2>
							<div class="item">
								<p><%=objNews.getDescription() %></p>
								<div class="clr"></div>
							</div>
						</li>
						<%
										}
									}
								}
						
						%>		
					</ul>
				</div>
			</div>
<%@include file="inc/footer.jsp" %>