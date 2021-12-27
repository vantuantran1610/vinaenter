<%@page import="model.bean.Friends"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/inc/header.jsp" %>
<div class="content">
	 <div class="container">
		 <div class="content-grids">
			 <div class="col-md-8 content-main">
				 <div class="content-grid">
					 <div class="content-grid-head">				 	
						<%
							if(request.getAttribute("friend") != null){
								FriendsList findNameByFLId = (FriendsList)request.getAttribute("findNameByFLId");
								Friends objFriend = (Friends) request.getAttribute("friend");
							
						%>
						 <h3><%=findNameByFLId.getListName() %></h3>
						 <h4>Đăng ngày: <%=objFriend.getDateCteate() %>   - Lượt xem: <%=objFriend.getCount_number() %> </h4>
						 <div class="clearfix"></div>
					 </div>
					 <div class="content-grid-single">
						 <h3><%=objFriend.getName() %></h3>
						 <div class="detail_text">
							 <span><%=objFriend.getPreview_text() %></span>
							 <img class="single-pic" src="images/anh1.jpg" alt="">
							 <p><%=objFriend.getDetail() %></p>
						 </div>
						 
						 <%
							}
						 %>
						 <div class="comments">
							 <h3>Bạn thân khác của tôi</h3>
						 <%
						 	if(request.getAttribute("objFriend") != null){
						 		ArrayList<Friends> listFriend = (ArrayList<Friends>) request.getAttribute("objFriend");
						 		if(listFriend.size() > 0){
						 			for(Friends objFriend : listFriend){
		
						 %>
						 
		
							 <div class="comment-grid">
								 <img src="images/anh2.jpg" alt="">
								 <div class="comment-info">
								 <h4><a href="<%=request.getContextPath()%>/chi-tiet?id=<%=objFriend.getId()%>"><%=objFriend.getName() %></a></h4>
								 <p><%=objFriend.getDetail() %></p>
								 </div>
								 <div class="clearfix"></div>
							 </div>
						
						<%
						 			}
						 		}
						 	}
						
						%>
						</div>
					  </div>
					 
				 </div>			 			 
			 </div>
			 
			 <%@include file="/inc/rightbar.jsp" %>
			 <div class="clearfix"></div>
		 </div>
	 </div>
</div>

<%@include file="/inc/footer.jsp" %>