<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>find</title>
    </head>
    <body>
        

        <jsp:include page = "/board/header.jsp"></jsp:include>
        <div>
            <h3> 대기 현황 조회 페이지</h3>
            <table border = 1px solid>
                <thead>
                    <tr>
                        <th>대기번호</th>
                        <th>전화번호</th>
                        <th>인원수</th>
                        <th>등록시간</th>
                    </tr>
                </thead>
                <tbody id="boardTbody">

                </tbody>
            </table>
        </div>


        <script src="/board/find.js"></script>
    </body>
    </html>