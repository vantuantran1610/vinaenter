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


public class IndexPublicController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public IndexPublicController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		FriendsListDAO friendsListDAO = new FriendsListDAO();
		FriendsDAO friendsDAO = new FriendsDAO();
		
		ArrayList<FriendsList> listFriends = friendsListDAO.getAll();
		ArrayList<Friends> listFriend = friendsDAO.getAll();
		request.setAttribute("listFriends", listFriends);
		request.setAttribute("listFriend", listFriend);
		RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
