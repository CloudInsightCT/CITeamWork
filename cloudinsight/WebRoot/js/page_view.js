 $(function () { 
	 
	 $('#site').collapse('hide');
	 $('#host').collapse('hide');
 });
 
 
 $("#site_group").click(function(){
	 $("#site").empty();
	 for(var i=0;i<2;i++){
		 $("#site").append("<ul ><li><a class='btn btn-default' style='border:0px;' id='siteMore'>"+'121'+"<a></li></ul>"); 
	 }
	

 });
	 
 
 $("#siteMore").click(function(){
	 
 });
 
 
 
 $("#host_group").click(function(){
	 $("#host").empty();
	 $.ajax({
			"dataType":"json",
			"type":"post",
			"contentType": "application/json",
			"url":"gethost_group.do",
			"data":null,
			"async": false,
			"success":function(data){
			//	alert(dataMap);
				 $("#host").empty();
				 for(var i=0;i<data.length;i++){
					 $("#host").append("<ul ><li><a class='btn btn-default' style='border:0px;' id='hostMore' onclick='getList("+data[i].id+")'>"+data[i].host+"<a></li></ul>"); 
				 }
			},
			"error":function(){
			 alert("error");
			}
		 });
 });
 
 function getList(id){
	// alert(id);
	$.ajax({
		"dataType":"json",
		"type":"post",
		"contentType": "application/json",
		"url":"gethost_list.do",
		"data":JSON.stringify({id:id}),
		"async": true,
		"success":function(data){
		//	alert(dataMap);
			 $("#monitor").empty();
			 for(var i=0;i<data.length;i++){
				 $("#monitor").append("<ul ><li><a class='btn btn-default' style='border:0px;' id='hostMore' onclick='getMore("+data[i].hostid+")'>"+data[i].name+"<a></li></ul>"); 
			 }
		},
		"error":function(){
		 alert("error");
		}
		
	});
 }
 
 
 function getMore(id){
	 $("#choice").show();
	 $("#result").show();
	 var time=dateToStr(new Date());
//	/ alert(id);
	 $("#load").click(function(){
		 var radio=$("input[type='radio']:checked").val();
		 if(radio==null){
			 alert("请选择");
			 return false;
		 }
		 
		 $.ajax({
			 
			 "dataType":"json",
				"type":"post",
				"contentType": "application/json",
				"url":"getload.do",
				"data":JSON.stringify({id:id,radio:radio,time:time}),
				"async": true,
				"success":function(data){
				//alert(data);
				loadchart(id,data);
				},
				"error":function(){
				 alert("error");
				}
		 });
		
	 });
 }
 function loadchart(id,data){
	/// alert(data);
	 var xdata=[];
	 var formerData=[];
	 var tody=[];
	 var seriesData=[];
	 for(var i=0;i<data.length;i++){
		 if(xdata.indexOf(data[i].time)==-1){
			 xdata.push(data[i].time);
			 formerData.push(data[i].value);
		 }else{
			 tody.push(data[i].value);
		 }
	 }
	 var idChart=id+"_chart";
	 $("#chart").append('<div id="'+idChart+'" class="col-md-12 col-sm-12" style="height:400px;"></div>');
	 legendData=['cpu加载'];
		titleText="cpu加载";
		subText="";
		seriesData.push(
		{
         name:'前一天cpu加载', //注意name必须等于前面指定的legendData
         type:'line',
         smooth:true,
         itemStyle: {normal: {areaStyle: {type: 'default'}}},
         data:formerData,
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
 	   },
 	    {
 	         name:'今天cpu加载', //注意name必须等于前面指定的legendData
 	         type:'line',
 	         smooth:true,
 	         itemStyle: {normal: {areaStyle: {type: 'default'}}},
 	         data:tody,
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
 	 	   }
		
	);
	 
		
		

		 var myChart = echarts.init(document.getElementById(idChart)); 
		
		 var axisData = xdata;
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
		    	            
		    	        //    splitArea : {show : true}
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
	 
	// var time = year+"-"+month+"-"+date+" "+hour+":"+minutes+":"+second; //2009-06-12 17:18:05
	var time=year+"-"+month+"-"+date;
	// alert(time);
	 return time;
	} 

 