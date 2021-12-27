package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Friends;
import model.bean.FriendsList;
import model.dao.FriendsDAO;
import model.dao.FriendsListDAO;


public class IndexCatPublicController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public IndexCatPublicController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		int listId = Integer.parseInt(request.getParameter("listId"));
		FriendsListDAO friendsListDAO = new FriendsListDAO();
		FriendsDAO friendsDAO = new FriendsDAO();
		ArrayList<FriendsList> listFriends = friendsListDAO.getAll();
		ArrayList<Friends> listFriend = friendsDAO.findByCatId(listId);
		FriendsList objList = friendsListDAO.findById(listId);
		
		request.setAttribute("listFriends", listFriends);
		request.setAttribute("listFriend", listFriend);
		request.setAttribute("objList", objList);
		RequestDispatcher rd = request.getRequestDispatcher("/danh-muc.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
