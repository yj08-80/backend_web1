<%@ page language = "java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>view</title>
</head>
<body>
    <jsp:include page="/board/header.jsp"></jsp:include>

    <div>
        <h3>게시물 상세 페이지</h3>
        작성자 : <div class="bwriterBox"></div>
        내용 : <div class="bcontentBox"></div>
        <button type="button" onclick="boardDelete()">삭제</button>
        <button type="button" onclick="boardUpdateView()">수정</button>
    </div>

    <script src="/board/view.js"></script>
</body>
</html>