console.log( "view.js open" );


// [1] 개별조회
const waitingFind = async () => {
    console.log( "waitingFind exe" );

    const url = new URLSearchParams( location.search );
    const bno = url.get( 'bno' );
    const response = await fetch( `/waiting/find?bno=${bno}` )
    const data = await response.json();

    const phoneBox = document.querySelector( ".phoneBox");
    const countBox = document.querySelector( ".countBox" );
    const dateBox = document.querySelector( ".dateBox" );
    
    const phone = data.phone;
    const count = data.count;
    const date = data.date;

    phoneBox.innerHTML = phone;
    countBox.innerHTML = count;
    dateBox.innerHTML = date;

}
waitingFind();


// [2] 삭제
const waitingDelete = async () => {
    console.log( "boardDelete exe" );
    const bno = new URLSearchParams( location.search ).get( "bno" );

    let check = confirm( "정말 삭제하시겠습니까?" );
    if( check == true ){
        const option = { method : "DELETE" };
        const response = await fetch( `/waiting?bno=${bno}` , option );
        const data = await response.json();

        if( data == true ){
            alert( "삭제 성공" );
            location.href = "/waiting/list.jsp";
        }else{
            alert( "삭제 실패" );
        }
    }
}


// [3] 수정페이지 이동
const waitingUpdateView = () => {
    const bno = new URLSearchParams( location.search ).get( "bno" );
    location.href = `/waiting/update.jsp?bno=${ bno }`;
}