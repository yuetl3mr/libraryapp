package persistence;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reader")
public class Reader {
	
	@Id
	@Column(name = "UserID")
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "UserID", referencedColumnName = "UserID")
	private User user;
	
	@Column(name = "Sub")
	private LocalDateTime Sub;
	
	public Reader() {
		// TODO Auto-generated constructor stub
	}

	public Reader(User userID, LocalDateTime sub) {
		super();
		user = userID;
		Sub = sub;
	}

	public User getUserID() {
		return user;
	}

	public void setUserID(User userID) {
		user = userID;
	}

	public LocalDateTime getSub() {
		return Sub;
	}

	public void setSub(LocalDateTime sub) {
		Sub = sub;
	}

	@Override
	public String toString() {
		return "Reader [UserID=" + user + ", Sub=" + Sub + "]";
	}
	
	
}
