package org.example.day07;


import lombok.*;

@NoArgsConstructor // 빈생성자( 컴파일시 실행 ) 자동 생성
@AllArgsConstructor // 모든 매개변수 생성자( 컴파일시 실행 ) 자동 생성
@Getter // 모든 매개변수에 대해서 getter 메소드 *
@Setter // 모든 매개변수에 대해서 setter 메소드, 생략시 VO(읽기모드)
@ToString // 객체 조회 시 주소값 대신에 모든 멤버변수를 문자열 출력 메소드
public class StudentDto { // class start

    // 롬복이란 : 설계에서 자주 사용되는 코드 자동생성
    // 롬복 설치
    // 1) (환경)인텔리제이 설치
    // 2) (프로젝트)그레이들 설치
        // https://start.spring.io/
        // 디펜던시에서 'lombok' 검색
        // compile.


    // 1. 멤버변수
    private int sno; // 번호
    private String sname; // 이름
    private int skor; // 국어점수
    private int smath; // 수학점수
    private String sdate; // 등록일

    // 2. 생성자 : 빈생성자, 풀(모든 매개변수) 생성자

    // 3. setter and gettert

    // 4. toString()

} // class end
