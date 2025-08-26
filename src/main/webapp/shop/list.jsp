<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>list</title>
</head>
<body>
    
    <jsp:include page="/shop/header.jsp"></jsp:include>

    <div>
        <h3> 회원목록조회/수정 </h3>
        <a href="/shop/write.jsp"> 수정 </a>
        <table border="1px solid">
            <thead>
                <tr>
                    <th>회원번호</th>
                    <th>회원성명</th>
                    <th>전화번호</th>
                    <th>주소</th>
                    <th>가입일자</th>
                    <th>고객등급</th>
                    <th>거주지역</th>
                </tr>
            </thead>
            <tbody id="shopTbody">

            </tbody>
        </table>

    </div>

    <script src="/shop/list.js"></script>
</body>
</html>