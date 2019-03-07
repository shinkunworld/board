package model;

import java.io.Serializable;

public class User implements Serializable {
	//1.java beans

	private String name; //유저이름
	private String pass; // 패스워드

	public User() {

	}

	public User(String name, String pass) {
		this.name = name;
		this.pass = pass;

	}
//왜 get만 셋팅 하는지 아직 이해가 안됨.
	public String getName() {
		return name;
	}

	public String getPass() {
		return pass;
	}

}