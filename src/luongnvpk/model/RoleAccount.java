package luongnvpk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import luongnvpk.model.Enum.EService;

@Entity
@Table(name = EService.roleAccount)
public class RoleAccount {
	@Column(name = "role_id")
	String roleId ;
	@Column(name = "account_id")
	String accountId;
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	
	
	
}
