package org.web.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.web.model.dao.PostDao;
import org.web.model.dto.PageDto;
import org.web.model.dto.PostDto;

import java.util.List;

@Service
@RequiredArgsConstructor // 롬복제공 : final 변수에 대한 (final) 생성자 자동 제공 -- 제공
public class PostService { // class start


    // ( ** )  @RequiredArgsConstructor 사용시
    // @Aurowired 생략해도 자동으로 의존성이 처리된다
    private final PostDao postDao;


    // ( ** ) @RequiredArgsConstructor 미사용시
    /*

    public PostService postService( PostDao postDao ) {
            this.postDao = postDao;
    }

    */

    // [1] 게시물 등록
    public int writePost( PostDto postDto ){
        return postDao.writePost( postDto );
    }


    // [2] 게시물 전체조회 *페이징*
    public PageDto findALlPost(int cno , int page , int count , String key , String keyword ){
        // cno : 카테고리 번호, page : 현재 페이지 번호, count : 페이지당 게시물 수

        // 1. 페이지별 조회할 시작( 인덱스 ) 번호 계산
        /* 페이지당 5개씩 조회한다는 가정 : 1페이지 -> 1 , 2페이지 -> 6 , 3페이지 -> 11 */
        int startRow = ( page -1 ) * count ; // 현재 페이지 -1하고 페이지당 게시물 수 곱한다
        /* 1페이지 -> 1-1*5 -> 0 , 2페이지 -> 2-1*5 -> 5 , 3페이지 -> 3-1*5 -> 10 */

        // 예) 네이버 증권 게시판 : 1페이지 -> 1-1*20 -> 0 , 2페이지 -> 2-1*20 -> 20 , 3페이지 3-1*20 -> 30
        int totalCount;
        List<PostDto> postList;
        // ****** 2번 3번만 검생이 있을 때 없을 때 나눠서 totlaCount와 postList 구하기 ******
        if( key != null && !key.isEmpty() && keyword != null  && !keyword.isEmpty() ){ // 검색이 아닐 때
            // 만약에 key와 keyword가 null이 아니면서 .isEmpty() : 비어있으면 true 반환 함수
            // .(도트/접근) 연산자는 변수가 null일 때 사용 안된다.
            totalCount = postDao.getTotalCountSearch( cno , key, keyword );
            postList = postDao.findAllSearch( cno , startRow , count , key , keyword );
            // ****** 2. 자료의 총개수 구하기  ******

        }else{ // 검색일 때
            totalCount = postDao.getTotalCount( cno );
            // ****** 3. 자료 구하기 ******
            postList = postDao.findAll ( cno , startRow , count );
        }



        // ****** 4. 전체 페이지 수 구하기 ******
        int totalPage = totalCount % count == 0 ? totalCount/count : totalCount/count + 1 ; // 나머지가 존재하면 +!
        // 35개의 정보가 있을 때 5개씩 조회한다면 총 페이지 수는 몇 개 ? 7페이지
        // 42개의 정보가 있을 때 10개씩 조회한다면 총 페이지 수는 몇 개 ? 4페이지 + 1페이지( 나머지 2개 ) -> 5페이지


        int btnCount = 5; // 한 화면에 보여지는 최대 버튼 수
        // ****** 5. 시작 버튼 구하기 ******
        int startBtn = ( ( page - 1 ) / btnCount ) * btnCount + 1 ;


        // 6. 끝버튼 구하기
        int endBtn = startBtn + btnCount - 1;
        if( endBtn > totalPage ) endBtn = totalPage; // 만약에 끝버튼 수가 총 페이지수보다 커지면 총페이지 수로 끝버튼 번호 사용

        // ****** 5. 끝 버튼 구하기 ******
        // 총 페이지 수가 13일 때, 현재 페이지가 3이면 시작 버튼은 1, 끝 버튼은 5
        // 총 페이지 수가 13일 때, 현재 페이지가 7이면 시작 버튼은 6 , 끝 버튼은 10
        // 총 페이지 수가 13일 때, 현재 페이지가 12이면 시작 버튼은 11, 끝 버튼은 13( 마지막 페이지 수 )


        // ****** 6. 자료 요청, cno : 카테고리 번호, startRow(시작인덱스), count(페이지당 게시물 수) ******
        // SQL 페이징 처리 : LIMIT 시작인덱스, 개수
        // 1페이지 : LIMIT 0 , 5 / 2페이지 : LIMIT : 5 , 3페이지 : LIMIT : 10 , 5 / 4페이지 : LIMIT 15 , 5


        // ****** pageDto 구성하기 ******
        PageDto pageDto = new PageDto();
        pageDto.setCurrentPage( page );
        pageDto.setTotalPage( totalPage );
        pageDto.setPerCount( count );
        pageDto.setTotalCount( totalCount );
        pageDto.setStartBtn( startBtn );
        pageDto.setEndBtn( endBtn ); // 끝 페이징 번호
        pageDto.setData( postList ); // 페이징한 게시물 리스트

        return pageDto;




    }




} // class end
