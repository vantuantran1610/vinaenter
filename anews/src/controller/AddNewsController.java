package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.News;
import model.dao.NewsDAO;

public class AddNewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddNewsController() {
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
		int result = newsDAO.add(new News("Đưa xe đạp công cộng vào tour du lịch TP HCM",
				"Ngành du lịch TP HCM sẽ đưa xe đạp công cộng vào các tour, tuyến để quảng bá mô hình du lịch xanh, phù hợp với xu hướng.",
				"Mô hình xe đạp công cộng vừa triển khai tại TP HCM đang được ngành du lịch thành phố đánh giá có tiềm năng phát triển.",
				1));
		if (result > 0) {
			out.print("Them du lieu thanh cong");
		} else {
			out.print("Them du lieu that bai");
		}
	}

}
