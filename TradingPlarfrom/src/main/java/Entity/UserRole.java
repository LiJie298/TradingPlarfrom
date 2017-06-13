package Entity;

import java.util.HashSet;
import java.util.Set;

/**
 * UserRole entity. @author MyEclipse Persistence Tools
 */

public class UserRole implements java.io.Serializable {

	// Fields

	private Integer roleCode;
	private String roleName;
	private Set userMains = new HashSet(0);

	// Constructors

	/** default constructor */
	public UserRole() {
	}

	/** minimal constructor */
	public UserRole(Integer roleCode, String roleName) {
		this.roleCode = roleCode;
		this.roleName = roleName;
	}

	/** full constructor */
	public UserRole(Integer roleCode, String roleName, Set userMains) {
		this.roleCode = roleCode;
		this.roleName = roleName;
		this.userMains = userMains;
	}

	// Property accessors

	public Integer getRoleCode() {
		return this.roleCode;
	}

	public void setRoleCode(Integer roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Set getUserMains() {
		return this.userMains;
	}

	public void setUserMains(Set userMains) {
		this.userMains = userMains;
	}

}