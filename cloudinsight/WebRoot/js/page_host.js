//对应host.jsp
$("#http-sure")
			.click(
					function() {

						var name = $("#name").val();
						var http = $("#http").val();
						var select = $("#select option:selected").text();
						$("#monitor tbody")
								.append(
										);
						$('#myServer').modal('hide');

					});

	function edit_Mes() {
		$('#editServer').modal('show');

	}

	//全选
	$("#check_all").click(function() {
		$("#monitor").find('input:checkbox').each(function() {
			this.checked = true;
		});
	});
	//取消全选
	$("#check_cancle").click(function() {
		$("#monitor").find('input:checkbox').each(function(){
		this.checked = false;
		});
		});
	function ping(ip){
	 window.open ("getPing.do?ip="+ip, "newwindow", "height=550, width=400, top=100px,left=430px;toolbar=no, menubar=no, scrollbars=no, resizable=yes, location=no, status=no");
	}	
	
	
	$("#show").click(function(){
	 $("#monitor").find('input:checkbox:checked').each(function(){
	 var value=$(this).parent("tr").find('');
	} );
	});
function get_Mor(hostid){
	//alert(JSON.stringify({hostid:hostid}));
	//$.ajax({
	//"dataType":"json",
//	"type":"post",
//	"url":"getitems.do",
//	"contentType": "application/json",
//	"data":JSON.stringify({hostid:hostid}),
//	"success":function(data){
		//var data=eval(data);
		//alert(data.name);
	//	loadItem(hostid,data);
//	},
//	"error":function(){
//		alert("error");
//	}
//	});
	// $("#result").show();

	$("table input").each(function(){
		if($(this).val()==hostid){
			this.checked=true;
		}
		if($(this).val()!=hostid){
			this.checked=false;
		}
	
	});
	
	 var mytime=dateToStr(new Date());
	// var mytime="2016-04-06 01:00:00";
	// var ping=["loss","response"];
	 $('#charts_canvas').empty();
	 $.ajax({
			"dataType":"json",
			"type":"post",
			"contentType": "application/json",
			"url":"getData.do",
			"data":JSON.stringify({hostid:hostid,time:mytime}),
			"async": false,
			"success":function(dataMap){
				//alert(dataMap);
				load_Chart(dataMap);
			},
			"error":function(){
			 alert("error");
			}
		 });
	 
	 
	 
	 $("#query_chart").click(function(){
		 var btn=$(this).button('loading');
		 if($("#query_time").val().trim()==''||$("#query-time").val().trim()==''){
			 alert("请选择时间");
			 return ;
		 }
		 if($("#select option:selected").text()==-1){
			 alert("请选择监控项");
			 return;
		 }
		 var key=$("#select option:selected").text();
	//	 alert($("#select option:selected").text());
		 $('#charts_canvas').empty();
		// $.each(data,function(m,value){
				// var key=value.key;
				
			//	 var idChart=key+"_chart";
				
			//	 $("#charts_canvas").append('<div id="'+idChart+'" class="col-md-12 col-sm-12" style="height:400px;"></div>');
				 $.ajax({
				  "dataType":"json",
				  "type":"post",
				  "contentType": "application/json",
				  "url": "getHost_data.do" ,
				  "data":JSON.stringify({hostid:hostid,time:$("#query_time").val().trim(),preTime:$("#query-time").val().trim(),key:key}),
				  "async": false,
				  success:function(dataMap){
					 
					  load_Chart(dataMap);
					  btn.button('reset');
				 },
				 error:function(e){
					 alert("error");
				 }
				 });
			
		// });
		 
	 });
	// $.each(ping,function(i,value){
	//	 var id=value;
	//	 var idChart=id+"_chart";
	//	 $("#charts_canvas").append('<div id="'+idChart+'" class="col-md-12 col-sm-12" style="height:400px;"></div>');
	//	 $.ajax({
	//			"dataType":"json",
	//			"type":"post",
				
	//			"url":"getLocalData.do",
	//			"data":{'hostid':hostid,'time':mytime,'id':id},
	//			"async": false,
	//			"success":function(dataMap){
	//				loadChart(id,idChart,dataMap);
	//			},
	//			"error":function(){
	//			 alert("error");
	//			}
	//		 });
//	 });

	 
	// 
	// $("#query_chart").click(function(){
	//	 if($("#query_time").val().trim()==''||$("#query-time").val().trim()==''){
	//		 alert("请选择时间");
	//		 return ;
	//	 }
	//	 $('#charts_canvas').empty();
	//	 $.each(ping,function(m,value){
	//			 var id=value;
	//			 var idChart=value+"_chart";
	//			 $("#charts_canvas").append('<div id="'+idChart+'" class="col-md-12 col-sm-12" style="height:400px;"></div>');
	////			 $.ajax({
	//			  "dataType":"json",
	//			  "type":"post",
	//			  "url": "getHost_data.do" ,
	//			  "data":{'hostid':hostid,'id':id,'time':$("#query_time").val().trim(),'preTime':$("#query-time").val().trim()},
	//			  "async": false,
	//			  success:function(dataMap){
	//				  loadChart(id,idChart,dataMap);
	//			 },
	//			 error:function(e){
		//			 alert("error");
	//			 }
	//			 });
			
	//	 });
		 
	// });
 }	 
