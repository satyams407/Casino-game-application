<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Roulette</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
	integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
	crossorigin="anonymous">
</head>
<body>
	<nav class="navbar navbar-light bg-faded"
		style="background-color:green;width:100%"> <a
		class="navbar-brand">${navHeading}</a> </nav>

	<form method="post" action="/dashboard">
		<div class="container">
		  <label for="uniqueId">enter the unique id</label>
			<input type="text" name="userId" id="uniqueId" value="" onclick="this.value=''"
				style="width: 150px; margin-top: 200px" required="required" />
			<button value="Enter">${button}</button>
			<p style="color:red">${errorMessage}</p>
		</div>
	</form>
</body>
</html>