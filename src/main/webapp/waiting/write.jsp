<%@ page language = "java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Write</title>
</head>
<body>
    
    <jsp:include page="/waiting/header.jsp"></jsp:include>

    <div>
        <h3> 게시물 쓰기 페이지 </h3>
        전화번호 : <textarea class="phone"> </textarea><br/>
        인원수 : <input class="count"> <br/>
        <button type="button" onclick="waitingWrite()"> 등록 </button>

        <script src="/waiting/write.js"></script>
    </div>
</body>
</html>