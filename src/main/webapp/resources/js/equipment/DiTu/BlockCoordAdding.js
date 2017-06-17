var blockAddingMap;
function showMapToAddCoord() {
    blockAddingMap = new BMap.Map("MapToAddCoord");
    var mapSetting = $('.mapSetting').first();
    blockAddingMap.centerAndZoom(new BMap.Point(parseFloat(mapSetting.attr('data-initialLongtitude')),
            parseFloat(mapSetting.attr('data-initialLatitude'))),
            parseInt(mapSetting.attr('data-zoom')));

    blockAddingMap.addControl(new BMap.MapTypeControl());
    //map.setCurrentCity("北京");
    blockAddingMap.enableScrollWheelZoom(true);
    blockAddingMap.addEventListener("click", addBlock);
}
function addBlock(event) {
    var point = new BMap.Point(event.point.lng, event.point.lat);
    $('.LongtitudeInBlockCoordAddingEditDialog').val(event.point.lng);
    $('.LatitudeInBlockCoordAddingEditDialog').val(event.point.lat);
    //var marker = new BMap.Marker(point);
    //blockAddingMap.addOverlay(marker);
    PF('BlockCoordAddingEditDialog').show();
}