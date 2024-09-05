package com.spring_boot_mybatis_book.project.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.spring_boot_mybatis_book.project.model.BookVO;



public interface IBookDAO {
  
  //전체 도서조회: DAO에게 요청 -> DB에서 전체 도서(VO 여러 개(ArrayList)) 찾아서 반환
  public ArrayList<BookVO> listAllBook();
  
  //도서 정보 등록: 1개의 도서 정보를 전달 받아서 DB에 저장.(반환 없음)
  public void insertBook(BookVO vo); 
  
  //도서 정보 수정: 1개의 수정된 도서 정보를 전달 받아서 DB에 해당 상품의 수정된 값 저장.(반환 없음)
  public void updateBook(BookVO vo);
  
  //도서 정보 삭제: 1개의 상품 정보(기본키만 필요)를 전달 받아서 DB에 해당 도서 삭제.(반환 없음)
  public void deleteBook(String bookNo);
  
  //상세 도서 정보 조회: 1개의 도서 정보(기본키만 필요)를 전달 받아서DB에 해당 도서 1개 찾아서 반환.
  public BookVO detailViewBook(String bookNo);
  
  //도서번호 중복 체크
  public String bookNoCheck(String bookNo);
  
  //도서 검색
  public ArrayList<BookVO> bookSearch(HashMap<String, Object> map);
}
