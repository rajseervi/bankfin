package com.app.model;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection; 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "usertab")
public class User {

	@Id
	@GeneratedValue(generator = "mygen")
	@GenericGenerator(name = "mygen", strategy = "increment") // legecy generator
	@Column(name = "uid")
	private Integer userId;
	@Column(name = "uname")
	private String userFullName;
	@Column(name = "upwd")
	private String userPwd;
	@Column(name = "ugen")
	private String userGen;
	@Column(name = "uemail")
	private String userEmail;

	@ElementCollection
	@CollectionTable(name = "usr_roles_tab", joinColumns = @JoinColumn(name = "uid"))
	@Column(name="roles")
	private Set<String> userRole;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserFullName() {
		return userFullName;
	}

	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserGen() {
		return userGen;
	}

	public void setUserGen(String userGen) {
		this.userGen = userGen;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public User(Integer userId) {
		super();
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userFullName=" + userFullName + ", userPwd=" + userPwd + ", userGen="
				+ userGen + ", userEmail=" + userEmail + ", userRole=" + userRole + "]";
	}

	public Set<String> getUserRole() {
		return userRole;
	}

	public void setUserRole(Set<String> userRole) {
		this.userRole = userRole;
	}

	 
}
