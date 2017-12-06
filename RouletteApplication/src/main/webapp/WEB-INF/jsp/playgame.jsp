<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script type="text/javascript">
	window.onload = function() {
<%boolean insufficientBalance = (boolean) session.getAttribute("insufficientBalance");
			int gameResult = (int) session.getAttribute("gameResult");%>
	if (<%=insufficientBalance%>== true) {
			$('#errorModal').modal('show');
		}
		if (<%=gameResult%>>= 0) {
			$('#ResultModal').modal('show');
		}
	}

	function validateBetAmount() {
		var value1 = Number(document.getElementById('first12').value);
		var value2 = Number(document.getElementById('second12').value);
		var value3 = Number(document.getElementById('third12').value);
		var value4 = Number(document.getElementById('zero').value);
		var value5 = Number(document.getElementById('oneToEighteen').value);
		var value6 = Number(document.getElementById('nineteenToThirySix').value);
		var value7 = Number(document.getElementById('even').value);
		var value8 = Number(document.getElementById('odd').value);
		var totalBetAmount = (value1 + value2 + value3 + value4 + value5
				+ value6 + value7 + value8);
		if (totalBetAmount == 0) {
			document.getElementById("playButton").setAttribute("data-target",
					"");
			document.getElementById("playButton").setAttribute("data-toggle",
					"modal");
			document.getElementById("playButton").setAttribute("data-target",
					"#errorModal2");
		} else {
			document.getElementById("playButton").setAttribute("data-target",
					"");
			document.getElementById("playButton").setAttribute("data-toggle",
					"modal");
			document.getElementById("playButton").setAttribute("data-target",
					"#PlayModal");
		}
	}
	function playAgain() {
         <%session.setAttribute("gameResult", -1);%>
	}
</script>
<style>
#image {
	margin: 0 auto;
	width: 50%;
}

.bgimg {
	background-image:
		url("http://roulettegamble.com/wp-content/uploads/2014/11/Roulette-online-regeln-940x705.jpg");
	opacity: 0.9;
	background-repeat: no-repeat;
	background-size: cover;
}
</style>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Roulette Game</title>

</head>
<body>
	<nav class="navbar navbar-inverse" style="background-color:black">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<b class="navbar-brand"
				style="color: white; padding: 5px; margin: 3px">Roullete</b>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav" style="float: right">
				<li style="color: white; padding: 10px"><%@page
						import="java.text.DecimalFormat"%> <%
 	double userBalance = (double) session.getAttribute("currentUserBalance");
 	DecimalFormat dec = new DecimalFormat("#0.00");
 	out.print("Balance:" + dec.format(userBalance));
 %></li>

				<li style="padding: 2px">
					<form method="post" action="/">
						<button type="submit" class="btn btn-secondary"
							style="background-color: black; color: white; padding: 5px; margin-top: 3px">logout</button>
					</form>
				</li>

			</ul>

		</div>
	</div>
	</nav>

	<h4 style="margin-left: 10px; padding: 5px">
		Welcome
		<%
		String userName = (String) session.getAttribute("currentUserName");
		out.print(userName);
	%>
	</h4>

	<div id="image" style="padding: 10px">
		<img
			src="http://www.roulette.co.uk/wp-content/uploads/european-roulette.jpeg"
			alt="unable to load image" content="img/jpg" />
	</div>


	<form method="post" action="/dashboard/betamount"
		modelAttribute="BetAmount">
		<table class="table table-striped">
			<tbody class="thead-light">
				<tr>
					<td>1st 12</td>
					<td><input type="number" class="form-control" path="first12"
						name="first12" id="first12" min="0" step="500" value="0" /></td>
					<td>2nd 12</td>
					<td><input type="number" class="form-control" path="second12"
						name="second12" id="second12" min="0" step="500" value="0" /></td>
					<td>3rd 12</td>
					<td><input type="number" class="form-control" path="third12"
						name="third12" id="third12" min="0" step="500" value="0" /></td>
				</tr>
				<tr>
					<td>Zero</td>
					<td><input type="number" class="form-control" path="zero"
						name="zero" id="zero" min="0" step="500" value="0" /></td>
					<td>1 to 18</td>
					<td><input type="number" class="form-control"
						path="oneToEighteen" id="oneToEighteen" name="oneToEighteen"
						min="0" step="500" value="0" /></td>
					<td>19 to 36</td>
					<td><input type="number" class="form-control"
						path="nineteenToThirySix" id="nineteenToThirySix"
						name="ninteenToThirtySix" min="0" step="500" value="0" /></td>
				</tr>
				<tr>
					<td>Even</td>
					<td><input type="number" class="form-control" path="even"
						name="even" id="even" min="0" step="500" value="0" /></td>
					<td>Odd</td>
					<td><input type="number" class="form-control" path="odd"
						name="odd" id="odd" min="0" step="500" value="0" /></td>
					<td></td>

					<td>
						<button type="button" id="playButton" class="btn btn-primary"
							onclick="validateBetAmount()" style="background-color: green">Play</button>
					</td>
				</tr>
			</tbody>
		</table>

		<!-- Modal -->
		<div class="modal fade" id="PlayModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Try your luck</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						Are you sure!!
						<p>you want to try your luck with your current selection..??</p>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">No</button>
						<button type="submit" value="submit" class="btn btn-primary">Sure!!</button>
					</div>
				</div>
			</div>
		</div>






		<!--insufficient amount modal -->
		<div class="modal fade" id="errorModal" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">

						<h4 class="modal-title">Error</h4>
					</div>
					<div class="modal-body">
						<p>Sorry Dear !!!</p>
						<p>You have insufficient balance for your selection ...</p>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary" data-dismiss="modal">Reset
							Game</button>
					</div>
				</div>
			</div>
		</div>

		<!--not selected any bet modal -->
		<div class="modal fade" id="errorModal2" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">

						<h4 class="modal-title">Oops!!</h4>
					</div>
					<div class="modal-body">
						<p>Please put money on atleast one field</p>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>

	</form>


	<!-- Result modal -->
	<div class="modal fade" id="ResultModal" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">
						<%
							if ((int) session.getAttribute("resultAmount") != 0) {
								out.print("You Won!!");

							} else {
								out.print("You Lost!!");

							}
						%>
					</h4>
				</div>
				<div class="modal-body">
					<p>
						<%
							if ((int) session.getAttribute("resultAmount") != 0) {
								out.print("Random Number is " + session.getAttribute("randomNumber"));
						%><br>
						<%
							out.print("You Won " + session.getAttribute("resultAmount"));
							}
						%>
					</p>
				</div>
				<div class="modal-footer">

					<form method="post" action="/">
						<button type="submit" style='float: left' class="btn btn-default">Exit</button>
					</form>

					<button type="button" onclick="playAgain()" class="btn btn-primary"
						data-dismiss="modal">Play Again!!</button>

				</div>
			</div>
		</div>
	</div>


</body>
</html>

