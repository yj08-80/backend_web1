<%@ page language = "java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>view</title>
</head>
<body>
    
    <jsp:include page="/waiting/header.jsp"></jsp:include>

    <div>
        <h3> 게시물 상세 페이지 </h3>
        전화번호 : <div class="phoneBox"></div>
        인원수 : <div class="countBox"></div>
        날짜 : <div class="dateBox"></div>
        <button type="button" onclick="waitingDelete()">삭제</button>
        <button type="button" onclick="waitingUpdateView()">수정</button>

        <script src="/waiting/view.js"></script>
    </div>
</body>
</html>