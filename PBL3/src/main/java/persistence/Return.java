package persistence;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "return")
public class Return {

	@Id
	@Column(name = "loanId")
	private Integer loanId;
	
	@Column(name = "userId")
	private Integer userId;
	
	@Column(name = "bookId")
	private Integer bookId;
	
	@Column(name = "staffId")
	private Integer staffId;
	
	@Column(name = "returnTime")
	private LocalDateTime returnTime;
	
	public Return() {
		// TODO Auto-generated constructor stub
	}

	public Return(Integer loanId, Integer userId, Integer bookId, Integer staffId, LocalDateTime returnTime) {
		super();
		this.loanId = loanId;
		this.userId = userId;
		this.bookId = bookId;
		this.staffId = staffId;
		this.returnTime = returnTime;
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

	public LocalDateTime getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(LocalDateTime returnTime) {
		this.returnTime = returnTime;
	}

	@Override
	public String toString() {
		return "Return [loanId=" + loanId + ", userId=" + userId + ", bookId=" + bookId + ", staffId=" + staffId
				+ ", returnTime=" + returnTime + "]";
	}
	
	
	
}
