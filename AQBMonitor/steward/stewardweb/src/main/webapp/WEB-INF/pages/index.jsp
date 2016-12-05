<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
<title>APM 控制台</title>
<link rel="stylesheet" href="css/style.default.css" type="text/css" />
<script type="text/javascript" src="js/highcharts/jquery-1.8.3.min.js"></script>
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
.signuplink {
	color: #FB9337;
	font-weight: bold;
	font-size: 12px;
}
.signuplink:hover {
	color: red;
}
</style>
</head>

<body>
<div class="bodywrapper">

    <!-- <div class="header">
    	<ul class="headermenu">
            <li><a href="index.html"><span class="icon icon-flatscreen"></span>业务流拓扑</a></li>
            <li><a href="performance.html"><span class="icon icon-pencil"></span>业务流性能表现</a></li>
            <li><a href="app_load.html"><span class="icon icon-chart"></span>应用级负载监控</a></li>
            <li><a href="host_load.html"><span class="icon icon-chart"></span>主机负载监控</a></li>
            <li><a href="slow_call.html"><span class="icon icon-speech"></span>慢调用</a></li>
            <li><a href="wrong_call.html"><span class="icon icon-message"></span>出错调用</a></li>
        </ul>
    </div> --><!--header-->
    
    <div class="contentwrapper">
        <div id="updates" class="subcontent" style="width:800px; margin:0 auto; position:relative;">
        	<ul class="shortcuts" style="width:700px; float:left;">
                <div class="title" style="border-bottom:2px solid #FB9337;padding-bottom:5px; margin-bottom:20px;margin-top:50px;"><h3>应用列表<span style="float:right;"><a class="signuplink" href="signUpApp.do">添加应用监控</a></span></h3></div>
                <c:forEach items="${agents}" var="agent">
				<c:if test="${agent.type==2}">
					<c:set var="name" value="${agent.agentID}"/><!--获取名称-->
					<li><a href="topo.do?agentID=<c:out value="${agent.agentID}"/>"  style="background-image:url(./images/icons/64/<c:out value="TOMCAT"/>.png)"    class="tomcat"><span>${fn:substringAfter(name, '-')}</span></a><!--截取部分名称-->
				</c:if>
				</c:forEach>
            </ul>
           
        </div>
        
    </div><!--contentwrapper-->
    
    
</div><!--bodywrapper-->
</body>
</html>
