package Entity;

import java.util.Date;

/**
 * UserMain entity. @author MyEclipse Persistence Tools
 */

public class UserMain implements java.io.Serializable {

	// Fields

	private String userNo;
	private UserRole userRole;
	private String userName;
	private String userPwd;
	private Date userDate;
	private UserDetail userDetail;

	// Constructors

	/** default constructor */
	public UserMain() {
	}

	/** minimal constructor */
	public UserMain(String userNo, String userName, String userPwd, Date userDate) {
		this.userNo = userNo;
		this.userName = userName;
		this.userPwd = userPwd;
		this.userDate = userDate;
	}

	/** full constructor */
	public UserMain(String userNo, UserRole userRole, String userName, String userPwd, Date userDate,
			UserDetail userDetail) {
		this.userNo = userNo;
		this.userRole = userRole;
		this.userName = userName;
		this.userPwd = userPwd;
		this.userDate = userDate;
		this.userDetail = userDetail;
	}

	// Property accessors

	public String getUserNo() {
		return this.userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public UserRole getUserRole() {
		return this.userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return this.userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public Date getUserDate() {
		return this.userDate;
	}

	public void setUserDate(Date userDate) {
		this.userDate = userDate;
	}

	public UserDetail getUserDetail() {
		return this.userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

}