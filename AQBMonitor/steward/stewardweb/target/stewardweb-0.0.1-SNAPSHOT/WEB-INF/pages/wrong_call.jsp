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
<title>APM 出错调用</title>
<link rel="stylesheet" href="css/style.default.css" type="text/css" />
<link rel="stylesheet" href="css/jquery.dataTables.min.css" type="text/css" />
<link type="text/css" href="css/jquery.simple-dtpicker.css" rel="stylesheet" />
<script type="text/javascript" src="js/highcharts/jquery-1.8.3.min.js"></script>
<!-- <script type="text/javascript" src="js/plugins/jquery-ui-1.8.16.custom.min.js"></script> -->
<script type="text/javascript" src="js/highcharts/highcharts.js"></script>
<script type="text/javascript" src="js/datetimepicker/jquery.simple-dtpicker.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="js/custom/general.js"></script>
<script type="text/javascript">
function getPercent(numA, numB){
    if(numA=="" || numB==""){
        return "-";
    }else{
        numA = parseFloat(numA.replace(",",""));
        numB = parseFloat(numB.replace(",",""));
        var total = numA+numB;
        return total <= 0 ? "0%" : (Math.round(numB / total * 10000)/100);
    }
}
function getWrongCallDetailData(traceID, timeStamp, data){
    var callstack = data["callStack"];
    var list_detail_items = [];
    $.each(callstack, function(index, item){
        var row = {"time_begin":item[1], "time_end":item[2], "appName":item[4], "tag":item[5], "id":item[6], "parentId":item[7], "title":item[10], "args":item[11], "formatTime":item[12], "gap":item[13], "execTime":item[14], "simpleClassName":item[16], "serviceType":item[17], "agent":item[18], "hasChild":item[19], "hasException":item[20]};
        list_detail_items.push(row);
    });
    return list_detail_items;
};

function getWrongCallData(data){
    var list_items = [];
    $.each(data, function(index, item){
        var code_item = {
            "index": (index+1),
            "time": {
                "timeFormat": Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', item.startTime),
                "timeStamp": item.startTime
            },
            "rpc": item.rpc,
            "timeResponse": item.elapsed,
            "exception": item.exceptionMessage,
            "agentId": item.agentId,
            "remoteAddr": item.remoteAddr,
            "transactionId": item.transactionId
        }
        list_items.push(code_item);
    });
    return list_items;
};

function format(d){
    console.log("/stewardweb/transactionInfo.do?traceId="+d.transactionId+"&focusTimestamp="+d.time.timeStamp);
    var json_url = "/stewardweb/transactionInfo.do?traceId="+d.transactionId+"&focusTimestamp="+d.time.timeStamp;
    var result = '<table cellpadding="5" cellspacing="0" border="0" style="padding-left:50px; width:100%; border:1px red solid;">'+
            '<tr>'+
                '<td>调用方法</td>'+
                '<td>参数</td>'+
                '<td>调用时间</td>'+
                '<td>间隔时间(ms)</td>'+
                '<td>执行时间(ms)</td>'+
                '<td>时间占比(%)</td>'+
                '<td>组件类型</td>'+
                '<td>应用名称</td>'+
                '<td>探针Id</td>'+
                '<td>应用名称</td>'+
            '</tr>';
    $.ajax({
        type:"GET",
        dataType:"JSON",
        async:false,
        url:json_url,
        success:function(data) {
            var data_wrong_call_detail = data;
            var list_detail_items = getWrongCallDetailData(d.transactionId, d.time.timeStamp, data_wrong_call_detail);
            $.each(list_detail_items, function(index, item){
                result = result +
                    '<tr>'+
                        '<td>'+item['title']+'</td>'+
                        '<td>'+item['args']+'</td>'+
                        '<td>'+item['formatTime']+'</td>'+
                        '<td>'+item['gap']+'</td>'+
                        '<td>'+item['execTime']+'</td>'+
                        '<td>'+getPercent(item['gap'], item['execTime'])+'</td>'+
                        '<td>'+item['simpleClassName']+'</td>'+
                        '<td>'+item['serviceType']+'</td>'+
                        '<td>'+item['agent']+'</td>'+
                        '<td>'+item['appName']+'</td>'+
                    '</tr>';
            });
            result += '</table>';
        }

    });
    return result;
};



$(document).ready(function(){
	var json_url = '/stewardweb/transactionErrorMetadata.do?agentID=' + agentID + '&from=' + sttime + '&to=' + endtime + '&limit=5000&v=2&threshold=' + threshold;
    $.getJSON(json_url,function(data,status){
        var data_wrong_call = data;
        var list_items = getWrongCallData(data_wrong_call);
        var table = $('#table_root').DataTable({
            "data": list_items,
            "columns":[
                {
                    "className":      'details-control',
                    "orderable":      false,
                    "data":           null,
                    "defaultContent": ''
                },
                {"data": "index"},
                {"data": "time.timeFormat"},
                {"data": "rpc"},
                {"data": "timeResponse"},
                {"data": "exception"},
                {"data": "agentId"},
                {"data": "remoteAddr"},
                {"data": "transactionId"}
            ],
            "order": [[1, 'asc']]
        });
        // Add event listener for opening and closing details
        $('#table_root tbody').on('click', 'td.details-control', function(){
            var tr = $(this).closest('tr');
            var row = table.row( tr );
     
            if (row.child.isShown()){
                // This row is already open - close it
                row.child.hide();
                tr.removeClass('shown');
            }
            else {
                // Open this row
                row.child(format(row.data())).show();
                tr.addClass('shown');
            }
        });
    });
	
});


function submitSearchForm(){
    var time_from = $('input[name=from]').val();
    var time_to = $('input[name=to]').val();
    stamp_from = new Date(time_from);
    stamp_to = new Date(time_to);
    sttime = stamp_from.getTime();
    endtime = stamp_to.getTime();
    var new_url = '/stewardweb/wrongCall.do?agentID='+ agentID+'&sttime=' + sttime + '&endtime=' + endtime + '&limit=5000&v=2&threshold=' + threshold;
    window.location.href = new_url;

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
            <li><a onclick='navjump(2)'><span class="icon icon-chart"></span>应用级负载</a></li>
            <li><a onclick='navjump(3)'><span class="icon icon-speech"></span>慢调用</a></li>
            <li class="current"><a onclick='navjump(4)'><span class="icon icon-message"></span>出错调用</a></li>
        </ul>
    </div><!--header-->
    
    <div class="pageheader">
    	<h1 class="pagetitle contenttitle2">出错调用</h1>
    </div><!--pageheader-->
    
    <div class="contentwrapper">
    
        <table cellpadding="0" cellspacing="0" border="0" class="display" id="table_root">
            <thead>
                <tr>
                    <th></th>
                    <th>#</th>
                    <th>时间</th>
                    <th>调用组件</th>
                    <th>响应时间(ms)</th>
                    <th>异常</th>
                    <th>探针ID</th>
                    <th>客户端IP</th>
                    <th>事务ID</th>
                </tr>
            </thead>
        </table>  

    </div><!--contentwrapper-->
    
    
</div><!--bodywrapper-->

</body>
</html>
