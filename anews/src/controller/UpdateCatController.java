package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Category;
import model.dao.CategoryDAO;

public class UpdateCatController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateCatController() {
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
		int result = categoryDAO.update(new Category(12, "Tin về Lập Trình"));
		if (result > 0) {
			System.out.println("Cập nhật thành công");
		} else {
			System.out.println("Cập nhật thất bại");
		}
	}
}
