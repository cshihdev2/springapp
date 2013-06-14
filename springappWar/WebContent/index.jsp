<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to C. Shih Profile</title>
</head>
<body>
<h1>Welcome to C. Shih Spring MVC Practice Site</h1>

Select the following projects:
<ul>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<li><a href="${contextPath}/stock">Lookup Stock</a></li>
<li><a href="${contextPath}/golf">Golf Driving Distance</a></li>
</ul>


</body>
</html>