/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.time.LocalDate;

/**
 *
 * @author 84775
 */
public class BorrowDto {
    private Integer bookId;
    private String name;
    private String author;
    private String category;
    private LocalDate borrowingTime;
    private LocalDate borrowingPeriod;
    private Integer loanId;

    public BorrowDto() {
    }

    public BorrowDto(Integer bookId, String name, String author, String category, LocalDate borrowingtime, LocalDate borrowingPeriod, Integer loanId) {
        this.bookId = bookId;
        this.name = name;
        this.author = author;
        this.category = category;
        this.borrowingTime = borrowingtime;
        this.borrowingPeriod = borrowingPeriod;
        this.loanId = loanId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setBorrowingtime(LocalDate borrowingtime) {
        this.borrowingTime = borrowingtime;
    }

    public void setBorrowingPeriod(LocalDate borrowingPeriod) {
        this.borrowingPeriod = borrowingPeriod;
    }

    public Integer getBookId() {
        return bookId;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public LocalDate getBorrowingtime() {
        return borrowingTime;
    }

    public LocalDate getBorrowingPeriod() {
        return borrowingPeriod;
    }

    public void setLoanId(Integer loanId) {
        this.loanId = loanId;
    }

    public Integer getLoanId() {
        return loanId;
    }

    @Override
    public String toString() {
        return "BorrowDto{" + "bookId=" + bookId + ", name=" + name + ", author=" + author + ", category=" + category + ", borrowingtime=" + borrowingTime + ", borrowingPeriod=" + borrowingPeriod + '}';
    }
    
    
}
