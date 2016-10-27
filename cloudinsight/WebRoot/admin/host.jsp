<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <div class="intro" style="background: url('img/services.jpg') no-repeat center center ;text-align: center;color: #f8f8f8;background-size:100% 100%;">
        <div class="container">

            <div class="row">
                <div class="col-lg-12">
                    <div class="intro-message">
                        <h2>移动互联网蓬勃发展，云计算驱动产业升级</h2>
                          <h3>这是一个体验为王、极致精简的时代</h3>
                         <div class="divider"></div>
                    </div>
                </div>
            </div>

        </div>
        <!-- /.container -->
    </div>



  <div class="content-section-b" style="margin-top: 0;">
  <div class="container">
   <div class="row" style="background: #fff;">
				<div class="col-lg-12">
					<div class="panel-group">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h4>
									可达性监控
								</h4>
							</div>
							<div class="panel-body" style="padding-bottom: 5px;">
								
									<form action="${pageContext.request.contextPath}/admin/gethost.do" method="post">
								<!--  	<button id="check_all" class="btn btn-default ">
										<span class="glyphicon glyphicon-check" id="select_all">全选</span>
									</button>
									<button id="check_cancle" class="btn btn-default ">
										<span class="glyphicon glyphicon-star-empty" id="select_all">反选</span>
									</button>
								-->
									<button id="create_ip" class="btn btn-default btn-sm"
										data-toggle="modal" data-target="#myServer">
										<span class="glyphicon glyphicon-plus">新建监控</span>
									</button>
								  
								<div class="input-group col-xs-3" style="float:right;">
									
                                 <input type="text" class="form-control input-sm" name="host" value="${s_host.host}" placeholder="请输入监控名称...."  >
                                 <span class="input-group-btn">
                                  <button class="btn btn-default btn-sm" type="submit">查询</button>
                                </span>
                                
                                 </div>
                                 </form>
								
							</div>
							<table id="monitor" class="table table-bordered table-hover" style="font-size: 10px;">
								<thead>
									<tr>
										<th>
											序号
										</th>
										<th>
											监控名称
										</th>
										<th>
											监控IP
										</th>
										<th>
											监控频率
										</th>
										<th>监控项</th>
										<th>
											告警
										</th>
										<th>
											状态
										</th>
										<th>
											操作
										</th>
									</tr>
								</thead>
								<c:forEach var="map" items="${list}" varStatus="status">
									
									<tbody>
										<tr>
											<td>
												${status.index+1}
											</td>
											
											<td>
											<span>${map.name}</span>
											</td>
			
											<td>
											<a href="javascript:ping('${map.ip}')">${map.ip}</a>	
											</td>
											<td>
												${map.delay}
											</td>
											<td >
											 <a href="${pageContext.request.contextPath}/admin/getItems.do?hostid=${map.hostid}">监控项</a> 
											</td>
											<td>
												<a href="${pageContext.request.contextPath}/admin/getTrig.do?hostid=${map.hostid}">告警</a>
											</td>
											<td>
												正常
											</td>
											<td style="text-decoration: none;">
											
											   <a href="javascript:edit_Mes();" style="margin-right: 20px;"><span class="glyphicon glyphicon-edit" title="编辑" style="color:black;"></span></a>
											   <a href="javascript:"style="margin-right: 20px;"><span class="glyphicon glyphicon-remove" title="删除" style="color:black;"></span></a>
												<a href="javascript:get_Mor('${map.hostid}');" ><span class=" glyphicon glyphicon-list" title="图表" style="color:black;"></span></a> 
												
											</td>
										</tr>
									</tbody>

								</c:forEach>

							</table>
							<nav >
		                     <ul class="pagination">
		                    	${pageCode }
		                     </ul>
	                      </nav>
						</div>
					</div>
				</div>
			</div>
		
         
			<div class="row" id="result" style="display: none;">
				<div class="col-lg-12">
					<h2 class="page-header" contenteditable="true">
						数据结果
					</h2>
				</div>
				
				 <div class="col-md-3">
					<div class="media">
					  <h4 class="media-heading">
								时间维度
							</h4>
						<div class="media-body">
							
							<div class="input-group">
								<div class="input-group-addon">
									<i class="fa fa-clock-o"></i>
								</div>
								<input type="text" class="form-control pull-right reservation"
									id="query-time" placeholder="请选择初始时间"/>
							</div>
							 <div class="input-group" style="margin-left: 120px;display: block;">
                              <img alt="图片" src="img/jiantou.jpg" height="40px" width="20px" >
                              </div>
							  <div class="input-group">
							  <div class="input-group-addon">
									<i class="fa fa-clock-o"></i>
								</div>
								<input type="text" class="form-control pull-right reservation"
									id="query_time" placeholder="请选择时间"/>
						<!-- 	<span class="input-group-btn">
								<button class=" btn btn-primary"
								id="query_chart" loading-text="请稍后...">
								查询
							</button>
								</span>
								 -->	
							</div>
							<!-- /.input group -->
							<br />
							
						</div>
					</div>
				</div>
				
				<div class="col-md-3">
				 <div class="media">
				 <h4 class="media-heading">
				     监控项
				 </h4>
				     <div class="media-body">
				         <div class="form-group">
				            <select class="form-control" id="select">
				            <option value="-1">请选择监控项</option>
				            
				            </select>
				             <br/><br/>
				             <button class="btn-block pull-right btn btn-primary" id="query_chart" data-loading-text="请稍后...">查询</button>
				         </div>
				 
				 </div>
				 
				 </div>
				
				</div>
				
			</div>
            <div class="row" >
              <div id="list">
              
              </div>
            
            </div>
			<div class="row">
				<div id="charts_canvas">

				</div>
			</div>
    </div>      
</div>
		<script src="js/jquery.js"></script>
		<!-- Bootstrap Core JavaScript -->
		<script src="js/bootstrap.min.js"></script>
		<script src="js/datepicker/bootstrap-datepicker.js"></script>
		<script src="js/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
		<script src="js/echarts-all.js"></script>
		<script src="js/echarts-blue.js"></script>
		<script src="js/page_host.js"></script>
		<script type="text/javascript" src="js/esl.js"></script>	