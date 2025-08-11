package org.example.종합.종합예제12.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dao { // class start
    // [DB연동 부가정보 ]
    private String db_url = "jdbc:mysql://localhost:3306/exam12";
    private String db_user = "root";
    private String db_password = "1234";
    // [DB연동 멤버변수] * 하위클래스를 사용할수 있게 public 으로 사용.
    public Connection conn;
    // [DB연동 생성자] * 싱글톤이 아니다.
    public Dao(){connect();}
    // [DB연동 메소드]
    public void connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection( db_url, db_user, db_password);
            System.out.println("Dao.connect"); // soutm 확인차
        }catch (Exception e ){  System.out.println(e);    }
    }
} // class end
