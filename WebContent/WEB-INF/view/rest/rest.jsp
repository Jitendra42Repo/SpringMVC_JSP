<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="page"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<page:template>
	<jsp:attribute name="title">Restful Webservice</jsp:attribute>

	<jsp:body>
		<h3> REST calls </h3>
		
		<div>
			<c:url value="/posts" var="postService" />
			<a href="${postService}">Calling with the value: ${postService}</a><br/><br/>
		
			<c:url value="/posts/1" var="postID" />
			<a href="${postID}">Calling with the value: ${postID}</a><br/><br/>
		
			<c:url value="/responseStatusError" var="statusError" />
			<a href="${statusError}">Calling with the value: ${statusError}</a><br/><br/>
		
		</div>
		
		
	</jsp:body>

</page:template>