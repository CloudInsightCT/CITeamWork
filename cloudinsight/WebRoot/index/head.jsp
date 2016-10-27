<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <nav class="navbar navbar-default navbar-fixed-top topnav" role="navigation" style="height: 60px;">
        <div class="container topnav">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand topnav" href="index.jsp">云眼CloudInsight</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="getAbout.do">关于云眼</a>
                    </li>
                    <li>
                        <a href="enterprise.do">企业用户</a>
                    </li>
                    <li>
                        <a href="provider.do">云服务商用户</a>
                    </li>
                    <li>
                        <a href="getCon.do">联系云眼</a>
                    </li>
                     <li>
                    <!--   <a data-toggle="modal" href="#myServer">登录</a>-->  
                    <a href="login.jsp">登录</a> 
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
