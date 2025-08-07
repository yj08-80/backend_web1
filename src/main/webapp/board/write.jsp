<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>write</title>
    </head>
    <body>
        <jsp:include page = "/board/header.jsp"></jsp:include>

        <div>
            전화번호 : <input type="text" class="phone"/><br>
            인원수 : <input type="number" class="count"/><br>
            <button type="button" onclick="write()">등록</button>
        </div>


        <script src="/board/write.js"></script>
    </body>
    </html>