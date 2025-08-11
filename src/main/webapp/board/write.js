console.log("write.js open");

const _write = async () => {
    alert("write 함수 실행됨!");
    const phoneInput = document.querySelector(".phone");
    const countInput = document.querySelector(".count");

    const phone = phoneInput.value;
    const count = countInput.value;

    console.log(phone);   // 이제 이게 반드시 찍혀야 정상!
    console.log(count);

    const object = { phone, count };

    const option = {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(object)
    };

    const response = await fetch("/board/write", option);
    const data = await response.json();

    if (data == true) {
        alert("등록 성공");
        location.href="/board/find.jsp";
        alert("등록 실패");
    }
};