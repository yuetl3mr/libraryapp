package persistence;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {

	@Id
	@Column(name = "bookId")
	private Integer bookId;
	
	@Column(name = "categoryId")
	private Integer categoryId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "author")
	private String author;
	
	@Column(name = "publication")
	private LocalDate publication;
	
	@Column(name = "status")
	private boolean status;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(Integer bookId, Integer categoryId, String name, String author, LocalDate publication, boolean status) {
		super();
		this.bookId = bookId;
		this.categoryId = categoryId;
		this.name = name;
		this.author = author;
		this.publication = publication;
		this.status = status;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public LocalDate getPublication() {
		return publication;
	}

	public void setPublication(LocalDate publication) {
		this.publication = publication;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", categoryId=" + categoryId + ", name=" + name + ", author=" + author
				+ ", publication=" + publication + ", status=" + status + "]";
	}
	
	
}
