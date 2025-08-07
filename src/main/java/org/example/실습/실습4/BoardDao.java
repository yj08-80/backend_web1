package org.example.실습.실습4;

import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BoardDao { // class start

    // 싱글톤
    @Getter
    private static final BoardDao instance = new BoardDao();

    private String db_url = "jdbc:mysql://localhost:3306/test04";
    private String db_user = "root";
    private String db_password = "1234";
    private Connection conn;

    // 연동코드
    private void connect(){
        try{
            Class.forName( "com.mysql.cj.jdbc.Driver" );
            conn = DriverManager.getConnection( db_url , db_user , db_password );
        }catch ( Exception e ){
            System.out.println( "오류 발생 " + e );
        }
    } // 연동 end

    // 1. 등록
    public boolean write(BoardDto boardDto) {
        connect();
        try {
            String sql = "INSERT INTO board(phone,count) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, boardDto.getPhone());
            ps.setInt(2, boardDto.getCount());

            int count = ps.executeUpdate();
            if(count == 1) return true;
        } catch(Exception e) {
            System.out.println("오류 발생 " + e);
        }
        return false;
    }


    // 2. 대기 현황 조회
    public List< BoardDto > find(){
        connect();
        List<BoardDto> list = new ArrayList<>();
        try{
            String sql = "SELECT * FROM board";
            PreparedStatement ps = conn.prepareStatement( sql );
            ResultSet rs = ps.executeQuery();

            while ( rs.next() ){
                BoardDto boardDto = new BoardDto(
                        rs.getInt( 1 ),
                        rs.getString( "phone" ),
                        rs.getInt( "count" ),
                        rs.getString( "date" )
                );
                list.add( boardDto );

            }
        }catch ( Exception e ){
            System.out.println( "오류 발생" + e);
        }
        return list;
    }

} // class end























