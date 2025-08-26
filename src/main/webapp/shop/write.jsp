<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
</head>
<body>
    <jsp:include page="/shop/header.jsp"></jsp:include>
    <div>
        <h3> 홈쇼핑 회원 등록 </h3>
        회원번호(자동발생) <input type="text" class="custno" disabled > <br/>
        회원성명 : <input type="text" class="custname" /> <br/>
        회원전화 : <input type="text" class="phone" /> <br/>
        회원주소 : <input type="text" class="address" /> <br/>
        가입일자 : <input type="text" class="joindate" placeholder="20001122" /> <br/>
        고객등급 : <input type="text" class="grade" /> <br/>
        도시코드 : <input type="text" class="city" /> <br/>

        <button type="button" onclick="memberWrite()"> 등록 </button>
        <button type="button" onclick=" location.href='/shop/memberList.jsp'">조회</button>
    </div>
    <jsp:include page="/shop/footer.jsp"></jsp:include>
    <script src="/shop/write.js"></script>
</body>
</html>