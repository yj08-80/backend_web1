<%@ page language = "java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>List</title>
</head>
<body>
    
    <jsp:include page="/waiting/header.jsp"></jsp:include>
    <div>
        <h3> 게시물 전체 조회 페이지 </h3>
        <a href="/waiting/write.jsp"> 글쓰기 </a>
        <table border="1px">
            <thead>
                <tr>
                    <th>대기번호</th>
                    <th>연락처</th>
                    <th>인원수</th>
                    <th>등록시간</th>
                </tr>
            </thead>
            <tbody id="waitingTbody">

            </tbody>
        </table>
    </div>

    <script src="/waiting/list.js"></script>
</body>
</html>