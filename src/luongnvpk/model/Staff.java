package luongnvpk.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import luongnvpk.model.Enum.EService;

@Entity
@Table(name = EService.staff)
public class Staff extends BaseModel{
	@Column(name = "name")
	String name;
	@Column(name = "cmnd")
	String CMND; 
	@Column(name = "phone")
	String phone;
	@Column(name = "email")
	String email; 
	@Column(name = "birth_at")
	Date birthAt; 
	@Column(name = "gender")
	String gender;
	@Column(name = "address")
	String address;
	@Column(name = "image")
	String image;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCMND() {
		return CMND;
	}
	public void setCMND(String cMND) {
		CMND = cMND;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String numberPhone) {
		this.phone = numberPhone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirthAt() {
		return birthAt;
	}
	public void setBirthAt(Date birthAt) {
		this.birthAt = birthAt;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String sex) {
		this.gender = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
}
