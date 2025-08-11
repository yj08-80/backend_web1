package org.example.day08._1의존성;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// ===== [ 방법1 ] 해당 인스턴스를 직접(new) 생성하여 메소드 호출
class SampleDoa1{
    void method1(){ }
}
class SampleController1{
    // 다른 클래스의 메소드 호출방법
    SampleDoa1 sampleDoa1 = new SampleDoa1();
    public void method2(){
        sampleDoa1.method1();
    }
}

// ===== [ 방법2 ] 해당 인스턴스를 미리(new) 생성하여 메소드 호출 = 싱글톤
class SampleDao2{
    // 미리 인스턴스를 만들어둔다 == 싱글톤
    private static final SampleDao2 instance = new SampleDao2();
    private SampleDao2(){}
    public static SampleDao2 getInstance(){
        return instance;
    }
    public void method1(){ }
}
class SampleController2{
    private final SampleDao2 sampleDao2 = SampleDao2.getInstance();
    public void method2(){
        sampleDao2.method1();
    }
}
// ===== [ 방법3 ] IOC와 DI
@Component // 스프링 컨테이너(저장소)에 빈 등록, 스프링 실행 시 *자동*으로 인스턴스 생성
class SampleDao3{
    void method1(){ }
}

// DI 방법1
class SampleController3{
    @Autowired // 스프링 컨테이너(저장소)에 등록된 빈( 스프링컨테이너에 저장된 인스턴스) 꺼내서 멤버변수에 주입

    private SampleDao3 sampleDao3; // = new sampleDao3();


    void method2(){
        sampleDao3.method1();
    }
}

// DI 방법2 *Spring 공식 권장

class SampleController4{

    private final SampleDao3 sampleDao3; // final( 수정 불가능 키워드 , 초기값 필수 ) 사용함으로 불변성 보장

    @Autowired // 생성자에 빈 주입 함으로써
    public SampleController4( SampleDao3 sampleDao3 ){
        this.sampleDao3 = sampleDao3;
    }
    void method2(){
        sampleDao3.method1();
    }
}





public class Dependency { // class start
} // class end













