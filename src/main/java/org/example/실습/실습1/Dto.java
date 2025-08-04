package org.example.실습.실습1;

public class Dto {
    private int bno;
    private String btitle;

    public Dto(){ }

    public Dto( int bno , String btitle ){
        this.bno = bno;
        this.btitle = btitle;
    }

    public int getBno() {
        return bno;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }

    public String getBtitle() {
        return btitle;
    }

    public void setBtitle(String btitle) {
        this.btitle = btitle;
    }
}
