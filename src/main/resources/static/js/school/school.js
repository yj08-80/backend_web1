console.log( "school.js open" );


// [1] 공공데이터
const dataAPI = async() => {
    const serviceKey = "IyP69fVIVjV1aAxlHLrB8nFMh8eVGNaEnOSVOR4Dz8N6oDm1l%2Bfo2cSoeC4SEJCPVmLslLj3QFz0%2FlsgUoVsMQ%3D%3D"
    const URL = "https://api.odcloud.kr/api/15039731/v1/uddi:1fcb72a0-ba75-4c97-a045-9ef7e3ef43c0?page=1&perPage=10&serviceKey="

    const response = await fetch( URL+serviceKey , { method : "GET" } );
    const data = await response.json();
    console.log( data );

    const sidebar = document.querySelector( "#sidebar" );
    let html = "";
    data.data.forEach( (value ) => {
        html += `<div id="store">
                        <div> 학교명 :  ${ value.학교명 } </div>
                        <div> 전화번호 : ${ value.행정실 } </div>
                        <div> 주소 : ${ value.주소 } </div>
                    </div>`
    });
    sidebar.innerHTML = html;
}
dataAPI();

// [2] 카카오맵 클러스터 라이브러리
const kakaoMap = async() => {
    var map = new kakao.maps.Map( document.getElementById( "map" ),
    { center : new kakao.maps.LatLng( 37.4240840, 126.6487610 ), level : 7 });

    

    var clusterer = new kakao.maps.MarkerClusterer({
        map : map,
        averageCenter : true, 
        minLevel : 6,
        disableClickZoom : true
    });

    const serviceKey = "IyP69fVIVjV1aAxlHLrB8nFMh8eVGNaEnOSVOR4Dz8N6oDm1l%2Bfo2cSoeC4SEJCPVmLslLj3QFz0%2FlsgUoVsMQ%3D%3D"
    const URL = "https://api.odcloud.kr/api/15039731/v1/uddi:1fcb72a0-ba75-4c97-a045-9ef7e3ef43c0?page=1&perPage=10&serviceKey="
    const response = await fetch( URL + serviceKey , { method : "GET" } );
    const data = await response.json();
    console.log( data );


    let markers = data.data.map( ( value ) => {
        let marker = new kakao.maps.Marker({
            position : new kakao.maps.LatLng( value.위도 , value.경도 )
        });
        
        kakao.maps.event.addListener( marker , 'click' , () => {
            const sidebar = document.querySelector( "#sidebar" );
            let html = ` <button type="button" onclick="dataAPI()"> 전체보기 </button>
                        <div id="store">
                            <div> 학교명 :  ${ value.학교명 } </div>
                            <div> 전화번호 : ${ value.행정실 } </div>
                            <div> 주소 : ${ value.주소 } </div>
                        </div>`;
            sidebar.innerHTML = html;
        })
        return marker;
    });
    clusterer.addMarkers( markers );

    kakao.maps.event.addListener( clusterer , "clusterclick" , function( cluster ){
        var level = map.getLevel() -1;
        map.setLevel( level , { anchor : cluster.getCenter()});
    } )
}
kakaoMap();
    

