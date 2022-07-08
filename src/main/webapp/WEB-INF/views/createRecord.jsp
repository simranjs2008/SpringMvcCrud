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
		<h1>Add a Record</h1>

		<form:form action="addRecord" modelAttribute="record" method="post">

            Name:
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
			<br>

			<input type="submit" value="Add Record" />

		</form:form>
	</div>
</body>
</html>