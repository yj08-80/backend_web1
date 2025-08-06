package org.example.종합.종합예제11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class AppStart { // class start
    public static void main(String[] args) { // main start
        // view 실행하는 게 아닌 스프링 실행
        // + 스프링 실행하면 프로젝트 내 resources 폴더의 static HTML/CSS/JS 프론트엔드 싹 다 등록한다.
        SpringApplication.run( AppStart.class );
        // SpringApplication.run : 스프링을 키는 것
        // ( AppStart.class ) : 현재 페이지 AppStart


    } // main end
} // class end
