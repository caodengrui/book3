package com.cdr.book.mapper;

import com.cdr.book.pojo.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookMapper {
    @Select("select id, bookName, author, price, pic from books")
    List<Book> findAllBooks();

    @Insert("insert into books(bookName, author, price ,pic) values(#{bookName},#{author},#{price},#{pic})")
    int addBook(Book book);

    @Delete("delete from books where id = #{id}")
    int deleteBook(int id);

    @Update("update books set bookName=#{bookName}, author=#{author}, price=#{price}, pic=#{pic} where id= #{id}")
    int updateBook(Book book);

    @Select("select id, bookName, author, price, pic from books where id = #{id}")
    Book findBookById(int id);

    @Select(value ={" <script>" +
            " SELECT id, bookName, author, price, pic from books " +
            " <where> 1=1 " +
            " <if test=\"id != 0\"> AND id=#{id}</if> " +
            " <if test=\"bookName != null\" >  AND bookName like '%${bookName}%'</if> " +
            " </where>" +
            " </script>"})
    List<Book> query(@Param("id") int id, @Param("bookName") String bookName);
}
