/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.time.LocalDateTime;

/**
 *
 * @author 84775
 */
public class Transaction {
    
    private Integer loanId;
    private Integer userId;
    private Integer bookId;
    private LocalDateTime transactionTime;
    private LocalDateTime dueTime;

    public Transaction() {
    }

    public Transaction(Integer loanId, Integer userId, Integer bookId, LocalDateTime transactionTime, LocalDateTime dueTime) {
        this.loanId = loanId;
        this.userId = userId;
        this.bookId = bookId;
        this.transactionTime = transactionTime;
        this.dueTime = dueTime;
    }

    public void setLoanId(Integer loanId) {
        this.loanId = loanId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public void setTransactionTime(LocalDateTime transactionTime) {
        this.transactionTime = transactionTime;
    }

    public void setDueTime(LocalDateTime dueTime) {
        this.dueTime = dueTime;
    }

    public Integer getLoanId() {
        return loanId;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public LocalDateTime getTransactionTime() {
        return transactionTime;
    }

    public LocalDateTime getDueTime() {
        return dueTime;
    }

    @Override
    public String toString() {
        return "Transaction{" + "loanId=" + loanId + ", userId=" + userId + ", bookId=" + bookId + ", transactionTime=" + transactionTime + ", dueTime=" + dueTime + '}';
    }
    
    
}
