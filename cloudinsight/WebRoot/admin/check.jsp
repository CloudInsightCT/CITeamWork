<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
  <script src="js/jquery.js"></script>
  <script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#iperf_test").click(function(){
		var exter_ip=$("#iperf_exter_ip").val();
		var inter_ip=$("#iperf_inter_ip").val();
		var password=$("#iperf_password").val();
		var model= $('input[name="iperf_model_type"]:checked').val();
		var port=$("#iperf_port").val();
		var email=$("#useremail").val();
		var ostype=$('input[name="iperf_os"]:checked').val();
		var data={exter_ip:exter_ip,inter_ip:inter_ip,password:password,model:model,port:port,email:email,ostype:ostype};
		//alert(JSON.stringify(data));
		$("#test").modal('show');
		$.ajax({
			url:"iperf.do",
			type:"post",
			dataType:"json",
			contentType: "application/json",
			data:JSON.stringify(data),
			success: function(data){
				$("#test").modal('hide');
				//alert("success");
				//alert(JSON.stringify(data.result));
				if(JSON.stringify(data.result)=='"success"'){
					alert("测试成功，带宽为"+JSON.stringify(data.value0)+" Mbits/s，具体信息已发送至您的邮箱");
				}else if(JSON.stringify(data.result)=='"fail"'){
					alert("测试失败，测试端出现故障");
				}else{
					alert("测试失败，ssh连接失败");
				}
			},
			error: function(e){
				$("#test").modal('hide');
				alert("测试失败，输入的信息存在问题");
			}
		});
	});
	
	
	
	$("#coremark_test").click(function(){
		var ip=$("#coremark_ip").val().replace(/[ ]/g,"");
		var password=$("#coremark_pw").val().replace(/[ ]/g,"");
		var port=$("#coremark_port").val();
		var email=$("#coremarkemail").val();
		var ostype=$('input[name="coremark_os"]:checked').val();
		var testdata={ip:ip,password:password,port:port,email:email,ostype:ostype};
		$("#test").modal('show');
	//	alert(JSON.stringify(testdata));
		$.ajax({
			url:"coremark.do",
			type:"post",
			dataType:"json",
			contentType: "application/json",
			data:JSON.stringify(testdata),
			success: function(data){
				$("#test").modal('hide');
				//alert("success");
				//alert(JSON.stringify(data.result));
				if(JSON.stringify(data.result)=='"success"'){
					alert("测试成功，测试值为"+JSON.stringify(data.value)+"，具体信息已发送至您的邮箱");
				}else if(JSON.stringify(data.result)=='"failed"'){
					alert("测试失败，测试端出现故障");
				}else{
					alert("测试失败，ssh连接失败");
				}
			},
			error: function(e){
				$("#test").modal('hide');
				alert("测试失败，输入的信息存在问题");
			}
		});
	});
	
	
	$("#reset").click(function(){
		$("#iperf_form")[0].reset();
	});
});
</script>
 <div class="headers" style="background: url('images/test.jpg') no-repeat center center ;background-size:100% 100%;">
        <div class="container">

            <div class="row">
                <div class="col-lg-12">
                    <div class="intro-message">
                        <h2>选择云服务，何去何从</h2>
                          <h3>让企业业务迁移和优化更加专业与自信</h3>
                         <div class="divider"></div>
                    </div>
                </div>
            </div>

        </div>
        <!-- /.container -->
    </div>









    <div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" id="test">
		<div class="modal-dialog modal-sm">
    		<div class="modal-content">
    			<div class="modal-header">
					<h4 class="modal-title" id="myModalLabel">
               		提示
					</h4>
				</div>
				<div class="modal-body">
					<p align="center">测试中，请耐心等待...</p>
					<p align="center"><img src="images/test.gif"></p>
				</div>
    		</div>
  		</div>
	</div>

<div class="content-section-a">
<div class="container sections">
<h3> 我们的服务</h3>
<div class="service-grids">
<div class="row">
<div class="col-lg-3 col-sm-6">
<img src="images/iperf.png">
<h4>IPERF</h4>
<p>TCP和UDP网络带宽性能评测</p>
<button class="btn btn-primary" data-toggle="modal" data-target="#myModal1" style="margin: 0 40%">测试</button>

</div>


<div class="col-lg-3 col-sm-6 col-xs-12">
<img src="images/oltp.png">
<h4>SYSBENCH_OLTP</h4>
<p>数据库事务处理性能评测</p>
<button class="btn btn-primary" style="margin: 0 40%">测试</button>
</div>


<div class="col-lg-3 col-sm-6 col-xs-12">
<img src="images/fio.png">
<h4>FIO</h4>
<p>服务器磁盘读取性能评测</p>
<button class="btn btn-primary" style="margin: 0 40%">测试</button>

</div>


