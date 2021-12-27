package model.bean;

import java.sql.Timestamp;

public class Friends {
	private int id;
	private String name;
	private String preview_text;
	private String detail;
	private Timestamp dateCteate;
	private int listId;
	private int count_number;
	private String picture;
	
	public Friends() {
		super();
	}

	public Friends(int id, String name, String preview_text, String detail, Timestamp dateCteate, int listId,
			int count_number, String picture) {
		super();
		this.id = id;
		this.name = name;
		this.preview_text = preview_text;
		this.detail = detail;
		this.dateCteate = dateCteate;
		this.listId = listId;
		this.count_number = count_number;
		this.picture = picture;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPreview_text() {
		return preview_text;
	}

	public void setPreview_text(String preview_text) {
		this.preview_text = preview_text;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Timestamp getDateCteate() {
		return dateCteate;
	}

	public void setDateCteate(Timestamp dateCteate) {
		this.dateCteate = dateCteate;
	}

	public int getListId() {
		return listId;
	}

	public void setListId(int listId) {
		this.listId = listId;
	}

	public int getCount_number() {
		return count_number;
	}

	public void setCount_number(int count_number) {
		this.count_number = count_number;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	
	
}
