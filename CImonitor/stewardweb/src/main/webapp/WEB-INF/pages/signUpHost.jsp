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
<title>APM 注册主机</title>
<link rel="stylesheet" href="css/style.default.css" type="text/css" />
<script type="text/javascript" src="js/highcharts/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/custom/general.js"></script>
<!--[if IE 9]>
    <link rel="stylesheet" media="screen" href="css/style.ie9.css"/>
<![endif]-->
<!--[if IE 8]>
    <link rel="stylesheet" media="screen" href="css/style.ie8.css"/>
<![endif]-->
<!--[if lt IE 9]>
	<script src="js/plugins/css3-mediaqueries.js"></script>
<![endif]-->
<style type="text/css">
p {
    font-size: 14px;
}
code, pre {
    font-family: Monaco, Menlo, Consolas, "Courier New", monospace;
    /*font-size: 12px;*/
    border-radius: 3px;
}
code {
    padding: 2px 4px;
    color: #c25;
    background-color: #f7f7f9;
    border: 1px solid #e1e1e8;
}
pre {
  display: block;
  padding: 9.5px;
  margin: 0 0 10px;
  /*font-size: 13px;*/
  line-height: 20px;
  word-break: break-all;
  word-wrap: break-word;
  white-space: pre;
  white-space: pre-wrap;
  background-color: #f5f5f5;
  border: 1px solid #ccc;
  border: 1px solid rgba(0, 0, 0, 0.15);
  -webkit-border-radius: 4px;
  -moz-border-radius: 4px;
  border-radius: 4px;
}
</style>
</head>

<body>
<div class="bodywrapper">
    <div class="topheader orangeborderbottom5">
        <div class="left">
            <h1 class="logo"><a href="/stewardweb/index.do">APM <span>Admin</span></a></h1>
            <span class="slogan">后台管理系统</span>
            
            <!-- <div class="search">
                <form action="" method="post">
                    <input type="datetime-local" name="time_start" />
                    <input type="datetime-local" name="time_end" />
                    <input type="text" name="keyword" id="keyword" value="请输入" />
                    <button class="submitbutton"></button>
                </form>
            </div> --><!--search-->
            
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
    
    <div class="contentwrapper" style="width:70%; margin:auto;">
        <div class="errorwrapper error403">
            <div class="errorcontent">
                <h1>主机监控接入</h1>
                
                <div class="contenttitle2">
                    <h3>1. 获取AgentId</h3>
                </div>
                <div class="profile_about">
                    <p>您的AgentId: <code>${uuidstr}</code></p>
                </div>

                <div class="contenttitle2">
                    <h3>2. 下载</h3>
                </div>
                <div class="profile_about">
                    <p>APM支持JDK6+</p>
                    <p>下载: <button class="stdbtn btn_orange"><a href="/stewardweb/downloads/APM_Host_Agent.zip" target="_blank">APM Host Agent</a></button></p>
                </div>

                <div class="contenttitle2">
                    <h3>3. 安装</h3>
                </div>
                <div class="profile_about">
                    <p>(1) 解压「Agent」至「你的目录」下: <code>unzip APM_Host_Agent.zip -d &lt;Your_Path&gt;/</code></p>
                    <p>解压完成后目录结构如下:</p>
                    <p><img src="images/dir2.png"></p>
                    <p>(2) 配置：</p>
                    <p>编辑<code>config.properties</code>配置文件</p>
                    <p>修改配置项<code>serverIP=59.56.69.124</code>为正确的APM服务端地址</p>
                    <p>修改配置项<code>id=${uuidstr}</code>为第一步给出的AgentId</p>
                    <p>(3) 启动：</p>
                    <p>启动主机监控Java程序：<code>nohup java -jar host-agent.jar &</code></p>
                </div>

                <div class="contenttitle2">
                    <h3>4. 注册Agent</h3>
                </div>
                <div class="profile_about">
                	<p>上述步骤确认完成后，点击“注册”按钮，向服务器注册新接入的主机</p>
                    <p><code>${uuidstr}</code> <button id="btn_signup" onclick="signuphost('${uuidstr}')" class="stdbtn btn_orange">注册</button></p>
                </div>
                
                <div class="contenttitle2">
                    <h3>4. 浏览</h3>
                </div>
                <div class="profile_about">
                    <p>回到<a href="/stewardweb/index.do" class="orangeboldlink">主页</a>，即可看到新接入的主机已在列表中</p>
                </div>
                
            </div><!--errorcontent-->
        </div><!--errorwrapper-->
    </div><!--contentwrapper-->
    
    
</div><!--bodywrapper-->

</body>
<script>
function signuphost(uuid) {
	$.ajax({
	   type: "GET",
	   url: '/stewardweb/signUpAgentID.do?',
	   data: 'agentid=' + uuid + '&type=1',
	   success: function(msg){
		   if(msg == 'success') {
	        	alert("注册成功！")
	        	$("#btn_signup").html("注册成功").attr("disabled", true).removeClass("btn_orange").addClass("reset");
	        } else {
	        	alert(msg);
	        }  
	   }
	});
}
</script>
</html>
