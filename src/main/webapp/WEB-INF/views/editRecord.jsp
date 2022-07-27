<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Record</title>
	<style>
		.error {
			color: red;
		}
	</style>
</head>

<body>
	<div>
		<h1>Edit a Record</h1>

		<form:form action="updateRecord" modelAttribute="record" method="post">

			Id:
            <form:input path="id" readonly="true"/>
            
            <br>
			<br> Name:
            <form:input path="name" />
            <form:errors path="name" cssClass="error" />

			<br>
			<br> Email:
            <form:input path="email" />
			<form:errors path="email" cssClass="error" />
			
			<br>
			<br> DOB:
            <form:input path="dob" />
			<form:errors path="dob" cssClass="error" />
			
			<br>
			<br> Phone no:
            <form:input path="phone" />
			<form:errors path="phone" cssClass="error" />

			<br>
			<br> City:
            <form:input path="address.city" />
			<form:errors path="address.city" cssClass="error" />
			
			<br>
			<br> State:
            <form:input path="address.state" />
			<form:errors path="address.state" cssClass="error" />

			<br>
			<br>

			<input type="submit" value="Update Record" />

		</form:form>
	</div>
</body>
</html>