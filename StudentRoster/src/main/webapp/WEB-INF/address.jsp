<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
	<h1>New Address</h1>
	<form:form action="/addresses/create" method="post" modelAttribute="address">
		<form:label path="person">Name</form:label>
		<form:select path="person">
			<c:forEach items="${persons}" var="person">
				<form:option value="${person.id}">
					<c:out value="${person.firstName}  ${person.lastName}" />
				</form:option>
			</c:forEach>
		</form:select>
		<form:label path="street">Address:  
				<form:input type="text" path="street" />
		</form:label>
		<br>
		<form:label path="city">City: 
				<form:input type="text" path="city" />
		</form:label>
		<br>
		<form:label path="state">State: 
				<form:input type="text" path="state" />
		</form:label>
		<br>
		<input type="submit" value="Create">

	</form:form>
</body>
</html>