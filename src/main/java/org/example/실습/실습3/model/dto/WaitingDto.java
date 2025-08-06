package org.example.실습.실습3.model.dto;

public class WaitingDto { // class start

    // 멤버변수
    int bno;
    String phone;
    int count;

    // 기본생성자
    public WaitingDto(){ }


    // 풀생성자
    public WaitingDto(int bno, String phone, int count) {
        this.bno = bno;
        this.phone = phone;
        this.count = count;
    }

    // setter and getter

    public int getBno() {
        return bno;
    }
    public void setBno(int bno) {
        this.bno = bno;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }

    // toString()
    @Override
    public String toString() {
        return "WaitingDto{" +
                "bno=" + bno +
                ", phone='" + phone + '\'' +
                ", count=" + count +
                '}';
    }
} // class end
