package com.baizhi.entity;


import java.io.Serializable;

/**
 * 用户实体类
 */
public class User implements Serializable{
	/**
	 * 基本属性
	 */
	private String uid;
	private String farmington;//法名
	private String nikename;//昵称
	private String gender;//性别
	private String photo;//
	private String location;//所在地
	private String description;//签名
	private Integer phone;
	private String password;
	private String salt;




	/*@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JSONField(format ="yyyy-MM-dd",name="birthday")
	private Date birthday;*/

	public User() {
	}

	public User(String uid, String farmington, String nikename, String gender, String photo, String location, String description, Integer phone, String password, String salt) {
		this.uid = uid;
		this.farmington = farmington;
		this.nikename = nikename;
		this.gender = gender;
		this.photo = photo;
		this.location = location;
		this.description = description;
		this.phone = phone;
		this.password = password;
		this.salt = salt;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getFarmington() {
		return farmington;
	}

	public void setFarmington(String farmington) {
		this.farmington = farmington;
	}

	public String getNikename() {
		return nikename;
	}

	public void setNikename(String nikename) {
		this.nikename = nikename;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}
}
