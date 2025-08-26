<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel="stylesheet" href="/shop/assets/style.css">
</head>
<body>

    <jsp:include page="/shop/header.jsp"></jsp:include>
    <div>
        <h3> 회원매출조회 </h3>
        <table border="1px solid">
            <thead>
                <tr>
                    <th> 회원번호 </th> 
                    <th> 회원성명 </th> 
                    <th> 고객등급 </th> 
                    <th> 매출 </th>
                </tr>
            </thead>
            <tbody id="moneyTbody">
            </tbody>
        </table>
    </div>
    <jsp:include page="/shop/footer.jsp"></jsp:include>

    <script src="/shop/moneyList.js"></script>

</body>
</html>