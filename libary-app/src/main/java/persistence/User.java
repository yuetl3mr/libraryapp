package persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	@Id
	@Column(name = "UserID")
	private Integer UserID;
	
	@Column(name = "Name")
	private String Name;
	
	@Column(name = "Address")
	private String Address;
	
	@Column(name = "PhoneNumber")
	private String PhoneNumber;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(Integer userID, String name, String address, String phoneNumber) {
		super();
		UserID = userID;
		Name = name;
		Address = address;
		PhoneNumber = phoneNumber;
	}

	public Integer getUserID() {
		return UserID;
	}

	public void setUserID(Integer userID) {
		UserID = userID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "User [UserID=" + UserID + ", Name=" + Name + ", Address=" + Address + ", PhoneNumber=" + PhoneNumber
				+ "]";
	}
	
	
	
}