<div class="col-lg-3 col-sm-6 col-xs-12">
<img src="images/coremark.png">
<h4>COREMARK</h4>
<p>服务器CPU性能评测</p>
<button class="btn btn-primary" data-toggle="modal" data-target="#myModal_coremark" style="margin: 0 40%">测试</button>

</div>

</div>
<hr>
<div class="row">
<div class="col-lg-3 col-sm-6 col-xs-12">
										<img src="images/unixbench.png">
										<h4>UNIXBENCH</h4>
										<p>UNIX系统性能评测</p>
										<button class="btn btn-primary" style="margin: 0 40%">测试</button>
									</div>
									<div class="col-lg-3 col-sm-6 col-xs-12">
										<img src="images/mongoDB.png">
										<h4>MONGODB_YCSB</h4>
										<p>MongoDB性能评测</p>
										<button class="btn btn-primary" style="margin: 0 40%">测试</button>
									</div>
									<div class="col-lg-3 col-sm-6 col-xs-12">
										<img src="images/mysql.png">
										<h4>MYSQL_SERVICE</h4>
										<p>MySQL性能评测</p>
										<button class="btn btn-primary" style="margin: 0 40%">测试</button>
									</div>
									<div class="col-lg-3 col-sm-6 col-xs-12">
										<img src="images/throughout.png">
										<h4>COPY_THROUGHPUT</h4>
										<p>吞吐量评测</p>
										<button class="btn btn-primary" style="margin: 0 40%">测试</button>
									</div>

</div>
<hr>
<div class="row">
<div class="col-lg-3 col-sm-6 col-xs-12">
										<img src="images/tomcat.png">
										<h4>TOMCAT_WRK</h4>
										<p>Tomcat性能评测</p>
										<button class="btn btn-primary" style="margin: 0 40%">测试</button>
									</div>
									<div class="col-lg-3 col-sm-6 col-xs-12">
										<img src="images/Redis.png">
										<h4>REDIS</h4>
										<p>Redis性能评测</p>
										<button class="btn btn-primary" style="margin: 0 40%">测试</button>
									</div>
									<div class=" col-lg-3 col-sm-6 col-xs-12">
										<img src="images/Hadoop.png">
										<h4>HADOOP</h4>
										<p>Hadoop性能评测</p>
										<button class="btn btn-primary" style="margin: 0 40%">测试</button>
									</div>
									<div class="col-lg-3 col-sm-6 col-xs-12">
										<img src="images/object_storage.png">
										<h4>OBJECT_STORAGE</h4>
										<p>对象存储性能评测</p>
										<button class="btn btn-primary" style="margin: 0 40%">测试</button>
									</div>

</div>
<hr>
<div class="row">
<div class="col-lg-3 col-sm-6 col-xs-12">
										<img src="images/search.png">
										<h4>WEBSEARCH</h4>
										<p>网络检索性能评测</p>
										<button class="btn btn-primary" style="margin: 0 40%">测试</button>
									</div>
									<div class="col-lg-3 col-sm-6 col-xs-12">
										<img src="images/web.png">
										<h4>WEBSERVICE</h4>
										<p>网络服务性能评测</p>
										<button class="btn btn-primary" style="margin: 0 40%">测试</button>
									</div>
									<div class="col-lg-3 col-sm-6 col-xs-12">
										<img src="images/media.png">
										<h4>MEDIA_STREAMING</h4>
										<p>媒体流性能评测</p>
										<button class="btn btn-primary" style="margin: 0 40%">测试</button>
									</div>
									<div class="col-lg-3 col-sm-6 col-xs-12">
										<img src="images/graph.png">
										<h4>GRAPH_ANALYTICS</h4>
										<p>图分析性能评测</p>
										<button class="btn btn-primary" style="margin: 0 40%">测试</button>
									</div>

</div>

</div>
</div>

