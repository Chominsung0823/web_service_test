package com.spring_boot_mybatis_book.project;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/book_images/**")
    // .addResourceLocations("file:///C:/springWorkspace/book_images/");
    .addResourceLocations("file:///usr/local/project/book_images/"); // 서버 경로
  }
}