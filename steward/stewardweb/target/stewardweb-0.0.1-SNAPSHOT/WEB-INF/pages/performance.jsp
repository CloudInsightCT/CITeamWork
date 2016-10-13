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
<title>APM 业务流性能表现</title>
<link rel="stylesheet" href="css/style.default.css" type="text/css" />
<link type="text/css" href="css/jquery.simple-dtpicker.css" rel="stylesheet" />
<script type="text/javascript" src="js/highcharts/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/highcharts/highcharts.js"></script>
<script type="text/javascript" src="js/datetimepicker/jquery.simple-dtpicker.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/custom/general.js"></script>
<script>

var data_performance = {"resultTo":endtime,"scatter":[],"resultFrom":sttime,"scatterIndex":{"x":0,"y":1,"transactionId":2,"type":3}}


/*
function getPerformanceData(data){
    var list_success = $.grep(data,function(index, item){
        return item[3]==1;
    });
};
*/
function getxAxis(data){
    var scatters = data['scatter'];
    if(scatters.length>=1){
        var time_start = data.resultFrom;
        var time_end = data.resultTo;
        var tag = parseInt(Math.abs(time_end-time_start)/5);
        var time_list = [
            Highcharts.dateFormat('%Y-%m-%d<br>%H:%M:%S', time_start),
            Highcharts.dateFormat('%Y-%m-%d<br>%H:%M:%S', time_start+tag),
            Highcharts.dateFormat('%Y-%m-%d<br>%H:%M:%S', time_start+2*tag),
            Highcharts.dateFormat('%Y-%m-%d<br>%H:%M:%S', time_start+3*tag),
            Highcharts.dateFormat('%Y-%m-%d<br>%H:%M:%S', time_start+4*tag)
        ];
    }else{
        var time_list = [];
    }
    return time_list;
}

function getSplitedTime(data){
    var scatters = data['scatter'];
    if(scatters.length>=1){
        var time_start = data.resultFrom;
        var time_end = data.resultTo;
        var tag = parseInt(Math.abs(time_end-time_start)/5);
        var xAxis_list = [time_start, time_start+tag, time_start+2*tag, time_start+3*tag, time_start+4*tag];
    }else{
        var xAxis_list = [];
    }
    return xAxis_list;
}

function getPerformanceData(data){
    var scatters = data['scatter'];
    //alert(data.length);
    // for(i=0, i<data.length, i++){
    //     alert(i);
    // }
    var list_success = [];
    var list_failed = [];
    var list_summary = [0, 0, 0, 0, 0];
    $.each(scatters, function(index, item){
        if(item[3]==1){
            list_success.push([item[0], item[1]]);
            /* Start of Summary */
            if(item[1]<5001){
                if(item[1]<3001){
                    if(item[1]<1001){
                        list_summary[0]++;
                    }else{
                        list_summary[1]++;
                    }
                }else{
                    list_summary[2]++;
                }
            }else{
                list_summary[3]++;
            }
            /* End of Summary */
        }else{
            list_failed.push([item[0], item[1]]);
            list_summary[4]++;
        }

        
        //alert(index+'|'+item[0]+'|'+item[1]);
    });
    var list_total = [list_success, list_failed, list_summary];

    return list_total;
};



function getPerformanceData_LOAD(data){
    var data_0 = [];
    var data_1 = [];
    var data_2 = [];
    var data_3 = [];
    var data_4 = [];
    var scatters = data['scatter'];
    var tags = getSplitedTime(data_performance);
    $.each(scatters, function(index, item){
        var t = parseInt(item[0]);
        if(t>tags[1]){
            if(t>tags[2]){
                if(t>tags[3]){
                    if(t>tags[4]){
                        data_4.push(item);
                    }else{
                        data_3.push(item);
                    }
                }else{
                    data_2.push(item);
                }
            }else{
                data_1.push(item);
            }
        }else{
            data_0.push(item);
        }
    });
    var s_0 = {"scatter":data_0};
    var s_1 = {"scatter":data_1};
    var s_2 = {"scatter":data_2};
    var s_3 = {"scatter":data_3};
    var s_4 = {"scatter":data_4};
    // !!需要转置数组
    var interval_summary =  [getPerformanceData(s_0)[2], getPerformanceData(s_1)[2], getPerformanceData(s_2)[2], getPerformanceData(s_3)[2], getPerformanceData(s_4)[2]];
    var ret = new Array();
    for (var i = 0; i < 5; i ++) {
    	var ret_i = new Array();
    	for (var j = 0; j < 5; j++) {
    		ret_i[j] = 0;
    	}
    	ret[i] = ret_i;
    }
    for (var i = 0; i < 5; i ++) {
    	for (var j = 0; j < 5; j++) {
    		ret[i][j] = interval_summary[j][i];
    	}
    }
    return ret;
};

