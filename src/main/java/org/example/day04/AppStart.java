package org.example.day04;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 스프링을 실행하는 어노테이션
public class AppStart { // class start
    public static void main(String[] args) {

        // AppStart 클래스는 항상 최상위에 위치한다
        // -> @SpringBootApplication은 *현재 패키지* 및 *하위 패키지*를 스캔하기 때문에
        SpringApplication.run( AppStart.class );
    }
} // class end
