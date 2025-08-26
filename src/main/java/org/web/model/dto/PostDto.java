package org.web.model.dto;


// 게시물 정보를 갖는 클래스

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PostDto { // class start

    // + DB 테이블 내 속성과 동일
    private int pno;
    private String ptitle;
    private String pcontent;
    private String pdate;
    private int pview;
    private int mno;
    private int cno;

    // + 그 외 : 현재 테이블에는 없지만 추가적인 속성
    private String mid; // 게시물의 작성자 회원 아이디, join
    private String cname; // 게시물의 카테고리명, join
    private boolean host; // 현재 게시물을 요청한 사람이  작성한 글인지 확인
} // class end
