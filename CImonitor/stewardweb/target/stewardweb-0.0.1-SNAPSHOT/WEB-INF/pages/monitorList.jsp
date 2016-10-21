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
				<c:if test="${agent.type==1}">
					<td><a href="monitorMachineList.do?agentID=<c:out value="${agent.agentID}"/>" ><c:out value="${agent.agentID}"/></a></td>
					<td><c:out value="${agent.type}"/></td>
				</c:if>
				<c:if test="${agent.type==0}">
					<td><a href="monitorServerList.do?agentID=<c:out value="${agent.agentID}" />" target="_blank"  ><c:out value="${agent.agentID}"/></a></td>
					<td><c:out value="${agent.type}"/></td>
				</c:if>
			</tr>
		</c:forEach>
	</table>
</body>
</html>