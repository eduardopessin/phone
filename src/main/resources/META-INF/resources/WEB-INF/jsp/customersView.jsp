<html>
<head>
	<title>Customers</title>


	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/custom.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/custom.css">
	


</head>

<body>
<div id="page-wrap">


<table>
<tr>
	<td>
		<select id="selCountry">
			<option value="*">All</option>
			<option value="Cameroon">Cameroon</option>
			<option value="Ethiopia" >Ethiopia</option>
			<option value="Morocco">Morocco</option>
			<option value="Mozambique">Mozambique</option>
			<option value="Uganda">Uganda</option>
		</select>
	</td>
	<td>
		<select id="selState">
			<option value="*">All</option>
			<option value="Valid" >Valid</option>
			<option value="Invalid">Invalid</option>
		</select>
	</td>
	<td>
		<input type="button" id="filter" value="filter" onclick="LoadUP(0)">
	</td> 
</tr>
</table>


	<div id="customersJson"></div>


</div>
</body>
</html>
