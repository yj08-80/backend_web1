package org.example.day08._2_MVC.model.dao;


import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.PrimitiveIterator;

@Repository // [3] Repository 빈 등록
public class MvcDao extends Dao { // class start
    // 다음 레이어(계층) 없어서 @AutoWired 없다.
    // extends Dao 할 경우 db연동 상속받아 사용한다,

    public void method(){
        System.out.println("MvcDao.method");
        connect();
        try{
            String sql = " SELECT * FROM mvc";
            PreparedStatement ps = conn.prepareStatement( sql );
            ResultSet rs = ps.executeQuery();
            while ( rs.next() ){
                System.out.println( rs.getString( "var1" ) );
            }
        }catch ( Exception e ){
            System.out.println( e );
        }
    }

} // class end
