<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Results</title>
</head>
<body>
	<h1><c:out value="${person.firstName} ${person.lastName }"/></h1>
	<h3>Age:   <c:out value="${person.age}"/></h3>
	<h3>Address:  <c:out value="${person.license.street}"/></h3>
	<h3>City:  <c:out value="${person.license.city}"/></h3>
	<h3>State:   <c:out value="${person.license.state}" /></h3>
</body>
</html>