package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Hoa;
import model.dao.HoaDAO;
import util.FileUtil;

@MultipartConfig
public class AddController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/add.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		HoaDAO hoaDAO = new HoaDAO();
		String name = request.getParameter("tenhoa");
		String description = request.getParameter("mota");
		int price = Integer.parseInt(request.getParameter("giaban"));
		String fileName = FileUtil.upload("hinhanh", request);
		Hoa hoa = new Hoa(name, description, fileName, price);
		if(hoaDAO.add(hoa) > 0) {
			response.sendRedirect(request.getContextPath() + "/trang-chu?msg=1");
			return;
		}
		request.setAttribute("error", "Có lỗi xảy ra, thêm thất bại");
		RequestDispatcher rd = request.getRequestDispatcher("/add.jsp");
		rd.forward(request, response);
	}
}
