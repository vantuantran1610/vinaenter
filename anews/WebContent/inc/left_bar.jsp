<%@page import="model.bean.Category"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<h3>Danh mục tin</h3>
<ul>
	<%
		if (request.getAttribute("listCat") != null) {
		ArrayList<Category> listCat = (ArrayList<Category>) request.getAttribute("listCat");
		if (listCat.size() > 0) {
			for (Category objCat : listCat) {
	%>
	<li><a href="<%=request.getContextPath()%>/danh-muc?catId=<%=objCat.getCatId() %>" title=""><%=objCat.getCatName() %></a></li>
	<%
		}
			}
		}
	%>
</ul>