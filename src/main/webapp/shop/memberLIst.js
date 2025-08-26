console.log( "memberList.js open" );


const memberList = async () => {
    const option = { method : "GET" };
    const response = await fetch( "/member" , option );
    const data = await response.json();
    const memberTbody = document.querySelector("#memberTbody");



    let html = "";
    for (let i = 0; i < data.length; i++) {
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
                    <td>${memberList.custno}</td>
                    <td> ${memberList.custname } </td>
                    <td> ${memberList.phone }</td>
                    <td> ${memberList.address }</td>
                    <td> ${memberList.joindate }</td>
                    <td> ${memberList.grade }</td>
                    <td> ${memberList.city }</td>
                </tr>`
    }
    memberTbody.innerHTML = html;
} 

memberList();