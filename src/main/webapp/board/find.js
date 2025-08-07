console.log( "find.js open" );

const find = async() => {
    const option = { method : "GET" };
    const response = await fetch( "/board/find" , option );
    const data = await response.json();
    console.log( data );


    const boardTbody = document.querySelector( "#boardTbody" )
    let html = "";

    for( let i = 0 ; i < data.length ; i++ ){
        const board = data[i];
        html += `<tr>
                    <td>${board.uno}</td>
                    <td>${board.phone}</td>
                    <td>${board.count}</td>
                    <td>${board.date}</td>
                </tr>`
    }
    boardTbody.innerHTML = html;

} // func end
find();