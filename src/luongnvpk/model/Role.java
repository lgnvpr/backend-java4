package luongnvpk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import luongnvpk.model.Enum.EService;

@Entity
@Table(name = EService.role)
public class Role extends BaseModel{
	@Column(name = "name")
	String name;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
