package org.example.day10;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

@RestController // HTTP 통신 컨트롤러
@RequestMapping // 공통 URL
public class LoginController { // class start

    // 1. 로그인 : 아이디와 패스워드가 일치하면 *세션*에 로그인 성공한 회원번호 저장
    // ex) console 프로젝트에서는 : static int loginMno
    @PostMapping("/login")
    public boolean login( @RequestBody LoginDto loginDto , HttpServletRequest request ){
        // HttpServletRequest : HTTP 요청 정보를 갖는 객체
        System.out.println( request.getRemoteAddr() ); // 통신을 요청한 클라이언트(사용자)의 IP 확인
        System.out.println( request.getRemotePort() ); // 통신을 요청한 클라이언트(사용자)의 PORT 확인
        System.out.println( request.getHeader( "User-Agent" ) ); // 통신을 요청한 클라이언트(사용자)의 브라우저 정보 확인

        // ** 세션 정보 가져오기, 세션이란 ? 톰캣 서버내 저장소( key-value / MAP 컬렉션 사용 )
        HttpSession session = request.getSession();
        System.out.println( session.getId() ); // 세션의 식별 번호 : 브라우저마다, pc마다 다르가 할당된다.
        System.out.println( session.getCreationTime() ); // 세션의 생성시간(ms) : 최초 요청한 시간
        System.out.println( session.getLastAccessedTime() ); // 세션의 마지막 접근 시간(ms), ms(밀리초=1/1000초)
        System.out.println( session.getMaxInactiveInterval() ); // 세션의 최대 유효 시간(초)

        // ** 세션 속성 추가하기, 속성이란? 키와 값으로 구성된 메모리 공간
        session.setAttribute( "login" , 3 ); // .setAttribute( "속성명" : 속성값 )
        // loginMno 라는 속성명으로 3이라는 데이터 저장하겠다는 뜻
        return true;
    }

    // 2. 로그인된 정보 확인 : 현재 세션에 저장된 회원번호 확인
    @GetMapping("/info")
    public boolean info( HttpServletRequest request ){
        // 1. 요청 서블릿에서 세션정보 꺼내기
        HttpSession session = request.getSession();
        // 2. 세션 정보 내 원하는 속성명 값 꺼내기, 개발자 의도와 상관없이 값은 무조건 object 타입
        Object obj = session.getAttribute( "loginMno" );
        if( obj == null ) return false; // 비로그인 상태
        // 3. 타입변환 필요
        int loginMno = ( int )obj; // 서버톰캣(스프링)을 재시작하면 모든 세션 정보는 초기화
        System.out.println( loginMno );

        return true;
    }

    // 3. 로그아웃 : 세션정보 내 속성 제거하기
    @GetMapping("/logout")
    public boolean logout( HttpServletRequest request ){
        // 1. 세션 정보 가져오기
        HttpSession session = request.getSession();
        // 2. 특정한 속성 제거하기
        session.removeAttribute( "loginMno" );
        // 3. 전체 속성 제거하기
        // session.invalidate();
        return true;
    }

} // class end
