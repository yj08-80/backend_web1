<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Title</title>
</head>
<body>
    
    <jsp:include page = "/student/header.jsp"></jsp:include>

    <div>
        <h3> 등록페이지 </h3>
        이름 : <input type="text" class="sname"/><br>
        국어점수 : <input type="text" class="skor"/><br>
        수학점수 : <input type="text" class="smath"/><br>
        <button type="button" onclick="save()">등록</button>
    </div>


    <script src="/student/save.js"></script>
</body>
</html>