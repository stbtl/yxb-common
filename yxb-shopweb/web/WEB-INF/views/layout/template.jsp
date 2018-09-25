<%@ taglib prefix="titls" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title><tiles:insertAttribute name="title" /></title>
		<tiles:insertAttribute name="header" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<%
			String path = request.getContextPath();
			String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		%>
		<base href="<%=basePath %>" />
	</head>
	<body>
		<div class="context">
			<div>
				<titls:insertAttribute name="bodyTop" />
			</div>
			<div>
				<tiles:insertAttribute name="bodyContext" />
			</div>
			<div>
				<tiles:insertAttribute name="bodyBottom" />
			</div>
		</div>
	</body>
</html>