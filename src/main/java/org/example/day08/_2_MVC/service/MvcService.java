package org.example.day08._2_MVC.service;


import org.example.day08._2_MVC.model.dao.MvcDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // [1] Service 빈 등록
public class MvcService { // class start

    @Autowired // [2] Repository(dto) 빈 주입
    private MvcDao mvcDao;
    public void method(){
        System.out.println("MvcService.method"); // soutm
        mvcDao.method();
    }

} // class end
