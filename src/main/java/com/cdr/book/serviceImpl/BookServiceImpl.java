package com.cdr.book.serviceImpl;

import com.cdr.book.mapper.BookMapper;
import com.cdr.book.pojo.Book;
import com.cdr.book.pojo.PageVo;
import com.cdr.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;

    @Override
    public PageVo findAllBooks(int curPage, int pageSize) {
        PageVo pageVo = new PageVo();
        List<Book> books = bookMapper.findAllBooks();
        int num = books.size();
        int firstIndex = (curPage - 1) * pageSize;
        int lastIndex = curPage * pageSize;
        if (lastIndex <= num) {
            pageVo.setEntity(books.subList(firstIndex, lastIndex));
            pageVo.setTotal(num);
            return pageVo;
        } else {
            pageVo.setEntity(books.subList(firstIndex, num));
            pageVo.setTotal(num);
            return pageVo;
        }
    }

    @Override
    public int addBook(Book book) {
        return bookMapper.addBook(book);
    }

    @Override
    public int deleteBook(int id) {
        return bookMapper.deleteBook(id);
    }

    @Override
    public int updateBook(Book book) {
        return bookMapper.updateBook(book);
    }

    @Override
    public Book findBookById(int id) {
        return bookMapper.findBookById(id);
    }

    @Override
    public List<Book> query(int id, String bookName) {
        return bookMapper.query(id, bookName);
    }
}
