package org.example.day03;

// AppStart : 스프링 실행과 동시에 같은패키지/하위패키지 내 모든 컴포넌트 스캔 자동 빈(객체) 등록

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller // 스프링에게 해당 클래스는 Controller입니다. 알림
// 어노테이션이란? (라벨) 택배상자 안에 있는 실질적인 내용물이 아닌, 택배상자 앞에 붙인 '유리 취급주의' 부착 느낌
//@RestController // Controller + ResponseBody가 내장
public class RestController1 { // class start
    // 싱글톤 생략 : @Component 사용했기 때문에

    @GetMapping( "/day03" ) // HTTP( 웹 통신규약 ) 중에서 'GET' METHOD 사용, baseURL 뒤로 자원URL 정의
    // url : http://localhost:8080/day03
    // Whitelable Error Page : 요청은 정상이지만, 응답은 없다.
    // * Talend API :
    @ResponseBody // 이 메서드의 반환값을 View가 아닌 'HTTP 응답 본문'으로 전송함
    //--> 현재 Controller 가 @RestController 면 생략 가능
    public String method1(){
        return "자바에서 보내온 메세지";
    }
    // ++++ 매개변수
    // 메소드에서 매개변수란 ? 메소드 호출 시 메소드 안으로 들어오는 값을 저장하는 변수
    // + HTTP 요청시에도 인자/자원 보낼 수 있다.
    // ++ 자바 메소드 인자값 전달 방식 : method2( 유재석 );
    // ++ HTTP 메소드 인자값 전달 방식 : http://localhost:8080/day03/param1?name=유재석
    // +++ 쿼리스트링이란? URL(주소) 뒤에 ? 붙이고 자원(데이터) 이동/전달/표현할 때 사용하는 문법
    // ++++ URL?매개변수명1=값&매개변수명2=값2&매개변수명3=값3 ( 주의할 점 : 문자만 가능 )
    @GetMapping( "/day03/param1" )
    public boolean method2( @RequestParam ( name = "name", defaultValue = "홍길동", required = true) String name ){
        // @RequestParam : Request( 요청 ) + Param( 매개변수 ) 요청매개변수
        // ++ name : "URL매개변수명" : 주소(URL) 상의 ? 뒤로 매핑(연결)할 매개변수명 명시, 단 자바 매개변수와 이름이 동일시 생략가능
            // 예) http://localhost:8080/day03/param1?name=유재석 ---> "유재석"     String name
            // 예) http://localhost:8080/day03/param1?name=유재석 ---> "홍길동"     @RequestParam( name = "name" ) String nickName
        // defaultVaule = "홍길동" : 만약에 매개변수명에 값이 생략되면 자동으로 들어가는 값
        // ++ required : 만약에 해당 매개변수가 없으면 예외(자동) 발생, HTTP 400 ERROR( 잘못된 요청 뜻 )
            // 예) http://localhost:8080/day03/param1?name=유재석 ---> 정상
            // 예) http://localhost:8080/day03/param1 ---> 404 ERROR
        System.out.println("RestController1.method2"); // soutm 현재 메소드명 출력
        System.out.println("name = " + name); // soutp 현재 메소드 매개변수 출력
        return true;
    }

    @GetMapping("/day03/param2")
    // http://localhost:8080/day03/param2?name=강호동&age=20
    public int method3(@RequestParam( required = true ) String name , @RequestParam( name = "age" ) int 나이 ){ // *자동타입변환*
        System.out.println("RestController1.method3");
        System.out.println("name = " + name + ", 나이 = " + 나이);
        return 3;
    }


    @DeleteMapping("/day03/param3")
    public String method4( @RequestParam Map< String , String > map ){
        // 일반적으로 정해진 규칙이나 매개변수명이 아닌 단순 MAP(비규칙) 구조일 경우 @RequestParam 사용해야한다.
        System.out.println( "RestController1.method4" );
        // Map : KEY와 VAULE를 한 쌍( ENTRY ) 구성하여 여러 개 ENTRY 저장 구조
        System.out.println( "map = " + map );
        return "안녕"; // 임의값
    }

    @DeleteMapping( "/day03/param4" )
    // http://localhost:8080/day03/param4?name=유재석&age=40
    // ++ DTO에 자동 매핑 하기 위해서는 DTO에도 name과 age 멤버변수가 존재해야한다. +생성자+setter
    public int method5( @ModelAttribute TaskDto taskDto ){
        // @RequestParam : DTO내 동일한 멤버변수와 생성자가 구성된 상태일 때 자동 DTO 생성
        System.out.println("RestController1.method5");
        System.out.println("taskDto = " + taskDto);
        // taskDto = TaskDto{ name = '유재석' , age = 40 }
        return 3;
    }


    /*

    * 쿼리스트링이란 ? HTTP 경로상의 매개변수 표현, 매개변수 노출o, URL?매개변수=값?매개변수=값
    * 2) BODY(본문)이란 ? HTTP 본문에 매개변수 표현, 매개변수 노출x, POST/PUT에서 JSON 타입으로 객체 지원

                        @RequestParam                               @ModelAttribute                                     @RequestBody

    역할                 단일 파라미터에 변수 바인딩                        복수 파라미터에 객체 바인딩                                본문(body) 객체 바인딩
    생략기준              변수명이 일치할 경우(쿼리스트링의매개변수명)            DTO 타입일 때 기본적용( +생성자, +setter )                DTO
    주요타입              기본형 : int/String/List/Map                  DTO(개발자가만든객체)                                    DTO
    처리가능요청           쿼리스트링, <form:첨뷰파일x>                      쿼리스트링, <form:첨부파일o>                             본문(body)
    HTTP메소드            GET/POST/PUT/DELETE                         GET/POST/PUT/DELETE                                 POST/PUT

     */


    @PostMapping("/day03/param5")
    // Talend API : [Method] Post, [Scheme] http://localhost:8080/day03/param5
    //              [HEADERS] JSON [BODY] { "name" : 유재석 , "age" : 40 }
    public boolean method6( @RequestBody TaskDto taskDto ){
        System.out.println("RestController1.method6");
        System.out.println("taskDto = " + taskDto);
        return true; // 임의값
    }

    @PutMapping("/day03/param6")
    public int method7( @RequestBody Map< String , String > map ){
        System.out.println("RestController1.method7");
        System.out.println("map = " + map);
        return 3;
    }

} // class end











