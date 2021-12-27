<%@page import="model.bean.Hoa"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/inc/header.jsp"%>
<div class="container_12">
	<div class="bottom-spacing">
		<div class="float-left">
		    <a href="<%=request.getContextPath() %>/add" class="button">
		        <span>Thêm sản phẩm <img src="<%=request.getContextPath()%>/images/plus-small.gif" alt="Thêm mới"></span>
		    </a>
		</div>
		<div class="clear"></div>
	</div>
    <div class="grid_12">
        <div class="module">
       		<%
				if (request.getParameter("msg") != null) {
					int msg = Integer.parseInt(request.getParameter("msg"));
					if (msg == 1) {
						out.print("<p style='color: blue; font-style: italic'>Thêm thành công!</p>");
					}
					if(msg == 2){
						out.print("<p style='color: blue; font-style: italic'>Cập nhật thành công!</p>");
					}
					if(msg == 3){
						out.print("<p style='color: blue; font-style: italic'>Xóa thành công!</p>");
					}
					if(msg == 0){
						out.print("<p style='color: red; font-style: italic'>Xóa không thành công!</p>");
					}

				}
			%>
        	<h2><span>Danh sách sản phẩm</span></h2>
            <div class="module-table-body">      
            	<form action="">
	            	<%
	            		if(request.getAttribute("listHoa") != null){
	            			ArrayList<Hoa> listHoa = (ArrayList<Hoa>) request.getAttribute("listHoa");
	            			if(listHoa.size() > 0){  			
	            	%>
	                <table id="myTable" class="tablesorter">
	                	<thead>
	                        <tr>
	                            <th style="width:4%; text-align: center;">ID</th>
	                            <th>Tên hoa</th>
	                            <th style="width:20%">Mô tả</th>
	                            <th style="width:16%; text-align: center;">Hình ảnh</th>
	                            <th style="width:11%; text-align: center;">Giá bán</th>
	                            <th style="width:11%; text-align: center;">Chức năng</th>
	                        </tr>
	                    </thead>
	                    <tbody>
	                    	<%
	                    		for (Hoa hoa : listHoa){

	                    	%>
	                        <tr>
	                            <td class="align-center"><%=hoa.getId() %></td>
	                            <td><a href="#"><%=hoa.getName() %></a></td>
	                            <td><%=hoa.getDescription() %></td>
	                            <td align="center"><img src="<%=request.getContextPath() %>/images/hoa/<%=hoa.getPicture() %>" class="hoa" /></td>
	                            <td align="right"><%=hoa.getPrice() %></td>
	                            <td align="center">
	                                <a href="<%=request.getContextPath()%>/update?id=<%=hoa.getId()%>">Sửa <img src="<%=request.getContextPath() %>/images/pencil.gif" alt="edit" /></a>
	                                <a href="<%=request.getContextPath()%>/delete?id=<%=hoa.getId()%>">Xóa <img src="<%=request.getContextPath() %>/images/bin.gif" width="16" height="16" alt="delete" /></a>
	                            </td>
	                        </tr>
              				<%
	                    		}
              				%>
	                    </tbody>
	                </table>
	               <%
	                    	}
	                    }
	               %>
                </form>
             </div>
        </div>
	</div>
	<div style="clear:both;"></div>
<%@ include file="/inc/footer.jsp"%>