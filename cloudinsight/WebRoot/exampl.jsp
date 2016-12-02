<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title >云眼CloudInsight</title>
    <meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

	<link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.ico"/>
    <script src="${pageContext.request.contextPath}/echart/jquery.min.js"></script>
     <style type="text/css">
      .navbar .nav > li .dropdown-menu {
	  margin: 0;
     }
     .navbar .nav > li:hover .dropdown-menu {
	display: block;
     }
     ul li{  
    list-style-type:none;  
    }  
    
     body {
                margin: 0;
            }
            #main {
                height: 100%;
            }
			.anchorBL{
			display:none;
			}
			
	
      </style>
      <script type="text/javascript" src="echart/echarts-2.2.7/build/dist/echarts.js"></script>
      <script type="text/javascript">
	$(document).ready(function(){  
    $("#main").bind("contextmenu",function(e){  
          return false;  
    });  
});

		
	</script>
	<%
	if(session.getAttribute("currentUser")==null){
	response.sendRedirect("login.jsp");
	}
	 %>
  </head>
  
  <body>
   <nav class="navbar navbar-default navbar-fixed-top topnav" role="navigation" style="display: none;" >
      <div class="container" style="display: none;">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header topnav">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="main.jsp">云眼CloudInsight</a>
        </div>    
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
          <ul class="nav navbar-nav navbar-right">
            
             <li class="dropdown">
              <a href="#" class="dropdown-toggle " data-toggle="dropdown" id="dropdownMenu1" data-hover="dropdown" data-delay="1000" data-close-others="false">
                                                        监控                              
               <b class="caret"></b>
              </a>
               <ul class="dropdown-menu dropdown-menu-left " style="float: left;" >
               <li ><a href="${pageContext.request.contextPath}/admin/getSite.do" >网站监控</a></li>
               <li><a href="${pageContext.request.contextPath}/admin/gethost.do">可达性监控</a></li>
               </ul>
            </li>
              <li>
              <a href="${pageContext.request.contextPath}/admin/check.do">测试</a>
            </li>
           <li>
              <a href="${pageContext.request.contextPath}/admin/data.do">云眼数据</a>
            </li>
            
            <li>
              <a href="${pageContext.request.contextPath}/admin/getAlarm.do">告警</a>
            </li>
             <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                                        工具                           
               <b class="caret"></b>
              </a>
               <ul class="dropdown-menu dropdown-menu-left" style="float: left;">
               <li><a href="${pageContext.request.contextPath}/getAgent.do">agent下载</a></li>
               <li><a href="${pageContext.request.contextPath}/getFile.do">agent文档下载</a></li>
               </ul>
            </li>
            <li class="dropdown" >
              <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown">
               ${currentUser.userName}                              
               <b class="caret"></b>
              </a>
               <ul class="dropdown-menu dropdown-menu-left">
               <li><a href="login.jsp">登录退出</a></li>
               </ul>
            </li>
          </ul>
        </div>
        
        <!-- /.navbar-collapse -->
      </div>
      <!-- /.container -->
    </nav>
    
 <div id="main" style="margin: 0;"></div>
		
		
		
<div class="contextMenu" id="myMenu1">
	<ul>
		<li id="open"> 可达性监控</li>
	     <hr style="margin: 0;border:1px solid #ccc"></hr>
		<li id="save">APM</li>
		
	</ul>
