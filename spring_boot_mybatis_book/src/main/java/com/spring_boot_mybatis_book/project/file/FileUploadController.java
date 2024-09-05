package com.spring_boot_mybatis_book.project.file;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {
  @RequestMapping("/fileUploadForm")
  public String ViewUploadForm() {
    return "upload/fileUploadForm";
  }
  
  // (1) 1개 파일 업로드
  @RequestMapping("/fileUpload")
  public String fileUpload(@RequestParam("uploadFile") MultipartFile file,
                            Model model) throws IOException {
    // 1. 파일 저장 경로 설정
    // 맨 마지막에 '/' 있어야 함
    // String uploadPath = "C:/springWorkspace/upload/";
    String uploadPath = "/usr/local/project/upload/";
    
    // 2. 원본 파일 이름 저장
    String originalFileName = file.getOriginalFilename();
    
    // 3. 파일 이름 중복되지 않도록 파일 이름 변경
    // 서버에 저장할 파일 이름 설정: UUID 사용
    UUID uuid = UUID.randomUUID();
    String savedFileName = uuid.toString() + "_" + originalFileName;
    
    // 4. 파일(객체) 생성
    File sendFile = new File(uploadPath + savedFileName);
    
    // 5. 서버로 전송
    file.transferTo(sendFile);
    
    // 웹 브라우저에 원본 파일명 출력: Model로 설정
    model.addAttribute("originalFileName", originalFileName);
    
    return "upload/fileUploadResultView";
  }
}













