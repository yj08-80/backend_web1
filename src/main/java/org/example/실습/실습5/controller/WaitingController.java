package org.example.실습.실습5.controller;

import org.example.실습.실습5.model.dto.WaitingDto;
import org.example.실습.실습5.service.WaitingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/waiting")
public class WaitingController { // class start

    @Autowired
    private WaitingService waitingService;

    // [1] 등록
    @PostMapping("")
    public boolean waitingWrite( @RequestBody WaitingDto waitingDto ){
        System.out.println("WaitingController.waitingWrite");
        System.out.println("waitingDto = " + waitingDto);
        boolean result = waitingService.waitingWrite( waitingDto );
        return result;
    }


    // [2] 전체조회
    @GetMapping("")
    public List< WaitingDto > waitingPrint(){
        System.out.println("WaitingController.waitingPrint");
        List< WaitingDto > result = waitingService.waitingPrint();
        return result;
    }


    // [3] 개별 조회
    @GetMapping("/find")
    public WaitingDto waitingFind(@RequestParam int bno) {
        System.out.println("WaitingController.waitingFind");
        System.out.println("bno = " + bno);
        WaitingDto result = waitingService.waitingFind( bno );
        return result;
    }


    // [4] 삭제
    @DeleteMapping("")
    public boolean waitingDelete( @RequestParam int bno ){
        System.out.println("WaitingController.waitingDelete");
        System.out.println("bno = " + bno);
        boolean result = waitingService.waitingDelete( bno );
        return result;
    }



    /// [5] 수정
    @PutMapping("")
    public boolean waitingUpdate(@RequestBody WaitingDto waitingDto) {
        System.out.println("WaitingController.waitingUpdate");
        System.out.println("waitingDto = " + waitingDto);

        // ★ bno 유효성 체크
        if (waitingDto == null || waitingDto.getBno() <= 0) {
            System.out.println("[Controller] 잘못된 bno 값: " +
                    (waitingDto != null ? waitingDto.getBno() : "null"));
            return false;
        }

        boolean result = waitingService.waitingUpdate(waitingDto);
        System.out.println("[Controller] update result = " + result);
        return result;
    }


} // class end





















