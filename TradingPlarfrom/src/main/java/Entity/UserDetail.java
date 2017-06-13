package Entity;

import java.util.Date;

/**
 * UserDetail entity. @author MyEclipse Persistence Tools
 */

public class UserDetail implements java.io.Serializable {

	// Fields

	private String userNo;
	private UserMain userMain;
	private String userAlis;
	private String userUnit;
	private Float userBalance;
	private String userHobbies;
	private String userTel;
	private String userQqno;
	private Date userBirth;
	private String userEmail;

	// Constructors

	/** default constructor */
	public UserDetail() {
	}

	/** minimal constructor */
	public UserDetail(String userNo, UserMain userMain) {
		this.userNo = userNo;
		this.userMain = userMain;
	}

	/** full constructor */
	public UserDetail(String userNo, UserMain userMain, String userAlis, String userUnit, Float userBalance,
			String userHobbies, String userTel, String userQqno, Date userBirth, String userEmail) {
		this.userNo = userNo;
		this.userMain = userMain;
		this.userAlis = userAlis;
		this.userUnit = userUnit;
		this.userBalance = userBalance;
		this.userHobbies = userHobbies;
		this.userTel = userTel;
		this.userQqno = userQqno;
		this.userBirth = userBirth;
		this.userEmail = userEmail;
	}

	// Property accessors

	public String getUserNo() {
		return this.userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public UserMain getUserMain() {
		return this.userMain;
	}

	public void setUserMain(UserMain userMain) {
		this.userMain = userMain;
	}

	public String getUserAlis() {
		return this.userAlis;
	}

	public void setUserAlis(String userAlis) {
		this.userAlis = userAlis;
	}

	public String getUserUnit() {
		return this.userUnit;
	}

	public void setUserUnit(String userUnit) {
		this.userUnit = userUnit;
	}

	public Float getUserBalance() {
		return this.userBalance;
	}

	public void setUserBalance(Float userBalance) {
		this.userBalance = userBalance;
	}

	public String getUserHobbies() {
		return this.userHobbies;
	}

	public void setUserHobbies(String userHobbies) {
		this.userHobbies = userHobbies;
	}

	public String getUserTel() {
		return this.userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public String getUserQqno() {
		return this.userQqno;
	}

	public void setUserQqno(String userQqno) {
		this.userQqno = userQqno;
	}

	public Date getUserBirth() {
		return this.userBirth;
	}

	public void setUserBirth(Date userBirth) {
		this.userBirth = userBirth;
	}

	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

}