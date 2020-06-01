package com.cdr.book.service;

import com.cdr.book.pojo.Book;
import com.cdr.book.pojo.PageVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookService {
    PageVo findAllBooks(int curPage, int pageSize);

    int addBook(Book book);

    int deleteBook(int id);

    int updateBook(Book book);

    Book findBookById(int id);

    List<Book> query(@Param("id") int id, @Param("bookName") String bookName);
}
