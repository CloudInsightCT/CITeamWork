<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
	$().ready(function(){
		
		$("#btn").click(function(){
			
			var username=$("#username").val();
			var randomChar=$("#randomChar").val();
			if(username==null){
				alert("用户名为空");
			}else{
				$.ajax({  
					 url:"getToken.do",  
					 type:"GET",
					 contentType:"application/json",
					 data:{username:username,randomChar:randomChar},
					 success:function(data){  
						 alert("token="+data);
					 }
					 }); 
	//			$.post("getToken.do",{username:username},function(data){
	//				alert(data);
	//			})
			}
		})
	})

</script>
</head>
<body>

用户名:<input type ="text" id ="username" name ="username"/>
randomChar:<input type ="text" id ="randomChar" name ="randomChar"/>
<input type="button" id ="btn"value="提交">
</body>
</html>