package persistence;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "borrow")
public class Borrow {

	@Id
	@Column(name = "loanId")
	private Integer loanId;
	
	@Column(name = "userId")
	private Integer userId;
	
	@Column(name = "bookId")
	private Integer bookId;
	
	@Column(name = "staffId")
	private Integer staffId;
	
	@Column(name = "releaseTime")
	private LocalDateTime releaseTime;
	
	@Column(name = "dueTime")
	private LocalDateTime dueTime;
	
	public Borrow() {
		// TODO Auto-generated constructor stub
	}

	public Borrow(Integer loanId, Integer userId, Integer bookId, Integer staffId, LocalDateTime releaseTime,
			LocalDateTime dueTime) {
		super();
		this.loanId = loanId;
		this.userId = userId;
		this.bookId = bookId;
		this.staffId = staffId;
		this.releaseTime = releaseTime;
		this.dueTime = dueTime;
	}

	public Integer getLoanId() {
		return loanId;
	}

	public void setLoanId(Integer loanId) {
		this.loanId = loanId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public Integer getStaffId() {
		return staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	public LocalDateTime getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(LocalDateTime releaseTime) {
		this.releaseTime = releaseTime;
	}

	public LocalDateTime getDueTime() {
		return dueTime;
	}

	public void setDueTime(LocalDateTime dueTime) {
		this.dueTime = dueTime;
	}

	@Override
	public String toString() {
		return "Borrow [loanId=" + loanId + ", userId=" + userId + ", bookId=" + bookId + ", staffId=" + staffId
				+ ", releaseTime=" + releaseTime + ", dueTime=" + dueTime + "]";
	}
	
	
}
