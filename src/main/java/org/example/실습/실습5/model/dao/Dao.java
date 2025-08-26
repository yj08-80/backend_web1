package org.example.실습.실습5.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dao { // class start

    // [ DB연동 부가정보 ]
    private String db_url = "jdbc:mysql://localhost:3306/assessment";
    private String db_user = "root";
    private String db_password = "1234";

    // [ DB연동 멤버변수 ]
    public Connection conn;

    // [ DB연동 생성자 ]
    public Dao(){
        connect();
    }

    // [DB연동 메소드 ]
    public void connect(){
        try{
            Class.forName( "com.mysql.cj.jdbc.Driver" );
            conn = DriverManager.getConnection( db_url , db_user , db_password );
            System.out.println( "Dao.connect" );
        }catch ( Exception e ){
            System.out.println( "오류 발생 " + e );
        }
    } // connection func end
} // class end
