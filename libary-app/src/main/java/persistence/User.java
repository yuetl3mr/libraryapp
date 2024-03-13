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
}
