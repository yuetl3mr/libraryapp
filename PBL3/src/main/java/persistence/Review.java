package persistence;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "review")
public class Review {

	@Id
	@Column(name = "reviewId")
	private Integer reviewId;
	
	@Column(name = "bookId")
	private Integer bookId;
	
	@Column(name = "userId")
	private Integer userId;
	// reader : userId
	
	@Column(name = "star")
	private Integer star;
	
	@Column(name = "reviewTime")
	private LocalDateTime reviewTime;
	
	@Column(name = "content")
	private String content;
	
	public Review() {
		// TODO Auto-generated constructor stub
	}

	public Review(Integer reviewId, Integer bookId, Integer userId, Integer star, LocalDateTime reviewTime,
			String content) {
		super();
		this.reviewId = reviewId;
		this.bookId = bookId;
		this.userId = userId;
		this.star = star;
		this.reviewTime = reviewTime;
		this.content = content;
	}

	public Integer getReviewId() {
		return reviewId;
	}

	public void setReviewId(Integer reviewId) {
		this.reviewId = reviewId;
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

	public Integer getStar() {
		return star;
	}

	public void setStar(Integer star) {
		this.star = star;
	}

	public LocalDateTime getReviewTime() {
		return reviewTime;
	}

	public void setReviewTime(LocalDateTime reviewTime) {
		this.reviewTime = reviewTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", bookId=" + bookId + ", userId=" + userId + ", star=" + star
				+ ", reviewTime=" + reviewTime + ", content=" + content + "]";
	}
	
	
}
