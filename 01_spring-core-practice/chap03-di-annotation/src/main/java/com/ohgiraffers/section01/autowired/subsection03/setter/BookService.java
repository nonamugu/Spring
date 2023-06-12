package com.ohgiraffers.section01.autowired.subsection03.setter;

import com.ohgiraffers.section01.autowired.common.BookDAO;
import com.ohgiraffers.section01.autowired.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/* @Service : @Component의 세분화 어노테이션의 한 종류로 Service 계층에서 사용한다. */
@Service("bookServiceSetter")
public class BookService {

    private BookDAO bookDAO;

    @Autowired
    public void setBookDAO(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    /* 도서 목록 전체 조회 */
    public List<BookDTO> selectAllBooks(){
        return bookDAO.selectBookList();
    }

    /* 도서 번호로 도서 조회 */
    public BookDTO searchBookBySequence(int sequence) {
        return bookDAO.selectOneBook(sequence);
    }
}