</div>
      
        <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=ZUONbpqGBsYGXNIYHicvbAbM"></script>
       
        <script src="echart/jquery.contextmenu.r2.js"></script>
       
		<script src="js/bootstrap.min.js"></script>
	
		<script type="text/javascript">
		
		(function () {
	var list=${list};
	var data=list[0];
	//alert(data);
	//alert(list.length);
    require.config({
        paths: {
            echarts: 'echart/echarts-2.2.7/doc/example/www/js'
        },
        packages: [
            {
                name: 'BMap',
                location: 'echart/echarts-2.2.7/extension/BMap/src',
                main: 'main'
            }
        ]
    });

    require(
    [
        'echarts',
        'BMap',
        'echarts/chart/map',
         'echarts/chart/line'
    ],
    function (echarts, BMapExtension) {
        $('#main').css({
            height:$('body').height(),
            width: $('body').width()
        });

        // 初始化地图
        var BMapExt = new BMapExtension($('#main')[0], BMap, echarts,{
            enableMapClick: false
        });
        var map = BMapExt.getMap();
        var container = BMapExt.getEchartsContainer();

        var startPoint = {
            x: 104.114129,
            y: 37.550339
        };

        var point = new BMap.Point(startPoint.x, startPoint.y);
        map.centerAndZoom(point, 5);
        map.enableScrollWheelZoom(true);
        
   
        
    //    function showInfo(e){
	//	alert(e.point.lng + ", " + e.point.lat);
	//   }
	//    map.addEventListener("click", showInfo);
        
    //   var marker = new BMap.Marker(new BMap.Point(116.4551,40.2539)); // 创建点
	 // marker.addEventListener("click",attribute);
	//   map.addOverlay(marker);    //增加点
	
	//function attribute(){
	//	var p = marker.getPosition();  //获取marker的位置
	//	alert("marker的位置是" + p.lng + "," + p.lat);    
	//}
        // 地图自定义样式
        map.setMapStyle({
            styleJson: [
                  {
                       "featureType": "water",
                       "elementType": "all",
                       "stylers": {
                            "color": "#044161"
                       }
                  },
                  {
                       "featureType": "land",
                       "elementType": "all",
                       "stylers": {
                            "color": "#004981"
                       }
                  },
                  {
                       "featureType": "boundary",
                       "elementType": "geometry",
                       "stylers": {
                            "color": "#064f85"
                       }
                  },
                  {
                       "featureType": "railway",
                       "elementType": "all",
                       "stylers": {
                            "visibility": "off"
                       }
                  },
                  {
                       "featureType": "highway",
                       "elementType": "geometry",
                       "stylers": {
                            "color": "#004981"
                       }
                  },
                  {
                       "featureType": "highway",
                       "elementType": "geometry.fill",
                       "stylers": {
                            "color": "#005b96",
                            "lightness": 1
                       }
                  },
                  {
                       "featureType": "highway",
                       "elementType": "labels",
                       "stylers": {
                            "visibility": "off"
                       }
                  },
                  {
                       "featureType": "arterial",
                       "elementType": "geometry",
                       "stylers": {
                            "color": "#004981"
                       }
                  },
                  {
                       "featureType": "arterial",
                       "elementType": "geometry.fill",
                       "stylers": {
                            "color": "#00508b"
                       }
                  },
                  {
                       "featureType": "poi",
                       "elementType": "all",
                       "stylers": {
                            "visibility": "off"
                       }
                  },
                  {
                       "featureType": "green",
                       "elementType": "all",
                       "stylers": {
                            "color": "#056197",
                            "visibility": "off"
                       }
                  },
                  {
                       "featureType": "subway",
                       "elementType": "all",
                       "stylers": {
                            "visibility": "off"
                       }
                  },
                  {
                       "featureType": "manmade",
                       "elementType": "all",
                       "stylers": {
                            "visibility": "off"
                       }
                  },
                  {
                       "featureType": "local",
                       "elementType": "all",
                       "stylers": {
                            "visibility": "off"
                       }
                  },
                  {
                       "featureType": "arterial",
                       "elementType": "labels",
                       "stylers": {
                            "visibility": "off"
                       }
                  },
                  {
                       "featureType": "boundary",
                       "elementType": "geometry.fill",
                       "stylers": {
                            "color": "#029fd4"
                       }
                  },
                  {
                       "featureType": "building",
                       "elementType": "all",
                       "stylers": {
                            "color": "#1a5787"
                       }
                  },
                  {
                       "featureType": "label",
                       "elementType": "all",
                       "stylers": {
                            "visibility": "off"
                       }
                  }
            ]
        });
       var geoCoordMap= {
                '上海': [121.4648,31.2891],
                '东莞': [113.8953,22.901],
                '东营': [118.7073,37.5513],
                '中山': [113.4229,22.478],
                '临汾': [111.4783,36.1615],
                '临沂': [118.3118,35.2936],
                '丹东': [124.541,40.4242],
                '丽水': [119.5642,28.1854],
                '乌鲁木齐': [87.9236,43.5883],
                '佛山': [112.8955,23.1097],
                '保定': [115.0488,39.0948],
                '兰州': [103.5901,36.3043],
                '包头': [110.3467,41.4899],
                '北京': [116.4551,40.2539],
                '北海': [109.314,21.6211],
                '南京': [118.8062,31.9208],
                '南宁': [108.479,23.1152],
                '南昌': [116.0046,28.6633],
                '南通': [121.1023,32.1625],
                '厦门': [118.1689,24.6478],
                '台州': [121.1353,28.6688],
                '合肥': [117.29,32.0581],
                '呼和浩特': [111.4124,40.4901],
                '咸阳': [108.4131,34.8706],
                '哈尔滨': [127.9688,45.368],
                '唐山': [118.4766,39.6826],
                '嘉兴': [120.9155,30.6354],
                '大同': [113.7854,39.8035],
                '大连': [122.2229,39.4409],
                '天津': [117.4219,39.4189],
                '太原': [112.3352,37.9413],
                '威海': [121.9482,37.1393],
                '宁波': [121.5967,29.6466],
                '宝鸡': [107.1826,34.3433],
                '宿迁': [118.5535,33.7775],
                '常州': [119.4543,31.5582],
                '广州': [113.5107,23.2196],
                '廊坊': [116.521,39.0509],
                '延安': [109.1052,36.4252],
                '张家口': [115.1477,40.8527],
                '徐州': [117.5208,34.3268],
                '德州': [116.6858,37.2107],
                '惠州': [114.6204,23.1647],
                '成都': [103.9526,30.7617],
                '扬州': [119.4653,32.8162],
                '承德': [117.5757,41.4075],
                '拉萨': [91.1865,30.1465],
                '无锡': [120.3442,31.5527],
                '日照': [119.2786,35.5023],
                '昆明': [102.9199,25.4663],
                '杭州': [119.5313,29.8773],
                '枣庄': [117.323,34.8926],
                '柳州': [109.3799,24.9774],
                '株洲': [113.5327,27.0319],
                '武汉': [114.3896,30.6628],
                '汕头': [117.1692,23.3405],
                '江门': [112.6318,22.1484],
                '沈阳': [123.1238,42.1216],
                '沧州': [116.8286,38.2104],
                '河源': [114.917,23.9722],
                '泉州': [118.3228,25.1147],
                '泰安': [117.0264,36.0516],
                '泰州': [120.0586,32.5525],
                '济南': [117.1582,36.8701],
                '济宁': [116.8286,35.3375],
                '海口': [110.3893,19.8516],
                '淄博': [118.0371,36.6064],
                '淮安': [118.927,33.4039],
                '深圳': [114.5435,22.5439],
                '清远': [112.9175,24.3292],
                '温州': [120.498,27.8119],
                '渭南': [109.7864,35.0299],
                '湖州': [119.8608,30.7782],
                '湘潭': [112.5439,27.7075],
                '滨州': [117.8174,37.4963],
                '潍坊': [119.0918,36.524],
                '烟台': [120.7397,37.5128],
                '玉溪': [101.9312,23.8898],
                '珠海': [113.7305,22.1155],
                '盐城': [120.2234,33.5577],
                '盘锦': [121.9482,41.0449],
                '石家庄': [114.4995,38.1006],
                '福州': [119.4543,25.9222],
                '秦皇岛': [119.2126,40.0232],
                '绍兴': [120.564,29.7565],
                '聊城': [115.9167,36.4032],
                '肇庆': [112.1265,23.5822],
                '舟山': [122.2559,30.2234],
                '苏州': [120.6519,31.3989],
                '莱芜': [117.6526,36.2714],
                '菏泽': [115.6201,35.2057],
                '营口': [122.4316,40.4297],
                '葫芦岛': [120.1575,40.578],
                '衡水': [115.8838,37.7161],
                '衢州': [118.6853,28.8666],
                '西宁': [101.4038,36.8207],
                '西安': [109.1162,34.2004],
                '贵阳': [106.6992,26.7682],
                '连云港': [119.1248,34.552],
                '邢台': [114.8071,37.2821],
                '邯郸': [114.4775,36.535],
                '郑州': [113.4668,34.6234],
                '鄂尔多斯': [108.9734,39.2487],
                '重庆': [107.7539,30.1904],
                '金华': [120.0037,29.1028],
                '铜川': [109.0393,35.1947],
                '银川': [106.3586,38.1775],
                '镇江': [119.4763,31.9702],
                '长春': [125.8154,44.2584],
                '长沙': [113.0823,28.2568],
                '长治': [112.8625,36.4746],
                '阳泉': [113.4778,38.0951],
                '青岛': [120.4651,36.3373],
                '韶关': [113.7964,24.7028]
            };
            
            
   var serise=[];
      
   for(var i=0;i<list.length;i++){
 //  alert(list[0].length);
   if(i==0){
    var data=[]; 
     var name=''; 
     var add=[];  
   for(var j=0;j<list[0].length;j++){
    
    data.push([
      list[0][j][0],
      list[0][j][1]
      ]);
     name=list[0][j][2].name;
     
    /// alert(add);
    add.push(list[0][j][1]);
   
   }
 // alert(name);
      serise.push({
           name:name,
            type:'map',
            mapType: 'none',
            data:[],
            geoCoord:geoCoordMap,

            markLine : {
                smooth:true,
                effect : {
                    show: true,
                    scaleSize: 1,
                    period: 30,
                    color: '#fff',
                    shadowBlur: 10
                },
                itemStyle : {
                    normal: {
                        borderWidth:1,
                        lineStyle: {
                            type: 'solid',
                            shadowBlur: 10
                        }
                    }
                },
                data : 
                   data
                
            },
            markPoint : {
                symbol:'emptyCircle',
                symbolSize : function (v){
                    return 10 + v/10
                },
                effect : {
                    show: true,
                    shadowBlur : 0
                },
                itemStyle:{
                    normal:{
                        label:{show:false},
                        color:'blue'
                    }
                },
                data : add
                    
                
            }
            
        
    });
      
   //   alert(data);
   
   }else{
     var data=[]; 
     var name=''; 
     var add=[];  
     for(var j=0;j<list[i].length;j++){
     
     
      data.push([
      list[i][j][0],
      list[i][j][1]
      ]);
      name=list[i][j][2].name;
      add.push(list[i][j][1]);
     }
    
	
      serise.push({
    
            name:name,
            type:'map',
            mapType: 'none',
            data:[],
            markLine : {
                smooth:true,
                effect : {
                    show: true,
                    scaleSize: 1,
                    period: 30,
                    color: '#fff',
                    shadowBlur: 10
                },
                itemStyle : {
                    normal: {
                        borderWidth:1,
                        lineStyle: {
                            type: 'solid',
                            shadowBlur: 10
                        }
                    }
                },
                data :data
            },
            markPoint : {
                symbol:'emptyCircle',
                symbolSize : function (v){
                    return 10 + v/10
                },
                effect : {
                    show: true,
                    shadowBlur : 0
                },
                itemStyle:{
                    normal:{
                        label:{show:false},
                        color:'blue'
                    }
                },
                data : add
                    
                
            }
        
   
   });
  
    
   }
  
   }
                     
      
    option = {
  //  color: ['gold','aqua','lime','#46bee9'],
  color: ['gold'],
    title : {
        text: '分布式监控',
        subtext:'网站监控',
        x:'center',
        textStyle: {
           
            color: '#fff'          // 主标题文字颜色
        }
       
    },
    tooltip : {
        trigger: 'item',
        formatter: function (v) {
            return v[1].replace(':', ' > ');
        }
    },
    legend: {
        orient: 'vertical',
        x:'left',
        textStyle:{color : '#fff'},
        data:['金和软件', '呼和浩特白塔国际机场', '中国铁建','翼校通','灯塔'],
        selectedMode: 'single',
         selected:{
          '呼和浩特白塔国际机场':true,
		 '中国铁建':true,
		 '翼校通':true,
		 '灯塔':true
         }
       
    },
    toolbox: {
        show : true,
        orient : 'vertical',
        x: 'right',
        y: 'center',
        feature : {
            mark : {show: true},
            dataView : {show: true, readOnly: false},
            restore : {show: true},
            saveAsImage : {show: true}
        }
    },
   
    series : serise
       
};

  
        var myChart = BMapExt.initECharts(container);
        window.onresize = myChart.onresize;
        BMapExt.setOption(option);
		
		
        $('#main').contextMenu('myMenu1',{
   		      bindings:{
   			'open': function(t){
   				window.open ('admin/gethost.do','_parent','height=100,width=400,top=0,left=0,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no');
   			},
   			'email': function(t){
   				alert('Trigger was '+t.id+'\nAction was Email');
   			},
   			'save': function(t){
   		  window.open ('http://180.153.44.154:8088/stewardweb/login.do?username=cloudinsight&&password=cloudinsight','_parent','height=100,width=400,top=0,left=0,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no');

   			},
   			'delete': function(t){
   				alert('Trigger was '+t.id+'\nAction was Delete');
   			}
   		}
   	});
		//增加监听事件
function eConsole(param) {
if (typeof param.seriesIndex != 'undefined') {
 if (param.type == 'click') {     

 for(var j=0;j<option.series.length;j++){
  var peiLenght= option.series[j].markLine.data.length;
 
 	for(var i=0;i<peiLenght;i++){
     everyClick(param,i,j);
     }  
    }        
    }
      }
 }
   myChart.on("click", eConsole);
  // myChart.on("hover", eConsole);
    
	 function everyClick(param,i,j){    
	     var time=dateToStr(new Date());
		 var http=["speed","response"];	
	  if(param.seriesIndex==j&&param.dataIndex==i){
		  var add=option.series[j].markLine.data[i][0].name;
		  var name=option.series[j].name;
		  $("#charts_canvas").empty();
		 // alert(add);
		//  alert(name);
		// if(confirm("确定要查看吗？")){	
		   $.each(http,function(i,value){
			   var id=value;
				 var idChart=id+"_chart";
				 $("#charts_canvas").append('<div id="'+idChart+'" class="col-md-12 col-sm-12" style="height:300px;width:800px;"></div>');
			   $.ajax({
				   "dataType":"json",
					"type":"post",
					"url":"getNow_site.do",
					"data":{'add':add,'time':time,'name':name,'item':id},
					"async": false,
					"success":function(dataMap){
					 $("#myModal").modal('show');
						getMore(id,idChart,dataMap,add,name);
						 
					},
					"error":function(){
						alert("error");
					}
				   
			   });
		   });
		  // }
		   }}

    }
);
})();



		</script>
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document" style="width:800px;z-index:9999;">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" class="text-center">结果</h4>
      </div>
      <div class="modal-body">
        	<div class="row">
			 
				<div id="charts_canvas" class="col-lg-12 col-sm-12 ">

				</div>
			</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" id="More">更多</button>
        <button type="button" class="btn btn-primary" data-dismiss="modal">关闭</button>
      </div>
    </div>
  </div>
