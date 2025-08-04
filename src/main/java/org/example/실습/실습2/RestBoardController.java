package org.example.실습.실습2;

import org.example.day01.model.dto.BoardDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class RestBoardController { // class start


    private ArrayList<BoardDto> boardList = new ArrayList<>();



    // 게시물 등록
    @PostMapping( "/board" )
    public boolean boardWrite( BoardDto dto) {
        System.out.println("RestBoardController.boardWrite");
        System.out.println("dto = " + dto);

        return true;
    }

    // 게시물 전체조회
    @GetMapping( "/board" )
    public ArrayList<BoardDto> boardPrint(){

        System.out.println("RestBoardController.boardPrint");
        System.out.println();

        return boardList;
    }

    // 게시물 개별조회
    @GetMapping("/board/detail")
    public BoardDto boardDetail( int bno ){

        System.out.println("RestBoardController.boardDetail");
        System.out.println("bno = " + bno);

        return null;
    }


    // 게시물 삭제
    @DeleteMapping( "/board" )
    public boolean boardDelete( int bno ){

        System.out.println("RestBoardController.boardDelete");
        System.out.println("bno = " + bno);

        return true;
    }


    // 게시물 수정
    @PutMapping( "/board" )
    public boolean boardUpdate( BoardDto dto) {

        System.out.println("RestBoardController.boardUpdate");
        System.out.println("dto = " + dto);

        return false;
    }

} // class end
