<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
 	<title>云眼CloudInsight</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/landing-page.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/js/datepicker/datepicker3.css" rel="stylesheet">
    <link rel="SHORTCUT ICON" href="img/icon.ico"/>
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
      <style type="text/css">
      .navbar .nav > li .dropdown-menu {
	  margin: 0;
     }
     .navbar .nav > li:hover .dropdown-menu {
	display: block;
     }
     ul li{  
    list-style-type:none;  
    }  
      </style>
    
    <%
	if(session.getAttribute("currentUser")==null){
	response.sendRedirect("login.jsp");
	}
	 %>
  </head>
  
  <body>
   <nav class="navbar navbar-default navbar-fixed-top topnav" role="navigation">
      <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header topnav">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="main.jsp">云眼CloudInsight</a>
        </div>    
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
          <ul class="nav navbar-nav navbar-right">
            
             <li class="dropdown">
              <a href="#" class="dropdown-toggle " data-toggle="dropdown" id="dropdownMenu1" data-hover="dropdown" data-delay="1000" data-close-others="false">
                                                        监控                              
               <b class="caret"></b>
              </a>
               <ul class="dropdown-menu dropdown-menu-left " style="float: left;" >
               <li ><a href="${pageContext.request.contextPath}/admin/getSite.do" >网站监控</a></li>
               <li><a href="${pageContext.request.contextPath}/admin/gethost.do">可达性监控</a></li>
               </ul>
            </li>
              <li>
              <a href="${pageContext.request.contextPath}/admin/check.do">测试</a>
            </li>
           <li>
              <a href="${pageContext.request.contextPath}/admin/data.do">云眼数据</a>
            </li>
            
            <li>
              <a href="${pageContext.request.contextPath}/admin/getAlarm.do">告警</a>
            </li>
             <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                                        工具                           
               <b class="caret"></b>
              </a>
               <ul class="dropdown-menu dropdown-menu-left" style="float: left;">
               <li><a href="${pageContext.request.contextPath}/getAgent.do">agent下载</a></li>
               <li><a href="${pageContext.request.contextPath}/getFile.do">agent文档下载</a></li>
               </ul>
            </li>
            <li class="dropdown" >
              <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown">
               ${currentUser.userName}                              
               <b class="caret"></b>
              </a>
               <ul class="dropdown-menu dropdown-menu-left">
               <li><a href="login.jsp">登录退出</a></li>
               </ul>
            </li>
          </ul>
        </div>
        
        <!-- /.navbar-collapse -->
      </div>
      <!-- /.container -->
    </nav>
    
       <div class="intro" style="background: url('img/banner03.jpg') no-repeat center center ;text-align: center;color: #f8f8f8;background-size:100% 100%;">
        <div class="container">

            <div class="row">
                <div class="col-lg-12">
                    <div class="intro-message">
                        <h2>提升业务性能，分毫必争</h2>
                          <h3>云眼CloudInsight帮你洞悉切合业务特性的瓶颈点</h3>
                         <div class="divider"></div>
                    </div>
                </div>
            </div>

        </div>
        <!-- /.container -->
    </div>
    
    <div class="content-section-b">
     <div class="container">
    		<div class="row" id="result_one" >

					<div class="col-lg-12 col-sm-12">
						<h3 class="page-header" contenteditable="true">
							${name} ${add}监测点结果查询
						</h3>
						<div class="row">
						<div class="media">
								<div class="media-body">
									<h4 class="media-heading" style="margin-left: 10px;">
										时间维度检测
									</h4>
						      <div class="col-md-3 col-sm-5">
							
									<div class="input-group">
										<div class="input-group-addon">
											<i class="fa fa-clock-o"></i>
										</div>
										<input type="text" class="form-control pull-right reservation"
											id="query-time" />
									</div>
									</div>
									<div class="col-md-1 col-sm-2">
									<div class="input-group">
										<img alt="图片" src="img/jiantou.png" height="40px" width="20px" style="margin-left: 20px;">
									</div>
									</div>
									<div class="col-md-3 col-sm-5">
									<div class="input-group" style="margin-left: 0px;">

										<input type="text" class="form-control pull-right reservation"
											id="query_time" />
										<span class="input-group-btn">
											<button class="btn btn-primary" type="button" id="query"
												loading-text="请稍后...">
												查询
											</button> </span>
									</div>
									<!-- /.input group -->
									<br />
									<div>

									</div>
								</div>
							</div>
                      </div>
						</div>
					</div>
				</div>
			</div>

			<br />
           
			<div class="row">
			 
				<div id="charts_canvas" class="col-lg-12 col-sm-12 ">

				</div>
			</div>

		</div>
<div class="content-section-a">
	 <footer>
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                    <a href="http://www.ctbri.com.cn/"><h3 class="text-info">中国电信北京研究院</h3>
                    </a>
                    <p class="text-primary">Copyright@CTBRI CloudInsight 2016
					</p>
               </div>
            </div>
        </div>
    </footer>
    </div>
  </body>
  <script src="js/datepicker/bootstrap-datepicker.js"></script>
