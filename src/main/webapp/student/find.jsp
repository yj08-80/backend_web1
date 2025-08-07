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
        <h3> 전체 조회 페이지 </h3>
        <table border = 1px solid>
            <thead>
                <tr>
                    <th>번호</th>
                    <th>이름</th>
                    <th>국어 점수</th>
                    <th>수학 점수</th>
                </tr>
            </thead>
            <tbody id="studentTbody">

            </tbody>
        </table>
    </div>


    <script src="/student/find.js"></script>
</body>
</html>
