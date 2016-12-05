<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>APM 控制台页面</title>
<link rel="stylesheet" href="css/style.default.css" type="text/css" />
<link type="text/css" href="css/jquery.simple-dtpicker.css" rel="stylesheet" />
<script type="text/javascript" src="js/highcharts/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/datetimepicker/jquery.simple-dtpicker.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/jcanvas/jcanvas.min.js"></script>
<!--[if lte IE 8]><script language="javascript" type="text/javascript" src="js/plugins/excanvas.min.js"></script><![endif]-->
<!--[if IE 9]>
    <link rel="stylesheet" media="screen" href="css/style.ie9.css"/>
<![endif]-->
<!--[if IE 8]>
    <link rel="stylesheet" media="screen" href="css/style.ie8.css"/>
<![endif]-->
<!--[if lt IE 9]>
	<script src="js/plugins/css3-mediaqueries.js"></script>
<![endif]-->
<script type="text/javascript">
var mapData = {
    "nodeDataArray": [{
        "key": "agent^USER",
        "applicationName": "USER",
        "category": "USER",
        "serviceType": "USER",
        "serviceTypeCode": "2",
        "isWas": false,
        "histogram": {
            "1s": 0,
            "3s": 0,
            "5s": 1,
            "Slow": 0,
            "Error": 0
        },
        "totalCount": 1,
        "errorCount": 0,
        "slowCount": 1,
        "hasAlert": false,
        "agentHistogram": {},
        "timeSeriesHistogram": [{
            "key": "1s",
            "values": [
                [0, 0],
                [1463212860000, 0]
            ]
        }, {
            "key": "3s",
            "values": [
                [0, 0],
                [1463212860000, 0]
            ]
        }, {
            "key": "5s",
            "values": [
                [0, 0],
                [1463212860000, 1]
            ]
        }, {
            "key": "Slow",
            "values": [
                [0, 0],
                [1463212860000, 0]
            ]
        }, {
            "key": "Error",
            "values": [
                [0, 0],
                [1463212860000, 0]
            ]
        }],
        "agentTimeSeriesHistogram": {},
        "serverList": {},
        "instanceCount": 0
    }, {
        "key": "agent^TOMCAT",
        "applicationName": "agent",
        "category": "TOMCAT",
        "serviceType": "TOMCAT",
        "serviceTypeCode": "1010",
        "isWas": true,
        "histogram": {
            "1s": 0,
            "3s": 0,
            "5s": 1,
            "Slow": 0,
            "Error": 0
        },
        "totalCount": 1,
        "errorCount": 0,
        "slowCount": 1,
        "hasAlert": false,
        "agentHistogram": {
            "agent1001": {
                "1s": 0,
                "3s": 0,
                "5s": 1,
                "Slow": 0,
                "Error": 0
            }
        },
        "timeSeriesHistogram": [{
            "key": "1s",
            "values": [
                [0, 0],
                [1463212860000, 0]
            ]
        }, {
            "key": "3s",
            "values": [
                [0, 0],
                [1463212860000, 0]
            ]
        }, {
            "key": "5s",
            "values": [
                [0, 0],
                [1463212860000, 1]
            ]
        }, {
            "key": "Slow",
            "values": [
                [0, 0],
                [1463212860000, 0]
            ]
        }, {
            "key": "Error",
            "values": [
                [0, 0],
                [1463212860000, 0]
            ]
        }],
        "agentTimeSeriesHistogram": {
            "agent1001": [{
                "key": "1s",
                "values": [
                    [0, 0],
                    [1463212860000, 0]
                ]
            }, {
                "key": "3s",
                "values": [
                    [0, 0],
                    [1463212860000, 0]
                ]
            }, {
                "key": "5s",
                "values": [
                    [0, 0],
                    [1463212860000, 1]
                ]
            }, {
                "key": "Slow",
                "values": [
                    [0, 0],
                    [1463212860000, 0]
                ]
            }, {
                "key": "Error",
                "values": [
                    [0, 0],
                    [1463212860000, 0]
                ]
            }]
        },
        "serverList": {},
        "instanceCount": 0
    }],
    "linkDataArray": [{
        "key": "agent^USER~agent^TOMCAT",
        "from": "agent^USER",
        "to": "agent^TOMCAT",
        "toAgent": [],
        "sourceInfo": {
            "applicationName": "agent",
            "serviceType": "USER",
            "serviceTypeCode": 2,
            "isWas": false
        },
        "targetInfo": {
            "applicationName": "agent",
            "serviceType": "TOMCAT",
            "serviceTypeCode": 1010,
            "isWas": true
        },
        "filterApplicationName": "agent",
        "filterApplicationServiceTypeCode": 1010,
        "filterApplicationServiceTypeName": "TOMCAT",
        "totalCount": 1,
        "errorCount": 0,
        "slowCount": 1,
        "histogram": {
            "1s": 0,
            "3s": 0,
            "5s": 1,
            "Slow": 0,
            "Error": 0
        },
        "sourceHistogram": {
            "agent1001": {
                "1s": 0,
                "3s": 0,
                "5s": 1,
                "Slow": 0,
                "Error": 0
            }
        },
        "targetHistogram": {
            "agent1001": {
                "1s": 0,
                "3s": 0,
                "5s": 1,
                "Slow": 0,
                "Error": 0
            }
        },
        "timeSeriesHistogram": [{
            "key": "1s",
            "values": [
                [0, 0],
                [1463212860000, 0]
            ]
        }, {
            "key": "3s",
            "values": [
                [0, 0],
                [1463212860000, 0]
            ]
        }, {
            "key": "5s",
            "values": [
                [0, 0],
                [1463212860000, 1]
            ]
        }, {
            "key": "Slow",
            "values": [
                [0, 0],
                [1463212860000, 0]
            ]
        }, {
            "key": "Error",
            "values": [
                [0, 0],
                [1463212860000, 0]
            ]
        }],
        "sourceTimeSeriesHistogram": {
            "agent1001": [{
                "key": "1s",
                "values": [
                    [0, 0],
                    [1463212860000, 0]
                ]
            }, {
                "key": "3s",
                "values": [
                    [0, 0],
                    [1463212860000, 0]
                ]
            }, {
                "key": "5s",
                "values": [
                    [0, 0],
                    [1463212860000, 1]
                ]
            }, {
                "key": "Slow",
                "values": [
                    [0, 0],
                    [1463212860000, 0]
                ]
            }, {
                "key": "Error",
                "values": [
                    [0, 0],
                    [1463212860000, 0]
                ]
            }]
        },
        "hasAlert": false
    }]
};

