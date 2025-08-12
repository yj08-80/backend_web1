package org.example.실습.실습5.service;

import org.example.실습.실습5.model.dto.WaitingDto;
import org.example.실습.실습5.model.dao.WaitingDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;


@Service
public class WaitingService { // class start

    @Autowired
    private WaitingDao waitingDao;

    // 등록 기능
    public boolean waitingWrite(@RequestBody WaitingDto waitingDto ){
        System.out.println("WaitingService.waitingWrite");
        System.out.println("waitingDto = " + waitingDto);
        boolean result = waitingDao.waitingWrite( waitingDto );
        return result;
    }


    // 전체조회 기능
    public ArrayList< WaitingDto > waitingPrint(){
        System.out.println("WaitingService.waitingPrint");
        ArrayList< WaitingDto > result = waitingDao.waitingPrint();
        return result;
    }


    // 게시물 개별조회 기능
    public WaitingDto waitingFind( int bno ){
        System.out.println("WaitingService.waitingFind");
        System.out.println("bno = " + bno);
        WaitingDto result = waitingDao.waitingFind( bno );
        return result;
    }


    // 삭제 기능
    public boolean waitingDelete( @RequestParam int bno ){
        System.out.println("WaitingService.waitingDelete");
        System.out.println("bno = " + bno);
        boolean result = waitingDao.waitingDelete( bno );
        return result;
    }


    // 수정 기능
    public boolean waitingUpdate( WaitingDto waitingDto ){
        System.out.println("WaitingService.waitingUpdate");
        System.out.println("waitingDto = " + waitingDto);
        boolean result = waitingDao.waitingUpdate( waitingDto );
        return result;
    }

} // class end




















