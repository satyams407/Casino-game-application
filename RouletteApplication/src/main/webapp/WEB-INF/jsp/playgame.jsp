<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
	integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
	crossorigin="anonymous">

<!-- Compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css">
<!-- Compiled and minified JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js">
	
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<nav>
	<div class="nav-wrapper" style="background-color: green; color: white">
		<a class="brand-logo">Roullete</a>
		<ul id="nav-mobile" class="right hide-on-med-and-down">
			<li>
				<%
					double userBalance = (double) session.getAttribute("currentUserBalance");
					out.print("Balance:" + userBalance);
				%>
			</li>
			<li><a onclick()=logout()>logout</a></li>
		</ul>
	</div>
	</nav>
	<h5>
		Welcome
		<%
		String userName = (String) session.getAttribute("currentUserName");
		out.print(userName);
	%>
	</h5>
	<!-- <img src="https://www.w3schools.com/images/w3schools_green.jpg"
		alt="Smiley face" width="42" height="42"> -->
	<form method="post" action="/dashboard/betamount"
		modelAttribute="BetAmount">
		<table class="striped" style="">
			<tbody>
				<tr>
					<td>1st 12</td>
					<td><input type="number" class="form-control" path="first12"
						name="first12" min="0" step="500" value="0" /></td>
					<td>2nd 12</td>
					<td><input type="number" class="form-control" path="second12"
						name="second12" min="0" step="500" value="0" /></td>
					<td>3rd 12</td>
					<td><input type="number" class="form-control" path="third12"
						name="third12" min="0" step="500" value="0" /></td>
				</tr>
				<tr>
					<td>0</td>
					<td><input type="number" class="form-control" path="zero"
						name="zero" min="0" step="500" value="0" /></td>
					<td>1 to 18</td>
					<td><input type="number" class="form-control"
						path="oneToEighteen" name="oneToEighteen" min="0" step="500"
						value="0" /></td>
					<td>19 to 36</td>
					<td><input type="number" class="form-control"
						path="nineteenToThirySix" name="ninteenToThirtySix" min="0"
						step="500" value="0" /></td>
				</tr>
				<tr>
					<td>Even</td>
					<td><input type="number" class="form-control" path="even"
						name="even" min="0" step="500" value="0" /></td>
					<td>Odd</td>
					<td><input type="number" class="form-control" path="odd"
						name="odd" min="0" step="500" value="0" /></td>
					<td></td>
					<!--play button-->
					<td>
						<button type="button" class="btn btn-primary" data-toggle="modal"
							data-target="#exampleModal"
							class="btn btn-success btn-lg btn-block"
							style="background-color: green">Play</button>
					</td>
				</tr>
			</tbody>
		</table>
	</form>



	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">...</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary">Save changes</button>
				</div>
			</div>
		</div>
	</div>

</body>
</html>