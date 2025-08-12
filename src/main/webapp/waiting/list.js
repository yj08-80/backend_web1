console.log( "list.js open" );

const waitingPrint = async () => { 
    console.log( "waitingPrint exe" );

    const response = await fetch( "/waiting" );
    const data = await response.json();
    const waitingTbody = document.querySelector( "#waitingTbody" );

    let html = "";
    for( let i = 0 ; i < data.length ; i++ ){
        const waiting = data[i];
        html += `<tr>
                    <td> ${ waiting.bno } </td>
                    <td>
                        <a href="/waiting/view.jsp?bno=${ waiting.bno }"> 
                            ${ waiting.phone } 
                        </a>
                    </td>
                    <td> ${ waiting.count } </td>
                    <td> ${ waiting.date } </td>
                </tr>`
    }

    waitingTbody.innerHTML = html;
} // func end

waitingPrint();