package model.bean;

import java.sql.Timestamp;

public class News {
	private int id;
	private String name;
	private String description;
	private String detail;
	private Timestamp dateCteate;
	private int catId;

	public News() {
		super();
	}

	public News(int id, String name, String description, String detail, Timestamp dateCteate,
			int catId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.detail = detail;
		this.dateCteate = dateCteate;
		this.catId = catId;
	}
	
	

	public News(String name, String description, String detail, int catId) {
		super();
		this.name = name;
		this.description = description;
		this.detail = detail;
		this.catId = catId;
	}
	
	

	public News(int id, String name, String description, String detail, int catId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.detail = detail;
		this.catId = catId;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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


	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

}