<script src="js/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
<script type="text/javascript" src="js/echarts-blue.js"></script>
<script type="text/javascript" src="js/echarts-all.js"></script>
<script>
$(document).ready(function(){  

var add='${add}';
var name='${name}'
//alert(add);

  
		   //获取所选择时间的数据      
	       $("#query").click(function(){
	    	   if($("#query-time").val().trim()==''||$("#query_time").val().trim()==''){
	    			 alert("请选择时间");
	    			 return ;
	    		 }
	    	  $('#charts_canvas').empty();
	    	   var http=["speed","response"];
	    	  $.each(http,function(i,value){
	    		var id=value;
			    var idChart=id+"_chart";
				$("#charts_canvas").append('<div id="'+idChart+'" class="col-md-12 col-sm-12" style="height:400px;"></div>');
	    	   $.ajax({
	    		  "dataType":"json",
	    		  "type":"post",
	    		  "url":  "getSite_data.do",
	    		  "data":{'add':add,'preTime':$("#query-time").val().trim(),'name':name,'time':$("#query_time").val().trim(),'id':id},
	    		  "async": false,
	    		  "success":function(dataMap){
	    			  getMore(id,idChart,dataMap);
	    		  },
	    		  "error":function(e){
	    			  alert("error");
	    		  }
	    	  });
	    	  });    
	       });
	       
	function getMore(id,idChart,dataMap){
//	alert(id);
//	alert(dataMap);
	 var Data=[]; 
	 var seriesData=[];
	var xAxisData=[];
	for(var i=0;i<dataMap.length;i++){
		xAxisData.push(dataMap[i].time);
		//alert(dataMap[i].time);
		Data.push(dataMap[i].value);
	}
  switch(id){
  case 'speed':
		legendData=['加载速度'];
		titleText="加载速度";
		subText="单位：KBPs";
		seriesData.push({
            name:'加载速度', //注意name必须等于前面指定的legendData
            type:'line',
            smooth:true,
            itemStyle: {normal: {areaStyle: {type: 'default'}}},
            data: Data,
            markPoint : {
                data : [
                    {type : 'max', name: '最大值'},
                    {type : 'min', name: '最小值'}
                ]
            },
            markLine : {
                data : [
                    {type : 'average', name: '平均值'}
                ]
            }
    	});
		break;
 case 'response':
		legendData=['响应时间'];
		titleText="响应时间";
		subText="单位：s";
		
		seriesData.push({
            name:'响应时间', //注意name必须等于前面指定的legendData
            type:'line',
            smooth:true,
            itemStyle: {normal: {areaStyle: {type: 'default'}}},
            data:Data,
            markPoint : {
                data : [
                    {type : 'max', name: '最大值'},
                    {type : 'min', name: '最小值'}
                ]
            },
            markLine : {
                data : [
                    {type : 'average', name: '平均值'}
                ]
            }
    	});
		break;
	default:break;
 
 }
 
 
 var myChart = echarts.init(document.getElementById(idChart)); 
 var axisData = xAxisData;
    var option = {
    	    title : {
    	        text: titleText,
    	        subtext: subText
    	    },
    	    tooltip : {
    	        trigger: 'axis'
    	    },
    	    legend: {
    	        data:legendData //动态生成多个不同类别
    	    },
    	    toolbox: {
    	        show : true,
    	        feature : {
    	            mark : {show: true},
    	            dataView : {show: true, readOnly: false},
    	            magicType : {show: true, type: ['line','bar']},
    	            restore : {show: true},
    	            saveAsImage : {show: true}
    	        }
    	    },
    	    calculable : true,
    	    dataZoom : {
                show : true,
                realtime: true,
                start : 50,
                end : 100
            },    	    
    	    xAxis : [
    	        {
    	        	type : 'category',
                    position:'bottom',
                    boundaryGap : true,
                    axisLabel:{show:false},
                    axisTick: {onGap:false},
                    splitLine: {show:false},	   
    	            data : axisData //动态生成x横轴坐标       
    	        }
    	    ],
    	    yAxis : [
    	        {   
    	            type : 'value',
    	            scale:true,
    	         //   splitLine: {show:false},
    	            splitArea : {show : true}
    	        }
    	    ],
    	    series : seriesData //动态生成纵轴数据
    };
	 // 为echarts对象加载数据 
    myChart.setOption(option);
	
	
}

$('.reservation').datepicker({
minView: "month", //选择日期后，不会再跳转去选择时分秒 
format: "yyyy-mm-dd", //选择日期后，文本框显示的日期格式 
language: 'zh-CN', //汉化 
autoclose:true //选择日期后自动关闭 
});

});
	

</script>
</html>
