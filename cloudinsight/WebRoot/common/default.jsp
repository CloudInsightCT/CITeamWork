<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
  <!-- Header Carousel -->
  <div class="intro" style="background: url('img/banner01.jpg') no-repeat center center ;text-align: center;color: #f8f8f8;background-size:100% 100%;">
        <div class="container">

            <div class="row">
                <div class="col-lg-12">
                    <div class="intro-message">
                        <h1>云眼CloudInsight</h1>
                          <h3>让企业业务迁移和优化更加专业与自信</h3>
                         <div class="divider"></div>
                    </div>
                </div>
            </div>

        </div>
        <!-- /.container -->
    </div>
      <!-- Controls -->

<div class="content-section-c">
    <div class="container" >
		<div class="row ">
		<h3 class="text-center">移动互联网蓬勃发展，云计算驱动产业升级。</h3>	
		<h4 class="text-center">这是一个体验为王、极致精简的时代</h4>
		</div><!-- row -->
		
	</div><!-- container -->
</div>
      <!-- /.row -->
      <!-- Portfolio Section -->
  <div class="content-section-b">
  <div class="container">
      <div class="row">
        <div class="col-lg-12">
          <h2 class="page-header">监测数据</h2>
        </div>
        
        <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    	<div id="radarmain" class="col-md-12 col-sm-12" style="height:400px"></div>
    	<!-- ECharts单文件引入 -->
    	<script src="http://echarts.baidu.com/build/dist/echarts-all.js"></script>
    	
    	<script type="text/javascript">
    	var myChart = echarts.init(document.getElementById('radarmain')); 
    	
    	var option = {
    title : {
        text: '加权Z标准化云计算综合性能模型',
        subtext: 'CloudInsight Model'
    },
    tooltip : {
        trigger: 'axis'
    },
    legend: {
        orient : 'vertical',
        x : 'right',
        y : 'bottom',
        data:['亚马逊AWS','阿里云','腾讯云','金山云','天翼云','沃云','青云','UCloud']
    },
    toolbox: {
        show : true,
        feature : {
            mark : {show: true},
            dataView : {show: true, readOnly: false},
            restore : {show: true},
            saveAsImage : {show: true}
        }
    },
    polar : [
       {
           indicator : [
               { text: '计算性能（Computing）'},
               { text: '数据库性能（Database）'},
               { text: '操作系统性能（OS）'},
               { text: '网络性能（Network）'},
               { text: '存储性能（Storage）'}
            ]
        }
    ],
    calculable : true,
    series : [
        {
            name: '加权Z标准化云计算综合性能模型',
            type: 'radar',
            data : [
                {
                    value : [1.419030003, 0.314326159, -1.74125642, -0.828614176, -0.324654134],
                    name : '亚马逊AWS'
                },
                 {
                    value : [-0.774072172, -0.534056086, 0.36117087, -0.976700693, -0.272927879],
                    name : '阿里云'
                },
                {
                    value : [0.367994695, -0.214637656, 0.711539768, -0.316388419, -0.520538926],
                    name : '腾讯云'
                },
                {
                    value : [0.524838542, 0.252160687, -0.492719632, 0.956050293, 0.149723677],
                    name : '金山云'
                },
              {
                    value : [0.390988494, -0.218403145, 0.733571512, -0.207926677, 1.474715858],
                    name : '天翼云'
                },
                {
                    value : [-1.289515717, -1.239968307, -1.064261571, 0.274368838, -0.401658984],
                    name : '沃云'
                },
                {
                    value : [-0.812893386, 0.267893249, 0.355609459, 0.190824288, -0.370325384],
                    name : '青云'
                },
              {
                    value : [0.173629542, 1.372685098, 1.136346014, 0.908386547, 0.265665773],
                    name : 'UCloud'
                }
            ]
        }
    ]
};
        
        

        // 为echarts对象加载数据 
        myChart.setOption(option); 
    	
    	</script>
        
             
      </div>
     </div>
     </div>
      <!-- /.row -->
      <!-- Features Section -->
  <div class="content-section-a" > 
      <div class="container">
      <div class="row">
        <div class="col-lg-12">
          <h2 class="page-header">合作伙伴</h2>
        </div>
        <div class="col-md-3">
          <a href="http://www.catr.cn/">
          <img class="img-responsive" src="img/caict.jpg" style="height:50px;width:200px" alt="">
          </a>
        </div>
        <div class="col-md-3">
         <a href="http://www.dca.org.cn/">
          <img class="img-responsive" src="img/dca.jpg" style="height:50px;width:200px" alt="">
         </a>
        </div>
        <div class="col-md-3">
        <a href="http://www.kexinyun.org/">
          <img class="img-responsive" src="img/trustcloud.jpg" style="height:50px;width:200px" alt="">
        </a>
        </div>
        <div class="col-md-3">
        <a href="http://www.chinatelecom.com.cn/">
          <img class="img-responsive" src="img/ct.jpg" style="height:50px;width:200px" alt="">
        </a>
        </div>
      </div>
      </div>
      </div>