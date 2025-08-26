package org.example.day10;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor // 기본 생성자
@AllArgsConstructor // 전체 매개변수 생성자
@Data // setter,getter,Tostring 한 번에 가능
public class LoginDto {
    private int mno; // 회원번호
    private String mid; // 회원아이디
    private String mpw; // 회원비밀번호
}