function initChart() {                           
    Highcharts.setOptions({                                                     
        global: {
            useUTC: false
        }                                                                       
    });
    $('#chart_sandian').highcharts({                                                             
        chart: {                                                                             
            type: 'scatter',                                                                 
            zoomType: 'xy'                                                                   
        },                                                                                   
        title: {                                                                             
            text: null
        },                                                                                  
        xAxis: {                                                                             
            title: {                                                                         
                enabled: true,                                                               
                text: null                                                          
            },                                                                               
            startOnTick: true,                                                               
            endOnTick: true,                                                                 
            showLastLabel: true,
            type: 'datetime',
            dateTimeLabelFormats: {
                 millisecond: '%H:%M:%S<br>%Y-%m'
            }
        },                                           
        yAxis: {                                                                             
            title: {                                                                         
                text: '响应时间 (ms)'                                                          
            }                                                                                
        },                                                                                   
        legend: {                                                                            
            layout: 'vertical',                                                              
            align: 'left',                                                                   
            verticalAlign: 'top',                                                            
            x: 100,                                                                          
            y: 30,                                                                           
            floating: true,                                                                  
            backgroundColor: '#FFFFFF',                                                      
            borderWidth: 1                                                                   
        },                                                                                   
        plotOptions: {                                                                       
            scatter: {                                                                       
                marker: {                                                                    
                    radius: 5,                                                               
                    states: {                                                                
                        hover: {                                                             
                            enabled: true,                                                   
                            lineColor: 'rgb(100,100,100)'                                    
                        }                                                                    
                    }                                                                        
                },                                                                           
                states: {                                                                    
                    hover: {                                                                 
                        marker: {                                                            
                            enabled: false                                                   
                        }                                                                    
                    }                                                                        
                },                                                                           
                tooltip: {                                                                   
                    headerFormat: '<b>{series.name}</b><br>',
                    pointFormat: '{point.x} , {point.y} ms',
                    //pointFormat: '{point.x} , {point.y} ms', 
                    //formatter: function() {                                             
                    //	return '<b>'+ 'name</b><br/>'+                
                    //	Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) +'<br/>'+
                   	//	Highcharts.numberFormat(this.y, 2);                         
                    //}  
                }                                                                            
            }                                                                                
        },                                                                                   
        series: [{                                                                           
            name: '成功',                                                                  
            color: 'rgba(10, 232, 10, .5)',                                                  
            //data: [[1459166930522, 52],[1459166930528, 48],[1459166930928, 48],[1459166931028, 68]]   
            //data: getPerformanceData(data_performance)[0]
            data: []
                                                                                             
        }, {                                                                                 
            name: '超时',                                                                    
            color: 'rgba(223, 83, 83, .5)',                                                
            //data: [[1459166930926, 58],[1459166931121, 65],[1459166931322, 56]]                                                
            //data: getPerformanceData(data_performance)[1]
            data: []
        }]                                                                                   
    });    




    var colors = Highcharts.getOptions().colors,
        categories = ['1s', '3s', '5s', 'Slow', 'Error'],
        name = '响应时间',
        data = [{
                //y: getPerformanceData(data_performance)[2][0],
                y: 0,
                color: colors[2]
            }, {
                //y: getPerformanceData(data_performance)[2][1],
                y: 0,
                color: colors[0]
            }, {
                //y: getPerformanceData(data_performance)[2][2],
                y: 0,
                color: colors[4]
            }, {
                //y: getPerformanceData(data_performance)[2][3],
                y: 0,
                color: colors[3]
            }, {
                //y: getPerformanceData(data_performance)[2][4],
                y: 0,
                color: colors[1]
            }];

    var chart_response_summary = $('#chart_response_summary').highcharts({
        chart: {
            type: 'column'
        },
        title: {
            text: null
        },
        xAxis: {
            categories: categories
        },
        yAxis: {
            title: {
                text: '响应数'
            }
        },
        tooltip: {
            formatter: function() {
                var point = this.point,
                    s = '<b>' + this.x +':</b> <b>'+ this.y +'</b> 请求.<br/>';
                return s;
            }
        },
        series: [{
            name: name,
            data: data,
            color: 'white'
        }],
        exporting: {
            enabled: false
        }
    }).highcharts(); // return chart



    /*----------- Start Of Load Chart Section -----------*/
    //getPerformanceData_LOAD(data_performance);
    $('#chart_load').highcharts({
        chart: {
            type: 'column'
        },
        title: {
            text: null
        },
        xAxis: {
            title: {                                                                         
                enabled: true,                                                               
                text: null                                                          
            }, 
            type: 'datetime',
            dateTimeLabelFormats: {
                millisecond: '%H:%M:%S<br>%Y-%m'
            }
            //categories: getxAxis(data_performance)
        },
        yAxis: {
            min: 0,
            title: {
                text: '响应数'
            },
            stackLabels: {
                enabled: true,
                style: {
                    fontWeight: 'bold',
                    color: (Highcharts.theme && Highcharts.theme.textColor) || 'gray'
                }
            }
        },
        legend: {
            align: 'right',
            x: -20,
            verticalAlign: 'top',
            y: 5,
            floating: true,
            backgroundColor: (Highcharts.theme && Highcharts.theme.legendBackgroundColorSolid) || 'white',
            borderColor: '#CCC',
            borderWidth: 1,
            shadow: false
        },
        tooltip: {
            formatter: function() {
                return '<b>'+ this.x +'</b><br/>'+
                    this.series.name +': '+ this.y +'<br/>'+
                    'Total: '+ this.point.stackTotal;
            }
        },
        plotOptions: {
            column: {
                stacking: 'normal',
                dataLabels: {
                    enabled: true,
                    color: (Highcharts.theme && Highcharts.theme.dataLabelsColor) || 'white'
                }
            }
        },
        series: [{
            name: '1s',
            data: [0, 0, 0, 0, 0],
        	color: colors[2] 
            //data: getPerformanceData_LOAD(data_performance)[0]
        }, {
            name: '3s',
            data: [0, 0, 0, 0, 0],
            color: colors[0]
            //data: getPerformanceData_LOAD(data_performance)[1]
        }, {
            name: '5s',
            data: [0, 0, 0, 0, 0],
        	color: colors[4]
            //data: getPerformanceData_LOAD(data_performance)[2]
        }, {
            name: 'Slow',
            data: [0, 0, 0, 0, 0],
            color: colors[3]
            //data: getPerformanceData_LOAD(data_performance)[3]
        }, {
            name: 'Error',
            data: [0, 0, 0, 0, 0],
            color: colors[1]
            //data: getPerformanceData_LOAD(data_performance)[4]
        }]
    });
    /*----------- End Of Load Chart Section -----------*/
}

