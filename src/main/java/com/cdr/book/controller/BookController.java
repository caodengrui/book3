package com.cdr.book.controller;

import com.cdr.book.pojo.Book;
import com.cdr.book.pojo.PageVo;
import com.cdr.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    /*
     * 显示所有
     * */
    @GetMapping("/findAllBooks/{curPage}/{pageSize}")
    public PageVo findAllBooks(@PathVariable("curPage") int curPage, @PathVariable("pageSize") int pageSize) {
        PageVo pageVo = bookService.findAllBooks(curPage, pageSize);
        return pageVo;
    }
    /*
     * 添加书籍
     * */
    @PostMapping("/addBook")
    public boolean addBook(@RequestBody Book book) {
        if (bookService.addBook(book) != 0) {
            return true;
        } else {
            return false;
        }
    }

    @PostMapping("/deleteBook/{id}")
    public boolean deleteBook(@PathVariable("id") int id){
        if(bookService.deleteBook(id) != 0){
            return true;
        }else {
            return false;
        }
    }

    @PostMapping("/updateBook")
    public boolean updateBook(@RequestBody Book book){
        if(bookService.updateBook(book) != 0){
            return true;
        }else{
            return false;
        }
    }

    @GetMapping("/findBookById/{id}")
    public Book findBookById(@PathVariable("id") int id){
        Book book = bookService.findBookById(id);
        return book;
    }

    @RequestMapping("/query")
    public List<Book> query(@RequestBody Book book){
        int id = book.getId();
        String bookName = book.getBookName();
        return bookService.query(id,bookName);
    }

}
