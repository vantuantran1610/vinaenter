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

public class DetailIndexController extends HttpServlet {
	private FriendsDAO friendsDAO = new FriendsDAO();
	private FriendsListDAO friendsListDAO = new FriendsListDAO();
	private static final long serialVersionUID = 1L;

	public DetailIndexController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));

		Friends friend = friendsDAO.findById(id);
		ArrayList<Friends> objFriend = friendsDAO.findByCatId(friend.getListId());
		ArrayList<FriendsList> listFriends =friendsListDAO.getAll();
		FriendsList findNameByFLId = friendsListDAO.findById(friend.getListId());
		
		request.setAttribute("findNameByFLId",findNameByFLId);
		request.setAttribute("listFriends", listFriends);
		request.setAttribute("objFriend", objFriend);
		request.setAttribute("friend", friend);
		RequestDispatcher rd = request.getRequestDispatcher("/chi-tiet.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
