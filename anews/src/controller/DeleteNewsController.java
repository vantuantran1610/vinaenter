package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CategoryDAO;
import model.dao.NewsDAO;

public class DeleteNewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteNewsController() {
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
		PrintWriter out = response.getWriter();
		NewsDAO newsDAO = new NewsDAO();
		int result = newsDAO.delete(12);
		if(result > 0) {
			out.print("Xóa tin tức thành công");
		}else {
			out.print("Xóa tin tức thất bại");
		}
	}
}
