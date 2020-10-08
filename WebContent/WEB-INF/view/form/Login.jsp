<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>


<html>
	<head>
		<meta charset="UTF-8">
		<title>Login</title>
		<spring:url value="/resources/css/bootstrap.css" var="bootstrap"/>
		<spring:url value="/resources/css/signin.css" var="signin"/>
		<link href="${signin}" rel="stylesheet"/>
		<link href="${bootstrap}" rel="stylesheet"/>	
		
	</head>
	<body>
		
		<form action="j_spring_security_check" method="post" class="form-signin">
		<security:authorize access="hasAnyRole('ROLE_USER', 'ROLE_ADMIN', 'ROLE_SUPER_USER')" var="isUser"/>
		<font size="2" color="red">
			<c:if test="${not isUser}"> 
				<c:if test="${empty param.error}">
					You are not logged in
				</c:if>
			</c:if>
		</font>
		
		<font size="2" color="green">
			<c:if test="${isUser}">Hi "
				<security:authentication property="principal.username"/> ". Your role is: "
				<security:authentication property="principal.authorities"/> "
					
			</c:if>
						
		</font>
		<br/>
		
		<h2>Please sign in </h2>
		
		<label class="sr-only" for="inputEmail"><spring:message code="email" text="Email" /></label>
		<input id="inputEmail" class="form-control" type="email" name="j_username" value="tunatore@gmail.com" required autofocus />
		
		<label class="sr-only" for="inputpassword"><spring:message code="pass" text="Password"/></label> 
		<input id="inputPassword" class="form-control" type="password" name="j_passsword" value="12345" required/>
		
		<div class="checkbox">
			<label>
				<input type="checkbox" name="_spring_security_remember_me" id="rememberme"/> Remember me 
			</label>
		</div>
		<br/>
		<input type="submit" id="inputSubmit" class="btn btn-lg btn-primary btn-block" value="Submit"/>
		
		</form>
		<a href="javascript:history.back()" class="btn btn-primary btn-sm" >Back</a>
		
	</body>

</html>