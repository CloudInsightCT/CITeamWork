<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:choose>
<c:when test="${currentUser.surName=='Administrator'}">
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
</c:when>

 
<c:when test="${currentUser.surName=='operator'}">
 <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
      <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
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
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                                        监控                              
               <b class="caret"></b>
              </a>
               <ul class="dropdown-menu dropdown-menu-left">
               <li><a href="${pageContext.request.contextPath}/operator/gethost.do">可达性监控</a></li>
               </ul>
            </li>
            <li>
              <a href="${pageContext.request.contextPath}/operator/getAlarm.do">告警</a>
            </li>
             <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                                        工具                           
               <b class="caret"></b>
              </a>
               <ul class="dropdown-menu dropdown-menu-left">
               <li><a href="${pageContext.request.contextPath}/getAgent.do">agent下载</a></li>
               <li><a href="${pageContext.request.contextPath}/getFile.do">agent文档下载</a></li>
               </ul>
            </li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">
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
</c:when>

<c:when test="${currentUser.surName=='user'}">
 <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
      <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
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
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                                        监控                              
               <b class="caret"></b>
              </a>
               <ul class="dropdown-menu dropdown-menu-left">
               <li><a href="${pageContext.request.contextPath}/user/getSite.do">网站监控</a></li>
               </ul>
            </li>
             <li>
              <a >报表</a>
            </li>
            <li>
              <a href="${pageContext.request.contextPath}/user/getAlarm.do">告警</a>
            </li>
             <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                                        工具                           
               <b class="caret"></b>
              </a>
               <ul class="dropdown-menu dropdown-menu-left">
               <li><a href="${pageContext.request.contextPath}/getAgent.do">agent下载</a></li>
               <li><a href="${pageContext.request.contextPath}/getFile.do">agent文档下载</a></li>
               </ul>
            </li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">
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
</c:when>
</c:choose>