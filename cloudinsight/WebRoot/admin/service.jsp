<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <div class="intro" style="background: url('img/banner03.jpg') no-repeat center center ;text-align: center;color: #f8f8f8;background-size:100% 100%;">
        <div class="container">

            <div class="row">
                <div class="col-lg-12">
                    <div class="intro-message">
                        <h2>提升业务性能，分毫必争</h2>
                          <h3>云眼CloudInsight帮你洞悉切合业务特性的瓶颈点</h3>
                         <div class="divider"></div>
                    </div>
                </div>
            </div>

        </div>
        <!-- /.container -->
    </div>
    
    
 <div class="content-section-b">
 
 <div class="container">
    
      <!-- /.row -->
      <!-- Service Panels -->
      <!-- The circle icons use Font Awesome's stacked icon classes. For more
      information, visit http://fontawesome.io/examples/ -->
      <!-- Service Tabs -->
      <div class="row"></div>
      <!-- Service List -->
      <!-- The circle icons use Font Awesome's stacked icon classes. For more
      information, visit http://fontawesome.io/examples/ -->
      <div class="row">
        <div class="col-lg-12">
          <h2 class="page-header">数据选项</h2>
        </div>
        <div class="col-md-4">
          <div class="media">
            <div class="pull-left">
              <span class="fa-stack fa-2x">
                <i class="fa fa-circle fa-stack-2x text-primary"></i>
                <i class="fa fa-tree fa-stack-1x fa-inverse"></i>
              </span>
            </div>
            <div class="media-body" id="providers">
              <h4 class="media-heading">云服务商</h4>
              <div class="checkbox">
                <label>
                  <input type="checkbox" value="AWS">亚马逊AWS</label>
              </div>
              <div class="checkbox">
                <label>
                  <input type="checkbox" value="AliYun">阿里云</label>
              </div>
              <div class="checkbox">
                <label>
                  <input type="checkbox" value="CTYun">天翼云</label>
              </div>
              <div class="checkbox">
                <label>
                  <input type="checkbox" value="UCloud">UCloud</label>
              </div>
              <div class="checkbox">
                <label>
                  <input type="checkbox" value="qcloud"">腾讯云</label>
              </div>
              <div class="checkbox">
                <label>
                  <input type="checkbox" value="ksyun">金山云</label>
              </div>
              <div class="checkbox">
                <label>
                  <input type="checkbox" value="wocloud"">联通沃云</label>
              </div>
              <div class="checkbox">
                <label>
                  <input type="checkbox" value="qingcloud"">青云</label>
              </div>
            </div>
          </div>
        </div>
        <div class="col-md-4">
          <div class="media" id="conditions">
            <div class="pull-left">
              <span class="fa-stack fa-2x">
                <i class="fa fa-circle fa-stack-2x text-primary"></i>
                <i class="fa fa-database fa-stack-1x fa-inverse"></i>
              </span>
            </div>
            <div class="media-body">
              <h4 class="media-heading">评测指标</h4>
              <div class="checkbox">
                <label>
                  <input type="checkbox" value="coremark">CPU效能</label>
              </div>
              <div class="checkbox">
                <label>
                  <input type="checkbox" value="scimark">科学计算</label>
              </div>
              <div class="checkbox">
                <label>
                  <input type="checkbox" value="hpcc">内存效率</label>
              </div>
              <div class="checkbox">
                <label>
                  <input type="checkbox" value="ping">网络延迟</label>
              </div>
              <div class="checkbox">
                <label>
                  <input type="checkbox" value="netperf">网络吞吐
                  </label>
              </div>
              <div class="checkbox">
                <label>
                  <input type="checkbox" value="fio">存储性能</label>
              </div>
              <div class="checkbox">
                <label>
                  <input type="checkbox" value="unixbench">操作系统</label>
              </div>
              <div class="checkbox">
                <label>
                  <input type="checkbox" value="oltp">关系型数据库</label>
              </div>
              <div class="checkbox">
                <label>
                  <input type="checkbox" value="nosql">NoSQL数据库</label>
              </div>
            </div>
          </div>
        </div>
        <div class="col-md-4">
          <div class="media">
            <div class="pull-left">
              <span class="fa-stack fa-2x">
                <i class="fa fa-circle fa-stack-2x text-primary"></i>
                <i class="fa fa-paper-plane fa-stack-1x fa-inverse"></i>
              </span>
            </div>
            <div class="media-body">
              <h4 class="media-heading">时间维度</h4>
           		<div class="input-group">
				  <div class="input-group-addon">
					<i class="fa fa-clock-o"></i>
				  </div>
				  <input type="text" class="form-control pull-right reservation" id="query-time"/>
				</div><!-- /.input group -->
				<br/>
				<button class="btn-block pull-right btn btn-primary" id="query-chart" loading-text="请稍后...">查询</button>
            </div> 
          </div>
        </div>
      </div>
      <!-- /.row -->
      <div class="row">
        <div class="col-lg-12">
          <h2 class="page-header" contenteditable="true">数据结果</h2>
        </div>
        <div id="charts-canvas">
        </div>
      </div>
      
      <hr>
 
 </div>
 
 
 </div>
 
 <script src="js/jquery.js"></script>
			<!-- Bootstrap Core JavaScript -->
			<script src="js/bootstrap.min.js"></script>
			<script src="js/datepicker/bootstrap-datepicker.js"></script>
			<script src="js/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>		
			<script src="js/echarts-blue.js"></script>
		    <script src="js/echarts-all.js"></script>
			
			<script src="js/page_services.js"></script>