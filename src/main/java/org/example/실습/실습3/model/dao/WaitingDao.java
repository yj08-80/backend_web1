package org.example.실습.실습3.model.dao;

import org.example.실습.실습3.model.dto.WaitingDto;

import java.sql.*;
import java.util.ArrayList;

public class WaitingDao { //  class start

    // 싱글톤
    private WaitingDao() {
    }
    private static final WaitingDao instance = new WaitingDao();

    public static WaitingDao getInstance() {
        return instance;
    }

    // DB 연동
    private String db_url = "jdbc:mysql://localhost:3306/test3";
    private String db_user = "root";
    private String db_password = "1234";
    private Connection conn;
    private void connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection( db_url , db_user , db_password );
        }catch (Exception e ){ System.out.println(e);   }
    }



    // 등록 기능 구현
    public boolean waitingWrite( WaitingDto waitingDto ){
        try{
            connect();
            String sql = "INSERT INTO waiting ( phone , count ) VALUES ( ? , ? );";
            PreparedStatement ps = conn.prepareStatement( sql);

            ps.setString( 1 , waitingDto.getPhone() );
            ps.setInt( 2 , waitingDto.getCount() );

            int count = ps.executeUpdate();

            if( count >= 1 ) return true;
            return false;
        } catch ( Exception e ){
            System.out.println( "SQL 오류 발생" + e );
        }
        return false;
    }

    // (2) 전체조회 기능 구현
    public ArrayList< WaitingDto > waitingPrint(){
        ArrayList< WaitingDto > list = new ArrayList<>();

        try{
            connect();
            String sql = "select * from waiting";
            PreparedStatement ps =  conn.prepareStatement( sql );
            ResultSet rs = ps.executeQuery();

            while ( rs.next() ){
                int bno = rs.getInt( "bno" );
                String phone = rs.getString( "phone" );
                int count = rs.getInt( "count" );
                WaitingDto waitingDto = new WaitingDto( bno , phone , count );
                list.add( waitingDto );
            }
        } catch ( Exception e ){
            System.out.println( " SQL 오류 발생" + e );
        }
        return list;
    }

    // 삭제 기능 구현
    public boolean waitingDelete( int bno ){
        try{
            connect();
            String sql = "delete from waiting where bno = ?";
            PreparedStatement ps = conn.prepareStatement( sql );
            ps.setInt( 1 , bno );
            int count = ps.executeUpdate();

            if( count == 1 ) return true;
            return false;
        }catch ( Exception e ){
            System.out.println( "SQL 오류 발생" + e);
        }
        return false;
    }

    // 수정 기능 구현
    public boolean waitingUpdate( WaitingDto waitingDto ){
        try {
            connect();
            String sql = "update waiting set count = ? where bno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, waitingDto.getCount());
            ps.setInt(2, waitingDto.getBno());

            int count = ps.executeUpdate();
            if( count == 1 ) return true;
            return false;
        }catch ( Exception e ){
            System.out.println( "SQL 오류 발생" + e );
        }
        return false;
    }
} // class end












