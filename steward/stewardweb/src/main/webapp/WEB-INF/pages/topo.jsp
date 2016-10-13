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
<title>APM 应用拓扑</title>
<link rel="stylesheet" href="css/style.default.css" type="text/css" />
<link type="text/css" href="css/jquery.simple-dtpicker.css" rel="stylesheet" />
<script type="text/javascript" src="js/highcharts/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/datetimepicker/jquery.simple-dtpicker.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/jcanvas/jcanvas.min.js"></script>
<script type="text/javascript" src="js/d3/d3.v3.min.js" charset="utf-8"></script>
<script type="text/javascript" src="js/custom/general.js"></script>
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
<style>
.nodetext {
    font-size: 12px ;
    font-family: SimSun;
    fill:#000000;
}
.linetext {
    font-size: 12px ;
    font-family: SimSun;
    fill:#0000FF;
    fill-opacity:0.0;
}
</style>
<script type="text/javascript">
var mapData = {
    "applicationMapData":{
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
    }
};

function getNodeEdgeInfo(data){
    var node_list = [];
    var node_name_list = [];
    var edge_list = [];
    var result_dict = {};
    var num_node = data['nodeDataArray'].length;
    var num_edge = data['linkDataArray'].length;
    $.each(data['nodeDataArray'], function(index, item){
        var name = item['applicationName'];
        var image = item['serviceType']=='UNKNOWN'?'UNKNOWN':item['serviceType'];
        node_list.push({
            'name': name,
            'image': 'images/d3/'+ image +'.png'
        });
        node_name_list.push(item['key']);
        /*
        node_list.push({
            'name': item['serviceType']=='UNKNOWN'?item['applicationName']:item['serviceType'],
            'image': 'images/d3/'+ item['serviceType'] +'.png'
        });
        node_name_list.push(item['serviceType']=='UNKNOWN'?item['applicationName']:item['serviceType']);
        */
    });
    $.each(data['linkDataArray'], function(index, item){
        var source = node_name_list.indexOf(item['from']);
        var target = node_name_list.indexOf(item['to']);
        if(source!=target){
            edge_list.push({
                'source': source, 
                'target': target, 
                'relation': '事务数 '+item['totalCount']
            });
        }
        /*
        var source = item['sourceInfo']['serviceType']=='UNKNOWN'?node_name_list.indexOf(item['sourceInfo']['applicationName']):node_name_list.indexOf(item['sourceInfo']['serviceType']);
        var target = item['targetInfo']['serviceType']=='UNKNOWN'?node_name_list.indexOf(item['targetInfo']['applicationName']):node_name_list.indexOf(item['targetInfo']['serviceType']);
        if(source!=target){
            edge_list.push({
                'source': source, 
                'target': target, 
                'relation': '事务数 '+item['totalCount']
            });
        }
        */
        /*
        edge_list.push({
            'source': node_name_list.indexOf(item['sourceInfo']['serviceType'])=='UNKNOWN'?node_name_list.indexOf(item['sourceInfo']['applicationName']):node_name_list.indexOf(item['sourceInfo']['serviceType']), 
            'target': node_name_list.indexOf(item['targetInfo']['serviceType'])=='UNKNOWN'?node_name_list.indexOf(item['targetInfo']['applicationName']):node_name_list.indexOf(item['targetInfo']['serviceType']), 
            'relation': '事务数 '+item['totalCount']
        });
        */
    });
    result_dict['nodes'] = node_list;
    result_dict['edges'] = edge_list;
    //console.log(result_dict);
    // $.each(node_list, function(index, item){
    //     console.log(index+' : '+item['name']);
    // });
    // $.each(edge_list, function(index, item){
    //     console.log(item['source']+'***'+item['target']+' : '+item['relation']);
    // });
    return result_dict;
}

