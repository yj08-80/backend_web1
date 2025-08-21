console.log("product.js open");

// 1. 카카오 지도로 위도 경도 받아오기

let latlng = null;
const getMap = async () => {
    var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
        mapOption = {
            center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
            level: 3 // 지도의 확대 레벨
        };

    var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

    // 지도를 클릭한 위치에 표출할 마커입니다
    var marker = new kakao.maps.Marker({
        // 지도 중심좌표에 마커를 생성합니다 
        position: map.getCenter()
    });
    // 지도에 마커를 표시합니다
    marker.setMap(map);

    // 지도에 클릭 이벤트를 등록합니다
    // 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
    kakao.maps.event.addListener(map, 'click', function (mouseEvent) {

        // ***** 클릭한 위도, 경도 정보를 가져옵니다 -> 전역변수로 전환 *****
        latlng = mouseEvent.latLng;

        // 마커 위치를 클릭한 위치로 옮깁니다
        marker.setPosition(latlng);

        var message = '클릭한 위치의 위도는 ' + latlng.getLat() + ' 이고, ';
        message += '경도는 ' + latlng.getLng() + ' 입니다';

        var resultDiv = document.getElementById('clickLatlng');
        resultDiv.innerHTML = message;

    });

} // func end

getMap();

// 2. 제품 등록
const onCreate = async() => {
    // 입력받은 값들을 하나씩 가져오는 방ㅂ버이 아닌
    // *form 전체를 한 번에 가져오는 방법*
    // 주의할 점 : form 안에 속성명은 name으로 자바의 dto 일치하게 한다

    // 1. 전송할 폼 가져오기
    const productForm = document.querySelector( "#productForm");

    // 2. 대용량 첨부파일 폼 전환
    const productFormData = new FormData( productForm );
    
    // 위도경도는 폼 안에서 입력받은 형식이 아닌 JS에서 표현한 것으로 직접 폼에 넣기
    productFormData.append( "plat" , latlng.getLat() ); // 위도
    productFormData.append( "plng" , latlng.getLng() ); // 경도

    // fetch 보내기
    const option = { method : "POST" , body : productFormData }
    const response = await fetch( '/product/create' , option );
    const data = await response.json(); 

    if( data > 0 ){
        alert( "등록 성공" );
    }else{
        alert( "등록 실패" );
    }

} // func end