//function load_Chart(dataMap){
//	var item=[];
//	//alert(dataMap[0].key);
//	for(var i=0;i<dataMap.length;i++){
//		if(item.indexOf(dataMap[i].key)==-1){
//			item.push(dataMap[i].key);
//		}
//	}
//	//alert(item);
//	$("#result").show();
//	 $.each(item,function(i,value){
//		 var id=value;
//		 var idChart=id+"_chart";
//		 $("#charts_canvas").append('<div id="'+idChart+'" class="col-md-12 col-sm-12" style="height:400px;"></div>');
////		 var Data=[]; 
//		 var seriesData=[];
//		var xAxisData=[];
//		for(var i=0;i<dataMap.length;i++){
//			if(dataMap[i].key==id){
//				Data.push(dataMap[i].value);
//				xAxisData.push(dataMap[i].time);
//			}
	//	}
//	 });
	
//}

//function loadItem(hostid,data){
//	 $("#result").show();
//	 var mytime=dateToStr(new Date());
	// var mytime="2016-04-06 01:00:00";
//	 var ping=["loss","response"];
//	 $('#charts_canvas').empty();
//	 $.each(data,function(i,value){
//		 var key=value.key;
//		 var idChart=key+"_chart";
//		 $("#charts_canvas").append('<div id="'+idChart+'" class="col-md-12 col-sm-12" style="height:400px;"></div>');
//		 $.ajax({
//				"dataType":"json",
//				"type":"post",	
//				"url":"getLocalData.do",
//				"contentType": "application/json",
//				"data":JSON.stringify({hostid:hostid,time:mytime,key:key}),
//				"async": false,
//				"success":function(dataMap){
//					//alert(dataMap);
//					loadChart(key,idChart,dataMap);
//				},
//				"error":function(){
//				 alert("error");
//				}
//			 });
//	 });
    
//	 $("#query_chart").click(function(){
//		 if($("#query_time").val().trim()==''||$("#query-time").val().trim()==''){
//			 alert("请选择时间");
//			 return ;
//		 }
//		 $('#charts_canvas').empty();
//		 $.each(data,function(m,value){
//				 var key=value.key;
				
//				 var idChart=key+"_chart";
//				
//				 $("#charts_canvas").append('<div id="'+idChart+'" class="col-md-12 col-sm-12" style="height:400px;"></div>');
//				 $.ajax({
//				  "dataType":"json",
//				  "type":"post",
//				  "contentType": "application/json",
//				  "url": "getHost_data.do" ,
//				  "data":JSON.stringify({hostid:hostid,key:key,time:$("#query_time").val().trim(),preTime:$("#query-time").val().trim()}),
//				  "async": false,
//				  success:function(dataMap){
//					 
//					  loadChart(key,idChart,dataMap);
//				 },
//				 error:function(e){
//					 alert("error");
//				 }
//				 });
//			
//		 });
		 
