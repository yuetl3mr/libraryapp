/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dao.template.AbstractHibernateDao;
import dto.BookDto;
import java.util.List;
import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;

/**
 *
 * @author 84775
 */
public class HibernateBookDtoDao extends AbstractHibernateDao implements BookDtoDao{
    private static final String getAll = "SELECT book.categoryId AS categoryId,\n" +
                                         "	   category.name AS `name`,\n" +
                                         "	   COUNT(*) AS count\n" +
                                         "FROM book\n" +
                                         "JOIN category\n" +
                                         "ON category.categoryId = book.categoryId\n" +
                                         "GROUP BY categoryId";

    public List<BookDto> getAll() {
        return (List<BookDto>)openSession().createNativeQuery(getAll)
                .addScalar("categoryId",IntegerType.INSTANCE )
                .addScalar("name", StringType.INSTANCE)
                .addScalar("count",IntegerType.INSTANCE )
                .setResultTransformer(Transformers.aliasToBean(BookDto.class)).getResultList();
    }
    
    
}
