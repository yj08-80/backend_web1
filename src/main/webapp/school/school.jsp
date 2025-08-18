<%@ page language = "java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link href="/css/kakao/datamap.css" rel="stylesheet"/>


</head>
<body>

    <div id="container">
        <!-- KAKAO 지도가 출력되는 DIV -->
        <div id="map" style="width:500px;height:400px;"></div>
        <div id="sidebar"></div>

    </div>



    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=65c4b3d296c9a07e1e693fb5a6a607b5&libraries=clusterer"></script>
    
    <script src="/js/school/school.js"></script>

</body>
</html>
