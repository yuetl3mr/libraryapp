package persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "loan")
public class Loan {
	
	@Id
	@Column(name = "loanId")
	private Integer loanId;
	
	@Column(name = "note")
	private String note;
	
	@Column(name = "status")
	private Boolean status;
	
	public Loan() {
		// TODO Auto-generated constructor stub
	}

	public Loan(Integer loanId, String note, Boolean status) {
		super();
		this.loanId = loanId;
		this.note = note;
		this.status = status;
	}

	public Integer getLoanId() {
		return loanId;
	}

	public void setLoanId(Integer loanId) {
		this.loanId = loanId;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Loan [loanId=" + loanId + ", note=" + note + ", status=" + status + "]";
	}
	
	
}
