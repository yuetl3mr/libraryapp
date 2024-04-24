package persistence;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Reader")
public class Reader {

	@Id
	@Column(name = "userId")
	private Integer userId;
	
	@Column(name = "sub")
	private LocalDateTime sub;
	
	public Reader() {
		// TODO Auto-generated constructor stub
	}

	public Reader(Integer userId, LocalDateTime sub) {
		super();
		this.userId = userId;
		this.sub = sub;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public LocalDateTime getSub() {
		return sub;
	}

	public void setSub(LocalDateTime sub) {
		this.sub = sub;
	}

	@Override
	public String toString() {
		return "Reader [userId=" + userId + ", sub=" + sub + "]";
	}
	
	
}
