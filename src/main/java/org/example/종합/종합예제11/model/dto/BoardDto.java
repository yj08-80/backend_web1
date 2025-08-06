package org.example.종합.종합예제11.model.dto;

public class BoardDto { // class start

    private int bno;
    private String bcontent;
    private String bwriter;

    // + 빈생성자 : @RequestXXX 사용한다
    public BoardDto(){ }


    // 풀생성자
    public BoardDto(int bno, String bcontent, String bwriter) {
        this.bno = bno;
        this.bcontent = bcontent;
        this.bwriter = bwriter;
    }

    // getter and setter
    public int getBno() {
        return bno;
    }
    public void setBno(int bno) {
        this.bno = bno;
    }
    public String getBcontent() {
        return bcontent;
    }
    public void setBcontent(String bcontent) {
        this.bcontent = bcontent;
    }
    public String getBwriter() {
        return bwriter;
    }
    public void setBwriter(String bwriter) {
        this.bwriter = bwriter;
    }


    // toString
    @Override
    public String toString() {
        return "BoardDto{" +
                "bno=" + bno +
                ", bcontent='" + bcontent + '\'' +
                ", bwriter='" + bwriter + '\'' +
                '}';
    }
} // class end
