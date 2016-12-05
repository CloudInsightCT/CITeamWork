<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
	$().ready(function(){
		
		$("#btn").click(function(){
			
			var token=$("#token").val();
			if(token==null){
				alert("用户名为空");
			}else{
				$.ajax({  
					 url:"destroyToken.do",  
					 type:"GET",
					 contentType:"application/json",
					 data:{token:token},
					 success:function(data){  
						 alert("token="+data);
					 }
					 }); 
	//			$.post("getToken.do",{token:token},function(data){
	//				alert(data);
	//			})
			}
		})
	})

</script>
</head>
<body>

token:<input type ="text" id ="token" name ="token"/>

<input type="button" id ="btn"value="提交">
</body>
</html>