<%@ page language = "java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update</title>
</head>
<body>
    

    <jsp:include page="/waiting/header.jsp"></jsp:include>
    <div>
        <h3> 수정 페이지 </h3>
        전화번호 : <input type="text" class="phone"></input></br>
        인원수 : <input type="text" class="count"></input></br>
        <button type="button" onclick="waitingUpdate()"> 수정 </button>
    </div>

    <script src="/waiting/update.js"></script>
</body>
</html>