package com.zxyy.domain;

/**
 * 当使用多表查询的时候，不仅仅只差一张表的信息，可能有两张表的信息，那么在使用返回值类型的时候就不能只写单张表
 */
public class SysRoleExtend extends SysRole {
	private String userName;
	private String userEmail;

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "SysRoleExtend{" +
				"userName='" + userName + '\'' +
				'}';
	}
}
