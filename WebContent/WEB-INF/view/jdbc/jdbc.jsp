<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
						   
<%@ taglib prefix="page" tagdir="/WEB-INF/tags"%>

<page:template>
	<jsp:attribute name="title">JDBC Template Example</jsp:attribute>

	<jsp:body>
		<c:url value="/jdbcSelectAllUsers" var="allUsers"></c:url>
		<c:url value="/jdbcSelectLogs" var="selectLogs"></c:url>
			
		<h2>JDBC Template Example</h2>
		
		<a type="button" href="javascript: history.back()" style="float:right">Back</a>
			
		<br/>
		<a href="${allUsers}">JDBCController jdbcSelectAllUsers</a>
		<br/>
		<p>Calling with the value: <strong>${allUsers}</strong> </p>
		<br/>
		<br/>
		<a href="${selectLogs}">JDBCController Select all Logs</a>
		<br/>
		<p>Calling with the value: <strong>${allUsers}</strong> </p>
		<br />
		
		<table>	
		<c:if test="${not empty users}">
			<h2>Users List</h2>
			
				<c:forEach var="user" items="${users}">
					<tr><td><b>Iduser:   </b></td> <td><c:out value="${user.idUser}" /></td> </tr>
					<tr><td><b>Username: </b></td> <td><c:out value="${user.username}" /></td> </tr>
					<tr><td><b>Password: </b></td> <td><c:out value="${user.password}" /></td> </tr>
					<tr><td><b>Enabled:  </b></td>
					<td>
						<c:if test="${user.enabled == true}">
							<font color="green"><b><c:out value="${user.enabled}" /></b></font>
						</c:if>
						<c:if test="${user.enabled == false}">
							<font color="red"><b><c:out value="${user.enabled}" /></b></font>
						</c:if>
					</td>
					</tr>
				</c:forEach>
			
		</c:if>
		</table>
			
		<c:if test="${not empty dbLogs }">
			<h2>Users List</h2>
			<table>
				<c:forEach var="dbLog" items="${dbLogs}">
					<tr><td><b>IDLOG:      </b></td> <td><c:out value="${dbLog.IDLOG}" /> <br /></td></tr>
					<tr><td><b>LOGSTRING:  </b></td> <td><c:out value="${dbLog.LOGSTRING}" /> <br /></td></tr>
				</c:forEach>
				
			</table>
			
		</c:if>
		<br />
			
		
			
	</jsp:body>
</page:template>

