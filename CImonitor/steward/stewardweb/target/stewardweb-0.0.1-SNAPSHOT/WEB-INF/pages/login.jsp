<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>APM 登录</title>
<link rel="stylesheet" href="css/style.default.css" type="text/css" />
<script type="text/javascript" src=js/highcharts/jquery-1.8.3.min.js></script>
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
<script type="text/javascript">
$(document).ready(function(){
});
</script>
<body class="loginpage">
    <div class="loginbox">
        <div class="loginboxinner">
            
            <div class="logo">
                <h1 class="logo">APM <span>Admin</span></h1>
                <span class="slogan">账号登录</span>
            </div><!--logo-->
            
            <br clear="all" /><br />
            
            <c:choose>
	            <c:when test="${msg=='none'}">
	            </c:when>
	            
	            <c:otherwise>
	            <div class="nousername">
	                <div class="loginmsg">${msg}</div>
	            </div>
	            </c:otherwise>
            </c:choose>
            
            <form id="login" action="login.do" method="post">
                
                <div class="username">
                    <div class="usernameinner">
                        <input type="text" name="username" placeholder="请输入用户名" id="username" />
                    </div>
                </div>
                
                <div class="password">
                    <div class="passwordinner">
                        <input type="password" name="password" placeholder="请输入密码" id="password" />
                    </div>
                </div>
                
                <button id="login">登录</button>
                
                <div class="keep"><input type="checkbox" /> 记住密码</div>
                <div class="register"><a href="signUp.do">注册账号</a></div>
            </form>
            
            
        </div><!--loginboxinner-->
    </div><!--loginbox-->
</body>
</html>