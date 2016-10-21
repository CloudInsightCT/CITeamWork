<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<table>
		<c:forEach items="${metrics}" var="metirc">
			<tr>
				<td><c:out value="${metirc.agentID}"/></td>
				<td><c:out value="${metirc.devID}"/></td>
				<td><c:out value="${metirc.tag}"/></td>
				<td><c:out value="${metirc.metric}"/></td>
				<td><c:out value="${metirc.timestamp}"/></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>