/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import dto.Transaction;

/**
 *
 * @author 84775
 */
public interface TransactionDao {
    
    public List<Transaction> getAllBorrow();
    public List<Transaction> getAllReturn();
    public List<Transaction> getAll();
    public List<Transaction> getLoanId(Integer Id);
    public List<Transaction> getUserId(Integer Id);
    public List<Transaction> getBookId(Integer Id);
}
