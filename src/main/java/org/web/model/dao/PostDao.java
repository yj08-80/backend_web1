package org.web.model.dao;


import org.springframework.stereotype.Repository;
import org.web.model.dto.PageDto;
import org.web.model.dto.PostDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


@Repository
public class PostDao extends Dao { // class start


    // [1] 게시물등록
    public int writePost(PostDto postDto ){
        try{ String sql = "insert into post( ptitle, pcontent, cno, mno)values(?,?,?,?)";
            // Statement.RETURN_GENERATED_KEYS : SQL 실행시 자동 생성된 **PK 반환 설정**
            PreparedStatement ps = conn.prepareStatement( sql , Statement.RETURN_GENERATED_KEYS );
            // SQL문법내 '?'가 4개 이니까 setXXX 이용한 각 '?' 4개를 순서에 맞춰서 매개변수 대입
            ps.setString( 1, postDto.getPtitle() );
            ps.setString( 2, postDto.getPcontent() );
            ps.setInt( 3 , postDto.getCno() );
            ps.setInt( 4 , postDto.getMno() );
            int count = ps.executeUpdate();
            if( count == 1 ){
                ResultSet rs =  ps.getGeneratedKeys(); // SQL 실행후 자동 생성된 **PK 반환**
                if( rs.next() ) return rs.getInt( 1 ); // 등록 성공시 첫번째 pk속성 값 반환
            }
        } catch (Exception e) {  System.out.println(e); }
        return 0; // 등록 실패시
    } // func end


    // [2-1] 카테고리별 게시물 수
    public int getTotalCount( int cno ){
        try{
            String sql = "select count(*) from post where cno = ? "; // count(*) : 레코드 전체 수 SQL 함수
            PreparedStatement ps = conn.prepareStatement( sql );
            ps.setInt( 1 , cno );
            ResultSet rs = ps.executeQuery();
            if( rs.next() ){
                return rs.getInt( 1 ); // 첫번째 레코드의 속성값 1개 반환
            }
        }catch ( Exception e ){
            System.out.println( e );
        }
        return 0; // 없으면 0
    }


    // [2-2] 게시물 전체 조회
    public List<PostDto> findAll( int cno , int startRow , int count ){
        List< PostDto > list = new ArrayList<>();
        try{
            String sql = "select * from post p inner join member m on p.mno = mno where p.cno = ? order by p.pno desc limit ? , ?";
            PreparedStatement ps = conn.prepareStatement( sql );
            ps.setInt( 1 , cno );
            ps.setInt( 2 , startRow );
            ps.setInt( 3 , count );
            ResultSet rs = ps.executeQuery();
            while( rs.next() ){
                PostDto postDto = new PostDto();
                postDto.setMno( rs.getInt( "mno" ) );
                postDto.setCno( rs.getInt( "cno" ) );
                postDto.setPcontent( rs.getString( "pcontent" ) );
                postDto.setPdate( rs.getString( "pdate" ) );
                postDto.setPview( rs. getInt( "pview" ) );
                postDto.setPno( rs.getInt( "pno" ) );
                postDto.setPtitle( rs.getString( "ptitle" ) );
                postDto.setMid( rs.getString( "mid" ) ); // member 테이블과 join한 결과 mid 호출 가능하다
                list.add( postDto );
            }
        } catch ( Exception e ){
            System.out.println( e );
        }
        return list;
    }

} // class end














