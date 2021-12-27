package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CategoryDAO;

public class DeleteCatController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteCatController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		CategoryDAO categoryDAO = new CategoryDAO();
		int result = categoryDAO.delete(11);
		if(result > 0) {
			System.out.println("Xóa thành công");
		}else {
			System.out.println("Xóa thất bại");
		}
	}
}
