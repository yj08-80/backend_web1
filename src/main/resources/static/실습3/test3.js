// 1. 연동 확인
console.log( "test3.js" );

// 2. 함수 연동 확인
const waitingWrite = () => {
    console.log( "waitingWrite() exe" )

    // 3. 함수 기능 구현 - fetch
    // (1) 보낼 데이터 객체 준비 - 샘플

    let data = { "phone" : "JS테스트중" , "count" : 2 }
    let option = {
        method : "POST",
        headers : { "Content-Type" : "application/json" },
        body : JSON.stringify( data )
    }

    fetch( "/waiting" , option )
    .then( response => response.json() )
    .then( data => { console.log( data ) } )
    .catch( error => { console.log( error ) } )
}


// 3.
const waitingPrint = () => {
    console.log( "waitingPrint() exe")
    let option = { method : "GET" }
    fetch( "/waiting" , option )
        .then( response => response.json() )
        .then( data => { console.log(data)  } )
        .catch( error => { console.log(error ) } )
}

// 4.

const waitingDelete = ( ) => {
    let bno = 2;
    let option = { method : "DELETE" }
    fetch( `/waiting?bno=${bno}` , option )
        .then( response => response.json() )
        .then( data => { console.log( data ) } )
        .catch( error => { console.log( error ) } )
}

// 5.
const waitingUpdate = () => {
    console.log( "waitingUpdate() exe" );
    let data = { "bno" : 5 , "count" : 10 }
    let option = {
        method : "PUT",
        headers : { "Content-Type" : "application/json" },
        body : JSON.stringify( data )
    }
    fetch( "/waiting" , option )
    .then( response => response.json() )
    .then( data => { console.log( data ) } )
    .catch( error => { console.log( error) } )
}










