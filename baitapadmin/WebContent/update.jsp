<%@page import="model.bean.Hoa"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/inc/header.jsp"%>
<div class="container_12">
	<div class="grid_12">
        <div class="module">
	        <h2><span>Cập nhật sản phẩm</span></h2>
	        	<%
	            	if(request.getAttribute("error") != null){
	            		String error = (String) request.getAttribute("error");
	            %>
	            <p style="color: red; font-style: italic"><%=error %></p>
	            <%
	            	}
	            %>
	        <div class="module-body">
		        <%
		        	if(request.getAttribute("hoa") != null){
		        		Hoa hoa = (Hoa) request.getAttribute("hoa");    
		        %>
	           <form action="" method="post" enctype="multipart/form-data" style="padding-top: 20px" >
	               <p>
	                   <label>Tên hoa</label>
	                   <input type="text" name="tenhoa" class="input-medium" value="<%=hoa.getName()%>" />
	               </p>
				   <p>
	                   <label>Hình ảnh</label>
	                   <img width="100px" alt="" src="<%=request.getContextPath() %>/images/hoa/<%=hoa.getPrice()%>"> <br />
	                   <input type="file" name="hinhanh" id="hinhanh"/>
	               </p>
	               <p>
	                   <label>Giá bán</label>
	                   <input type="text" name="giaban" class="input-medium" value="<%=hoa.getPrice()%>" /> VNĐ
	               </p>
	               <p>
	                   <label>Mô tả</label>
	                   <textarea rows="7" cols="90" name="mota" class="input-medium"><%=hoa.getDescription() %></textarea>
	               </p>
	               <fieldset>
	                   <input class="submit-green" type="submit" value="Cập nhật" /> 
	                   <input class="submit-gray" type="reset" value="Nhập lại" />
	               </fieldset>
	           </form>
	           <%
		        	}
	           %>
	        </div>
        </div>
 		<div style="clear:both"></div>
    </div>
    <div style="clear:both"></div>
<%@ include file="/inc/footer.jsp"%>