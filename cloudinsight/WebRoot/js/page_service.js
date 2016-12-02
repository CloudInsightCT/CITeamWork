/**
 * Js文件，对应services.jsp页面。
 */
 

 function get_Mes(id){
	
	  // if($("#result_one").is(":hidden")){
	     $("#result_one").show();
	  //   alert("abc")
	 //  }else{
		//   $("#result_one").show();
		   $("#query-time").empty();
	 //  }
	  
	   
	 
	   //   $("#query-chart").blind("click",function(e){
	  //  	if($("#query-time").val().trim()=""){
	//	    	  alert("請選擇時間");
	//	    	  return ;
	//	      }   
	    //	$(this).button("loading");
	    	//$("#chart").empty();
	    	//$("#chart").append("<div id='+idchart' class='col-md-12 col-sm-12' style='height:400px;'>"+"<p>"+"'wode'"+"</p>"+"</div>");
	    	//$("#chart").toggle();
	        
	     //  $("#chart").empty();
	       
	       $("#query").click(function(){
	    	   if($("#query-time").val().trim()==''){
	    			 alert("请选择时间");
	    			 return ;
	    		 }
	    	   
	    	  $.ajax({
	    		  "dataType":"json",
	    		  "type":"post",
	    		  "url":  "getData.do",
	    		  "data":{'id':id,'time':$("#query-time").val().trim()},
	    		  "success":function(data){
	    			  var data=eval(data);
	    			  alert(data.length);
	    			  load(data);
	    		  },
	    		  "error":function(e){
	    			  alert("error")
	    		  }
	    	  });
	 
	    	//   $("#charts_canvas").append('<div id="'+idChart+'" class="col-md-12 col-sm-12" style="height:400px;"></div>');
			//	 loadChart(id,idChart);
	    	   var axisData = [
		                        "0","1", "2", "3", "4", "5",
		                        "6", "7", "8", "9", "10", 
		                        "11", "12", "13", "14", "15", 
		                        "16", "17", "18", "19", "20", 
		                        "21", "22", "23"
		                    ];
		                    option2 = {
		                    	title:{
		                    	text:'speed in a day'+'\n',
		                    	 x:'center',
		                    	
		                    },
		                        tooltip : {
		                            trigger: 'axis',
		                            showDelay: 0             // 显示延迟，添加显示延迟可以避免频繁切换，单位ms
		                        },
		                        legend: {
		                        	x:'center',
		                            y : 'top',
		                            data:['speed(s)','response time(s)']
		                        },
		                        toolbox: {
		                            y : -30,
		                            show : true,
		                            feature : {
		                                mark : {show: true},
		                                dataZoom : {show: true},
		                                dataView : {show: true, readOnly: false},
		                                magicType : {show: true, type: ['line', 'bar']},
		                                restore : {show: true},
		                                saveAsImage : {show: true}
		                            }
		                        },
		                        dataZoom : {
		                            show : true,
		                            realtime: true,
		                            start : 50,
		                            end : 100
		                        },
		                        grid: {
		                            x: 80,
		                            y:5,
		                            x2:20,
		                            y2:40
		                        },
		                        xAxis : [
		                            {
		                                type : 'category',
		                                position:'bottom',
		                                boundaryGap : true,
		                                axisLabel:{show:false},
		                                axisTick: {onGap:false},
		                                splitLine: {show:false},
		                                data : axisData
		                            }
		                        ],
		                        yAxis : [
		                            {
		                                type : 'value',
		                                scale:true,
		                             //   splitNumber: 10,
		                              //  boundaryGap: false,
		                                axisLabel: {
		                                    formatter: function (v) {
		                                        return Math.max(v) + ' s'
		                                    }
		                                },
		                                splitArea : {show : true}
		                            }
		                        ],
		                        series : [
		                            {
		                                name:'speed',
		                                type:'line',
		                                symbol: 'none',
		                               
		                                data:[
		                                   0.1, 0.5, 0.8, 5, 1.6, 
		                                    0.7, 3, 4.6, 6.6, 3.5, 
		                                     0.4, 0.8, 0.8, 4.7, 1.9, 
		                                    0.7, 0.7, 4.6, 2.1, 3.9, 
		                                     0.1, 0.5, 9, 5 
		                                ],
		                                markLine : {
		                                    symbol : 'none',
		                                    itemStyle : {
		                                        normal : {
		                                            color:'#1e90ff',
		                                            label : {
		                                                show:false
		                                            },
		                                     areaStyle: {type: 'default'}
		                                        }
		                                    },
		                                    data : [
		                                        {type : 'average', name: '平均值'}
		                                    ]
		                                }
		                            }
		                        ]
		                    };
		                   // myChart2 = echarts.init(document.getElementById('main2'));
		                  //  myChart2.setOption(option2);

		                    option3 = {
		                        tooltip : {
		                            trigger: 'axis',
		                            showDelay: 0             // 显示延迟，添加显示延迟可以避免频繁切换，单位ms
		                        },
		                        legend: {
		                         
		                            data:['speed(s)','response time(s)']
		                        },
		                        toolbox: {
		                            y : -30,
		                            show : true,
		                            feature : {
		                                mark : {show: true},
		                                dataZoom : {show: true},
		                                dataView : {show: true, readOnly: false},
		                                magicType : {show: true, type: ['line', 'bar']},
		                                restore : {show: true},
		                                saveAsImage : {show: true}
		                            }
		                        },
		                        dataZoom : {
		                            y:200,
		                            show : true,
		                            realtime: true,
		                            start : 50,
		                            end : 100
		                        },
		                        grid: {
		                            x: 80,
		                            y:5,
		                            x2:20,
		                            y2:30
		                        },
		                        xAxis : [
		                            {
		                                type : 'category',
		                                position:'bottom',
		                                boundaryGap : true,
		                                axisTick: {onGap:false},
		                                splitLine: {show:false},
		                                data : axisData
		                            }
		                        ],
		                        yAxis : [
		                            {
		                                type : 'value',
		                                scale:true,
		                             //   splitNumber:10,
		                             //   boundaryGap: [0,0],
		                                axisLabel: {
		                                    formatter: function (v) {
		                                        return Math.max(v) + ' s'
		                                    }
		                                },
		                              //  splitArea : {show : true}
		                            }
		                        ],
		                        series : [
		                            {
		                                name:'response',
		                                type:'bar',
		                                symbol: 'none',
		                                data:[
		                                    0.1, 0.5, 0.8, 5, 1.6, 
		                                    0.7, 3, 4.6, 6.6, 3.5, 
		                                     0.4, 0.8, 0.8, 4.7, 1.9, 
		                                    0.7, 0.7, 4.6, 2.1, 3.9, 
		                                     0.1, 0.5, 9, 5 
		                                   
		                                ],
		                                markLine : {
		                                    symbol : 'none',
		                                    itemStyle : {
		                                        normal : {
		                                            color:'#1e90ff',
		                                            label : {
		                                                show:false
		                                            }
		                                        }
		                                    },
		                                    data : [
		                                        {type : 'average', name: '平均值'}
		                                    ]
		                                }
		                            }
		                        ]
		                    };
		                 //   myChart3 = echarts.init(document.getElementById('main3'));
		                  //  myChart3.setOption(option3);

		                  //  var ecConfig = require('echarts/config');
			     	    //	   myChart.on(ecConfig.EVENT.CLICK, function(param){
			     	    //		   alert("csacds");
			     	    //		   var selected=param.name;
			     	    //		   alert(selected);
			     	    //	   });

		                 //   myChart2.connect(myChart3);
		                  //  myChart3.connect(myChart2);

		                    setTimeout(function (){
		                        window.onresize = function () {
		                            
		                            myChart2.resize();
		                          //  myChart3.resize();
		                        }
		                    },200);          
		   
		                   
	     
		      
	       });
	    
 }
 
 function load(data){
	 var len=data.length;
	 var seriseXais=[];
	 var seriseVlaue=[];
	 for(var m=0;m<len;m++){
		 seriseXais.push(data[m].time);
		 seriseVlaue.push(data[m].value);
		
		// alert(data[m].value);
	 }
	 var axisData = seriseXais;
                 option2 = {
                 	title:{
                 	text:'speed in a day'+'\n',
                 	 x:'center',
                 	
                 },
                     tooltip : {
                         trigger: 'axis',
                         showDelay: 0             // 显示延迟，添加显示延迟可以避免频繁切换，单位ms
                     },
                     legend: {
                     	x:'center',
                         y : 'top',
                         data:['speed(s)','response time(s)']
                     },
                     toolbox: {
                         y : -30,
                         show : true,
                         feature : {
                             mark : {show: true},
                             dataZoom : {show: true},
                             dataView : {show: true, readOnly: false},
                             magicType : {show: true, type: ['line', 'bar']},
                             restore : {show: true},
                             saveAsImage : {show: true}
                         }
                     },
                     dataZoom : {
                         show : true,
                         realtime: true,
                         start : 50,
                         end : 100
                     },
                     grid: {
                         x: 80,
                         y:5,
                         x2:20,
                         y2:40
                     },
                     xAxis : [
                         {
                             type : 'category',
                             position:'bottom',
                             boundaryGap : true,
                             axisLabel:{show:false},
                             axisTick: {onGap:false},
                             splitLine: {show:false},
                             data : axisData
                         }
                     ],
                     yAxis : [
                         {
                             type : 'value',
                             scale:true,
                          //   splitNumber: 10,
                           //  boundaryGap: false,
                             axisLabel: {
                                 formatter: function (v) {
                                     return Math.max(v) + ' s'
                                 }
                             },
                             splitArea : {show : true}
                         }
                     ],
                     series : [
                         {
                             name:'speed',
                             type:'line',
                             symbol: 'none',
                            
                             data:seriseVlaue,
                             markLine : {
                                 symbol : 'none',
                                 itemStyle : {
                                     normal : {
                                         color:'#1e90ff',
                                         label : {
                                             show:false
                                         },
                                  areaStyle: {type: 'default'}
                                     }
                                 },
                                 data : [
                                     {type : 'average', name: '平均值'}
                                 ]
                             }
                         }
                     ]
                 };
                 myChart2 = echarts.init(document.getElementById('main2'));
                 myChart2.setOption(option2);
 } 
 
 
 
 
 //分界线
 function get_Mor(hostid){
	 $("#result").show();
	// var mytime=dateToStr(new Date());
	 var mytime="2016-04-06 01:00:00";
	 var ping=["loss","response"];
	 $('#charts_canvas').empty();
	 $.each(ping,function(i,value){
	//	 for(var i=0;i<ping.length;i++){
	//		 var id=ping[i];
		// alert(value);
		 var id=value;
		 var idChart=id+"_chart";
		 $("#charts_canvas").append('<div id="'+idChart+'" class="col-md-12 col-sm-12" style="height:400px;"></div>');
		 $.ajax({
				"dataType":"json",
				"type":"post",
				"url":"getLocalData.do",
				"data":{'hostid':hostid,'time':mytime,'id':id},
				"async": false,
				"success":function(dataMap){
					//alert("aadbdsa");
					loadChart(id,idChart,dataMap);
				},
				"error":function(){
				 alert("error");
				}
			 });
	 });
	//	 } 
	 
	 
	 $("#query_chart").click(function(){
		 if($("#query_time").val().trim()==''){
			 alert("请选择时间");
			 return ;
		 }
		 $('#charts_canvas').empty();
	//	 $("#conditions").find('input:checkbox:checked').each(function(){
		 $.each(ping,function(m,value){
		//   if($(this).val()!=''){
			// alert(m+" "+value);
				 var id=value;
				// alert(id);
				 var idChart=value+"_chart";
				 $("#charts_canvas").append('<div id="'+idChart+'" class="col-md-12 col-sm-12" style="height:400px;"></div>');
				 $.ajax({
				  "dataType":"json",
				  "type":"post",
				  "url": "getHost_data.do" ,
				  "data":{'hostid':hostid,'id':id,'time':$("#query_time").val().trim()},
				  "async": false,
				  success:function(dataMap){
					  loadChart(id,idChart,dataMap);
				 },
				 error:function(e){
					 alert("error");
				 }
				 });
		//	 }
			
		 });
		 
	 });
 }	 
 //function  loadChart(id,idChart,dataMap){
	 function  loadChart(id,idChart,dataMap){ 
		 var Data=[]; 
		 var seriesData=[];
		var xAxisData=[];
		for(var i=0;i<dataMap.length;i++){
			xAxisData.push(dataMap[i].time);
			//alert(dataMap[i].time);
			Data.push(dataMap[i].value)
		}
	 switch(id){
	 case 'ping':
			legendData=['ping'];
			titleText="ping";
			subText="单位：";
			
			var seriesInnerxAxisData = [];
			//for(var index in xAxisData){
				
		//		seriesInnerxAxisData.push(dataMap[xAxisData[index]][0]); //？？？
		//	}
			seriesData.push({
	            name:'ping', //注意name必须等于前面指定的legendData
	            type:'line',
	            smooth:true,
	            itemStyle: {normal: {areaStyle: {type: 'default'}, yAxislabel:{formatter:'{value} %'}}},
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
	 case 'loss':
			legendData=['loss'];
			titleText="loss";
			subText="单位：";
			var seriesInnerxAxisData = [];
			//for(var index in xAxisData){
				
		//		seriesInnerxAxisData.push(dataMap[xAxisData[index]][0]); //？？？
		//	}
			seriesData.push({
	            name:'内存使用率', //注意name必须等于前面指定的legendData
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
			legendData=['response'];
			titleText="response";
			subText="单位：s";
			var seriesInnerxAxisData = [];
			//for(var index in xAxisData){
				
		//		seriesInnerxAxisData.push(dataMap[xAxisData[index]][0]); //？？？
		//	}
			seriesData.push({
	            name:'response', //注意name必须等于前面指定的legendData
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
		 
		 var time = year+"-"+month+"-"+date+" "+hour+":"+minutes+":"+second; //2009-06-12 17:18:05
		// alert(time);
		 return time;
		} 
//分界	 
	 
	 
	 
 
$(function() {
	
	//bind the click action to the query button
	$('#query-chart').bind('click', function(e){
		if($('#query-time').val().trim()=='') {
			alert('请选择时间');
			return;
		}
		var theButton = $(this);
		theButton.button('loading');
		//check the checked providers on the left div and get the combined value
		var proString = $('#providers').find('input:checkbox:checked').map(function() {
			if ($(this).val() != '')
				return $(this).val();
		}).get().join(",");
		//empty the canvas before using
		$('#charts-canvas').empty();
		//get the checked conditions and create a chart for each 
		$('#conditions').find('input:checkbox:checked').each(function(){
			if ($(this).val() != ''){
				var id = $(this).val();
				
				var idChart = $(this).val()+"-chart";
				$('#charts-canvas').append('<div id="'+idChart+'" class="col-md-12 col-sm-12" style="height:400px;"></div>');
				$.ajax({//通过ajax请求，得到数据（一般为json数据）
					"dataType": 'json',//注意切回jsonp
					"type":"post",
					"url": jsBasePath+"/cloud/flat/getData.do",
					"data":{'key':id,'providers':proString,'time':$('#query-time').val().trim()},
					"success": function(dataMap){
						//load the chart
						loadTheChart(id,idChart,proString,dataMap);
						theButton.button('reset');
					},
					"error":function(e){
						alert('网络错误！');
					}
				} );				
			}
		});
		
	});
	
	$('.reservation').datepicker({
		　    minView: "month", //选择日期后，不会再跳转去选择时分秒 
		　　format: "yyyy-mm-dd", //选择日期后，文本框显示的日期格式 
		　　language: 'zh-CN', //汉化 
		　　autoclose:true //选择日期后自动关闭 
	});
});

/**该函数中的case对应于services.jsp中的checkbox的value值
 * 
 * @param id
 * @param idChart
 * @param proString ???从哪里来？
 * @param dataMap  ???从哪里来？
 * 
 * legend是echart顶部的图例
 * xAxis是echart横轴
 * 
 */
function loadTheChart(id,idChart,proString,dataMap){
	var legendData = proString.split(',');
	var xAxisData = proString.split(',');
	var seriesData=[];
	
	//先通过switch-case来组装echart的动态个性化内容
	switch (id) {
	case 'coremark':
		legendData=['CPU性能效率'];
		titleText="CPU效能";
		subText="单位：分数score";
		var seriesInnerxAxisData = [];
		for(var index in xAxisData){
			
			seriesInnerxAxisData.push(dataMap[xAxisData[index]][0]); //？？？
		}
		seriesData.push({
            name:'CPU性能效率', //注意name必须等于前面指定的legendData
            type:'bar',
            data:seriesInnerxAxisData,
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
	case 'unixbench':
		legendData=['OS综合得分'];
		titleText="操作系统性能";
		subText="单位：分数score";
		var seriesInnerxAxisData = [];
		for(var index in xAxisData){
			seriesInnerxAxisData.push(dataMap[xAxisData[index]][0]); //？？？
		}
		seriesData.push({
            name:'OS综合得分',
            type:'bar',
            data:seriesInnerxAxisData,
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
	case 'oltp':
		legendData=['Transaction_ID'];
		titleText="关系型数据库事务率";
		subText="单位：transactions per sec";
		var seriesInnerxAxisData = [];
		for(var index in xAxisData){
			seriesInnerxAxisData.push(dataMap[xAxisData[index]][0]); //？？？
		}
		seriesData.push({
            name:'Transaction_ID',
            type:'bar',
            data:seriesInnerxAxisData,
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
	case 'scimark':
		xAxisData=['场景1','场景2','场景3','场景4'];
		titleText="科学计算";
		subText="单位：million floating-point operations per sec";
		for(var index in legendData){
			seriesData.push({
	            name:legendData[index],
	            type:'bar',
	            data:dataMap[legendData[index]],
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
		}
		break;
	case 'hpcc':
		xAxisData=['随机访存*100','内存单元拷贝','内存单元乘法','内存单元加法','内存单元组合'];
		titleText="内存效率";
		subText="单位：GB per sec";
		for(var index in legendData){
			seriesData.push({
	            name:legendData[index],
	            type:'bar',
	            data:dataMap[legendData[index]],
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
		}
		break;
	case 'ping':
		xAxisData=['最小延迟','最大延迟','平均延迟','延迟方差'];
		titleText="网络延迟";
		subText="单位：millisecond";
		for(var index in legendData){
			seriesData.push({
	            name:legendData[index],
	            type:'bar',
	            data:dataMap[legendData[index]],
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
		}
		break;
	case 'netperf':
		xAxisData=['单TCP连接吞吐','多TCP连接吞吐','TCP批量传输吞吐','UDP请求响应吞吐'];
		titleText="网络吞吐";
		subText="单位：transactions per sec";
		for(var index in legendData){
			seriesData.push({
	            name:legendData[index],
	            type:'bar',
	            data:dataMap[legendData[index]],
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
		}
		break;
	case 'fio':
		xAxisData=['序列写IOPS','序列读IOPS','随机写IOPS','随机读IOPS'];
		titleText="存储吞吐";
		subText="单位：operations per sec";
		for(var index in legendData){
			seriesData.push({
	            name:legendData[index],
	            type:'bar',
	            data:dataMap[legendData[index]],
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
		}
		break;
	case 'nosql':
		xAxisData=['写密集型负载','读密集型负载'];
		titleText="NoSQL数据库事务率";
		subText="单位：operations per sec";
		for(var index in legendData){
			seriesData.push({
	            name:legendData[index],
	            type:'bar',
	            data:dataMap[legendData[index]],
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
		}
		break;
	default:
		break;
	}
	
	//这里开始根据个性化的动态内容最终生成echart，公用option选项，需要动态生成的内容见下面注释
    var myChart = echarts.init(document.getElementById(idChart),echarts_blue_theme); 
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
    	            magicType : {show: true, type: ['bar']},
    	            restore : {show: true},
    	            saveAsImage : {show: true}
    	        }
    	    },
    	    calculable : true,
    	    xAxis : [
    	        {
    	            type : 'category',
    	            data : xAxisData //动态生成x横轴坐标
    	        }
    	    ],
    	    yAxis : [
    	        {
    	            type : 'value'
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
