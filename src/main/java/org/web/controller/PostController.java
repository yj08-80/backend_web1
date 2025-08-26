package org.web.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.web.model.dto.PageDto;
import org.web.model.dto.PostDto;
import org.web.service.PostService;

@RestController // (1) HTTP 요청/응답 자료 매핑 기술
@RequestMapping("/post") // (2) HTTP URL 매핑 기술
@RequiredArgsConstructor // (3) final 변수에 대한 자동 생성자 주입
public class PostController {

    private final PostService postService; // @RequiredArgsConstructor 사용함으로 @Autowired 생략 한다.

    // [1] 게시물 등록
    @PostMapping("")
    public int writePost(@RequestBody PostDto postDto, HttpSession session) {
        // 1) 세션에서 Integer로 안전하게 꺼내기
        Integer mno = (Integer) session.getAttribute("loginMno");
        if (mno == null) return -1; // -1: 로그인 세션 없음

        // 2) 세션의 mno 주입
        postDto.setMno(mno);

        // 3) 서비스 호출: 성공 시 생성된 pno, 실패 시 0 또는 음수 코드
        int pno = postService.writePost(postDto);
        return (pno > 0) ? pno : -2; // -2: DB/비즈니스 실패
    } // func end

    // [2] 게시물 전체 조회
    @GetMapping("") // method : Get URL : localhost:8080/post?cno=1&page=1&count=5
    public PageDto findAllPost(@RequestParam( defaultValue = "1" ) int cno ,
                               @RequestParam( defaultValue = "1" ) int page ,
                               @RequestParam( defaultValue = "5" ) int count ){
        // 만약에 URL 주소상의 쿼리스트링 매개변수가 없으면 defaultValue 속성으로 기본값 대입할 수 있다.
        return postService.findALlPost( cno, page, count );
    } // func end

} // class end









