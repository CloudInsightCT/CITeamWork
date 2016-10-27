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
									监控项
								</h4>
							</div>
						
							<table id="monitor" class="table table-bordered table-hover" style="font-size: 10px;">
								<thead>
									<tr>
										<th>
											序号
										</th>
										<th>
											监控项
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
											<span>${map.name}</span>
											</td>
			
											
											<td>
												${map.delay}
											</td>
											
											
											<td>
												正常
											</td>
											<td>
											<a href="javascript:get_Mes('${map.itemid}')" ><span class=" glyphicon glyphicon-list" title="图表" style="color:black;"></span></a> 
											
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
		
         
			
         
          <br />


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
			
			<script src="js/page_items.js"></script>
  