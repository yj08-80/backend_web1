package org.example.실습.실습4;


import lombok.*;

// 기본생성자
@NoArgsConstructor
// 풀생성자
@AllArgsConstructor
// getter and setter
@Getter
@Setter
// toString
@ToString
public class BoardDto { // class start

    // 멤버변수
    private int uno;
    private String phone;
    private int count;
    private String date;
} // class end