function drawTopo(mapData){
    var root = getNodeEdgeInfo(mapData["applicationMapData"]);
    // console.log('root:'+root);
    var width = 800;
    var height = 600;
    var img_w = 70;
    var img_h = 70;

    var svg = d3.select("#topo").append("svg")
                            .attr("width",width)
                            .attr("height",height);
        
    var force = d3.layout.force()
                    .nodes(root.nodes)
                    .links(root.edges)
                    .size([width,height])
                    .linkDistance(250)
                    .charge(-1500)
                    .start();
                    
    var edges_line = svg.selectAll("line")
                        .data(root.edges)
                        .enter()
                        .append("line")
                        .style("stroke","#CCC")
                        .style("stroke-width",2);
                        
    var edges_text = svg.selectAll(".linetext")
                        .data(root.edges)
                        .enter()
                        .append("text")
                        .attr("class","linetext")
                        .style("fill-opacity", 1.0)
                        .text(function(d){
                            return d.relation;
                        });

                        
    var nodes_img = svg.selectAll("image")
                        .data(root.nodes)
                        .enter()
                        .append("image")
                        .attr("width",img_w)
                        .attr("height",img_h)
                        .attr("xlink:href",function(d){
                            return d.image;
                        })
                        // .on("mouseover",function(d,i){
                        //     //显示连接线上的文字
                        //     edges_text.style("fill-opacity",function(edge){
                        //         if( edge.source === d || edge.target === d ){
                        //             return 1.0;
                        //         }
                        //     });
                        // })
                        // .on("mouseout",function(d,i){
                        //     //隐去连接线上的文字
                        //     edges_text.style("fill-opacity",function(edge){
                        //         if( edge.source === d || edge.target === d ){
                        //             return 1.0;
                        //         }
                        //     });
                        // })
                        .call(force.drag);

    var text_dx = -15;
    var text_dy = 15;

    var nodes_text = svg.selectAll(".nodetext")
                        .data(root.nodes)
                        .enter()
                        .append("text")
                        .attr("class","nodetext")
                        .attr("dx",text_dx)
                        .attr("dy",text_dy)
                        .text(function(d){
                            return d.name;
                        });

                        
    force.on("tick", function(){
        
        //限制结点的边界
        root.nodes.forEach(function(d,i){
            d.x = d.x - img_w/2 < 0     ? img_w/2 : d.x ;
            d.x = d.x + img_w/2 > width ? width - img_w/2 : d.x ;
            d.y = d.y - img_h/2 < 0      ? img_h/2 : d.y ;
            d.y = d.y + img_h/2 + text_dy > height ? height - img_h/2 - text_dy : d.y ;
        });

        //更新连接线的位置
         edges_line.attr("x1",function(d){ return d.source.x; });
         edges_line.attr("y1",function(d){ return d.source.y; });
         edges_line.attr("x2",function(d){ return d.target.x; });
         edges_line.attr("y2",function(d){ return d.target.y; });
         
         //更新连接线上文字的位置
         edges_text.attr("x",function(d){ return (d.source.x + d.target.x) / 2 ; });
         edges_text.attr("y",function(d){ return (d.source.y + d.target.y) / 2 ; });
         
         
         //更新结点图片和文字
         nodes_img.attr("x",function(d){ return d.x - img_w/2; });
         nodes_img.attr("y",function(d){ return d.y - img_h/2; });
         
         nodes_text.attr("x",function(d){ return d.x });
         nodes_text.attr("y",function(d){ return d.y + img_w/2; });
    });
}

function updateTopo(mapData){
    var root = getNodeEdgeInfo(mapData["applicationMapData"]);
    // console.log('root:'+root);
    var width = 800;
    var height = 600;
    var img_w = 70;
    var img_h = 70;
    d3.select("svg").remove();
    var svg = d3.select("#topo").append("svg")
                            .attr("width",width)
                            .attr("height",height);
        
    var force = d3.layout.force()
                    .nodes(root.nodes)
                    .links(root.edges)
                    .size([width,height])
                    .linkDistance(250)
                    .charge(-1500)
                    .start();
                    
    var edges_line = svg.selectAll("line")
                        .data(root.edges)
                        .enter()
                        .append("line")
                        .style("stroke","#CCC")
                        .style("stroke-width",2);
                        
    var edges_text = svg.selectAll(".linetext")
                        .data(root.edges)
                        .enter()
                        .append("text")
                        .attr("class","linetext")
                        .style("fill-opacity", 1.0)
                        .text(function(d){
                            return d.relation;
                        });

                        
    var nodes_img = svg.selectAll("image")
                        .data(root.nodes)
                        .enter()
                        .append("image")
                        .attr("width",img_w)
                        .attr("height",img_h)
                        .attr("xlink:href",function(d){
                            return d.image;
                        })
                        // .on("mouseover",function(d,i){
                        //     //显示连接线上的文字
                        //     edges_text.style("fill-opacity",function(edge){
                        //         if( edge.source === d || edge.target === d ){
                        //             return 1.0;
                        //         }
                        //     });
                        // })
                        // .on("mouseout",function(d,i){
                        //     //隐去连接线上的文字
                        //     edges_text.style("fill-opacity",function(edge){
                        //         if( edge.source === d || edge.target === d ){
                        //             return 1.0;
                        //         }
                        //     });
                        // })
                        .call(force.drag);

    var text_dx = -15;
    var text_dy = 15;

    var nodes_text = svg.selectAll(".nodetext")
                        .data(root.nodes)
                        .enter()
                        .append("text")
                        .attr("class","nodetext")
                        .attr("dx",text_dx)
                        .attr("dy",text_dy)
                        .text(function(d){
                            return d.name;
                        });

                        
    force.on("tick", function(){
        
        //限制结点的边界
        root.nodes.forEach(function(d,i){
            d.x = d.x - img_w/2 < 0     ? img_w/2 : d.x ;
            d.x = d.x + img_w/2 > width ? width - img_w/2 : d.x ;
            d.y = d.y - img_h/2 < 0      ? img_h/2 : d.y ;
            d.y = d.y + img_h/2 + text_dy > height ? height - img_h/2 - text_dy : d.y ;
        });

        //更新连接线的位置
         edges_line.attr("x1",function(d){ return d.source.x; });
         edges_line.attr("y1",function(d){ return d.source.y; });
         edges_line.attr("x2",function(d){ return d.target.x; });
         edges_line.attr("y2",function(d){ return d.target.y; });
         
         //更新连接线上文字的位置
         edges_text.attr("x",function(d){ return (d.source.x + d.target.x) / 2 ; });
         edges_text.attr("y",function(d){ return (d.source.y + d.target.y) / 2 ; });
         
         
         //更新结点图片和文字
         nodes_img.attr("x",function(d){ return d.x - img_w/2; });
         nodes_img.attr("y",function(d){ return d.y - img_h/2; });
         
         nodes_text.attr("x",function(d){ return d.x });
         nodes_text.attr("y",function(d){ return d.y + img_w/2; });
    });
}

