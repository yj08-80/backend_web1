package org.example.실습.실습5.model.dao;


import org.example.실습.실습5.model.dto.WaitingDto;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository
public class WaitingDao extends Dao{ // class start

    // [1] 등록
    public boolean waitingWrite( WaitingDto waitingDto ){
        try {
            connect();
            String sql = "INSERT INTO waiting ( phone, count ) VALUES (?, ?);";
            PreparedStatement ps = conn.prepareStatement( sql );
            ps.setString( 1 , waitingDto.getPhone() );
            ps.setInt( 2 , waitingDto.getCount() );

            int count = ps.executeUpdate();

            if( count == 1 ){
                return true;
            }else {
                return false;
            }
        }catch ( Exception e ){
            System.out.println( "오류 발생 " + e );
        }
        return false;
    }


    // [2] 전체조회 기능
    public ArrayList< WaitingDto > waitingPrint(){
        ArrayList< WaitingDto > list = new ArrayList<>();

        try{
            String sql = "SELECT * FROM waiting";
            PreparedStatement ps = conn.prepareStatement( sql );
            ResultSet rs = ps.executeQuery();

            while ( rs.next() ){
                int bno = rs.getInt( "bno" );
                String phone = rs.getString( "phone" );
                int count = rs.getInt( "count" );
                String date = String.valueOf(rs.getDate( "date" ));
                WaitingDto waitingDto = new WaitingDto( bno , phone , count , date );
                list.add( waitingDto );
            }
        }catch ( Exception e ){
            System.out.println( "오류 발생 " + e );
        }
        return list;
    }


    // [3] 개별조회
    public WaitingDto waitingFind( int bno ){
        try{
            String sql = "SELECT * FROM waiting WHERE bno = ?";
            PreparedStatement ps= conn.prepareStatement( sql );
            ps.setInt( 1 , bno );
            ResultSet rs = ps.executeQuery();
            if( rs.next() ){
                WaitingDto waitingDto = new WaitingDto();
                waitingDto.setBno( rs.getInt( 1 ) );
                waitingDto.setPhone( rs.getString( 2) );
                waitingDto.setCount( rs.getInt( 3 ) );
                waitingDto.setDate(String.valueOf(rs.getDate( 4 )));
                return waitingDto;
            }
        } catch ( Exception e ) {
            System.out.println( "오류 발생 " + e );
        }
        return null;
    }


    // [4] 삭제 기능
    public boolean waitingDelete( int bno ){
        try{
            String sql = "DELETE FROM waiting WHERE bno = ?";
            PreparedStatement ps = conn.prepareStatement( sql );
            ps.setInt( 1 , bno );
            int count = ps.executeUpdate();

            if( count == 1 ) {
                return true;
            }else {
                return false;
            }
        } catch ( SQLException e ) {
            System.out.println( "오류 발생 " + e );
        }
        return false;
    }


    // [5] 개별 수정
    public boolean waitingUpdate( WaitingDto waitingDto ){
        try{
            String sql = "UPDATE waiting SET phone = ?, `count` = ? WHERE bno = ?";
            PreparedStatement ps = conn.prepareStatement( sql );
            ps.setString( 1 , waitingDto.getPhone() );
            ps.setInt( 2 , waitingDto.getCount() );
            ps.setInt( 3 , waitingDto.getBno() );

            int count = ps.executeUpdate();
            if( count == 1 ){
                return true;
            }
        }catch ( Exception e ){
            System.out.println( "오류 발생 " + e );
        }
        return false;
    }


} // class end























