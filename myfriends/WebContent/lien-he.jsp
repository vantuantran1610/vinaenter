<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/inc/header.jsp" %>
<div class="contact">
	 <div class="container">
		 <div class="contact-head">
			 <h3>Liên hệ</h3>
			 	<%
	            	if(request.getAttribute("error") != null){
	            		String error = (String) request.getAttribute("error");
	            %>
	            <p style="color: red; font-style: italic"><%=error %></p>
	            <%
	            	}
	            %>
	            
	            <%
					if (request.getParameter("msg") != null) {
						int msg = Integer.parseInt(request.getParameter("msg"));
						if (msg == 1) {
							out.print("<p style='color: blue; font-style: italic'>Thêm thành công!</p>");
						}
					}
				%>
			  <form action="<%=request.getContextPath() %>/lien-he" method="post" enctype="multipart/form-data">
				  <div class="col-md-6 contact-left">
						<input type="text" placeholder="Name" required="" name="name">
						<input type="text" placeholder="E-mail" required="" name="email">
						<input type="text" placeholder="Phone" required="" name="phone">
				 </div>
				 <div class="col-md-6 contact-right">
						 <textarea placeholder="Message" name="content"></textarea>
						 <input type="submit" value="SEND">
				 </div>
				 <div class="clearfix"></div>
			 </form>
		 </div>
	 </div>
</div>

<%@include file="/inc/footer.jsp" %>