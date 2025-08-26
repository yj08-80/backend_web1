// [1] 회원 등록
const memberWrite = async() => {
   
    const custname = document.querySelector('.custname').value;
    const phone = document.querySelector('.phone').value;
    const address = document.querySelector('.address').value;
    const joindate = document.querySelector('.joindate').value;
    const grade = document.querySelector('.grade').value;
    const city = document.querySelector('.city').value;

    if (custname.trim() == '') {
        alert("회원성명이 입력되지 않았습니다");
        return;
    }

    
    const object = { custname, phone, address, joindate, grade, city };

    const option = {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(object)
    };

    const response = await fetch("/shop", option);
    const data = await response.json();
    if (data == true) {
        alert('회원 등록이 완료되었습니다');
        location.href = "/shop/memberList.jsp";
    } else {
        alert('회원 등록에 실패했습니다');
    }
}

const custno = async() => {
    const custno = document.querySelector('.custno');
    const response = await fetch("/shop/custno");
    const data = await response.json();
    custno.value = data;
}
custno();