//	 });
	
	
//}
 function addSelect(item){
	 var sel=document.getElementById("select");
	 $("select").val(""); 
	// sel.empty();
	 for(var i=0;i<item.length;i++){
		 var option=document.createElement("option");
		 option.value=item[i];
		 option.text=item[i];
		sel.add(option);
	 }
 }
 //function  loadChart(id,idChart,dataMap){ 
	 function load_Chart(dataMap){
		 var item=[];
			//alert(dataMap[0].key);
			for(var i=0;i<dataMap.length;i++){
				if(item.indexOf(dataMap[i].key)==-1){
					item.push(dataMap[i].key);
				}
			}
			//alert(item);
			addSelect(item);
			$("#result").show();
			 $.each(item,function(i,value){
				 var id=value;
				 var idChart=id+"_chart";
				 $("#charts_canvas").append('<div id="'+idChart+'" class="col-md-12 col-sm-12" style="height:400px;"></div>');
				 var Data=[]; 
				 var seriesData=[];
				var xAxisData=[];
				for(var i=0;i<dataMap.length;i++){
					if(dataMap[i].key==id){
						Data.push(dataMap[i].value);
						xAxisData.push(dataMap[i].time);
					}
				}
			
		// var Data=[]; 
		// var seriesData=[];
		//var xAxisData=[];
	//	for(var i=0;i<dataMap.length;i++){
	//		xAxisData.push(dataMap[i].time);
	//		Data.push(dataMap[i].value);
	//	}
	 switch(id){
	 case 'icmppingsec':
			legendData=['响应时间'];
			titleText="响应时间";
			subText="单位：S";
			seriesData.push({
	            name:'响应时间', //注意name必须等于前面指定的legendData
	            type:'line',
	            smooth:true,
	            itemStyle: {normal: {areaStyle: {type: 'default'}}},
	            data:Data,
	            markPoint : {
	                data : [
	                    {type : 'max', name: '最大值'},
	                    {type : 'min', name: '最小值'}
	                ]
	            },
	            markLine : {
	                data : [
	                    {type : 'average', name: '平均值'}
	                ]
	            }
	    	});
			break;
	 case 'icmppingloss':
			legendData=['丢包率'];
			titleText="丢包率";
			subText="单位：%";
			seriesData.push({
	            name:'丢包率', //注意name必须等于前面指定的legendData
	            type:'line',
	            smooth:true,
	            itemStyle: {normal: {areaStyle: {type: 'default'}}},
	            data:Data,
	            markPoint : {
	                data : [
	                    {type : 'max', name: '最大值'},
	                    {type : 'min', name: '最小值'}
	                ]
	            },
	            markLine : {
	                data : [
	                    {type : 'average', name: '平均值'}
	                ]
	            }
	    	});
			break;
		default:break;
	 
		
	
			 
	 }
	 
	 
	
	
	 var myChart = echarts.init(document.getElementById(idChart)); 
	
	 var axisData = xAxisData;
	    var option = {
	    	    title : {
	    	        text: titleText,
	    	        subtext: subText
	    	    },
	    	    tooltip : {
	    	        trigger: 'axis'
	    	    },
	    	    legend: {
	    	        data:legendData //动态生成多个不同类别
	    	    },
	    	    toolbox: {
	    	        show : true,
	    	        feature : {
	    	            mark : {show: true},
	    	            dataView : {show: true, readOnly: false},
	    	            magicType : {show: true, type: ['line','bar']},
	    	            restore : {show: true},
	    	            saveAsImage : {show: true}
	    	        }
	    	    },
	    	    calculable : true,
	    	    dataZoom : {
                    show : true,
                    realtime: true,
                    start : 50,
                    end : 100
                },    	    
	    	    xAxis : [
	    	        {
	    	        	type : 'category',
                        position:'bottom',
                        boundaryGap : true,
                        axisLabel:{show:false},
                        axisTick: {onGap:false},
                        splitLine: {show:false},
	    	   
	    	            data : axisData //动态生成x横轴坐标
	    	            
	    	        }
	    	    ],
	    	    yAxis : [
	    	        {   
	    	            type : 'value',
	    	            scale:true,
	    	         //   splitLine: {show:false},
	    	            splitArea : {show : true}
	    	        }
	    	    ],
	    	    series : seriesData //动态生成纵轴数据
	    };
		 // 为echarts对象加载数据 
	   
	  
	
	    myChart.setOption(option);
		window.addEventListener("resize",function(){
				myChart.resize();
		});
		
		//var econfig=require('echarts/config');
		// myChart.on(econfig.EVENT.CLICK,function(parm){
		//	 alert("fdsa")
		//	 var sel=parm;
		// });
			 });//bian li item 
 }
 
 
	//获取当前系统时间 
	 function dateToStr(datetime){ 

		 var year = datetime.getFullYear();
		 var month = datetime.getMonth()+1;//js从0开始取 
		 var date = datetime.getDate(); 
		 var hour = datetime.getHours(); 
		 var minutes = datetime.getMinutes(); 
		 var second = datetime.getSeconds();
		 
		 if(month<10){
		  month = "0" + month;
		 }
		 if(date<10){
		  date = "0" + date;
		 }
		 if(hour <10){
		  hour = "0" + hour;
		 }
		 if(minutes <10){
		  minutes = "0" + minutes;
		 }
		 if(second <10){
		  second = "0" + second ;
		 }
		 
	//	 var time = year+"-"+month+"-"+date+" "+hour+":"+minutes+":"+second; //2009-06-12 17:18:05
		 var time=year+"-"+month+"-"+date;
		// alert(time);
		 return time;
		} 


//时间控件
$('.reservation').datepicker({
	    minView: "month", //选择日期后，不会再跳转去选择时分秒 
		format: "yyyy-mm-dd", //选择日期后，文本框显示的日期格式 
		language: 'zh-CN', //汉化 
		autoclose:true //选择日期后自动关闭 
	});