package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.News;
import model.dao.NewsDAO;


public class UpdateNewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public UpdateNewsController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		NewsDAO newsDAO = new NewsDAO();
		int result = newsDAO.update(new News(20, "Đưa xe đạp công cộng vào tour du lịch TP Đà Nẵng", "Mô tả cập nhật", "Chi tiết cập nhật", 2));
		if(result > 0) {
			System.out.println("Cập nhật thành công");
		}else {
			System.out.println("Cập nhật thất bại");
		}
	}
}
