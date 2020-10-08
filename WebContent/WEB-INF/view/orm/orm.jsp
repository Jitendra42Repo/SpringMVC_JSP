<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="page"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<page:template>
	
	<jsp:attribute name="title">ORM Hibername</jsp:attribute>
	<jsp:body>
		<h3> ORM Hibernate JPA Examples </h3>
		<c:url value="/ormFindAllUsers" var="findUsers"/>
		<c:url value="/ormUpdateUser/iduser/1/enabled/false" var="ormUpdateUsr"/>
		<c:url value="/ormDeleteUser/iduser/8" var="ormDeleteUsr"/>
		<c:url value="/ormInsertUser/username/testuser/password/testpassword/enabled/true" var="ormInsertUsr"/>
		
		<a href="${findUsers}">ORMController ormFindAllUsers</a>
		<br/>Calling with the value <strong>${findUsers}</strong><br/>
		
		<a href="${ormUpdateUsr}">ORMController ormUpdateUser</a>
		<br/>Calling with the value <strong>${ormUpdateUsr}</strong><br/>
		
		<a href="${ormDeleteUsr}">ORMController ormDeleteUser</a>
		<br/>Calling with the value <strong>${ormDeleteUsr}</strong><br/>
		
		<a href="${ormInsertUsr}">ORMController ormInsertUser</a>
		<br/>Calling with the value <strong>${ormInsertUsr}</strong><br/>
		
		<c:if test="${not empty users }">
		<h4 style="float:center">ORM User List</h4><br/>
			<table>
				<c:forEach var="user" items="${users}">
					<tr><td> <b>User ID:             </b></td> <td><c:out value="${user.idUser}"/></td></tr>
					<tr><td> <b>User username:       </b></td> <td><c:out value="${user.username}"/></td></tr>
					<tr><td> <b>User password:       </b></td> <td><c:out value="${user.password}"/></td></tr>
					<tr>
						<td> <b>User enabled:       </b></td>
						<td>
						<c:if test="${user.enabled == 'true'}">
							<font color="green"><b><c:out value="${user.enabled}"/></b></font>
						</c:if>
						<c:if test="${user.enabled == 'false'}">
							<font color="red"><b><c:out value="${user.enabled}"/></b></font>
						</c:if>
						</td>
					</tr>
				</c:forEach>
			
			</table>
		</c:if>
		
		<c:if test="${not empty result }">
			<h3>Result: </h3>
			<c:if test="${result == 'true'}">
				<font color="green"><c:out value="${result }"/></font>
			</c:if>
			<c:if test="${result == 'false'}">
				<font color="red"><c:out value="${result }"/></font>
			</c:if>
		</c:if>
		
		
	</jsp:body>
</page:template>

