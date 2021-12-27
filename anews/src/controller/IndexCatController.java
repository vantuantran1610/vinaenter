package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Category;
import model.bean.News;
import model.dao.CategoryDAO;
import model.dao.NewsDAO;


public class IndexCatController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public IndexCatController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		int catId = Integer.parseInt(request.getParameter("catId"));
		CategoryDAO categoryDAO = new CategoryDAO();
		NewsDAO newsDAO = new NewsDAO();
		ArrayList<Category> listCat = categoryDAO.getAll();
		ArrayList<News> listNews = newsDAO.findByCatId(catId);
		Category objCat = categoryDAO.findById(catId);
		request.setAttribute("listCat", listCat);
		request.setAttribute("listNews", listNews);
		request.setAttribute("objCat", objCat);
		RequestDispatcher rd = request.getRequestDispatcher("/cat.jsp");
		rd.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
