package luongnvpk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import luongnvpk.model.Enum.EService;

@Entity
@Table(name = EService.rolePermission)
public class RolePermission {
	@Column(name = "role_id")
	String roleId ;
	@Column(name = "permission")
	String permission;
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	
	
}
