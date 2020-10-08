<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="page" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<page:template>
	<jsp:attribute name="title">
		Welcome to Java Spring MVC Lectures
	</jsp:attribute>
	<jsp:body>
		<c:url value="/about.html" var="about" />	
		<figure style="text-align: center">
			<img style="border-radius: 15px;" width="450"
				src="${pageContext.request.contextPath}/resources/images/spring-angularjs-html5.png">
		</figure>
	
	</jsp:body>

</page:template>