package org.example.실습.실습3.controller;

import org.example.실습.실습3.model.dao.WaitingDao;
import org.example.실습.실습3.model.dto.WaitingDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
public class WaitingController { // class start

    // 등록 기능 구현
    private WaitingDao waitingDao = WaitingDao.getInstance();

    @PostMapping( "/waiting" )
    public boolean waitingWrite( @RequestBody WaitingDto waitingDto ){
        boolean result = waitingDao.waitingWrite( waitingDto );
        return result;
    }

    // 전체 조회 기능 구현
    @GetMapping( "/waiting" )
    public ArrayList< WaitingDto > waitingPrint(){
        ArrayList< WaitingDto > list = waitingDao.waitingPrint();
        return list;
    }

    // 삭제 기능 구현
    @DeleteMapping( "/waiting" )
    public boolean waitingDelete( @RequestParam int bno ){
        boolean result = waitingDao.waitingDelete( bno );
        return result;
    }

    // 수정 기능 구현
    @PutMapping( "/waiting" )
    public boolean waitingUpdate(@RequestBody WaitingDto waitingDto) {
        boolean result = waitingDao.waitingUpdate(waitingDto);
        return result;
    }
} // class end
