package org.example.day07;

import lombok.Getter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao { // class start

    // 싱글톤
    @Getter // 롬복 : 해당하는 멤버변수에만 getter 제공받을 수 있다.
    private static final StudentDao instance = new StudentDao();

    private String db_url = "jdbc:mysql://localhost:3306/spring07";
    private String db_user = "root";
    private String db_password = "1234";
    private Connection conn;

    // 연동코드
    private void connent(){
        try{
            Class.forName( "com.mysql.cj.jdbc.Driver" );
            conn = DriverManager.getConnection( db_url , db_user , db_password );
        }catch ( Exception e ){
            System.out.println( "오류 발생 " + e );
        }
    } // 연동 end

    // 1. 저장
    public boolean save( StudentDto studentDto ){
        connent();
        // Controller로부터 studentDto를 매개변수로 받아서 처리 후 boolean(true/false) 반환 메소드
        try{
            String sql = "INSERT INTO student(sname,skor,smath) VALUES( ? , ? , ? )"; // 1) SQL 작성한다
            PreparedStatement ps = conn.prepareStatement( sql ); // 2) 연동된 DB에 작성한 SQL을 기재한다.
            ps.setString( 1 , studentDto.getSname() ); // 3) 기재된 SQL에 매개변수 대입
            ps.setInt( 2 , studentDto.getSkor() ); // 1,2,3 : SQL 문법 내 ? 순서번호
            ps.setInt( 3 , studentDto.getSmath() ); // .set타입() :
            // SQL 문법 내 3(세번째) ? 에 수학점수를 int 타입으로 대입한다
            int count = ps.executeUpdate(); // 4) 기재된 SQL 실행한다. INSERT/UPDATE/DELETE -> executeUpdate
            if( count == 1 ) return true; // 5) 결과, 1개 저장했으며녀 성공
        } catch (SQLException e) {
            System.out.println( "오류 발생 " + e );
        }
        return false;
    } // func end


    // 2. 전체조회
    public List< StudentDto > find(){
        connent();
        List< StudentDto > list = new ArrayList<>(); // 여러개 dto 담을 배열
        try{
            String sql = "SELECT * FROM student";
            PreparedStatement ps = conn.prepareStatement( sql );
            ResultSet rs = ps.executeQuery(); // 4) 기재된 SQL 실행한다. 실행 결과의 모든 레코드를 (ResultSet) 인터페이스 조작
            // rs.next() : SQL 조회 결과 중 다음 레코드 이동 함수, 주로 하나 조회 : if( rs.next() ), 다수 조회 : while( rs.next() )
            while( rs.next() ){
                StudentDto studentDto = new StudentDto(
                        rs.getInt(1 ), // 현재 조회중인 레코드의 (1번) 첫번째 필드/속성/제목/열/컬럼 = 회원번호
                        rs.getString( "sname" ), // 현재 조회중인 레코드의 "sname"이라는 필드/속성/제목/열/컬럼 = 회원명
                        rs.getInt( "skor" ),
                        rs.getInt( "smath" ),
                        rs.getString( "sdate" ) // dateTime은 String 타입으로 가져오기
                );
                list.add( studentDto );
            }
        }catch ( SQLException e ){
            System.out.println( "오류 발생 " + e );
        }
        return list;
    }


} // class end











