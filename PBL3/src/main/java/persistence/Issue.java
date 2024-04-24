package persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "issue")
public class Issue {

	@Id
	@Column(name = "issueId")
	private Integer issueId;
	
	@Column(name = "bookId")
	private Integer bookId;
	
	@Column(name = "userId")
	private Integer userId;
	
	@Column(name = "issueStatus")
	private Integer issueStatus;
	
	@Column(name = "note")
	private String note;
	
	public Issue() {
		// TODO Auto-generated constructor stub
	}

	public Issue(Integer issueId, Integer bookId, Integer userId, Integer issueStatus, String note) {
		super();
		this.issueId = issueId;
		this.bookId = bookId;
		this.userId = userId;
		this.issueStatus = issueStatus;
		this.note = note;
	}

	public Integer getIssueId() {
		return issueId;
	}

	public void setIssueId(Integer issueId) {
		this.issueId = issueId;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getIssueStatus() {
		return issueStatus;
	}

	public void setIssueStatus(Integer issueStatus) {
		this.issueStatus = issueStatus;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "Issue [issueId=" + issueId + ", bookId=" + bookId + ", userId=" + userId + ", issueStatus="
				+ issueStatus + ", note=" + note + "]";
	}
	
	
}
