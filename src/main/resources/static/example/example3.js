console.log( "example3.js open" );


// (1) 비동기 fetch
// 람다식 함수 : const func1 = () => { }
// 선언적 함수 : function func1(){ }
const func1 = () => {
//(fetch) fetch가 실행되고 결과(response)가 오기 전에 다음 코드로 넘어감
// 즉 JS는 응답을 기다리지 않는다
    console.log( '[1] fetch 전' );

    const option = { method : "GET" }
    fetch( "/day06/exam1" , option )
    .then( response => response.json() )
    .then( data => { console.log( data ) } )
    console.log( '[2] fetch 통신 결과' )
    .catch( error => { console.log( error ) } )

    console.log( '[3] fetch 후')
    // 코드 실행 예측 : [1] - [2] - [3]
    // 결과 : [1] - [3] - [2]
} // func end


// (2) 동기 fetch : 하나의 흐름 (await, async 사용)
const func2 = async () => {   // ★ async 키워드 추가!
    console.log('[1] fetch 전');
    const option = { method: "get" }
    // await는 Promise가 끝날 때까지 기다림
    try{
        const response = await fetch("/day06/exam1", option);
        // fetch 결과를 JSON 객체로 변환
        const data = await response.json();
        console.log(data);
        console.log('[2] fetch 통신 결과');
    }catch( error ){
        console.log( error );
    }
    console.log('[3] fetch 후');
}









