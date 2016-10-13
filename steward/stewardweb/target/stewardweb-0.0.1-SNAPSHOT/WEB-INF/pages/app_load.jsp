<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>APM 应用负载监控</title>
<link rel="stylesheet" href="css/style.default.css" type="text/css" />
<link type="text/css" href="css/jquery.simple-dtpicker.css" rel="stylesheet" />
<script type="text/javascript" src="js/highcharts/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/highcharts/highcharts.js"></script>
<script type="text/javascript" src="js/datetimepicker/jquery.simple-dtpicker.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/custom/general.js"></script>
<script type="text/javascript">

var data_performance = {"resultTo":endtime,"scatter":[],"resultFrom":sttime,"scatterIndex":{"x":0,"y":1,"transactionId":2,"type":3}}


function getAppLoadData(data){
    var scatters = data['scatter'];
    var tag = 1000 * 60; // 每分钟事务数
    if(scatters.length>0){
        var time_end = data.resultTo;
        var time_start = data.resultFrom;
        var n = parseInt(Math.abs(time_end-time_start)/tag);
        var data_list = [];
        for(i=0;i<=n;i++){
            data_list.push(0);
        }
        $.each(scatters, function(index,item){
            tmp = parseInt(Math.abs(item[0]-time_start)/tag);
            data_list[tmp]++;
        });
        return data_list;
    }else{
        var data_list = [];
        return data_list;
    }
}

function getPointStart(data){
    var scatters = data['scatter'];
    if(scatters.length>0){
        var tag_end = parseInt(scatters.length-1);
        var time_start = parseInt(scatters[tag_end][0]);
        return time_start;
    }else{
        return 0;
    }
}

function initChart() {
    Highcharts.setOptions({
        global: {
            useUTC: false
        }
    }); 

    $('#chart_app_load').highcharts({
        chart: {
            zoomType: 'x',
            spacingRight: 20
        },
        title: {
            text: null
        },
        // xAxis: {
        //     type: 'datetime',
        //     maxZoom: 7 * 24 * 3600000, // fourteen days
        //     title: {
        //         text: null
        //     }
        // },
        xAxis: {
            type: 'datetime',
            dateTimeLabelFormats: {
                 millisecond: '%H:%M:%S<br>%Y-%m'
            },
            // maxZoom: 24 * 3600 *1000, // one day
            // title: {
            //     text: 'Time Line'
            // }
        },
        yAxis: {
            title: {
                text: '事务数/分钟'
            }
        },
        tooltip: {
            shared: true,
            formatter: function () {
                return Highcharts.dateFormat('%Y-%m-%d %H:%M:%S',this.x) +
                    '<br/>' + '事务数：' + this.y;
            }
        },
        legend: {
            enabled: false
        },
        plotOptions: {
            area: {
                fillColor: {
                    linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1},
                    stops: [
                        [0, Highcharts.getOptions().colors[0]],
                        [1, Highcharts.Color(Highcharts.getOptions().colors[0]).setOpacity(0).get('rgba')]
                    ]
                },
                lineWidth: 1,
                marker: {
                    enabled: false
                },
                shadow: false,
                states: {
                    hover: {
                        lineWidth: 1
                    }
                },
                threshold: null
            }
        },

        series: [{                                                                           
            type: 'area',
            name: 'Transactions',
            //data: [[1459166930522, 52],[1459166930528, 48],[1459166930928, 48],[1459166931028, 68]]   
            //pointStart: getPointStart(data_performance),
            pointInterval: 1000 * 60, //每分钟事务数
            //data: getAppLoadData(data_performance)
            data: []
                                                                                             
        }]   
        // series: [{
        //     type: 'area',
        //     name: 'Transactions:',
        //     pointInterval: 1 * 3600 * 1000,
        //     pointStart: Date.UTC(2016, 01, 01),
        //     //pointStart: Date.UTC(2006, 0, 01),
        //     //data: [[1459166930522, 52],[1459166930528, 48],[1459166930928, 48],[1459166931028, 68]]
        //     data: [
        //         0.8446, 0.8445, 0.8444, 0.8451,    0.8418, 0.8264,    0.8258, 0.8232,    0.8233, 0.8258,
        //         0.8283, 0.8278, 0.8256, 0.8292,    0.8239, 0.8239,    0.8245, 0.8265,    0.8261, 0.8269
        //     ]
        // }]
    });
}

function updateChart() {
	var chartAppLoad = $('#chart_app_load').highcharts();
    chartAppLoad.series[0].setData(getAppLoadData(data_performance));
    chartAppLoad.series[0].update({pointStart: data_performance.resultFrom});
}


$(document).ready(function() {
	initChart();
	var json_url = "/stewardweb/getScatterData.do?agentID=" + agentID + "&from=" + sttime + "&to=" + endtime + "&limit=5000&v=2";
    $.getJSON(json_url,function(data,status){
        data_performance = data;
        updateChart();
    });

});

function submitSearchForm(){	
	
    var time_from = $('input[name=from]').val();
    var time_to = $('input[name=to]').val();
	var appName = 'tomcat';
    stamp_from = new Date(time_from);
    stamp_to = new Date(time_to);
	sttime = stamp_from.getTime();
    endtime = stamp_to.getTime();
    
	var json_url = '/stewardweb/getScatterData.do?agentID='+ agentID+'&from=' + sttime + '&to=' + endtime + '&limit=5000&v=2';
    $.getJSON(json_url,function(data,status){
        data_performance = data;
        updateChart();
    });
	
    //chartAppLoad.series[0].addPoint([1462699993649,20]);
}
</script>
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
            <li><a onclick='navjump(0)'><span class="icon icon-flatscreen"></span>业务流拓扑</a></li>
            <li><a onclick='navjump(1)'><span class="icon icon-pencil"></span>业务流性能表现</a></li>
            <li class="current"><a onclick='navjump(2)'><span class="icon icon-chart"></span>应用级负载</a></li>
            <li><a onclick='navjump(3)'><span class="icon icon-speech"></span>慢调用</a></li>
            <li><a onclick='navjump(4)'><span class="icon icon-message"></span>出错调用</a></li>
        </ul>
    </div><!--header-->
    
    <div class="pageheader">
    	<h1 class="pagetitle contenttitle2">应用级负载</h1>
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
    	
            <div class="one_tatal last">
                <div class="contenttitle2">
                    <h3>每分钟处理事务数</h3>
                </div><!--contenttitle-->
                <br />
                <div id="chart_app_load" style="height:300px;"></div>
            </div><!--one_half-->
        <br clear="all" />
        
        </div><!--#charts-->
        
        <div id="statistics" class="subcontent">
        </div><!--#statistics-->
        
    </div><!--contentwrapper-->
    
    
</div><!--bodywrapper-->

</body>
</html>
