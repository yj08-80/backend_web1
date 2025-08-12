console.log( "write.js open" );

const waitingWrite = async () => {
    console.log( "waitingWrite open" );

    const phone = document.querySelector( ".phone" ).value;
    const count = document.querySelector( ".count" ).value;

    const obj = { "phone" : phone , "count" : count };
    const option = {
        method : "POST",
        headers : { "Content-Type" : "application/json" },
        body : JSON.stringify( obj )
    }

    const response = await fetch( "/waiting" , option );

    const data = await response.json();

    if( data == true ){
        alert( "글쓰기 성공" );
        location.href = "/waiting/list.jsp";
    }else{
        alert( "글쓰기 실패" );
    }

}