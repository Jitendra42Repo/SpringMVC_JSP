<!DOCTYPE html>
<%@tag description="Template Site Tag" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@attribute name="title" fragment="true"%>

<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, initial-scale=1">

<title><jsp:invoke fragment="title" /></title>

<spring:url value="/resources/css/bootstrap.css" var="bootstrap" />
<spring:url value="/resources/css/starter-template.css"
	var="startertemplate" />

<link href="${bootstrap}" rel="stylesheet" />
<link href="${startertemplate}" rel="stylesheet" />

<spring:url value="/resources/js/bootstrap.min.js" var="js" />
<spring:url value="/resources/js/jquery-2.1.4.min.js" var="jqueryjs" />

<script type="text/javascript" src="${jqueryjs}"></script>
<script type="text/javascript" src="${js}"></script>

</head>
<body>

	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
			</div>

			<id ="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li><a href="${pageContext.request.contextPath}"> Home</a></li>
				<li><a href="#" class="dropdown-toggle"
					style="padding-bottom: 20" data-toggle="dropdown" data-target="">Lectures</a>
					<div class="dropdown-menu">
						<ul class="list-group ">

							<c:url value="/jdbc.html" var="jdbc" />
							<li class="list-group-item"><a class="dropdown-item"
								dropdown-item href="${jdbc}">JDBC with JDBC-Templates</a></li>

							<li class="list-group-item"><a class="dropdown-item"
								dropdown-item href="#">HTML5</a></li>

							<c:url value="/file.html" var="fileUpload" />
							<li class="list-group-item"><a class="dropdown-item"
								dropdown-item href="${fileUpload}">File Upload Excel and PDF
									examples</a></li>

							<c:url value="/email.html" var="emailController" />
							<li class="list-group-item"><a class="dropdown-item"
								dropdown-item href="${emailController}">Sp-MVC Email &
									Velocity Template </a></li>

							<c:url value="/restfulWS.html" var="restService" />
							<li class="list-group-item"><a class="dropdown-item"
								dropdown-item href="${restService}">Sp-MVC Rest WS </a></li>

							<c:url value="/orm.html" var="ormHibernate" />
							<li class="list-group-item"><a class="dropdown-item"
								dropdown-item href="${ormHibernate}">Spring
									ORM_JPA_Hibernate </a></li>

						</ul>
					</div></li>
				<c:url value="/login.html" var="login" />
				<li><a href="${login}">Login</a></li>
			</ul>
			<security:authorize access="hasAnyRole('ROLE_USER', 'ROLE_ADMIN', 'ROLE_SUPER_USER')" var="isUser">
				<div style="color:#568C00; float: right;">Hi "<security:authentication property="principal.username"/>." Role: "
				<security:authentication property="principal.authorities"/> "
				<b><a style="color: #568C00; text-decoration: underline;" href="<c:url value="/j_spring_security_logout"/>"> Logout</a></b>
				</div>
			</security:authorize>
			
		</div>
	</nav>
	<div class="jumbotron text-center ">
		<div class="container-fluid">
			<div class="row">
				<div class="col col-lg-12 col-sm-1 h4">
					<p>
						<strong>Java Spring MVC </strong>
					</p>
					<p>Integrated with AngularJS by Google and HTML5</p>
				</div>
			</div>
		</div>
	</div>

	<div class="container">
		<div class="starter-template">
			<jsp:doBody />
		</div>
	</div>
	<br />
	<br />


	<div class="footer">
		<div class="container">
			<p class="text-muted">Footer</p>
		</div>
	</div>


</body>
</html>