</div>


  </body>
  <script type="text/javascript" src="js/echarts-blue.js"></script>
  <script type="text/javascript" src="js/echarts-all.js"></script>
 <script>
  function getMore(id,idChart,dataMap,add,name){

   var Data=[]; 
	 var seriesData=[];
	var xAxisData=[];
	for(var i=0;i<dataMap.length;i++){
		xAxisData.push(dataMap[i].time);
		//alert(dataMap[i].time);
		Data.push(dataMap[i].value);
	}
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

	  require.config({  
            paths: {  
                echarts: 'echart/echarts-2.2.7/build/dist'  
            }  
        });  
          
        // 使用  
        require(  
            [  
                'echarts',  
                'echarts/chart/line' // 使用柱状图就加载bar模块，按需加载  
            ],  
            function (ec) {  
                // 基于准备好的dom，初始化echarts图表  
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
	
            }  
        );  

  	$("#More").click(function(){
  	window.location.href='siteMore.do?add='+ encodeURI(encodeURI(add))+'&name='+ encodeURI(encodeURI(name));
  //		window.open ('siteMore.do?add='+add+'&name='+name,'_parent','height=100,width=400,top=0,left=0,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no');
//  	alert(add);
	//var add=${add};
//	alert(add});
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
	

 </script>
</html>
