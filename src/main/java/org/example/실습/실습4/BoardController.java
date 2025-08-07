package org.example.실습.실습4;

import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/board")

public class BoardController { // class start

    private BoardDao boardDao = BoardDao.getInstance();

    // 1. 등록
    @PostMapping("/write")
    public boolean write( @RequestBody BoardDto boardDto ){

        System.out.println("BoardController.write");
        System.out.println("boardDto = " + boardDto);

        return boardDao.write(boardDto);
    }


    // 2. 전체조회 요청
    @GetMapping( "/find" )
    public List< BoardDto > find(){
        System.out.println("BoardController.find");

        List< BoardDto > result = boardDao.find();
        return result;
    }
} // class end
