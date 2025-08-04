package org.example.실습.실습1;


import org.springframework.web.bind.annotation.*;

import java.util.*;
@org.springframework.stereotype.Controller

public class Controller2 { // class start

//    3. 각 URL 매핑 만들기
//        1. 글쓰기           POST       "/exam1/board"
//        요청자료 : x , 응답자료 : true/false

    @PostMapping( "/exam1/board" )
    @ResponseBody
    public boolean method1(){
        System.out.println( "Controller2 method1" );
        return false;
    }

    //        2. 전체 글 조회      GET        "/exam1/board"
//        요청자료 : x , 응답자료 : 임의의 List 타입 ,  [ {bno:'',btitle:''} ,  {bno:'',btitle:''}  ] , 아래 참고

    @GetMapping( "/exam1/board" )
    @ResponseBody
    public List< Dto > method2(){
        System.out.println( "Controller method2" );
        ArrayList< Dto > list = new ArrayList<>();
        list.add( new Dto( ) );
        list.add( new Dto( ) );
        return list;
    }


//    3. 개별 글 조회      GET        "/exam1/board/view"
//        요청자료 : x , 응답자료 : 임의의 MAP  타입  ,  {bno:'',btitle:''} , 아래 참고
    @GetMapping( "/exam1/board/view" )
    @ResponseBody
    public Map< Integer , String > method3(){
        System.out.println( "Controller method3" );
        Map< Integer , String > map = new HashMap<>();
        map.put( 1 , "안녕" );
        map.put( 2, "하세요" );
        return map;
    }

//    4. 개글 글 수정      PUT
//        요청자료 : x , 응답자료 : true 또는 false
    @PutMapping( "/exam1/board")
    @ResponseBody
    public boolean method4(){
        System.out.println( "Controller method4" );
        return false;
    }


//     5. 개별 글 삭제      DELETE     "/exam1/board"
//        요청자료 : x , 응답자료 : 임의의 삭제한 번호 , 3
    @DeleteMapping("/exam1/board" )
    @ResponseBody
    public int method5(){
        return 3;
    }




} // class end
