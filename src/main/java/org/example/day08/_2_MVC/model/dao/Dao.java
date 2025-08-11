package org.example.day08._2_MVC.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dao { // class start
    // 여러개 DAO를 연동하는 중복 코드를 관리하는 슈퍼클래스

    // [ DB연동 부가정보 ]
    private String db_url = "jdbc:mysql://localhost:3306/spring08";
    private String db_user = "root";
    private String db_password = "1234";

    // [ DB연동 멤버변수 ] + 하위 클래스를 사용할 수 있게 public으로 사용
    public Connection conn;
    // [ DB연동 생성자 ]
    public void connect(){
        try {
            Class.forName( "com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection( db_url , db_user , db_password );
            System.out.println( "Dao.connect" ); // soutm 확인차
        }catch ( Exception e ){
            System.out.println( e );
        }
    }
} // class end
