package org.example.실습.실습5.model.dto;


import lombok.*;

@NoArgsConstructor //
@AllArgsConstructor
@Getter
@Setter
@ToString
public class WaitingDto { // class start

    // 멤버변수
    private int bno;
    private String phone;
    private int count;
    private String date;

} // class end