function submitSearchForm(){
    var serviceTypeName_url = "/stewardweb/serviceTypeName.do?agentID="+agentID;
    $.get(serviceTypeName_url, function(data, status){
        //console.log('updateServiceTypeName:'+data);
        var serviceTypeName = data;
        var d = new Date();
        stamp_from = new Date($('input[name=from]').val());
        stamp_to = new Date($('input[name=to]').val());
        sttime = stamp_from.getTime();
        endtime = stamp_to.getTime();
        var data_url = "/stewardweb/getServerMapData.do?agentID="+agentID+"&from="+sttime+"&to="+endtime+"&serviceTypeName="+serviceTypeName+"&_="+d.getTime();
        //console.log('updateData_url:'+data_url);
        $.getJSON(data_url, function(data,status){
            mapData = data;
            // console.log('nodeData:'+mapData["nodeDataArray"]);
            // console.log('linkData:'+mapData["linkDataArray"]);
            updateTopo(mapData);
        });
    });
}

$(document).ready(function() {
    var serviceTypeName_url = "/stewardweb/serviceTypeName.do?agentID="+agentID;
    $.get(serviceTypeName_url, function(data, status){
        //console.log('serviceTypeName:'+data);
        var serviceTypeName = data;
        var d = new Date();
        var data_url = "/stewardweb/getServerMapData.do?agentID="+agentID+"&from="+sttime+"&to="+endtime+"&serviceTypeName="+serviceTypeName+"&_="+d.getTime();
        //console.log('data_url:'+data_url);
        $.getJSON(data_url, function(data,status){
            mapData = data;
            // console.log('nodeData:'+mapData["nodeDataArray"]);
            // console.log('linkData:'+mapData["linkDataArray"]);
            $('#topo').html(' ');
            drawTopo(mapData);
        });
    });
    /*
    var json_url = "/stewardweb/getServerMapData.do?agentID="+agentID+"&from="+sttime+"&to="+endtime+"&serviceTypeName="+"";
    $.getJSON(json_url,function(data,status){  
        data_performance = data;
    });
    */



    // var root = getNodeEdgeInfo(mapData["applicationMapData"]);
    // console.log('root:'+root);
    // var width = 800;
    // var height = 600;
    // var img_w = 70;
    // var img_h = 70;

    // var svg = d3.select("#topo").append("svg")
    //                         .attr("width",width)
    //                         .attr("height",height);
        
    // var force = d3.layout.force()
    //                 .nodes(root.nodes)
    //                 .links(root.edges)
    //                 .size([width,height])
    //                 .linkDistance(250)
    //                 .charge(-1500)
    //                 .start();
                    
    // var edges_line = svg.selectAll("line")
    //                     .data(root.edges)
    //                     .enter()
    //                     .append("line")
    //                     .style("stroke","#CCC")
    //                     .style("stroke-width",2);
                        
    // var edges_text = svg.selectAll(".linetext")
    //                     .data(root.edges)
    //                     .enter()
    //                     .append("text")
    //                     .attr("class","linetext")
    //                     .style("fill-opacity", 1.0)
    //                     .text(function(d){
    //                         return d.relation;
    //                     });

                        
    // var nodes_img = svg.selectAll("image")
    //                     .data(root.nodes)
    //                     .enter()
    //                     .append("image")
    //                     .attr("width",img_w)
    //                     .attr("height",img_h)
    //                     .attr("xlink:href",function(d){
    //                         return d.image;
    //                     })
    //                     .on("mouseover",function(d,i){
    //                         //显示连接线上的文字
    //                         edges_text.style("fill-opacity",function(edge){
    //                             if( edge.source === d || edge.target === d ){
    //                                 return 1.0;
    //                             }
    //                         });
    //                     })
    //                     .on("mouseout",function(d,i){
    //                         //隐去连接线上的文字
    //                         edges_text.style("fill-opacity",function(edge){
    //                             if( edge.source === d || edge.target === d ){
    //                                 return 1.0;
    //                             }
    //                         });
    //                     })
    //                     .call(force.drag);

    // var text_dx = -15;
    // var text_dy = 15;

    // var nodes_text = svg.selectAll(".nodetext")
    //                     .data(root.nodes)
    //                     .enter()
    //                     .append("text")
    //                     .attr("class","nodetext")
    //                     .attr("dx",text_dx)
    //                     .attr("dy",text_dy)
    //                     .text(function(d){
    //                         return d.name;
    //                     });

                        
    // force.on("tick", function(){
        
    //     //限制结点的边界
    //     root.nodes.forEach(function(d,i){
    //         d.x = d.x - img_w/2 < 0     ? img_w/2 : d.x ;
    //         d.x = d.x + img_w/2 > width ? width - img_w/2 : d.x ;
    //         d.y = d.y - img_h/2 < 0      ? img_h/2 : d.y ;
    //         d.y = d.y + img_h/2 + text_dy > height ? height - img_h/2 - text_dy : d.y ;
    //     });

    //     //更新连接线的位置
    //      edges_line.attr("x1",function(d){ return d.source.x; });
    //      edges_line.attr("y1",function(d){ return d.source.y; });
    //      edges_line.attr("x2",function(d){ return d.target.x; });
    //      edges_line.attr("y2",function(d){ return d.target.y; });
         
    //      //更新连接线上文字的位置
    //      edges_text.attr("x",function(d){ return (d.source.x + d.target.x) / 2 ; });
    //      edges_text.attr("y",function(d){ return (d.source.y + d.target.y) / 2 ; });
         
         
    //      //更新结点图片和文字
    //      nodes_img.attr("x",function(d){ return d.x - img_w/2; });
    //      nodes_img.attr("y",function(d){ return d.y - img_h/2; });
         
    //      nodes_text.attr("x",function(d){ return d.x });
    //      nodes_text.attr("y",function(d){ return d.y + img_w/2; });
    // });
});

