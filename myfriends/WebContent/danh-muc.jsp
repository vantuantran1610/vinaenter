<%@page import="model.bean.Friends"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/inc/header.jsp" %>
<div class="content">
	 <div class="container">
		 <div class="content-grids">
			 <div class="col-md-8 content-main">	
			 	<%
					if(request.getAttribute("objList") != null){
								FriendsList objList = (FriendsList)request.getAttribute("objList");
								ArrayList<Friends> listFriend = (ArrayList<Friends>)request.getAttribute("listFriend");
								if(listFriend.size() > 0){
									for(Friends objFriend : listFriend){
						
				%>		 
				 <h1 class="title"><span>Những người bạn >> </span><%=objList.getListName() %></h1>
				 <div class="content-grid-sec">
					 <div class="content-sec-info">
							 <h3><a href="<%=request.getContextPath()%>/chi-tiet?id=<%=objFriend.getId()%>"><%=objFriend.getName() %></a></h3>
							 <h4>Đăng ngày: <%=objFriend.getDateCteate() %> - Lượt xem: <%=objFriend.getCount_number() %></h4>
							 <p><%=objFriend.getDetail() %></p>
							 <img src="images/anh1.jpg" alt=""/>
							 <a class="bttn" href="<%=request.getContextPath()%>/chi-tiet?id=<%=objFriend.getId()%>">Chi tiết bạn tôi</a>
					 </div>
				 </div>
				 <%
							}		
						}
					}
				 %>	 
			 </div>
			 
			 <%@include file="/inc/rightbar.jsp" %>
			 <div class="clearfix"></div>
		 </div>
	 </div>
</div>

<%@include file="/inc/footer.jsp" %>