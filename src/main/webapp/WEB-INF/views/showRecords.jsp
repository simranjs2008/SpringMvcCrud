<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Records</title>
	<style>
		.error {
			color: red;
		}
		td {
		    padding: 0 25px;
			border: 1px solid black;
		}
		table, th {
		  border: 1px solid black;
		}
	</style>
</head>

<body>
	<div>
		<h1>List of Records</h1>
		

		
            <table>
			  <tr>
			    <th>Name</th>
			    <th>Email</th>
			    <th>dob</th>
			    <th>phone</th>
			    <th>buttons</th>
			  </tr>
			  <c:forEach var="record" items="${records}"> 
			  <tr>
			    <td>${record.name }</td>
			    <td>${record.email }</td>
			    <td>${record.dob }</td>
			    <td>${record.phone }</td>
			    <td>
					<form:form action="editRecord/${record.id}">

						<input type="submit" value="Edit" />
			
					</form:form>
				</td>
			    
			  </tr>
			  </c:forEach>
			</table>
        
        
		<form:form action="createRecord" modelAttribute="record" method="post">

			<input type="submit" value="Add Record" />

		</form:form>
	</div>
</body>
</html>