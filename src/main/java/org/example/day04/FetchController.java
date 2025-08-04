package org.example.day04;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController // @Controller( +Component ) + @ResponseBody
// HTTP(클라이언트)의 요청과 응답 처리 담당
public class FetchController { // class start

    //1. HTTP 정의, METHOD : GET, URL : /day04/exam1
    @GetMapping( "/day04/exam1" )
    public void method1(){
        System.out.println( "FetchController.method1" ); // soutm
    } // method end
    //2. HTTP 정의, METHOD : POST, URL : /day04/exam1
    @PostMapping( "/day04/exam2" )
    public void method2(){
        System.out.println("FetchController.method2");
    }
    //3. HTTP 정의, METHOD : PUT, URL : /day04/exam1
    @PutMapping( "/day04/exam3" )
    public void method3(){
        System.out.println("FetchController.method3");
    }
    //4. HTTP 정의, METHOD : DELETE, URL : /day04/exam1
    @DeleteMapping( "/day04/exam4" )
    public void method4(){
        System.out.println("FetchController.method4");
    }


    //5. 매개변수(쿼리스트링) 반환타입(JSON)
    // request " localhost:8080/day04/exam=5?name=유재석&age=10;
    @GetMapping( "/day04/exam5" )
    public boolean method5(@RequestParam String name , @RequestParam int age ){
        System.out.println("FetchController.method5");
        System.out.println("name = " + name + ", age = " + age);
        boolean result = true; // 임의의 값
        System.out.println("result = " + result); // 가장 가까운 지역변수 출력함수
        return result;
    }

    // 6. 매개변수(HTTP본문) 반환타입(JSON)
    // request : localhost:8080/day04/exam6
    // body : { "name" : "유재석" , "age" : "40" }
    // response : 200 , 20
    @PostMapping( "/day04/exam6" )
    public int method6( @RequestBody Map< String , String> map ) {
        System.out.println("FetchController.method6");
        System.out.println("map = " + map);
        int result = 20;
        return result;
    }

    //7.
    @PutMapping( "/day04/exam7" )
    public TaskDto method7( @RequestBody TaskDto taskDto ){
        System.out.println( "FetchController.method7" );
        System.out.println("taskDto = " + taskDto);
        TaskDto result = new TaskDto( "강호동" , 40 );
        return result;
    }

    //8.
    @DeleteMapping( "/day04/exam8" )
    // requert : localhost:8080/day04/exam8?name=유재석&age=10
    public List<TaskDto> method08(@RequestParam String name , int age ){
        System.out.println("FetchController.method08");
        System.out.println("name = " + name + ", age = " + age);
        List<TaskDto>result = new ArrayList<>();
        result.add( new TaskDto( "강호동" , 10 ) );
        result.add( new TaskDto( "유재석" , 20 ) );
        return result;
    }
} // class end
