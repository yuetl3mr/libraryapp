package aaa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class user {
	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "taikhoan")
	private String taikhoan;
	
	@Column(name = "matkhau")
	private String matkhau;
	
	@Column(name = "tennguoidung")
	private String tennguoidung;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "diachi")
	private String diachi;
	
	public user() {
		// TODO Auto-generated constructor stub
	}

	public user(Integer id, String taikhoan, String matkhau, String tennguoidung, String email, String diachi) {
		super();
		this.id = id;
		this.taikhoan = taikhoan;
		this.matkhau = matkhau;
		this.tennguoidung = tennguoidung;
		this.email = email;
		this.diachi = diachi;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTaikhoan() {
		return taikhoan;
	}

	public void setTaikhoan(String taikhoan) {
		this.taikhoan = taikhoan;
	}

	public String getMatkhau() {
		return matkhau;
	}

	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}

	public String getTennguoidung() {
		return tennguoidung;
	}

	public void setTennguoidung(String tennguoidung) {
		this.tennguoidung = tennguoidung;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	@Override
	public String toString() {
		return "user [id=" + id + ", taikhoan=" + taikhoan + ", matkhau=" + matkhau + ", tennguoidung=" + tennguoidung
				+ ", email=" + email + ", diachi=" + diachi + "]";
	}

	
	
	
}
