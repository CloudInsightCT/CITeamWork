<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>ping</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="css/bootstrap.min.css" rel="stylesheet">

	<style type="text/css">
      table{
      border-collapse:collapse;
      }
      table,td{
      border:0px;
      font-size: 12px;
      }
      
</style>
	</head>

	<body style="background-color: #160f2b;">
		<div class="panel-group" >
			<div class="panel panel-default">
				<div class="panel-heading" style="background-color: #4a3391;">
					<h4 style="color: #fff;">
						Result of "ping"
					</h4>
				</div>
				<div class="panel-body" style="background-color: #2f1f5a">
					<table >
						<c:forEach var="map" items="${list}">
							<tbody>
								<tr>
									<td style="color:#fff;">
										${map}
									</td>
								</tr>
							</tbody>

						</c:forEach>

					</table>
				</div>
			</div>
		</div>
	</body>
</html>
