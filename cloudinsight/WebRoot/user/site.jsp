<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <header id="myCarousel" class="carousel slide" data-interval="false" data-ride="carousel" ">
      <!-- Indicators -->
      <!-- Wrapper for slides -->
      <div class="carousel-inner">
        <div class="item active">
          <div class="fill" style="background-image: url('img/banner03.jpg');"></div>
          
        </div>
      </div>
    </header>
<div class="content-section-b">
  <div class="container">
   <div class="row" style="background: #fff; margin-top: 10px;">

				<div class="col-lg-12">
					<div id="myTabContent" class="panel-group">
						<div id="service-one" class="panel panel-default">

							<div class="panel-heading">
								<h3>
									网站监控
								</h3>
							</div>
							<div class="panel-body" style="padding-bottom: 5px;">
								
								<!--  <button id="check_all" class="btn btn-default btn-sm">
										<span class="glyphicon glyphicon-check">全选</span>
									</button>
									<button id="check_cancle" class="btn btn-default btn-sm">
										<span class="glyphicon glyphicon-star-empty" id="select_all">反选</span>
									</button>
								-->	
									<form action="${pageContext.request.contextPath}/user/getSite.do" method="post">
									<button id="create-internet" class="btn btn-default btn-sm"
										data-toggle="modal" data-target="#myModal" type="button">
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

							<table id="users" class="table table-bordered table-hover" style="font-size: 10px;">
								<thead>
									<tr>
										<th>
											序号
										</th>
										<th>
											监控名称
										</th>
										<th>
											监控网址
										</th>
										<th>
											监控频率
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
												${map.name}
											</td>
											<td>
												<a href="${map.url}" target="_blank">${map.site}</a>
											</td>
											<td>
												${map.delay}
											</td>
											<td>
												正常
											</td>
											<td style="text-decoration: none;">
											  <a href="javascript:edit_Mes();" style="margin-right: 20px;"><span class="glyphicon glyphicon-edit" title="编辑" style="color:black;"></span></a>
											   <a href="javascript:"style="margin-right: 20px;"><span class="glyphicon glyphicon-remove" title="删除" style="color:black;"></span></a>
												<a href="javascript:get_Mes('${map.hostid}')" ><span class=" glyphicon glyphicon-list" title="图表" style="color:black;"></span></a> 
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
				<!-- 图形 -->
				<br />

				<div class="row" style="margin-top: 100px; display: block;">

				</div>

				<div class="row" id="result_one" style="display: none;">

					<div class="col-lg-12">
						<h3 class="page-header" contenteditable="true">
							数据结果
						</h3>
						<div class="col-md-3">
							<div class="media">
								<div class="media-body">
									<h4 class="media-heading">
										时间维度检测
									</h4>
									<div class="input-group">
										<div class="input-group-addon">
											<i class="fa fa-clock-o"></i>
										</div>
										<input type="text" class="form-control pull-right reservation"
											id="query-time" />
									</div>
									<div class="input-group"
										style="margin-left: 120px; display: block;">
										<img alt="图片" src="img/jiantou.jpg" height="40px" width="20px">
									</div>
									<div class="input-group">

										<input type="text" class="form-control pull-right reservation"
											id="query_time" />
										<span class="input-group-btn">
											<button class="btn btn-primary" type="button" id="query"
												loading-text="请稍后...">
												查询
											</button> </span>
									</div>
									<!-- /.input group -->
									<br />
									<div>

									</div>
								</div>
							</div>

						</div>
					</div>
				</div>
			</div>

			<br />

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
			
			<script src="js/echarts-blue.js"></script>
		    <script src="js/echarts-all.js"></script>
			
			<script src="js/page_site.js"></script>
  