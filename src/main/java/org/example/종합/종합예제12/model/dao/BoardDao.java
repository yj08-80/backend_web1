package org.example.종합.종합예제12.model.dao;


import org.example.종합.종합예제12.model.dto.BoardDto;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@Repository
public class BoardDao extends Dao { // class start

    // [1] 등록
    public boolean boardWrite( BoardDto boardDto){
        // boolean              : 해당 메소드 실행 결과를 true(저장성공)false(저장실패) 반환 하기 위한 타입
        // BoardDto boardDto    : controller 로부터 저장할 값들을 dto로 구성해서 받는 매개변수
        try {
            connect();
            String sql = "INSERT INTO board ( bcontent, bwriter ) VALUES (?, ?);";  // 1. SQL 작성한다.
            PreparedStatement ps = conn.prepareStatement( sql );  // 2. SQL 기재한다..
            // 3. SQL 매개변수 대입 , 현재 ? 2개
            ps.setString( 1 , boardDto.getBcontent() ); // SQL내 1번 ? 에 매개변수로 받은 boardDto의 bcontent 값 대입
            ps.setString( 2 , boardDto.getBwriter() ); // SQL내 2번 ? 에 매개변수로 받은 boardDto의 bwriter 값 대입
            // 4. SQL 실행  , insert/update/delete 은 .executeUpdate();
            int count = ps.executeUpdate();
            // 5. sql 결과에 따른 로직/리턴/확인
            if( count >= 1 ) return true; // 1개 이상 insert 했으면 저장성공
            return false; // 1개이상 insert 못했으면 저장실패
        } catch (Exception e) { System.out.println(e); } // catch end
        return false; // 예외 발생시 저장실패.
    } // func end

    // (2) 전체조회 기능
    public ArrayList< BoardDto > boardPrint(){
        ArrayList< BoardDto > list = new ArrayList<>();

        try{
            String sql = "SELECT * FROM BOARD";
            PreparedStatement ps = conn.prepareStatement( sql );
            ResultSet rs = ps.executeQuery();

            while( rs.next() ){
                int bno = rs.getInt( "bno" );
                String bcontent = rs.getString( "bcontent" );
                String bwriter = rs.getString( "bwriter" );
                BoardDto boardDto = new BoardDto( bno , bcontent , bwriter );
                list.add( boardDto );
            }
        }catch ( Exception e ){
            System.out.println( e );
        }
        return list;
    }




    // [3] 개별조회
    public BoardDto boardFind( int bno ){
        try{
            String sql = "select * from board where bno = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt( 1  , bno ); // sql문법내 첫번째 ? 에 int타입 bno값 대입
            ResultSet rs = ps.executeQuery();
            if( rs.next() ){
                // while(rs.next()) : 여러개 조회
                // if( rs.next() ) : 한개 조회
                BoardDto boardDto = new BoardDto();
                boardDto.setBno( rs.getInt( 1 ) );
                boardDto.setBcontent( rs.getString( 2 ) );
                boardDto.setBwriter( rs.getString( 3 ) );
                return boardDto; // 성공시 1개 dto
            }
        } catch (Exception e) {System.out.println(e); }
        return null; // 실패시 null
    }

    // (3) 삭제 기능 구현
    public boolean boardDelete( int bno ){ // int bno : 매개변수이면서 삭제할 게시물의 식별(pk)번호
        try {
            String sql = "delete from board where bno = ?";// 1. SQL 작성
            PreparedStatement ps = conn.prepareStatement(sql);// 2. SQL 기재
            ps.setInt(1, bno);// SQL문법내 첫번째 ? 의 INT타입으로 bno 값 대입 // 3. SQL 매개변수 대입
            // 4. SQL 실행 , insert/update/delete 문법 실행 결과는 처리된 레코드수 반환
            int count = ps.executeUpdate();
            // 5. SQL 결과에 따른 로직/리턴/확인
            if (count == 1) {  return true; } // <---sql 결과 1이면 성공
            else {   return false; } // <--- sql 결과 1 아니면 실패
        } catch (Exception e) {  System.out.println(e);  }
        return false; // <--- 예외발생시 삭제실패
    }

    // [5] 개별수정
    public boolean boardUpdate( BoardDto boardDto ){
        try{
            String sql ="update board set bcontent = ? where bno = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString( 1 , boardDto.getBcontent() );
            ps.setInt( 2 , boardDto.getBno() );
            int count = ps.executeUpdate();
            if( count == 1 ) return true;
        } catch (Exception e) {  System.out.println(e);   }
        return false;
    }

} // class end


















