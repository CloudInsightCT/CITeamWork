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
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>APM 业务流性能表现</title>
<link rel="stylesheet" href="css/style.default.css" type="text/css" />
   <script type="text/javascript" src="js/highcharts/jquery-1.8.3.min.js"></script>
   <script type="text/javascript" src="js/highcharts/highcharts.js"></script>
   <script>
$(function () {                           

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
                text: 'Times Line'                                                          
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
                text: 'Response Time (ms)'                                                          
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
                }                                                                            
            }                                                                                
        },                                                                                   
        series: [{                                                                           
            name: 'Success',                                                                  
            color: 'rgba(10, 232, 10, .5)',                                                  
            data: [[1459166930522, 52],[1459166930528, 48],[1459166930928, 48],[1459166931028, 68]]   
                                                                                             
        }, {                                                                                 
            name: 'Failed',                                                                    
            color: 'rgba(223, 83, 83, .5)',                                                
            data: [[1459166930926, 58],[1459166931121, 65],[1459166931322, 56]]                                                
        }]                                                                                   
    });    




    var colors = Highcharts.getOptions().colors,
        categories = ['1s', '2s', '3s', 'Slow', 'Error'],
        name = 'Response Categories',
        data = [{
                y: 55,
                color: colors[0]
            }, {
                y: 21,
                color: colors[1]
            }, {
                y: 11,
                color: colors[2]
            }, {
                y: 7,
                color: colors[3]
            }, {
                y: 2,
                color: colors[4]
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
                text: 'Number Of Items'
            }
        },
        tooltip: {
            formatter: function() {
                var point = this.point,
                    s = this.x +':include <b>'+ this.y +'</b> items.<br/>';
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
    $('#chart_load').highcharts({
        chart: {
            type: 'column'
        },
        title: {
            text: null
        },
        xAxis: {
            categories: ['12:00:00', '12:10:00', '12:20:00', '12:30:00', '12:40:00']
        },
        yAxis: {
            min: 0,
            title: {
                text: 'Number Of Items'
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
            x: -70,
            verticalAlign: 'top',
            y: 20,
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
            data: [5, 3, 4, 7, 2]
        }, {
            name: '2s',
            data: [2, 2, 3, 2, 1]
        }, {
            name: '3s',
            data: [3, 4, 4, 2, 5]
        }, {
            name: 'Slow',
            data: [3, 4, 4, 2, 5]
        }, {
            name: 'Error',
            data: [3, 4, 4, 2, 5]
        }]
    });
    /*----------- End Of Load Chart Section -----------*/

});
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
            <h1 class="logo">APM <span>Admin</span></h1>
            <span class="slogan">后台管理系统</span>
            
            <div class="search">
                <form action="" method="post">
                    <input type="text" name="keyword" id="keyword" value="请输入" />
                    <button class="submitbutton"></button>
                </form>
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
            	<div class="avatar">
                	<a href=""><img src="images/thumbs/avatarbig.png" alt="" /></a>
                    <div class="changetheme">
                    	切换主题: <br />
                    	<a class="default"></a>
                        <a class="blueline"></a>
                        <a class="greenline"></a>
                        <a class="contrast"></a>
                        <a class="custombg"></a>
                    </div>
                </div><!--avatar-->
                <div class="userdata">
                    <h4>Juan</h4>
                    <span class="email">youremail@yourdomain.com</span>
                    <ul>
                        <li><a href="editprofile.html">编辑资料</a></li>
                        <li><a href="accountsettings.html">账号设置</a></li>
                        <li><a href="help.html">帮助</a></li>
                        <li><a href="index.html">退出</a></li>
                    </ul>
                </div><!--userdata-->
            </div><!--userinfodrop-->
        </div><!--right-->
    </div><!--topheader-->
    
    
    <div class="header">
    	<ul class="headermenu">
            <li><a href="reports_index.html"><span class="icon icon-flatscreen"></span>业务流拓扑</a></li>
            <li class="current"><a href="reports_performance.html"><span class="icon icon-pencil"></span>业务流性能表现</a></li>
            <li><a href="reports_app_load.html"><span class="icon icon-chart"></span>应用级负载均衡</a></li>
            <li><a href="reports_host_load.html"><span class="icon icon-chart"></span>主机负载监控</a></li>
            <li><a href="reports_slow_call.html"><span class="icon icon-speech"></span>慢调用</a></li>
            <li><a href="reports_wrong_call.html"><span class="icon icon-message"></span>出错调用</a></li>
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
                    <h3>Performance</h3>
                </div><!--contenttitle-->
                <br />
                <div id="chart_sandian" style="height:300px;"></div>
            </div><!--one_half-->
            
            <div class="one_half last">            
                <div class="contenttitle2">
                    <h3>Response Summary</h3>
                </div><!--contenttitle-->
                <br />
                <div id="chart_response_summary" style="height:300px;"></div>
            </div><!--one_half last-->
            
            <br clear="all" /><br />
            
            <div class="one_half">
                <div class="contenttitle2">
                    <h3>Load</h3>
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
