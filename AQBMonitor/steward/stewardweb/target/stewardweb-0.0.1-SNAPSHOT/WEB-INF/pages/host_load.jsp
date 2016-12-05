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
<title>APM 主机负载监控</title>
<link rel="stylesheet" href="css/style.default.css" type="text/css" />
<link type="text/css" href="css/jquery.simple-dtpicker.css" rel="stylesheet" />
<script type="text/javascript" src="js/highcharts/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/highcharts/highcharts.js"></script>
<script type="text/javascript" src="js/sockjs-1.0.3.min.js"></script>
<script type="text/javascript" src="js/datetimepicker/jquery.simple-dtpicker.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/custom/general.js"></script>


<script type="text/javascript">

    var socket;
    function setConnected(connected) {
        document.getElementById('connect').disabled = connected;
        document.getElementById('disconnect').disabled = !connected;
        document.getElementById('response').innerHTML = '';
    }

    function connect() {
        if ('WebSocket' in window) {
            console.log('Websocket supported');
            socket = new WebSocket('ws://' + window.location.host + '/stewardweb/websocket.do?agentid=' + agentID);
            console.log('Connection attempted');
            socket.onopen = function() {
                console.log('Connection open!');
                setConnected(true);
            }
            socket.onclose = function() {
                console.log('Disconnecting connection');
            }
            socket.onmessage = function(evt) {
                var received_msg = evt.data;
                //alert(received_msg);
                //console.log(received_msg);
                console.log('message received!');
//                $('#note').html()
                //showMessage(received_msg);
                console.log(received_msg);
                var num_list = analysisMessage($.parseJSON(received_msg));
                updateChartCPU($.parseJSON(received_msg), num_list[0]);
                updateChartMEM($.parseJSON(received_msg), num_list[1]);
                updateChartNET($.parseJSON(received_msg), num_list[2]);
                updateChartFS($.parseJSON(received_msg), num_list[3]);
            }
        } else {
            console.log('Websocket not supported');
        }
    }

    function disconnect() {
        setConnected(false);
        console.log("Disconnected");
        socket.close();
    }

    function sendName() {
        var message = document.getElementById('message').value;
        socket.send(JSON.stringify({
            'message' : message
        }));
    }

    function showMessage(message) {
        var response = document.getElementById('response');
        var p = document.createElement('p');
        p.style.wordWrap = 'break-word';
        p.appendChild(document.createTextNode(message));
        response.appendChild(p);
    }

    function updateChartCPU(messageJSON, num){
        /*
        var chartCPU = $('#chart_cpu').highcharts();
        var time = (new Date()).getTime();
        $.each(messageJSON, function(index, item){
            if(item['devID']=='CPU0'&&item['tag']=='1'){
                //var time = parseInt(item['timestamp']);
                console.log(item);
                chartCPU.series[0].addPoint([time,item['metric']],true,true);
            }
            if(item['devID']=='CPU0'&&item['tag']=='2'){
                //var time = parseInt(item['timestamp']);
                console.log(item);
                chartCPU.series[1].addPoint([time,item['metric']],true,true);
            }
            if(item['devID']=='CPU0'&&item['tag']=='5'){
                //var time = parseInt(item['timestamp']);
                console.log(item);
                chartCPU.series[2].addPoint([time,item['metric']],true,true);
            }
            if(item['devID']=='CPU0'&&item['tag']=='6'){
                //var time = parseInt(item['timestamp']);
                console.log(item);
                chartCPU.series[3].addPoint([time,item['metric']],true,true);
            }
        });
        */

        var chartCPU = [];
        for(i=1;i<=num;i++){
            var cpu_name = '#chart_cpu_'+i;
            if($(cpu_name).length==0){
                if(i==1){
                    $('#charts').html(' ');
					$('#charts').html("<div class='pageheader'><h1 class='pagetitle contenttitle2' style='margin:0px 0px;'>CPU监控</h1></div>");
                }
                var chartNodeCode = "<div class='one_half";
                if(i%2==0){
                    chartNodeCode += " last";
                }
                chartNodeCode += "'><div class='contenttitle2'><h3>CPU"+i+"状况</h3></div><br /><div id='chart_cpu_"+i+"' style='height:300px;'></div></div>";
                $('#charts').append(chartNodeCode);
                $(cpu_name).highcharts({                                                
                    chart: {                                                                
                        type: 'spline',                                                     
                    },
                    title: {
                        text: null
                    },
                    xAxis: {
                        type: 'datetime',                                                   
                        tickPixelInterval: 150                                              
                    },
                    yAxis: {
                        title: {                                                            
                            text: '使用率'                                                   
                        },                                                                  
                        plotLines: [{                                                       
                            value: 0,                                                       
                            width: 1,                                                       
                            color: '#808080'                                                
                        }]                                                                  
                    },                                                                      
                    tooltip: {                                                              
                        formatter: function() {                                             
                                return '<b>'+ this.series.name +'</b><br/>'+                
                                Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) +'<br/>'+
                                Highcharts.numberFormat(this.y, 2);                         
                        }                                                                   
                    },                                                                      
                    legend: {                                                               
                        enabled: true
                    },                                                                      
                    exporting: {                                                            
                        enabled: false                                                      
                    },                                                                      
                    series: [{                                                              
                        name: '用户使用率',
                        data: (function() {                                                 
                            var data = [],                                                  
                                time = (new Date()).getTime(),                              
                                i;                                                          
                            for (i = -9; i <= 0; i++) {                                    
                                data.push({                                                 
                                    x: time + i * 1000,                                     
                                    y: 0                                        
                                });                                                         
                            }                                                               
                            return data;                                                    
                        })()
                    },{
                        name: '系统使用率',
                        data: (function() {
                            var data = [],
                                time = (new Date()).getTime(),                              
                                i;
                            for (i = -9; i <= 0; i++) {                                    
                                data.push({                                                 
                                    x: time + i * 1000,                                     
                                    y: 0                                        
                                });                                                         
                            }                                                               
                            return data;                                                    
                        })()
                    },{
                        name: '当前空闲率',
                        data: (function() {                                                 
                            var data = [],                                                  
                                time = (new Date()).getTime(),                              
                                i;
                            for (i = -9; i <= 0; i++) {                                    
                                data.push({                                                 
                                    x: time + i * 1000,                                     
                                    y: 0                                    
                                });                                                         
                            }                                                               
                            return data;                                                    
                        })()
                    },{
                        name: '总体使用率',
                        data: (function() {
                            var data = [],                                                  
                                time = (new Date()).getTime(),                              
                                i;                                                          
                            for (i = -9; i <= 0; i++) {                                    
                                data.push({                                                 
                                    x: time + i * 1000,                                     
                                    y: 0                                    
                                });                                                         
                            }                                                               
                            return data;                                                    
                        })()
                    }]
                });
                if(i==num){
                    $('#charts').append("<br clear='all' /><br />");
                }
            }
            chartCPU.push($(cpu_name).highcharts());
        }

        //var chartCPU = $('#chart_cpu').highcharts();
        var time = (new Date()).getTime();
        $.each(messageJSON, function(index, item){
            for(i=0;i<num;i++){
                devID = 'CPU'+i;
                if(item['devID']==devID&&item['tag']=='1'){
                    //var time = parseInt(item['timestamp']);
                    //console.log(item);
                    chartCPU[i].series[0].addPoint([time,item['metric']],true,true);
                }
                if(item['devID']==devID&&item['tag']=='2'){
                    //var time = parseInt(item['timestamp']);
                    //console.log(item);
                    chartCPU[i].series[1].addPoint([time,item['metric']],true,true);
                }
                if(item['devID']==devID&&item['tag']=='5'){
                    //var time = parseInt(item['timestamp']);
                    //console.log(item);
                    chartCPU[i].series[2].addPoint([time,item['metric']],true,true);
                }
                if(item['devID']==devID&&item['tag']=='6'){
                    //var time = parseInt(item['timestamp']);
                    //console.log(item);
                    chartCPU[i].series[3].addPoint([time,item['metric']],true,true);
                }
            }
        });
        

        //alert(typeof(message));
        // var messages = $.parseJSON(message);
        // //alert(messages);
        // //alert(messages.length);
        // $('#statistics').html(message);
        // $.each(messages, function(index, item){
        //     alert(item);
        // });   
    }
    function updateChartMEM(messageJSON, num){
        var chart_memory = '#chart_memory_1';
        var chart_swap = '#chart_swap_1';
        if($(chart_memory).length==0){
			$('#charts').append("<div class='pageheader'><h1 class='pagetitle contenttitle2' style='margin:0px 0px;'>内存监控</h1></div>");
            var chartNodeCode = "<div class='one_fourth'><div class='contenttitle2'><h3>内存状况</h3></div><br /><div id='chart_memory_1' style='height:300px;'></div></div>";
            chartNodeCode += "<div class='one_fourth last'><div class='contenttitle2'><h3>交换内存状况</h3></div><br /><div id='chart_swap_1' style='height:300px;'></div></div>";
            $('#charts').append(chartNodeCode);
            $('#charts').append("<br clear='all' /><br />");
            $(chart_memory).highcharts({                                                
                chart: {
                    plotBackgroundColor: null, 
                    plotBorderWidth: null, 
                    plotShadow: false
                },                                                                      
                title: {                                                                
                    text: null
                },
                tooltip: {                                                              
                    pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
                },
                plotOptions: { 
                    pie: { 
                        allowPointSelect: true, 
                        size: 200,
                        cursor: 'pointer', 
                        dataLabels: { 
                            distance:10,
                            enabled: true, 
                            color: '#000000', 
                            connectorColor: '#000000', 
                            format: '<b>{point.name}</b>: {point.percentage:.1f} %' 
                        } 
                    }
                },
                legend: {                                                               
                    enabled: false                                                      
                },                                                               
                series: [{
                    type: 'pie',
                    name: '百分比',
                    data:[
                        ['未使用', 100],
                        ['已使用', 0]
                    ]                                                            
                }]                                                                      
            });
            $(chart_swap).highcharts({                                                
                chart: {
                    plotBackgroundColor: null, 
                    plotBorderWidth: null, 
                    plotShadow: false
                },                                                                      
                title: {                                                                
                    text: null
                },
                tooltip: {                                                              
                    pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
                },
                plotOptions: { 
                    pie: { 
                        allowPointSelect: true, 
                        size: 200,
                        cursor: 'pointer', 
                        dataLabels: { 
                            distance:10,
                            enabled: true, 
                            color: '#000000', 
                            connectorColor: '#000000', 
                            format: '<b>{point.name}</b>: {point.percentage:.1f} %' 
                        } 
                    }
                },
                legend: {                                                               
                    enabled: false                                                      
                },                                                               
                series: [{
                    type: 'pie',
                    name: '百分比',
                    data:[
                        ['未使用', 100],
                        ['已使用', 0]
                    ]                                                            
                }]                                                                      
            });
        }
        var chartMEM = $('#chart_memory_1').highcharts();
        var chartSWAP = $('#chart_swap_1').highcharts();
        var result_list = [0,0,0,0];
        $.each(messageJSON, function(index, item){
            var devID = 'MEM';
            if(item['devID']==devID&&item['tag']=='9'){
                //console.log(item);
                result_list[0] = item['metric'];
            }
            if(item['devID']==devID&&item['tag']=='8'){
                //console.log(item);
                result_list[1] = item['metric'];
            }
            if(item['devID']==devID&&item['tag']=='12'){
                //console.log(item);
                result_list[3] = item['metric'];
            }
            if(item['devID']==devID&&item['tag']=='11'){
                //console.log(item);
                result_list[2] = item['metric'];
            }
        });
        chartMEM.series[0].setData([result_list[0],result_list[1]]);
        chartSWAP.series[0].setData([result_list[2],result_list[3]]);
    }



    function updateChartNET(messageJSON, num){
        var chartNET_Pkt = [];
        var chartNET_Byte = [];
        for(i=1;i<=num;i++){
            var chart_net_pkt = '#chart_net_pkt_'+i;
            var chart_net_byte = '#chart_net_byte_'+i;
            if($(chart_net_pkt).length==0){
				if(i==1){
					$('#charts').append("<div class='pageheader'><h1 class='pagetitle contenttitle2' style='margin:0px 0px;'>网络监控</h1></div>");
				}
                var chartNodeCode = "<div class='one_fourth'><div class='contenttitle2'><h3>网络"+i+"使用情况</h3></div><br /><div id='chart_net_pkt_"+i+"' style='height:300px;'></div></div>";
                chartNodeCode += "<div class='one_fourth";
                if(i%2==0){
                    chartNodeCode += " last";
                }
                chartNodeCode += "'><div class='contenttitle2'><h3>网络"+i+"使用情况</h3></div><br /><div id='chart_net_byte_"+i+"' style='height:300px;'></div></div>";
                $('#charts').append(chartNodeCode);
                if(i==num){
                    $('#charts').append("<br clear='all' /><br />");
                }
                $(chart_net_pkt).highcharts({                                                
                    chart: {                                                                
                        type: 'spline',                                                     
                    },                                                                      
                    title: {                                                                
                        text: null
                    },                                                                      
                    xAxis: {                                                                
                        type: 'datetime',                                                   
                        tickPixelInterval: 150
                    },                                                                      
                    yAxis: {                                                                
                        title: {                                                            
                            text: '包数'                                                   
                        },                                                                  
                        plotLines: [{                                                       
                            value: 0,                                                       
                            width: 1,                                                       
                            color: '#808080'                                                
                        }]                                                                  
                    },                                                                      
                    tooltip: {                                                              
                        formatter: function() {                                             
                                return '<b>'+ this.series.name +'</b><br/>'+                
                                Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) +'<br/>'+
                                Highcharts.numberFormat(this.y, 2);                         
                        }                                                                   
                    },                                                                      
                    legend: {                                                               
                        enabled: true
                    },                                                                      
                    exporting: {                                                            
                        enabled: false                                                      
                    },                                                                      
                    series: [{                                                              
                        name: '收包数',
                        data: (function() {
                            var data = [],                                                  
                                time = (new Date()).getTime(),                              
                                i;                                                          
                                                                                            
                            for (i = -9; i <= 0; i++) {                                    
                                data.push({                                                 
                                    x: time + i * 1000,                                     
                                    y: 0                                        
                                });                                                         
                            }                                                               
                            return data;                                                    
                        })()
                    },{
                        name: '发包数',
                        data: (function() {                                                 
                            var data = [],                                                  
                                time = (new Date()).getTime(),                              
                                i;                                                          
                                                                                            
                            for (i = -9; i <= 0; i++) {                                    
                                data.push({                                                 
                                    x: time + i * 1000,                                     
                                    y: 0                                        
                                });                                                         
                            }                                                               
                            return data;                                                    
                        })()
                    }]
                });
                $(chart_net_byte).highcharts({                                                
                    chart: {                                                                
                        type: 'spline',                                                     
                    },                                                                      
                    title: {                                                                
                        text: null
                    },                                                                      
                    xAxis: {                                                                
                        type: 'datetime',                                                   
                        tickPixelInterval: 150
                    },                                                                      
                    yAxis: {                                                                
                        title: {                                                            
                            text: '字节数'                                                   
                        },                                                                  
                        plotLines: [{                                                       
                            value: 0,                                                       
                            width: 1,                                                       
                            color: '#808080'                                                
                        }]                                                                  
                    },                                                                      
                    tooltip: {                                                              
                        formatter: function() {                                             
                                return '<b>'+ this.series.name +'</b><br/>'+                
                                Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) +'<br/>'+
                                Highcharts.numberFormat(this.y, 2);                         
                        }                                                                   
                    },                                                                      
                    legend: {                                                               
                        enabled: true
                    },                                                                      
                    exporting: {                                                            
                        enabled: false                                                      
                    },                                                                      
                    series: [{                                                              
                        name: '收字节数',
                        //data: [[(new Date()).getTime(),0]]
                        data: (function() {                                                 
                            // generate an array of random data                             
                            var data = [],                                                  
                                time = (new Date()).getTime(),                              
                                i;                                                          
                                                                                            
                            for (i = -9; i <= 0; i++) {                                    
                                data.push({                                                 
                                    x: time + i * 1000,                                     
                                    y: 0                                        
                                });                                                         
                            }                                                               
                            return data;                                                    
                        })()
                    },{
                        name: '发字节数',
                        //data: [[(new Date()).getTime(),0]]
                        data: (function() {                                                 
                            // generate an array of random data                             
                            var data = [],                                                  
                                time = (new Date()).getTime(),                              
                                i;                                                          
                                                                                            
                            for (i = -9; i <= 0; i++) {                                    
                                data.push({                                                 
                                    x: time + i * 1000,                                     
                                    y: 0                                        
                                });                                                         
                            }                                                               
                            return data;                                                    
                        })()
                    }]
                });
            }
            chartNET_Pkt.push($(chart_net_pkt).highcharts());
            chartNET_Byte.push($(chart_net_byte).highcharts());
        }

        var time = (new Date()).getTime();
        $.each(messageJSON, function(index, item){
            for(i=0;i<num;i++){
                var devID = 'NET'+i;
                if(item['devID']==devID && item['tag']=='13'){
                    console.log(item);
                    chartNET_Pkt[i].series[0].addPoint([time,item['metric']],true,true);
                }
                if(item['devID']==devID && item['tag']=='14'){
                    console.log(item);
                    chartNET_Pkt[i].series[1].addPoint([time,item['metric']],true,true);
                }
                if(item['devID']==devID && item['tag']=='15'){
                    console.log(item);
                    chartNET_Byte[i].series[0].addPoint([time,item['metric']],true,true);
                }
                if(item['devID']==devID && item['tag']=='16'){
                    console.log(item);
                    chartNET_Byte[i].series[1].addPoint([time,item['metric']],true,true);
                }
            }
        });
        /*
        var chartNET_1 = $('#chart_net_pkt').highcharts();
        var chartNET_2 = $('#chart_net_byte').highcharts();
        var time = (new Date()).getTime();
        result_list = [0,0,0,0];
        $.each(messageJSON, function(index, item){
            if(item['devID']=='NET0' && item['tag']=='13'){
                result_list[0] = item['metric'];
                chartNET_1.series[0].addPoint([time,item['metric']],true,true);
            }
            if(item['devID']=='NET0' && item['tag']=='14'){
                chartNET_1.series[1].addPoint([time,item['metric']],true,true);
            }
            if(item['devID']=='NET0' && item['tag']=='15'){
                chartNET_2.series[0].addPoint([time,item['metric']],true,true);
            }
            if(item['devID']=='NET0' && item['tag']=='16'){
                chartNET_2.series[1].addPoint([time,item['metric']],true,true);
            }
        });
        */
    }
    function updateChartFS(messageJSON, num){
        var chartFS_Space = [];
        var chartFS_Rate = [];
        for(i=1;i<=num;i++){
            var fs_name_space = '#chart_fs_space_'+i;
            var fs_name_rate = '#chart_fs_rate_'+i;
            if($(fs_name_space).length==0){
				if(i==1){
					$('#charts').append("<div class='pageheader'><h1 class='pagetitle contenttitle2' style='margin:0px 0px;'>磁盘监控</h1></div>");
				}
                var chartNodeCode = "<div class='one_fourth'><div class='contenttitle2'><h3>磁盘"+i+"使用状况</h3></div><br /><div id='chart_fs_space_"+i+"' style='height:300px;'></div></div>";
                chartNodeCode += "<div class='one_fourth";
                if(i%2==0){
                    chartNodeCode += " last";
                }
                chartNodeCode += "'><div class='contenttitle2'><h3>磁盘"+i+"读写状况</h3></div><br /><div id='chart_fs_rate_"+i+"' style='height:300px;'></div></div>";
                $('#charts').append(chartNodeCode);
                if(i==num){
                    $('#charts').append("<br clear='all' /><br />");
                }
                $(fs_name_space).highcharts({                                                
                    chart: {                                                                
                        plotBackgroundColor: null, 
                        plotBorderWidth: null, 
                        plotShadow: false
                    },                                                                      
                    title: {                                                                
                        text: null
                    },
                    tooltip: {                                                              
                        pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
                    },
                    plotOptions: { 
                        pie: { 
                            allowPointSelect: true, 
                            size: 200,
                            cursor: 'pointer', 
                            dataLabels: { 
                                distance:10,
                                enabled: true, 
                                color: '#000000', 
                                connectorColor: '#000000', 
                                format: '<b>{point.name}</b>: {point.percentage:.1f} %' 
                            } 
                        }
                    },
                    legend: {                                                               
                        enabled: false                                                      
                    },                                                               
                    series: [{
                        type: 'pie',
                        name: '百分比',
                        data:[
                            ['未使用', 100],
                            ['已使用', 0]
                        ]                                                            
                    }]                                                                      
                });

                $(fs_name_rate).highcharts({                                                
                    chart: {                                                                
                        type: 'spline',                                                     
                    },                                                                      
                    title: {                                                                
                        text: null
                    },                                                                      
                    xAxis: {                                                                
                        type: 'datetime',                                                   
                        tickPixelInterval: 150
                    },                                                                      
                    yAxis: {                                                                
                        title: {                                                            
                            text: '请求次数'                                                   
                        },                                                                  
                        plotLines: [{                                                       
                            value: 0,                                                       
                            width: 1,                                                       
                            color: '#808080'                                                
                        }]                                                                  
                    },                                                                      
                    tooltip: {                                                              
                        formatter: function() {                                             
                                return '<b>'+ this.series.name +'</b><br/>'+                
                                Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) +'<br/>'+
                                Highcharts.numberFormat(this.y, 2);                         
                        }                                                                   
                    },                                                                      
                    legend: {                                                               
                        enabled: true
                    },                                                                      
                    exporting: {                                                            
                        enabled: false                                                      
                    },                                                                      
                    series: [{                                                              
                        name: '每秒读请求次数',
                        //data: [[(new Date()).getTime(),0]]
                        data: (function() {                                                 
                            // generate an array of random data                             
                            var data = [],                                                  
                                time = (new Date()).getTime(),                              
                                i;                                                          
                                                                                            
                            for (i = -9; i <= 0; i++) {                                    
                                data.push({                                                 
                                    x: time + i * 1000,                                     
                                    y: 0                                        
                                });                                                         
                            }                                                               
                            return data;                                                    
                        })()
                    },{
                        name: '每秒写请求次数',
                        //data: [[(new Date()).getTime(),0]]
                        data: (function() {                                                 
                            // generate an array of random data                             
                            var data = [],                                                  
                                time = (new Date()).getTime(),                              
                                i;                                                          
                                                                                            
                            for (i = -9; i <= 0; i++) {                                    
                                data.push({                                                 
                                    x: time + i * 1000,                                     
                                    y: 0                                        
                                });                                                         
                            }                                                               
                            return data;                                                    
                        })()
                    }]
                });
            }

            chartFS_Space.push($(fs_name_space).highcharts());
            chartFS_Rate.push($(fs_name_rate).highcharts());
        }



        var time = (new Date()).getTime();
        result_list = [];
        for(i=0;i<num;i++){
            result_list.push([0,0]);
        }
        $.each(messageJSON, function(index, item){
            for(i=0;i<num;i++){
                var devID = 'FS'+i;
                if(item['devID']==devID && item['tag']=='25'){
                    console.log(item);
                    chartFS_Rate[i].series[0].addPoint([time,item['metric']],true,true);
                }
                if(item['devID']==devID && item['tag']=='26'){
                    console.log(item);
                    chartFS_Rate[i].series[1].addPoint([time,item['metric']],true,true);
                }
                if(item['devID']==devID && item['tag']=='23'){
                    console.log(item);
                    result_list[i][0] = item['metric'];
                    //chartFS_Space[i].series[0].addPoint([time,item['metric']],true,true);
                }
                if(item['devID']==devID && item['tag']=='22'){
                    console.log(item);
                    result_list[i][1] = item['metric'];
                    //chartFS_Space[i].series[1].addPoint([time,item['metric']],true,true);
                }
            }
        });
        for(i=0;i<num;i++){
            chartFS_Space[i].series[0].setData([result_list[0],result_list[1]]);
        }


        

        /*
        var chartFS_1 = $('#chart_fs_space').highcharts();
        var chartFS_2 = $('#chart_fs_rate').highcharts();
        var time = (new Date()).getTime();
        result_list = [0,0];
        $.each(messageJSON, function(index, item){
            if(item['devID']=='FS0' && item['tag']=='25'){
                chartFS_2.series[0].addPoint([time,item['metric']],true,true);
            }
            if(item['devID']=='FS0' && item['tag']=='26'){
                chartFS_2.series[1].addPoint([time,item['metric']],true,true);
            }
            if(item['devID']=='FS0' && item['tag']=='23'){
                result_list[0] = item['metric'];
            }
            if(item['devID']=='FS0' && item['tag']=='22'){
                result_list[1] = item['metric'];
            }
        });
        chartFS_1.series[0].setData([result_list[0],result_list[1]]);
        */
    }
    function analysisMessage(messageJSON){
        //console.log(typeof(messageJSON));
        //console.log(messageJSON[1]);
        var dev_list = [];
        var result_list = [0,0,0,0];
        $.each(messageJSON, function(index, item){
            //console.log(item['devID'][0]);
            // var tag = item['devID'][0];
            // if(tag=='C'){
            //     if(item['devID'])
            //     cpu_list.push(item['devID'])
            // }else{

            // }
            if($.inArray(item['devID'],dev_list)==-1){
                //console.log(item);
                dev_list.push(item['devID']);
            }else{
                console.log('Already exist!');
                //console.log($.inArray('a',['b']));
            }
        });
        console.log("dev_list:"+dev_list);
        $.each(dev_list, function(index, item){
            if(item[0]=='C'){
                result_list[0]++;
            }
            if(item[0]=='M'){
                result_list[1]++;
            }
            if(item[0]=='N'){
                result_list[2]++;
            }
            if(item[0]=='F'){
                result_list[3]++;
            }
        });
        console.log("result_list:"+result_list);
        return result_list;
    }

