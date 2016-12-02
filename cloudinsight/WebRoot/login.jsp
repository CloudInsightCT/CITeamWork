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
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/jqBootstrapValidation.js"></script>
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css">
	<link href="css/normalize.css" rel="stylesheet" type="text/css">
	<link href="css/cloudinsight.css" rel="stylesheet" type="text/css">
	<link rel="SHORTCUT ICON" href="img/icon.ico"/>
	<title>云眼CloudInsight登录</title>
	<script type="text/javascript">
	function checkForm(){
		var userName=document.getElementById("userName").value;
		var password=document.getElementById("password").value;
		if(userName==null || userName==""){
			document.getElementById("login_err").innerHTML="用户名不能为空";
			return false;
		}
		if(password==null || password==""){
			document.getElementById("login_err").innerHTML="密码不能为空";
			return false;
		}
		return true;
	}
	
	</script>
  </head>
  <body>
     
		<div class="cover-image">
			<div class="cover-image-trans">
                      <form class="form-horizontal fixed-login-form" role="form" action="login.do" method="post" onsubmit="return checkForm()">
                      <!-- <form action="logincheck.jsp" method="post">  -->
                         <div id="login_tip">
						<span id="login_err" class="sty_txt2" style="color: red;">${errorMsg }</span>
				     	</div>
                          <div class="form-group">
                            <div class="col-sm-3">
                              <label for="inputEmail3" class="control-label">用户名</label>
                            </div>
                            <div class="col-sm-9 col-xs-9">
                              <input type="text" class="form-control" id="userName" name="userName" value="${user.userName }" placeholder="用户名" required>
                            </div>
                          </div>
                          <div class="form-group">
                            <div class="col-sm-3">
                              <label for="inputPassword3" class="control-label">密&nbsp;&nbsp;&nbsp;码</label>
                            </div>
                            <div class="col-sm-9">
                              <input type="password" class="form-control" id="passWord"  name="passWord"  value="${user.passWord }" placeholder="密码" required>
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
                              <input type="reset" class="btn btn-default login-reset" value="重置"/>
                            </div>
                          </div>
                        </form>

			</div>
		</div>
	
  

</body></html>


<script>
//    $(".login-confirm").bind('click',function(){
//        $(".login-confirm").button("loading");
//    });
</script>