package org.example.종합.종합예제12.service;


import org.example.종합.종합예제12.model.dao.BoardDao;
import org.example.종합.종합예제12.model.dto.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Service
public class BoardService { // class start
    @Autowired
    private BoardDao boardDao;

    // 등록 기능
    public boolean boardWrite(@RequestBody BoardDto boardDto ){
        System.out.println("BoardService.boardWrite");
        System.out.println("boardDto = " + boardDto);
        boolean result = boardDao.boardWrite( boardDto );
        return result;
    }

    // 전체조회 기능
    public ArrayList<BoardDto> boardPrint(){
        System.out.println("BoardService.boardPrint");
        ArrayList<BoardDto> result = boardDao.boardPrint();
        return result;
    }

    // 게시물 개별조회 기능
    public BoardDto boardFind( int bno ){
        System.out.println("BoardService.boardPrint2");
        System.out.println("bno = " + bno);
        BoardDto result = boardDao.boardFind( bno );
        return result;
    }

    // 삭제 기능
    public boolean boardDelete( @RequestParam int bno ){
        System.out.println("BoardService.boardDelete");
        System.out.println("bno = " + bno);
        boolean result = boardDao.boardDelete( bno );
        return result;
    }



    // [5] 개별수정
    public boolean boardUpdate( BoardDto boardDto  ){
        System.out.println("BoardService.boardUpdate");
        System.out.println("boardDto = " + boardDto);
        boolean result = boardDao.boardUpdate( boardDto );
        return result;
    }
} // class end
