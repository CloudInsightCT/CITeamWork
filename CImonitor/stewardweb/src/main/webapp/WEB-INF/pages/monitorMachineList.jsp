<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MonitorList</title>
</head>
<body>
	<table>
		<c:forEach items="${agents}" var="agent">
			<tr>
				<td><c:out value="${agent.agentID}"/></td>
				<td><c:out value="${agent.entity.os}"/></td>
				<td><c:out value="${agent.entity.osArc}"/></td>
				<td><c:out value="${agent.entity.osVersion}"/></td>
				<td><c:out value="${agent.entity.ip}"/></td>
				<td><c:out value="${agent.entity.computerName}"/></td>
				<td><c:out value="${agent.entity.hostName}"/></td>
			</tr>
			<tr>
				<c:forEach items="${devs}" var="dev">
						<td><a href="monitor.do?agentID=<c:out value="${agent.agentID}"/>&devID=<c:out value="${dev.devID}"/>"><c:out value="${dev.devInfo}"/></a></td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>
</body>
</html>