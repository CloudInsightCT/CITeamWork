/**
 * Js文件，对应services.jsp页面。
 */
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
			//	alert(proString);
				$.ajax({//通过ajax请求，得到数据（一般为json数据）
					"dataType": 'json',//注意切回jsonp
					"type":'post',
					"url": 'getDatas.do',
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
		format: "yyyy-mm",
		weekStart: 1,
		startView: 1,
		minViewMode: 1,
		todayBtn: "linked",
		language: "zh-CN",
		toggleActive: true
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
