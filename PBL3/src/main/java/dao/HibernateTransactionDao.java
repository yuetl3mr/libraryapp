/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dao.template.AbstractHibernateDao;
import dto.Transaction;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.hibernate.type.LocalDateTimeType;

/**
 *
 * @author 84775
 */
public class HibernateTransactionDao extends AbstractHibernateDao implements TransactionDao {

    private static final String getAllBorrow = "SELECT loanId,\n"
            + "	   userId,\n"
            + "       bookId,\n"
            + "       releaseTime as transactionTime,\n"
            + "       dueTime\n"
            + "FROM borrow;";
    private static final String getAllReturn = "SELECT loanId,\n"
            + "	   userId,\n"
            + "       bookId,\n"
            + "       returnTime as transactionTime\n"
            + "FROM `return`;";

    public List<Transaction> getAllBorrow() {
        return (List<Transaction>) openSession().createNativeQuery(getAllBorrow)
                .addScalar("loanId", IntegerType.INSTANCE)
                .addScalar("userId", IntegerType.INSTANCE)
                .addScalar("bookId", IntegerType.INSTANCE)
                .addScalar("transactionTime", LocalDateTimeType.INSTANCE)
                .addScalar("dueTime", LocalDateTimeType.INSTANCE)
                .setResultTransformer(Transformers.aliasToBean(Transaction.class)).getResultList();
    }

    public List<Transaction> getAllReturn() {
        return (List<Transaction>) openSession().createNativeQuery(getAllReturn)
                .addScalar("loanId", IntegerType.INSTANCE)
                .addScalar("userId", IntegerType.INSTANCE)
                .addScalar("bookId", IntegerType.INSTANCE)
                .addScalar("transactionTime", LocalDateTimeType.INSTANCE)
                .setResultTransformer(Transformers.aliasToBean(Transaction.class)).getResultList();
    }

    public List<Transaction> getAll() {
        List<Transaction> borrow = getAllBorrow();
        List<Transaction> returnn = getAllReturn();
        List<Transaction> result = new ArrayList<Transaction>();
        for(Transaction transaction : borrow){
            result.add(transaction);
        }
        for(Transaction transaction : returnn){
            result.add(transaction);
        }
        return result;
    }

    public List<Transaction> getLoanId(Integer Id) {
        List<Transaction> transactions = getAll();
        List<Transaction> result = new ArrayList<Transaction>();
        for(Transaction transaction : transactions){
            if(transaction.getLoanId() == Id){
                result.add(transaction);
            }
        }
        return result;
    }
    
    public List<Transaction> getUserId(Integer Id) {
        List<Transaction> transactions = getAll();
        List<Transaction> result = new ArrayList<Transaction>();
        for(Transaction transaction : transactions){
            if(transaction.getUserId() == Id){
                result.add(transaction);
            }
        }
        return result;
    }
    
    public List<Transaction> getBookId(Integer Id) {
        List<Transaction> transactions = getAll();
        List<Transaction> result = new ArrayList<Transaction>();
        for(Transaction transaction : transactions){
            if(transaction.getBookId()== Id){
                result.add(transaction);
            }
        }
        return result;
    }

}
