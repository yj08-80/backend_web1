
console.log( 'login.js open');

// [1] 로그인 , login 
const login = async() =>{
    // 1. 마크업을 DOM객체로 가져오기 , document(HTML뜻).query(질의)Selector(선택자) , .클래스명 , #ID
    const idInput = document.querySelector('.idInput'); // 지정한 선택자의 마크업을 DOM객체로 가져오기 
    const pwdInput =  document.querySelector('.pwdInput');
    // 2. 가져온 마크업의 입력받은 값 가져오기
    const mid = idInput.value;  // 해당 마크업의 value 속성의 값 호출 
    const mpwd = pwdInput.value; // value속성을 가진 마크업은 주로 input , textarea , select 등 입력상자
    // 3. 객체화 , 객체내 속성명과 속성값변수명이 같으면 생략가능 , 주의할점 *자바의 DTO 의 멤버변수명*과 동일
    const obj = { mid , mpwd }; // vs { "mid" : mid , "mpwd" : mpwd }
    try{ // 4. fetch 실행 
        const option = {  method : "POST",  headers : { "Content-Type" : "application/json"},  body : JSON.stringify( obj ) }
        const response = await fetch( "/member/login" , option ); // login API 요청 
        const data = await response.json();
        // 5. fetch 응답
        if( data > 0 ){ // 0보다 크면 로그인성공이고 회원번호 반환 
            alert('로그인성공');
            location.href="/index.jsp"; // 메인페이지로 이동 
        }else{
            alert('로그인실패:아이디 또는 비밀번호가 다릅니다.');
        }
    }catch{  }
} // func end 