</script>
</head>
<body>
<div class="bodywrapper">
    <div class="topheader">
        <div class="left">
            <h1 class="logo"><a href="/stewardweb/index.do">APM <span>Admin</span></a></h1>
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
                <span>${sessionScope.userInfo.username}</span>
            </div><!--userinfo-->
            
            <div class="userinfodrop">
                <div class="userdata">
                    <h4>${sessionScope.userInfo.username}</h4>
                    <span class="email">${sessionScope.userInfo.email}</span>
                    <ul>
                        <li><a href="logout.do">退出</a></li>
                    </ul>
                </div><!--userdata-->
            </div><!--userinfodrop-->
        </div><!--right-->
    </div><!--topheader-->
    
    
    <div class="header">
    	<ul class="headermenu">
            <li class="current"><a onclick='navjump(0)'><span class="icon icon-flatscreen"></span>业务流拓扑</a></li>
            <li><a onclick='navjump(1)'><span class="icon icon-pencil"></span>业务流性能表现</a></li>
            <li><a onclick='navjump(2)'><span class="icon icon-chart"></span>应用级负载</a></li>
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
        	  	<div id="topo" style="width:800px; height:auto; margin:0 auto;">
			   		<!-- <canvas id="canvas_topo" width="800" height="500"></canvas> -->
			  	</div>
        </div><!--#charts-->

        
    </div><!--contentwrapper-->
    
    
</div><!--bodywrapper-->

</body>
</html>