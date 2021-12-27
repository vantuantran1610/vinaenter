package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Category;
import model.dao.CategoryDAO;


public class AddCatController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public AddCatController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		CategoryDAO categoryDAO = new CategoryDAO();
		int result = categoryDAO.add(new Category(1, "Tin quoc te"));
		if(result > 0){
			out.print("Them du lieu thanh cong");
		}else {
			out.print("Them du lieu that bai");
		}
	}
}