</div>	
	
	
	
	
	
	
	
	
	
	

						<div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
   							<div class="modal-dialog">
      							<div class="modal-content">
         							<div class="modal-header">
            						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                  						&times;
            						</button>
            						<h4 class="modal-title" id="myModalLabel">
               						请提供您所测试的硬件信息
            						</h4>
         							</div>
         							<div class="modal-body">
        							<form id="iperf_form" class="form-horizontal" role="form" >
        								<div class="form-group">
      										<label for="iperf_exter_ip" class="col-md-3 control-label">被测机外网IP</label>
      										<div class="col-md-9">
         									<input type="text" class="form-control" id="iperf_exter_ip" placeholder="由于需要两个IP，请将两个IP之间用空格隔开">
      										</div>
   										</div>
   										<div class="form-group">
      										<label for="iperf_inter_ip" class="col-md-3 control-label">被测机内网IP</label>
      										<div class="col-md-9 ">
         									<input type="text" class="form-control" id="iperf_inter_ip" placeholder="由于需要两个IP，请将两个IP之间用空格隔开">
      										</div>
   										</div>
   										<div class="form-group">
      										<label for="iperf_password" class="col-md-3 control-label">被测机密码</label>
      										<div class="col-md-9">
         									<input type="password" class="form-control" id="iperf_password" placeholder="由于需要两个密码，请将两个密码之间用空格隔开" >
      										</div>
   										</div>
   										<div class="form-group">
   										
      										<label for="iperf_model" class="col-md-3 control-label">网络模式</label>
      										<div class="col-md-9" id="iperf_model" >
      										  <div class="col-md-4" style="margin-left: 0;">
      										  <input type="radio" name="iperf_model_type" value="INTERNAL"/> 内网
      										  </div>
      										  <div class="col-md-4">
      										  <input type="radio" name="iperf_model_type" value="EXTERNAL" /> 外网
      										  </div>
         								<!--  		<input type="radio" name="iperf_model_type" value="INTERNAL"/> internal&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
         										<input type="radio" name="iperf_model_type" value="EXTERNAL" /> external
         										-->
      										
   										</div>
   										</div>
   										<div class="form-group">
      										<label for="iperf_port" class="col-md-3 control-label">端口号</label>
      										<div class="col-md-9">
         									<input type="text" class="form-control" id="iperf_port" placeholder="请输入输口号" >
      										</div>
   										</div>
   										<div class="form-group">
      										<label for="useremail" class="col-md-3 control-label">用户邮箱</label>
      										<div class="col-md-9">
         									<input type="text" class="form-control" id="useremail" placeholder="请输入您的邮箱，测试结果随后发送至此邮箱" >
      										</div>
   										</div>
   										<div class="form-group">
      										<label for="ostype" class="col-md-3 control-label">系统类型</label>
      										
      										<div class="col-md-9" id="ostype">
      									    <div class="col-md-4">
      										<input type="radio" name="iperf_os" value="debian"/> Ubuntu
      										</div>
      										<div class="col-md-4">
      										<input type="radio" name="iperf_os" value="rhel" /> RedHat/CentOS
      										</div>
         									<!-- 	<input type="radio" name="iperf_os" value="debian"/> debian&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
         										<input type="radio" name="iperf_os" value="rhel" /> rhel
      										 -->
      										</div>
   										</div>
        							</form>
         						</div>
         						<div class="modal-footer">
           					 		<button type="button" class="btn btn-primary" id="iperf_test" data-dismiss="modal" >提交信息</button>
           					 		<button type="button" class="btn btn-primary" id="reset">重置</button>
         						</div>
      						</div><!-- /.modal-content -->
							</div><!-- /.modal -->
							</div>
							
				
				
				
					
	<div class="modal fade" id="myModal_coremark" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
   		<div class="modal-dialog">
      		<div class="modal-content">
         		<div class="modal-header">
            		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            		<h4 class="modal-title" id="myModalLabel">被测机信息</h4>
         		</div>
         		<div class="modal-body">
            		<form class="form-horizontal" role="form">
            			<div class="form-group row">
      						<label class="col-md-3 control-label">外网IP</label>
      						<div class="col-md-9">
      								<input type="text" class="form-control" id="coremark_ip" placeholder="请输入外网IP"/>
      						</div>
   						</div> 
   						<div class="form-group row">
      						<label class="col-md-3 control-label">密码</label>
      						<div class="col-md-9">
      								<input type="text" class="form-control" id="coremark_pw" placeholder="请输入密码"/>
      						</div>
   						</div> 
   						<div class="form-group">
      						<label class="col-md-3 control-label">端口号</label>
      						<div class="col-md-9">
         						<input type="text" class="form-control" id="coremark_port" placeholder="请输入输口号"/>
      						</div>
   						</div>
   						<div class="form-group">
      						<label class="col-md-3 control-label">用户邮箱</label>
      						<div class="col-md-9">
         						<input type="text" class="form-control" id="coremarkemail" placeholder="请输入您的邮箱，测试结果随后发送至此邮箱"/>
      						</div>
   						</div>
   						<div class="form-group">
      						<label class="col-md-3 control-label">系统类型</label>
      						<div class="col-md-9" id="ostype">
      							<div class="col-md-4">
      								<input type="radio" name="coremark_os" value="debian"/> debian
      							</div>
      							<div class="col-md-4">
      								<input type="radio" name="coremark_os" value="rhel" /> rhel
      							</div>
         					</div>
   						</div>		
            		</form>
         		</div>
         		<div class="modal-footer">
         			<button type="button" class="btn btn-default" id="reset">重置</button>
            		<button type="button" class="btn btn-primary" id="coremark_test" data-dismiss="modal">提交</button>
         		</div>
      		</div><!-- /.modal-content -->
		</div><!-- /.modal -->
		</div>
				