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
		<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
		<!-- Custom CSS -->
		<link href="${pageContext.request.contextPath}/css/modern-business.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/css/landing-page.css" rel="stylesheet">
		<!-- Custom Fonts -->
		<link href="${pageContext.request.contextPath}/font-awesome/css/font-awesome.min.css" rel="stylesheet"
			type="text/css">
		<!-- Date picker -->
		<link href="${pageContext.request.contextPath}/js/datepicker/datepicker3.css" rel="stylesheet">
		<link rel="SHORTCUT ICON" href="${pageContext.request.contextPath}/img/icon.ico" />
		
		<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
       <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
       <script type="text/javascript">
        $(function () { $('#site').collapse('hide');});
       
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
		mainPage="/common/default.jsp";
	}
	
	if(session.getAttribute("currentUser")==null){
	response.sendRedirect("../login.jsp");
	}
  %>
  </head>
  
  <body>
      <div class="fill" style="background-image:url('http://placehold.it/1900x1080&amp;text=Slide One');"></div>
    <div class="container">
  <div class="row">
	  <div class="col-lg-12">
	  	<jsp:include page="/common/head.jsp"/>
	  </div>
  </div>
</div>
 <div class="intro">
 <jsp:include page="<%=mainPage %>"></jsp:include>
 </div>
 
 <div class="intro" style="margin: 0;">
 
 <jsp:include page="/common/foot.jsp"></jsp:include>
 </div>
  </body>
</html>
