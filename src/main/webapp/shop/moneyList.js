console.log( "moneyList.js open" );


const moneyList = async () => {
    const option = { method : "GET" };
    const response = await fetch("/money" , option );
    const data = await response.json();
    const moneyTbody = document.querySelector("#moneyTbody");



    let html = "";

    for(let i = 0; i < data.length ; i++ ) {
        const memberList = data[i];
        if (memberList.grade == 'A') {
            memberList.grade = "VIP";
        }
        if (memberList.grade == 'B') {
            memberList.grade = "일반";
        }

        if (memberList.grade == 'C') {
            memberList.grade = "직원";
        }
        html += `<tr>
                    <td> ${ moneyList.customerNo } </td>  
                    <td> ${ moneyList.customerName } </td>
                    <td> ${ moneyList.grade }</td>
                    <td> ${moneyList.sales }</td>
                </tr>`
    }

    moneyTbody.innerHTML = html;
} 

moneyList();