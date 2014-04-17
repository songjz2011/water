package com.tsingsoft.android.entity;

import java.util.List;

/**
 * <pre>
 * 验证用户对象
 * </pre>
 * 
 * @author songjz
 * @time 2013年12月17日
 */
public class UserValidate {

	/** 用户登录名 */
	private String userName;

	/** 用户密码 */
	private String passWord;

	/** 验证是否成功，true：成功（errorMessage为空）；false：失败（errorMessage为失败的错误信息） */
	private boolean isSuccess;

	/** 验证失败的错误信息 */
	private String errorMessage;

	/** 用户所能看到的电网信息 */
	private List<LfCtrlNet> netList;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public List<LfCtrlNet> getNetList() {
		return netList;
	}

	public void setNetList(List<LfCtrlNet> netList) {
		this.netList = netList;
	}

}
