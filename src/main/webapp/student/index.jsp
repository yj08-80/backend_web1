<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Page Title</title>
</head>
<body>

    <!-- 현재 JSP 파일 내 다른 JSP 포함하기 -->
    <jsp:include page = "/student/header.jsp"></jsp:include>
    <div>
        <h3> 메인 페이지 </h3>
        <p> localhost:8080/student/index.jsp </p>
    </div>



</body>
</html>