function getNodeEdgeInfo(data){
	var node_list = [];
	var edge_list = [];
	var result_dict = {};
	num_node = data['nodeDataArray'].length;
	num_edge = data['linkDataArray'].length;
	$.each(data['nodeDataArray'], function(index, item){
		node_list.push(item['key']);
	});
	$.each(data['linkDataArray'], function(index, item){
		edge_list.push([item['from'],item['to']]);
	})
	console.log(node_list);
	console.log(edge_list);
	result_dict['node'] = node_list;
	result_dict['edge'] = edge_list;
	console.log(result_dict);
	return result_dict;
}

// function drawMap(data){
// 	var topo = $('#canvas_topo');
// 	var w_1 = 160;
// 	var h_1 = 160;
// 	var canvasWidth = 800;
// 	var canvasHeight = 600;


// 	for(i=0;i<data['edge'].length;i++){
// 		topo.drawImage({
// 			layer:true,
// 			name: 'mytoto'+i,
// 			source: 'images/jcanvas/computer.png',
// 			x: 200,
// 			y: 250,
// 			scale: 0.8
// 		}).addLayerToGroup('mytopo'+i);
// 	}
// }

$(document).ready(function() {
  mapInfo = getNodeEdgeInfo(mapData);
  //drawMap(mapInfo);
  var w_1 = 68;
  var h_1 = 68;
  var canvasWidth = 800;
  var canvasHeight = 600;
  var x_1 = canvasWidth/4*1;
  var x_2 = canvasWidth/4*3;
  var y_1 = canvasHeight/2 - h_1/2;
  var y_2 = canvasHeight/2 - h_1/2;
  $('#canvas_topo').drawImage({
    layer: true,
    name: 'mytopo',
    source: 'images/jcanvas/USER.png',
    x: x_1, y: y_1,
    scale: 0.8,
    // click:function(layer){
    //   alert('Polly');
    // }
  }).drawText({
    layer: true,
    name: 'text_1',
    fillStyle: '#9cf',
    strokeStyle: '#25a',
    strokeWidth: 2,
    x: x_1, y: y_1+40,
    fontSize: 16,
    fontFamily: 'Verdana, sans-serif',
    text: 'USER'
  }).drawImage({
    layer: true,
    name: 'mytopo1',
    source: 'images/jcanvas/TOMCAT.png',
    x: x_2, y: y_2,
    scale: 0.8
  }).drawText({
    layer: true,
    name: 'text_2',
    fillStyle: '#9cf',
    strokeStyle: '#25a',
    strokeWidth: 2,
    x: x_2, y: y_2+40,
    fontSize: 16,
    fontFamily: 'Verdana, sans-serif',
    text: 'TOMCAT'
  }).drawLine({
    layer: true,
    name: 'mytopo2',
    strokeStyle: '#000',
    startArrow: true,
    arrowRadius: 15,
    strokeWidth: 5,
    x1: x_2-w_1/2, y1: y_1,
    x2: x_1+w_1/2, y2: y_2,
  }).drawText({
    layer: true,
    name: 'mytopo3',
    fillStyle: '#9cf',
    strokeStyle: '#25a',
    strokeWidth: 2,
    x: (x_1+x_2)/2, y: y_2-20,
    fontSize: 24,
    fontFamily: 'Verdana, sans-serif',
    text: '200'
  }).addLayerToGroup('mytopo','text_1','text_2', 'mytopo1','mytopo2','mytopo3');

});
</script>
</head>
<body>
<div class="bodywrapper">
    <div class="topheader">
        <div class="left">
            <h1 class="logo">APM <span>Admin</span></h1>
            <span class="slogan">后台管理系统</span>
            
            <div class="search">
                <!-- <form id="searchForm" action="getScatterData.do" method="get"> -->
                    <input type="text" id="form_from" name="from" value="" />
                    <input type="text" id="form_to" name="to" value="" />
                    <input type="hidden" id="form_limit" name="limit" value="5000" />
                    <input type="hidden" id="form_v" name="v" value="2" />
                    
                    <!-- <input type="text" name="keyword" id="keyword" value="请输入" /> -->
                    <button class="submitbutton" onClick="submitSearchForm();"></button>
                <!-- </form> -->
            </div><!--search-->
            
            <br clear="all" />
            
        </div><!--left-->
        
        <div class="right">
        	<!--<div class="notification">
                <a class="count" href="notifications.html"><span>9</span></a>
        	</div>
			-->
        	<div class="userinfo">
                <img src="images/thumbs/avatar.png" alt="" />
                <span>管理员</span>
            </div><!--userinfo-->
            
            <div class="userinfodrop">
                <div class="userdata">
                    <h4>管理员</h4>
                    <span class="email">youremail@yourdomain.com</span>
                    <ul>
                        <li><a href="index.html">退出</a></li>
                    </ul>
                </div><!--userdata-->
            </div><!--userinfodrop-->
        </div><!--right-->
    </div><!--topheader-->
    
    
    <div class="header">
    	<ul class="headermenu">
            <li class="current"><a onclick='navjump(0)'><span class="icon icon-flatscreen"></span>业务流拓扑</a></li>
            <li><a onclick='navjump(1)'><span class="icon icon-pencil"></span>业务流性能表现</a></li>
            <li><a onclick='navjump(2)'><span class="icon icon-chart"></span>应用级负载均衡</a></li>
            <li><a onclick='navjump(3)'><span class="icon icon-speech"></span>慢调用</a></li>
            <li><a onclick='navjump(4)'><span class="icon icon-message"></span>出错调用</a></li>
        </ul>
    </div><!--header-->
    <div class="pageheader">
    	<h1 class="pagetitle contenttitle2">业务流拓扑</h1>
        <!--
        <span class="pagedesc">An example of graphs &amp; charts. A page without left menu.</span>
        
        <ul class="hornav">
        	<li class="current"><a href="#charts">Charts</a></li>
            <li><a href="#statistics">Statistics</a></li>
        </ul>
        --> 
    </div><!--pageheader-->
    
    <div class="contentwrapper">
    
    	<div id="charts" class="subcontent">
    	
<!--             <iframe src="topo_canvas.html" width="100%" height="700px" seamless="seamless" scrolling="no"></iframe> -->
        	  	<div style="width:800px; height:auto; margin:0 auto;">
			   		<canvas id="canvas_topo" width="800" height="500"></canvas>
			  	</div>
        </div><!--#charts-->

        
    </div><!--contentwrapper-->
    
    
</div><!--bodywrapper-->

</body>
</html>