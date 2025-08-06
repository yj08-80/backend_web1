package org.example.종합.종합예제11.controller;


import org.example.종합.종합예제11.model.dao.BoardDao;
import org.example.종합.종합예제11.model.dto.BoardDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController // 싱글톤 같은 기능이 내장되어 있음
public class BoardController { // class start


    // (*) boardDao 싱글톤 가져오기
    private BoardDao boardDao = BoardDao.getInstance();


    @PostMapping( "/board" )
    // (1) 등록 기능 구현
    public boolean boardWrite( @RequestBody BoardDto boardDto ){
       // 1. 객체화된 dto를 dao에게 전달 후 결과를 받는다.
        boolean result = boardDao.boardWrite( boardDto );
        // 4. 결과를 view에게 리턴한다.
        return result;
    }

    // (2) 전체조회 기능 구현
    @GetMapping("/board")
    public ArrayList<BoardDto> boardPrint( ){
        // - 유효성검사 ~ // - 매개변수 ~
        // 3. dao에게 전달후 결과를 받는다.
        ArrayList<BoardDto> result = boardDao.boardPrint( );
        // 4. 결과를 view에게 리턴한다.
        return result;
    }



    // (3) 삭제 기능 구현
    @DeleteMapping( "/board" )
    public boolean boardDelete( @RequestParam int bno ){
        // 1.유효성검사2.객체화
        // 3. dao에게 삭제할번호 전달후 결과를 받는다.
        boolean result = boardDao.boardDelete( bno );
        // 4. 결과를 view에게 리턴한다.
        return result;
    }



    // (4) 수정 기능 구현
    @PutMapping( "/board" )
    public boolean boardUpdate( @RequestBody BoardDto boardDto ){
        // 1. dao에게 삭제할번호 전달후 결과를 받는다.
        boolean result = boardDao.boardUpdate( boardDto );
        // 2. 결과를 view에게 리턴한다.
        return result;
    }

} // class end














