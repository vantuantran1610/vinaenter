package model.bean;

public class FriendsList {
	private int listId;
	private String listName;
	public FriendsList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FriendsList(int listId, String listName) {
		super();
		this.listId = listId;
		this.listName = listName;
	}
	public int getListId() {
		return listId;
	}
	public void setListId(int listId) {
		this.listId = listId;
	}
	public String getListName() {
		return listName;
	}
	public void setListName(String listName) {
		this.listName = listName;
	}
	
	
}
