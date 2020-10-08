<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="page" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<page:template>
	<jsp:attribute name="title">Email Success</jsp:attribute>
	
	<jsp:body>
		<div class="alert alert-success">
			<strong>$message</strong> Indicates a success or positive action.
		
		</div>
	</jsp:body>
	
</page:template>