function updateChart() {
	var chartSandian = $('#chart_sandian').highcharts();
    var chartSummary = $('#chart_response_summary').highcharts();
    var chartLoad = $('#chart_load').highcharts();

    var colors = Highcharts.getOptions().colors,
        data = [{
                y: getPerformanceData(data_performance)[2][0],
                color: colors[2]
            }, {
                y: getPerformanceData(data_performance)[2][1],
                color: colors[0]
            }, {
                y: getPerformanceData(data_performance)[2][2],
                color: colors[4]
            }, {
                y: getPerformanceData(data_performance)[2][3],
                color: colors[3]
            }, {
                y: getPerformanceData(data_performance)[2][4],
                color: colors[1]
            }];

    chartSandian.series[0].setData(getPerformanceData(data_performance)[0]);
    chartSandian.series[1].setData(getPerformanceData(data_performance)[1]);
    chartSummary.series[0].setData(data);
    chartLoad.xAxis[0].update({categories: getxAxis(data_performance)});
    chartLoad.series[0].setData(getPerformanceData_LOAD(data_performance)[0]);
    chartLoad.series[1].setData(getPerformanceData_LOAD(data_performance)[1]);
    chartLoad.series[2].setData(getPerformanceData_LOAD(data_performance)[2]);
    chartLoad.series[3].setData(getPerformanceData_LOAD(data_performance)[3]);
    chartLoad.series[4].setData(getPerformanceData_LOAD(data_performance)[4]);
}

$(document).ready(function(){
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
    stamp_from = new Date(time_from);
    stamp_to = new Date(time_to);
    sttime = stamp_from.getTime();
    endtime = stamp_to.getTime();
    var json_url = '/stewardweb/getScatterData.do?agentID='+ agentID+'&from=' + sttime + '&to=' + endtime + '&limit=5000&v=2';
    $.getJSON(json_url,function(data,status){
        data_performance = data;
        updateChart();
    });  
};
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
            <li class="current"><a onclick='navjump(1)'><span class="icon icon-pencil"></span>业务流性能表现</a></li>
            <li><a onclick='navjump(2)'><span class="icon icon-chart"></span>应用级负载</a></li>
            <li><a onclick='navjump(3)'><span class="icon icon-speech"></span>慢调用</a></li>
            <li><a onclick='navjump(4)'><span class="icon icon-message"></span>出错调用</a></li>
        </ul>
    </div><!--header-->
    
    <div class="pageheader">
    	<h1 class="pagetitle contenttitle2">业务流性能表现</h1>
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
    	
            <div class="one_half">
                <div class="contenttitle2">
                    <h3>性能概览</h3>
                </div><!--contenttitle-->
                <br />
                <div id="chart_sandian" style="height:300px;"></div>
            </div><!--one_half-->
            
            <div class="one_half last">            
                <div class="contenttitle2">
                    <h3>响应统计</h3>
                </div><!--contenttitle-->
                <br />
                <div id="chart_response_summary" style="height:300px;"></div>
            </div><!--one_half last-->
            
            <br clear="all" /><br />
            
            <div class="one_half">
                <div class="contenttitle2">
                    <h3>性能负载</h3>
                </div><!--contenttitle-->
                <br />
                <div id="chart_load" style="height:300px;"></div>
            </div><!--one_half-->
            
            <div class="one_half last" style="display:none;">
                <div class="contenttitle2">
                    <h3>监控4</h3>
                </div><!--contenttitle-->
                <br />
                <div id="piechart" style="height: 300px;"></div>
            </div><!--one_half last-->
        
        <br clear="all" />
        
        </div><!--#charts-->
        
        <div id="statistics" class="subcontent">
        	&nbsp;
        </div><!--#statistics-->
        
    </div><!--contentwrapper-->
    
    
</div><!--bodywrapper-->

</body>
</html>
