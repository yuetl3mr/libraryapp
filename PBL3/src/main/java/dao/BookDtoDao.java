/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import dto.BookDto;

/**
 *
 * @author 84775
 */
public interface BookDtoDao {
    List<BookDto> getAll();
    
    List<BookDto> getAllBorrow();
}
