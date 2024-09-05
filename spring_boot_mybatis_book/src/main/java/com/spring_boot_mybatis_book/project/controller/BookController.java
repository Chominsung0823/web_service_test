package com.spring_boot_mybatis_book.project.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring_boot_mybatis_book.project.model.BookVO;
import com.spring_boot_mybatis_book.project.service.BookService;



@Controller
public class BookController {
  //DI 설정
  @Autowired
  BookService bookService;
  
  @RequestMapping("/")
  public String viewIndex() {
    return "index";
  }
  
  @RequestMapping("/book/listAllBook")
  public String listAllBook(Model model) {
    ArrayList<BookVO> bookList = bookService.listAllBook();
    
    model.addAttribute("bookList", bookList);
    
    return "book/bookListView";
  }
  
  // 도서 등록 폼 열기
  @RequestMapping("/book/newBookForm")
  public String newBookForm() {
    return "book/newBookForm";
  }
  
  // 도서 등록
  @RequestMapping("/book/insertBook")
  public String insertBook(BookVO vo) {
    bookService.insertBook(vo);
    
    return "redirect:/book/listAllBook";
  }
  
  //상품 상세 정보 조회
  @RequestMapping("/book/detailViewBook/{bookNo}")
  public String detailViewBook(@PathVariable String bookNo, Model model) {
    // 서비스에게 상품번호 전달하고, 해당 상품 데이터 받아오기
    BookVO book = bookService.detailViewBook(bookNo);
    
    // 뷰 페이지에 출력하기 위해 Model 설정
    model.addAttribute("book", book);
    
    return "book/bookDetailView";
  }
  
  // 수정 폼 열기
  @RequestMapping("/book/updateBookForm/{bookNo}")
  public String updateBookForm(@PathVariable String bookNo, Model model) {
    // 서비스에게 상품번호 전달하고, 해당 상품 데이터 받아오기
    BookVO book = bookService.detailViewBook(bookNo);
    
    // 뷰 페이지에 출력하기 위해 Model 설정
    model.addAttribute("book", book);
    
    return "book/updateBookForm";
  }
  
  // 수정된 데이터 받아서 DB에 저장
  @RequestMapping("/book/updateBook")
  public String updateBook(BookVO vo) {
    bookService.updateBook(vo);
    
    return "redirect:/book/listAllBook";
  }
  
  // 도서 정보 삭제
  // 도서번호 전달 받아서 서비스에게 전달 -> dao -> Mapper -> DB에서 삭제
  // 삭제 후 전체 도서 정보 조회 화면으로 이동: 포워딩
  @RequestMapping("/book/deleteBook/{bookNo}")
  public String deleteBook(@PathVariable String bookNo) {
    bookService.deleteBook(bookNo);
     
    return "redirect:/book/listAllBook";
  }
  
  // 중복 확인
  @ResponseBody
  @RequestMapping("/book/bookNoCheck")
  public String bookNoCheck(@RequestParam("bookNo") String bookNo) {
    
    String bookNo_result = bookService.bookNoCheck(bookNo);
    String result = "available";
    if(bookNo_result != null) { // 도서번호가 존재한다면
       result = "not_available";
    }
    
    return result;
  }
  
  //도서 검색 폼 열기
  @RequestMapping("/book/bookSearchForm1") 
  public String bookSearchForm1() {
    
    return "book/bookSearchForm1";
  }
  
  // 상품 검색 방법
  // 검색 조건과 keyword 전달 받아서 서비스에게 전달하고
  // DB에서 검색 결과를 ArrayList를 Model 설정해놓고 뷰 페이지 반환
  @ResponseBody
  @RequestMapping("/book/bookSearch1") 
  public ArrayList<BookVO> bookSearch1(@RequestParam HashMap<String, Object> param) {
    ArrayList<BookVO> bookList = bookService.bookSearch(param);
    
    return bookList;
  }  
  
  //도서 검색 폼 열기
  @RequestMapping("/book/bookSearchForm2") 
  public String bookSearchForm2() {
    
    return "book/bookSearchForm2";
  }
  
  // 상품 검색 방법2
  // 검색 조건과 keyword 전달 받아서 서비스에게 전달하고
  // DB에서 검색 결과를 ArrayList로 받아서 Ajax로 전달
  @RequestMapping("/book/bookSearch2") 
  public String bookSearch2(@RequestParam HashMap<String, Object> param, Model model) {
    ArrayList<BookVO> bookList = bookService.bookSearch(param);
    model.addAttribute("bookList", bookList);
    
    return "book/bookSearchResultView";
  }  
}







