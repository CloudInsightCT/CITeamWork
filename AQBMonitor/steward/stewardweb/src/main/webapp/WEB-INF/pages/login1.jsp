<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
	<base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=0">
    <script type="text/javascript" src="js/login/jquery.js"></script>
    <script type="text/javascript" src="js/login/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/login/jqBootstrapValidation.js"></script>
    <link href="css/login/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="css/login/bootstrap.css" rel="stylesheet" type="text/css">
	<link href="css/login/normalize.css" rel="stylesheet" type="text/css">
	<link href="css/login/cloudinsight.css" rel="stylesheet" type="text/css">
	<link rel="SHORTCUT ICON" href="images/login/icon.ico"/>
	<title>云眼CloudInsight登录</title>
  </head>
  <body>
     
		<div class="cover-image" style="background-image:url('images/login/login-top.jpg')">
			<div class="cover-image-trans">
                      <form class="form-horizontal fixed-login-form" role="form" action="login.do" method="post">
                      <!-- <form action="logincheck.jsp" method="post">  -->
                          <div class="form-group">
                            <div class="col-sm-3">
                              <label for="inputEmail3" class="control-label">用户名</label>
                            </div>
                            <div class="col-sm-9 col-xs-9">
                              <input type="text" class="form-control" id="username" name="username" placeholder="用户名" required>
                            </div>
                          </div>
                          <div class="form-group">
                            <div class="col-sm-3">
                              <label for="inputPassword3" class="control-label">密&nbsp;&nbsp;&nbsp;码</label>
                            </div>
                            <div class="col-sm-9">
                              <input type="password" class="form-control" id="password" name="password" placeholder="密码" required>
                            </div>
                          </div>
                          <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                              <div class="checkbox">
                                <label></label>
                              </div>
                            </div>
                          </div>
                          <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                           <!--    <button type="submit" class="btn btn-default login-confirm" loading-text="loading...">确认登录</button>
                              <input type="button" class="btn btn-default login-reset" value="清空重置"/>
                           --> 
                             <input type="submit" class="btn btn-default login-confirm" value="登录">
                             &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                             <a class="btn btn-default login-confirm" href="signUp.do">注册账号</a>
                            </div>
                          </div>
                        </form>

			</div>
		</div>
		<div class="hr-line"></div>
		<div class="footer">
			<div class="footer-content">
				<span class="footer-line">Copyright © 2015www.cloudinsight.net All Rights Reserved.</span>
				<span class="footer-line">备案号：XXXXXX 中国电信股份有限公司北京研究院 设计制作</span>
				<span class="footer-line">@本网站最佳使用分辨率建议为1920*1080；@本网站所有图形与文字仅供参考，一切以最终政府批准文件</span>
			</div>
		</div>
    </div>
  

</body></html>


<script>
//    $(".login-confirm").bind('click',function(){
//        $(".login-confirm").button("loading");
//    });
</script>
