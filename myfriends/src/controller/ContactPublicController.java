package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Contact;
import model.dao.ContactDAO;

@MultipartConfig
public class ContactPublicController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ContactPublicController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/lien-he.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		ContactDAO contactDAO = new ContactDAO();
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		int phone = Integer.parseInt(request.getParameter("phone"));
		String content = request.getParameter("content");
		Contact contact = new Contact(name, email, phone, content);
		if (contactDAO.add(contact) > 0) {
			response.sendRedirect(request.getContextPath() + "/lien-he?msg=1");
			return;
		}
		request.setAttribute("error", "Có lỗi xảy ra, thêm thất bại");
		RequestDispatcher rd = request.getRequestDispatcher("/lien-he.jsp");
		rd.forward(request, response);
	}
}
