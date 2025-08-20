
<%@ page language = "java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' href='/css/member/update.css'>
</head>
<body>
    
    <jsp:include page="/header.jsp"></jsp:include>
    
    <div id="container">
        <h3> 수정 페이지 </h3>
        <div>회원번호 : <span class="mno"> </span> </div>
        <div>아이디 : <span class="mid"> </span> </div>
        <div>이름 : <input class="mname"> </div>
        <div>연락처  : <input class="mphone"> </span> </div>
        <button type="button" onclick="onUpdate()"> 수정 </button>
    </div>
    
    <script src="/js/member/update.js"></script>
    
</body>
</html>