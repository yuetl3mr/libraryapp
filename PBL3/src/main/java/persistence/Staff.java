package persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "staff")
public class Staff {

	@Id
	@Column(name = "userId")
	private Integer userId;
	
	@Column(name = "dept")
	private String dept;
	
	@Column(name = "salary")
	private Double salary;
	
	public Staff() {
		// TODO Auto-generated constructor stub
	}

	public Staff(Integer userId, String dept, Double salary) {
		super();
		this.userId = userId;
		this.dept = dept;
		this.salary = salary;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Staff [userId=" + userId + ", dept=" + dept + ", salary=" + salary + "]";
	}
	
	
}
