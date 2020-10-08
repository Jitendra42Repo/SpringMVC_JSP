<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="page" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<page:template>
	<jsp:attribute name="title">Email Error</jsp:attribute>
	<jsp:body>
		<div class="alert alert-danger">
			<strong>$message</strong> Indicates that the email send has failed.
		</div>	
	</jsp:body>
</page:template>