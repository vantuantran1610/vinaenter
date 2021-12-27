<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/inc/header.jsp"%>
<div class="container_12">
	<div class="grid_12">
        <div class="module">
	        <h2><span>Thêm sản phẩm</span></h2>
	        <div class="module-body">
	       		<%
	            	if(request.getAttribute("error") != null){
	            		String error = (String) request.getAttribute("error");
	            %>
	            <p style="color: red; font-style: italic"><%=error %></p>
	            <%
	            	}
	            %>
	           <form style="padding-top: 20px" action="<%=request.getContextPath()%>/add" method="post" enctype="multipart/form-data">
	               <p>
	                   <label>Tên hoa</label>
	                   <input type="text" name="tenhoa" class="input-medium" value="" />
	               </p>
				   <p>
	                   <label>Hình ảnh</label>
	                   <input type="file" name="hinhanh" id="hinhanh"/>
	               </p>
	               <p>
	                   <label>Giá bán</label>
	                   <input type="text" name="giaban" class="input-medium" value="" /> VNĐ
	               </p>
	               <p>
	                   <label>Mô tả</label>
	                   <textarea rows="7" cols="90" name="mota" class="input-medium"></textarea>
	               </p>
	               <fieldset>
	                   <input class="submit-green" type="submit" value="Thêm" /> 
	                   <input class="submit-gray" type="reset" value="Nhập lại" />
	               </fieldset>
	           </form>
	        </div>
        </div>
 		<div style="clear:both"></div>
    </div>
    <div style="clear:both"></div>
<%@ include file="/inc/footer.jsp"%>