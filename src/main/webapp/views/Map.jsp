<%-- 
    Document   : Map
    Created on : 2017-6-17, 9:50:56
    Author     : Aaron-PC-i3-4130
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" src="http://api.map.baidu.com/api?v=1.4"></script>
        <style type="text/css">
            body, html {width: 100%;height: 100%;margin:0;font-family:"微软雅黑";}
            #allmap{width:100%;height:100%;}
            p{margin-left:5px; font-size:14px;}
        </style>
    </head>
    <body>
        <div id="allmap"></div>
    </body>
</html>
<script type="text/javascript">
    var map = new BMap.Map("allmap");
    map.centerAndZoom(new BMap.Point(116.4035, 39.915), 8);
</script>
