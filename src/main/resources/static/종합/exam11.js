// 1. 연동 확인
console.log( "exam11.js" );

// 2. 함수 연동 확인
// 일반 함수 선언 : function 함수명(){ }
// 람다식 함수 선언 : const 함수명 () => { }
const boardWrite = () => {
    console.log( "boardWrite() exe" )
    // 3. 함수 기능 구현 - fetch
    // (1) 보낼 데이터 객체 준비 - 샘플
    let data = { "bcontent" : "JS테스트중" , "bwriter" : "유재석" }
    // (2) fetch 옵션 : 3가지 ( method , header , body )
    let option = {
        // 1) method
        method : "POST",
        // 2) headers
        headers : { "Content-Type" : "application/json" },
        // 3) body
        body : JSON.stringify( data )
    } // option end
    // (3)fetch ( url ).then( response => response.json() ).then( data => {} )
    fetch( "/board" , option )
    .then( response => response.json() ) //응답 자료를 타입변환
    .then( data => { console.log( data ) } ) // 타입변환된 자료
    .catch( error => { console.log( error ) } ) // 에러가 발생했을 때
}

// 3.
 	
const boardPrint = () => {
    console.log( "boardPrint() exe")
    // (1) 보낼 데이터 - 없음
    // (2) fetch option , GET생략가능
    let option = { method : "GET" }
    // (3) fetch 실행
    fetch( "/board" , option )
        .then( response => response.json() )
        .then( data => { console.log(data)  } )
        .catch( error => { console.log(error ) } )
}

// 4.
const boardDelete = ( ) => {
    console.log( "boardDelete() exe" )
    // (1) 보낼 데이터 준비 - 샘플
    let bno = 3; // 존재하는 bno 아무거나
    // (2) fetch option 
    let option = { method : "DELETE" }
    // (3) fetch 실행, `백틱
    fetch( `/board?bno=${bno}` , option )
    .then( response => response.json() )
    .then( data => { console.log( data ) } )
    .catch( error => { console.log( error ) } )
}

// 5.
const boardUpdate = () => {
    console.log( "boardUpate() exe" );
    let data = { "bno" : 2 , "bcontent" : "JS에서 수정" }
    // (2) 보낼 데이터 - 샘플
    let option = {
        method : "PUT",
        headers : { "Content-Type" : "application/json" },
        body : JSON.stringify( data ) // (3) 보낼 자료
    } // option end
    // (3) fetch 실행
    fetch( "/board" , option )
    .then( response => response.json() )
    .then( data => { console.log( data ) } )
    .catch( error => { console.log( error) } )
}







