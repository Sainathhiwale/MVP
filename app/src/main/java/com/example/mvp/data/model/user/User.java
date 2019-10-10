package com.example.mvp.data.model.user;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class User{

	@SerializedName("UserName")
	private String userName;

	@SerializedName("ID")
	private int iD;

	@SerializedName("Password")
	private String password;

	private List<UserDto> userDtoList;

	public int getiD() {
		return iD;
	}

	public void setiD(int iD) {
		this.iD = iD;
	}

	public List<UserDto> getUserDtoList() {
		return userDtoList;
	}

	public void setUserDtoList(List<UserDto> userDtoList) {
		this.userDtoList = userDtoList;
	}

	public User(String userName, String password, int iD) {
		this.userName = userName;
		this.iD = iD;
		this.password = password;
	}

	public void setUserName(String userName){
		this.userName = userName;
	}

	public String getUserName(){
		return userName;
	}

	public void setID(int iD){
		this.iD = iD;
	}

	public int getID(){
		return iD;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	@Override
 	public String toString(){
		return 
			"User{" + 
			"userName = '" + userName + '\'' + 
			",iD = '" + iD + '\'' + 
			",password = '" + password + '\'' + 
			"}";
		}



}