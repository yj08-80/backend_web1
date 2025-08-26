<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>view</title>
    </head>
    <body>
        
        <jsp:include part="/shop/header.jsp"></jsp:include>

        <div>
            <h3> 회원정보 수정 페이지 </h3>
            회원성명 : <div class="custnameBox"></div>
            전화번호 : <div class="phoneBox"></div>
            주소 : <div class="addressBox"></div>
            가입일자 : <div class="joindateBox"></div>
            고객등급 : <div class="gradeBox"></div>
            거주지역 : <div class="cityBox"></div>

            <button type="button" onclick="waitingUpdate()"></button>
        </div>

        <script src="/shop/view.js"></script>
    </body>
    </html>