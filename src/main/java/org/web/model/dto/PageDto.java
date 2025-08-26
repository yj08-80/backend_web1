package org.web.model.dto;


import lombok.*;


// 출력할 정보(게시물/회원/제품 등)들과 페이징 정보를 갖는 클래스
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PageDto { // class start

    // + DB 테이블이 없고 자바에서만 사용되는 DTO


    // 1. 전체 자료 개수
    private int totalCount;
    // 2. 현재 페이지 번호
    private  int currentPage;
    // 3. 전체 페이지 수
    private int totalPage;

    // 실무에서는 시작번호와 끝번호는 없는 경우가 좀 더 많음
    // 4. 페이징 버튼 시작번호;
    private int startBtn;
    // 5. 페이징 버튼 끝번호;
    private int endBtn;


    // 6. 1 페이지 당 보이는 자료 수
    private int perCount;
    // 7. 페이징된 자료들
    private Object data;
    // * Object 사용한 이유 : 정보/자료 호환성 *
    // 게시물 정보 뿐만 아니라 여러 정보들을 저장하기 위해 슈퍼클래스


} // class end
