package persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "managersystem")
public class ManagerSystem {

	@Id
	@Column(name = "userid")
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "userid", referencedColumnName = "userid")
	private User user;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	public ManagerSystem() {
		// TODO Auto-generated constructor stub
	}

	public ManagerSystem(User user, String username, String password) {
		super();
		this.user = user;
		this.username = username;
		this.password = password;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "ManagerSystem [user=" + user + ", username=" + username + ", password=" + password + "]";
	}
	
	
}
