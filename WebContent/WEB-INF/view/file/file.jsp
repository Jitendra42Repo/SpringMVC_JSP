<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="page" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<page:template>
	<jsp:attribute name="title">Spring MVC File Upload Controller Example</jsp:attribute>
	
	<jsp:body>
		<h2>Spring MVC FileUploadController Example</h2><br/>
		
		<a type="button" href="javascript:history.back()" style="float: right;">Back</a><br/>
		
		<c:url value="/uploadFile" var="uploadFile"/>
		<form action="${uploadFile}" method="post"enctype="multipart/form-data">
			<table>
				<tr> 
					<td><b>File: </b></td>
					<td><input type="file" name="file"/> </td>
					<td><input type="submit" value="Press to Upload File" /></td> 
				</tr>
			</table>
		</form>
		<br/><br/>
		<c:url value="/excel" var="excelController"/>
		<a href="${excelController}">Excel</a><br/><br/>
		
		<c:url value="/pdf" var="pdfController"/>
		<a href="${pdfController}">PDF</a> 
		
	</jsp:body>

</page:template>









