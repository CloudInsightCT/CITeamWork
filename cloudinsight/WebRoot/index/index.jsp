<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="description" content="">
		<meta name="author" content="">
		<title>云眼CloudInsight</title>
		<!-- Bootstrap Core
    CSS -->
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<!-- Custom CSS -->
		<link href="css/modern-business.css" rel="stylesheet">
			<link href="css/styles.css" rel="stylesheet">
		<!-- Custom Fonts -->
		<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet"
			type="text/css">
		 <link href="css/landing-page.css" rel="stylesheet">
		<!-- Date picker -->
		<link href="js/datepicker/datepicker3.css" rel="stylesheet">
		<link rel="SHORTCUT ICON" href="img/icon.ico" />
		
		<script src="js/jquery.js"></script>
       <script src="js/bootstrap.min.js"></script>
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
    String mainPage=(String)request.getAttribute("mainPage");
    
	if(mainPage==null || mainPage.equals("")){
		mainPage="index/default.jsp";
	}
  %>
  </head>
  
  <body>
      <div class="fill" style="background-image:url('http://placehold.it/1900x1080&amp;text=Slide One');"></div>
    <div class="container">
  <div class="row">
	  <div class="col-lg-12">
	  	<jsp:include page="../index/head.jsp"/>
	  </div>
  </div>
</div>

 <div class="intro">
 <jsp:include page="<%=mainPage %>"></jsp:include>
 </div>
 


 <jsp:include page="../index/foot.jsp"></jsp:include>

 
 
  </body>
</html>
