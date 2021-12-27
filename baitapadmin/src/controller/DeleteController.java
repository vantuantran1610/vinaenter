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

public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		HoaDAO hoaDAO = new HoaDAO();
		if(hoaDAO.delete(id) > 0) {
			response.sendRedirect(request.getContextPath() + "/trang-chu?msg=3");
		}else {
			response.sendRedirect(request.getContextPath() + "/trang-chu?msg=0");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
