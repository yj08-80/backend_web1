console.log( "example2 open" ); // **HTML에 JS 파일 연동 확인



// TalendAPI 대신에 실제로 통신 함수 만들어보기
// (1)
const func1 = () => {
    console.log( "func1 exe" );
    // *fetch 이용한 스프링 controller와 통신하기
    fetch( "/day04/exam1" , { method : "GET" } );
} // func end

// (2)
const func2 = () => {
    console.log( "func2 exe" );
    fetch( "/day04/exam2" , { method : "POST" } );
} // func end


// (3)
const func3 = () => {
    console.log( "func3 exe" );
    // +baseURL(localhost:8080)은 생략이 가능하다
    fetch( "/day04/exam3" , { method : "PUT" } );
} // func end

// (4)
const func4 = () => {
    console.log( "func4 exe" );
    // +baseURL(localhost:8080)은 생략이 가능하다
    fetch( "/day04/exam4" , { method : "DELETE" } );
} // func end

// (5)
const func5 = () =>{
    console.log( "func5 exe" );
    const name = "유재석";
    const age = 10;
    fetch( `/day04/exam5?name=${name}&age=${age}` , { method : "GET" } )
    .then( response => response.json() ) // 응답 자료를 매개변수로 받아 JSON 타입으로 변환
    .then( data => { console.log( data ); } ) // 타입변환된 자료를 매개변수로 받아 실행문 처리
    .catch( error => console.log( error) )  // 만약에 fetch 통신간에 오루 발생 시 실행문 처리
} // func end

// (6)
const func6 = () => {
    console.log( "func6 exe" );
    const name = "유재석";
    const age = "10";
    // + fetch 함수를 이용한 BODY 본문 방식,
    const option = {
        method : "POST" ,
        headers : { "Content-Type" : "application/json" } , // Http Body 타입 설정
        body : JSON.stringify( { name : name , age : age } )
        // JSON 타입으로 변환, JSON.stringfy() : JS 객체를 문자열 타입으로 변환
        // JSON.parse() : 문자열 타입 --> JS 객체 변환
    } // func end
    fetch( "/day04/exam6" , option )
    .then( r => r.json() )
    .then( data => console.log( data) )
    .catch( error => { console.log( error ) } )
}

// (7) PUT
const func7 = () => {
    let sample = { name : "유재석" , age : 10 };
    let option = {
        method : "PUT",
        headers : { "Content-Type" : "application/json" },
        body : JSON.stringify( sample ),
    } // option end
    // +
    fetch( "/day04/exam7" , option )
    .then( r => r.json() )
    .then( data => console.log( data) )
    .catch( error => { console.log( error ) } )
}

//(8) DELETE
const func8 = () => {
    let name = "유재석";
    let age = 40;
    // + option 생략
    fetch( `/day04/exam8?name=${name}&age=${age}` , { method : "DELETE" } )
    .then( r => r.json() )
    .then( data => console.log( data) )
    .catch( error => { console.log( error ) } )
}

/*

[FETCH] 라이브러리 (내장)함수
    - 외부 주소로부터 요청과 응답을 *비동기 통신* 지원하는 함수
        -> 비동기통신 : fetch , ajax(JQUERY) , axios(React)
    - 사용법
        fetch( URL , HEADER ).then( 응답매개변수 => 응답매개변수.json ).then( data => { } ).catch
            1) 통신할 URL 주소 
            2) 통신할 option
                {
                    method : "GET or POST or PUT or DELETE" ,
                    headers : { "Content-Type" : "application.json" },
                    body : JSON.stringfy()
                }
            3) .then( 응답매개변수 => 응답매개변수.json() ) : 응답 자료를 JSON 타입으로 변환
            4) .then( data => {실행문;} ) : 타입변환된 자료를 매개변수로 받아 실행문 처리
            5) catch( error => {실행문;} ) : 만약에 fetch 통신간에 오류 발생시 실행문 처리
*/