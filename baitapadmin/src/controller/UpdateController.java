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
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		HoaDAO hoaDAO = new HoaDAO();
		Hoa hoa = hoaDAO.findById(id);
		request.setAttribute("hoa", hoa);
		RequestDispatcher rd = request.getRequestDispatcher("/update.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HoaDAO hoaDAO = new HoaDAO();
		int id = Integer.parseInt(request.getParameter("id"));
		Hoa hoa = hoaDAO.findById(id);
		String name = request.getParameter("tenhoa");
		String description = request.getParameter("mota");
		int price = Integer.parseInt(request.getParameter("giaban"));
		String fileName = FileUtil.upload("hinhanh", request);
		Hoa hoaUpdate = new Hoa(id, name, description, fileName, price);
		if(fileName.equals("")) {
			hoaUpdate.setPicture(hoa.getPicture());
		}
		if(hoaDAO.update(hoaUpdate) > 0) {
			if(!fileName.equals("")) {
				FileUtil.delFile(hoa.getPicture(), request);
			}
			response.sendRedirect(request.getContextPath() + "/trang-chu?msg=2");
			return;
		}
		request.setAttribute("error", "Có lỗi xảy ra, cập nhật thất bại");
		RequestDispatcher rd = request.getRequestDispatcher("/update.jsp");
		rd.forward(request, response);
	}
}