</script>

<script type="text/javascript">
$(document).ready(function() {
	connect();

    Highcharts.setOptions({
        global: {                                                               
            useUTC: false                                                       
        }                                                                       
    });                                                                         
    /*---------- Start Of CPU Chart --------------*/
    var chart;                                                                  
    $('#chart_cpu').highcharts({                                                
        chart: {                                                                
            type: 'spline',                                                     
        },                                                                      
        title: {                                                                
            text: null
        },                                                                      
        xAxis: {                                                                
            type: 'datetime',                                                   
            tickPixelInterval: 150                                              
        },                                                                      
        yAxis: {                                                                
            title: {                                                            
                text: 'Value'                                                   
            },                                                                  
            plotLines: [{                                                       
                value: 0,                                                       
                width: 1,                                                       
                color: '#808080'                                                
            }]                                                                  
        },                                                                      
        tooltip: {                                                              
            formatter: function() {                                             
                    return '<b>'+ this.series.name +'</b><br/>'+                
                    Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) +'<br/>'+
                    Highcharts.numberFormat(this.y, 2);                         
            }                                                                   
        },                                                                      
        legend: {                                                               
            enabled: true
        },                                                                      
        exporting: {                                                            
            enabled: false                                                      
        },                                                                      
        series: [{                                                              
            name: '用户使用率',
            //data: [[(new Date()).getTime(),0]]
            data: (function() {                                                 
                // generate an array of random data                             
                var data = [],                                                  
                    time = (new Date()).getTime(),                              
                    i;                                                          
                                                                                
                for (i = -9; i <= 0; i++) {                                    
                    data.push({                                                 
                        x: time + i * 1000,                                     
                        y: 0                                        
                    });                                                         
                }                                                               
                return data;                                                    
            })()
        },{
            name: '系统使用率',
            //data: [[(new Date()).getTime(),0]]
            data: (function() {                                                 
                // generate an array of random data                             
                var data = [],                                                  
                    time = (new Date()).getTime(),                              
                    i;                                                          
                                                                                
                for (i = -9; i <= 0; i++) {                                    
                    data.push({                                                 
                        x: time + i * 1000,                                     
                        y: 0                                        
                    });                                                         
                }                                                               
                return data;                                                    
            })()
        },{
            name: '当前空闲率',
            //data: [[(new Date()).getTime(),0]]
            data: (function() {                                                 
                // generate an array of random data                             
                var data = [],                                                  
                    time = (new Date()).getTime(),                              
                    i;                                                          
                                                                                
                for (i = -9; i <= 0; i++) {                                    
                    data.push({                                                 
                        x: time + i * 1000,                                     
                        y: 0                                    
                    });                                                         
                }                                                               
                return data;                                                    
            })()
        },{
            name: '总体使用率',
            //data: [[(new Date()).getTime(),0]]
            data: (function() {                                                 
                // generate an array of random data                             
                var data = [],                                                  
                    time = (new Date()).getTime(),                              
                    i;                                                          
                                                                                
                for (i = -9; i <= 0; i++) {                                    
                    data.push({                                                 
                        x: time + i * 1000,                                     
                        y: 0                                    
                    });                                                         
                }                                                               
                return data;                                                    
            })()
        }]
    });                          
    /*---------- End Of CPU Chart --------------*/  

    /*---------- Start Of Memory Chart --------------*/                                                    
    $('#chart_memory').highcharts({                                                
        chart: {                                                                
            plotBackgroundColor: null, 
            plotBorderWidth: null, 
            plotShadow: false
        },                                                                      
        title: {                                                                
            text: null
        },
        tooltip: {                                                              
            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: { 
            pie: { 
                allowPointSelect: true, 
                size: 200,
                cursor: 'pointer', 
                dataLabels: { 
                    distance:10,
                    enabled: true, 
                    color: '#000000', 
                    connectorColor: '#000000', 
                    format: '<b>{point.name}</b>: {point.percentage:.1f} %' 
                } 
            } 
        },
        legend: {                                                               
            enabled: false                                                      
        },                                                               
        series: [{
            type: 'pie',
            name: '百分比',
            data:[
                ['未使用', 100],
                ['已使用', 0]
            ]                                                            
        }]                                                                      
    });                          
    /*---------- End Of Memory Chart --------------*/

    /*---------- Start Of Swap Chart --------------*/                                                    
    $('#chart_swap').highcharts({                                                
        chart: {                                                                
            plotBackgroundColor: null, 
            plotBorderWidth: null, 
            plotShadow: false
        },                                                                      
        title: {                                                                
            text: null
        },
        tooltip: {                                                              
            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: { 
            pie: { 
                allowPointSelect: true, 
                size: 200,
                cursor: 'pointer', 
                dataLabels: { 
                    distance:10,
                    enabled: true, 
                    color: '#000000', 
                    connectorColor: '#000000', 
                    format: '<b>{point.name}</b>: {point.percentage:.1f} %' 
                } 
            } 
        },
        legend: {                                                               
            enabled: false                                                      
        },                                                               
        series: [{
            type: 'pie',
            name: '百分比',
            data:[
                ['未使用', 100],
                ['已使用', 0]
            ]                                                            
        }]                                                                     
    });                    
    /*---------- End Of Swap Chart --------------*/




    $('#chart_net_pkt').highcharts({                                                
        chart: {                                                                
            type: 'spline',                                                     
        },                                                                      
        title: {                                                                
            text: null
        },                                                                      
        xAxis: {                                                                
            type: 'datetime',                                                   
            tickPixelInterval: 150
        },                                                                      
        yAxis: {                                                                
            title: {                                                            
                text: 'Value'                                                   
            },                                                                  
            plotLines: [{                                                       
                value: 0,                                                       
                width: 1,                                                       
                color: '#808080'                                                
            }]                                                                  
        },                                                                      
        tooltip: {                                                              
            formatter: function() {                                             
                    return '<b>'+ this.series.name +'</b><br/>'+                
                    Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) +'<br/>'+
                    Highcharts.numberFormat(this.y, 2);                         
            }                                                                   
        },                                                                      
        legend: {                                                               
            enabled: true
        },                                                                      
        exporting: {                                                            
            enabled: false                                                      
        },                                                                      
        series: [{                                                              
            name: '收包数',
            //data: [[(new Date()).getTime(),0]]
            data: (function() {                                                 
                // generate an array of random data                             
                var data = [],                                                  
                    time = (new Date()).getTime(),                              
                    i;                                                          
                                                                                
                for (i = -9; i <= 0; i++) {                                    
                    data.push({                                                 
                        x: time + i * 1000,                                     
                        y: 0                                        
                    });                                                         
                }                                                               
                return data;                                                    
            })()
        },{
            name: '发包数',
            //data: [[(new Date()).getTime(),0]]
            data: (function() {                                                 
                // generate an array of random data                             
                var data = [],                                                  
                    time = (new Date()).getTime(),                              
                    i;                                                          
                                                                                
                for (i = -9; i <= 0; i++) {                                    
                    data.push({                                                 
                        x: time + i * 1000,                                     
                        y: 0                                        
                    });                                                         
                }                                                               
                return data;                                                    
            })()
        }]
    });

    $('#chart_net_byte').highcharts({                                                
        chart: {                                                                
            type: 'spline',                                                     
        },                                                                      
        title: {                                                                
            text: null
        },                                                                      
        xAxis: {                                                                
            type: 'datetime',                                                   
            tickPixelInterval: 150
        },                                                                      
        yAxis: {                                                                
            title: {                                                            
                text: 'Value'                                                   
            },                                                                  
            plotLines: [{                                                       
                value: 0,                                                       
                width: 1,                                                       
                color: '#808080'                                                
            }]                                                                  
        },                                                                      
        tooltip: {                                                              
            formatter: function() {                                             
                    return '<b>'+ this.series.name +'</b><br/>'+                
                    Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) +'<br/>'+
                    Highcharts.numberFormat(this.y, 2);                         
            }                                                                   
        },                                                                      
        legend: {                                                               
            enabled: true
        },                                                                      
        exporting: {                                                            
            enabled: false                                                      
        },                                                                      
        series: [{                                                              
            name: '收字节数',
            //data: [[(new Date()).getTime(),0]]
            data: (function() {                                                 
                // generate an array of random data                             
                var data = [],                                                  
                    time = (new Date()).getTime(),                              
                    i;                                                          
                                                                                
                for (i = -9; i <= 0; i++) {                                    
                    data.push({                                                 
                        x: time + i * 1000,                                     
                        y: 0                                        
                    });                                                         
                }                                                               
                return data;                                                    
            })()
        },{
            name: '发字节数',
            //data: [[(new Date()).getTime(),0]]
            data: (function() {                                                 
                // generate an array of random data                             
                var data = [],                                                  
                    time = (new Date()).getTime(),                              
                    i;                                                          
                                                                                
                for (i = -9; i <= 0; i++) {                                    
                    data.push({                                                 
                        x: time + i * 1000,                                     
                        y: 0                                        
                    });                                                         
                }                                                               
                return data;                                                    
            })()
        }]
    });



    $('#chart_fs_space').highcharts({                                                
        chart: {                                                                
            plotBackgroundColor: null, 
            plotBorderWidth: null, 
            plotShadow: false
        },                                                                      
        title: {                                                                
            text: null
        },
        tooltip: {                                                              
            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: { 
            pie: { 
                allowPointSelect: true, 
                cursor: 'pointer', 
                dataLabels: { 
                    enabled: true, 
                    color: '#000000', 
                    connectorColor: '#000000', 
                    format: '<b>{point.name}</b>: {point.percentage:.1f} %' 
                } 
            } 
        },
        legend: {                                                               
            enabled: false                                                      
        },                                                               
        series: [{
            type: 'pie',
            name: 'Random data',
            data:[
                ['Unused', 100],
                ['Used', 0]
            ]                                                            
        }]                                                                      
    });  



    $('#chart_fs_rate').highcharts({                                                
        chart: {                                                                
            type: 'spline',                                                     
        },                                                                      
        title: {                                                                
            text: null
        },                                                                      
        xAxis: {                                                                
            type: 'datetime',                                                   
            tickPixelInterval: 150
        },                                                                      
        yAxis: {                                                                
            title: {                                                            
                text: 'Value'                                                   
            },                                                                  
            plotLines: [{                                                       
                value: 0,                                                       
                width: 1,                                                       
                color: '#808080'                                                
            }]                                                                  
        },                                                                      
        tooltip: {                                                              
            formatter: function() {                                             
                    return '<b>'+ this.series.name +'</b><br/>'+                
                    Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) +'<br/>'+
                    Highcharts.numberFormat(this.y, 2);                         
            }                                                                   
        },                                                                      
        legend: {                                                               
            enabled: true
        },                                                                      
        exporting: {                                                            
            enabled: false                                                      
        },                                                                      
        series: [{                                                              
            name: '每秒读请求次数',
            //data: [[(new Date()).getTime(),0]]
            data: (function() {                                                 
                // generate an array of random data                             
                var data = [],                                                  
                    time = (new Date()).getTime(),                              
                    i;                                                          
                                                                                
                for (i = -9; i <= 0; i++) {                                    
                    data.push({                                                 
                        x: time + i * 1000,                                     
                        y: 0                                        
                    });                                                         
                }                                                               
                return data;                                                    
            })()
        },{
            name: '每秒写请求次数',
            //data: [[(new Date()).getTime(),0]]
            data: (function() {                                                 
                // generate an array of random data                             
                var data = [],                                                  
                    time = (new Date()).getTime(),                              
                    i;                                                          
                                                                                
                for (i = -9; i <= 0; i++) {                                    
                    data.push({                                                 
                        x: time + i * 1000,                                     
                        y: 0                                        
                    });                                                         
                }                                                               
                return data;                                                    
            })()
        }]
    });






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
    
    <!--
    <div class="header">
    	<ul class="headermenu">
            <li><a onclick='navjump(0)'><span class="icon icon-flatscreen"></span>业务流拓扑</a></li>
            <li><a onclick='navjump(1)'><span class="icon icon-pencil"></span>业务流性能表现</a></li>
            <li><a onclick='navjump(2)'><span class="icon icon-chart"></span>应用级负载均衡</a></li>
            <li><a onclick='navjump(3)'><span class="icon icon-speech"></span>慢调用</a></li>
            <li><a onclick='navjump(4)'><span class="icon icon-message"></span>出错调用</a></li>
        </ul>
    </div>--><!--header-->
    <!--
    <div class="pageheader">
    	<h1 class="pagetitle contenttitle2">主机负载监控</h1>
	</div>--><!--pageheader-->
    
    <div class="contentwrapper">
    <div id="note"></div>
    	<div id="charts" class="subcontent">
    	   <div style="width:300px; height:100px; margin:0 auto; text-algin:center;">加载中ing...</div>
        
<!--             <div class="one_half">
                <div class="contenttitle2">
                    <h3>CPU状况</h3>
                </div>
                <br />
                <div id="chart_cpu" style="height:300px;"></div>
            </div> -->

<!--             <div class="one_fourth">
                <div class="contenttitle2">
                    <h3>内存状况</h3>
                </div>
                <br />
                <div id="chart_memory" style="height:300px;"></div>
            </div>
            
            <div class="one_fourth last">
                <div class="contenttitle2">
                    <h3>交换内存状况</h3>
                </div>
                <br />
                <div id="chart_swap" style="height:300px;"></div>
            </div> -->

<!--             <div class="one_fourth">
                <div class="contenttitle2">
                    <h3>网络使用情况</h3>
                </div>
                <br />
                <div id="chart_net_byte" style="height:300px;"></div>
            </div>
            
            <div class="one_fourth">
                <div class="contenttitle2">
                    <h3>网络使用情况</h3>
                </div>
                <br />
                <div id="chart_net_pkt" style="height:300px;"></div>
            </div> -->

<!--             <div class="one_fourth last">            
                <div class="contenttitle2">
                    <h3>磁盘使用情况</h3>
                </div>
                <br />
                <div id="chart_fs_space" style="height:300px;"></div>
            </div>
            

            <div class="one_fourth last">            
                <div class="contenttitle2">
                    <h3>磁盘使用情况</h3>
                </div>
                <br />
                <div id="chart_fs_rate" style="height:300px;"></div>
            </div>

            <br clear="all" /><br /> -->
        
        
        </div><!--#charts-->
        
        <div id="statistics" class="subcontent">
        	&nbsp;
        </div><!--#statistics-->
        
    </div><!--contentwrapper-->
    





</div><!--bodywrapper-->

</body>
</html>
