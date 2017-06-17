function showMapToSetCenterOfMap() {
    var map = new BMap.Map("Map");
    map.centerAndZoom(new BMap.Point(parseFloat($('.XCoord').val()),
            parseFloat($('.YCoord').val())),
            parseInt($('.Zoom').val()));

    map.addControl(new BMap.MapTypeControl());
    //map.setCurrentCity("北京");
    map.enableScrollWheelZoom(true);

    var marker = new BMap.Marker(map.getBounds().getCenter());
    map.addOverlay(marker);

    map.addEventListener("moving", function () {
        marker.setPosition(map.getCenter());
        $('.XCoord').val(map.getCenter().lng);
        $('.YCoord').val(map.getCenter().lat);
        $('.Zoom').val(map.getZoom());
    });
    map.addEventListener("zoomend", function () {
        marker.setPosition(map.getCenter());
        $('.XCoord').val(map.getCenter().lng);
        $('.YCoord').val(map.getCenter().lat);
        $('.Zoom').val(map.getZoom());
    });
}