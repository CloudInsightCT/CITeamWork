<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
  
 <div class="panel panel-default">
 <div class="panel-heading">
  
		${modeName}
	
 </div>
 <div class="panel-body">
 <div class="row">
 
  <div class="col-md-3">
  
 <div class="list-group">
  <a  class="list-group-item btn btn-primary" data-toggle="collapse" data-target="#site" id="site_group">
       <span >网站监控</span>
   <b class="caret" style="float:right;margin-top: 10px;"></b>
  </a>
  
  <div id="site" class="collapse in">
 
</div>

  <a class="list-group-item btn btn-primary" data-toggle="collapse" data-target="#host" id="host_group">
 <span>可达性监控</span>
 <b class="caret" style="float:right;margin-top: 10px;"></b>
  </a>
 <div id="host" class="collapse in">

</div>
</div>
  </div>
 <div class="col-md-4">
 
 <div class="panel panel-default">
 <div class="panel-heading">
 
    监控
 </div>
 <div class="panel-body">
 <div class="col-md-12" id="monitor">
 
 
 </div>
 </div>
 <div >
 
 </div>
 </div>
 </div>
 <div class="col-md-5" style="border:1px;display: none;" id="choice">
 <div class="col-md-5">
 <div class="btn-group" data-toggle="buttons">
 <div>
  <input type="radio" name="yestoday" id="yestoday" value="yestoday">  <label> 与昨天比较</label>
 </div>
 <div>
  <input type="radio" name="lastweek" id="lastweek" value="lastweek">  <label> 与上周比较</label>
 </div>
 <div>
  <input type="radio" name="lastmonth" id="lastmonth" value="lastmonth">  <label> 与上个月作比较</label>
 </div>
 </div>
 </div>
  <div class="col-md-7">
  <div>
   <button class="btn btn-default" type="button" id="load">cpu负载</button>
  </div>
  
  </div>
 
 </div>
 </div>
 </div>
 
 </div>
 
 <div class="panel panel-default" style="display: none;" id="result">
 <div class="panel-heading">
 <div class="row">
 <div class="col-md-12" id="site_res">
 
 <span>结果</span>
 </div>
 </div>
     
 </div>
 <div class="panel-body">
 <div class="row">
 
 
  <div class="col-md-12">
 <div id="chart">
 
 
 </div>
 </div>
 </div>
 </div>
 </div>
 <script src="${pageContext.request.contextPath}/js/echarts-all.js"></script>
<script src="${pageContext.request.contextPath}/js/echarts-blue.js"></script>
<script src="${pageContext.request.contextPath}/js/page_view.js"></script>
