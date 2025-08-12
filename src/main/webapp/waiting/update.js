console.log( "update.js open" );


// [1] 개별 조회
const waitingFind = async () => {
    console.log( "waitingFind exe" );
    const bno = new URLSearchParams( location.search ).get( `bno` );
    const response = await fetch( `/waiting/find?bno=${ bno }` );
    const data = await response.json();

    document.querySelector( ".phone" ).innerHTML = data.phone;
    document.querySelector( ".count" ).innerHTML = data.count;

}
waitingFind();

// [2] 개별 수정
const waitingUpdate = async () => {
    console.log( "waitingUpdate exe" );
    const bno = new URLSearchParams( location.search ).get( "bno" );
    const phone = document.querySelector( ".phone" ).value;
    const count = document.querySelector( ".count" ).value;
    const obj = { "bno" : bno , "phone" : phone , "count" : count };

    const option = {
        method : "PUT",
        headers : { "Content-Type" : "application/json" },
        body : JSON.stringify( obj )
    }

    const response = await fetch( "/waiting" , option );
    const data = await response.json();

    if( data == true ){
        alert( "수정 성공" );
        location.href = `/waiting/view.jsp?bno=${ bno }`
    }else{
        alert( "수정 실패" );
    }
}



