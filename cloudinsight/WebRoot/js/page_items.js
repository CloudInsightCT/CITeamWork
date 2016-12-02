//对应site.jsp
     function get_Mes(itemid){
    	 //获取当前时间的数据
	     $("#result_one").show();
	     var time=dateToStr(new Date());
	   //  alert(itemid);
	  //   var time="2016-04-06 01:00:00";
	//	 var http=["speed","response"];
		 $('#charts_canvas').empty();
		
					 var id=itemid;
					 var idChart=id+"_chart";
					 $("#charts_canvas").append('<div id="'+idChart+'" class="col-md-12 col-sm-12" style="height:400px;"></div>');
					 $.ajax({
							"dataType":"json",
							"type":"post",
							"url":"getNow_data.do",
							"data":{'itemid':itemid,'time':time,'id':id},
							"async": false,
							"success":function(dataMap){
								//alert("aadbdsa");
								loadChart(id,idChart,dataMap);
								
							},
							"error":function(){
							 alert("error");
							}
						 });
			
		 
		 
	 //获取所选择时间的数据      
	       $("#query").click(function(){
	    	   if($("#query-time").val().trim()==''||$("#query_time").val().trim()==''){
	    			 alert("请选择时间");
	    			 return ;
	    		 }
	    	  $('#charts_canvas').empty();
	    	  
	    		var id=itemid;
	    	//	alert(id);
			    var idChart=id+"_chart";
				$("#charts_canvas").append('<div id="'+idChart+'" class="col-md-12 col-sm-12" style="height:400px;"></div>');
	    	   $.ajax({
	    		  "dataType":"json",
	    		  "type":"post",
	    		  "url":  "getItem_data.do",
	    		  "data":{'id':id,'preTime':$("#query-time").val().trim(),'itemid':itemid,'time':$("#query_time").val().trim()},
	    		  "async": false,
	    		  "success":function(dataMap){
	    		//	  alert(dataMap);
	    			  loadChart(id,idChart,dataMap);
	    		  },
	    		  "error":function(e){
	    			  alert("error")
	    		  }
	    	  });
	    	  });    
	     
	    
 }
 
     function  loadChart(id,idChart,dataMap){ 
		 var Data=[]; 
		 var seriesData=[];
		var xAxisData=[];
	    var name="";
	    var units="";
		for(var i=0;i<dataMap.length;i++){
			xAxisData.push(dataMap[i].time);
			//alert(dataMap[i].time);
			Data.push(dataMap[i].value);
			name=dataMap[i].name;
			units=dataMap[i].units;
		}
		
		legendData=[name];
		titleText=name;
		subText= units;
		seriesData.push({
            name:name, //注意name必须等于前面指定的legendData
            type:'line',
            smooth:true,
            itemStyle: {normal: {areaStyle: {type: 'default'}}},
            data: Data,
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
	  switch(id){
	  case 'speed':
			legendData=['加载速度'];
			titleText="加载速度";
			subText="单位：KBPs";
			seriesData.push({
	            name:'加载速度', //注意name必须等于前面指定的legendData
	            type:'line',
	            smooth:true,
	            itemStyle: {normal: {areaStyle: {type: 'default'}}},
	            data: Data,
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
	 case 'response':
			legendData=['响应时间'];
			titleText="响应时间";
			subText="单位：s";
			
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
		
	
 }
     
    //获取当前时间
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
 $('.reservation').datepicker({
   minView: "month", //选择日期后，不会再跳转去选择时分秒 
   format: "yyyy-mm-dd", //选择日期后，文本框显示的日期格式 
   language: 'zh-CN', //汉化 
   autoclose:true //选择日期后自动关闭 
});