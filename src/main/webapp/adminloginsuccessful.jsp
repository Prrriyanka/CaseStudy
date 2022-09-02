<%@page language="java" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

<title>Insert title here</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/adminloginsuccess.css" />

</head>
<body style="margin: 0px;">

	<%
	//allow access only if session exists
	String user = null;
	if (session.getAttribute("admin") == null) {
		response.sendRedirect("LoginPage.jsp");
	} else
		user = (String) session.getAttribute("user");

	String userName = null;
	String sessionID = null;
	Cookie[] cookies = request.getCookies();
	if (cookies != null) {
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("user"))
		userName = cookie.getValue();
			if (cookie.getName().equals("JSESSIONID"))
		sessionID = cookie.getValue();
		}
	}
	%>

	<ul class="topnav">
		<li><a>Admin's page-Material view</a></li>
		
		<li class="dropbtn" style="float:right;font-weight:bold;"><i class="fa fa-fw fa-bell"></i></li>
		<li class="dropbtn" style="float:right;font-weight:bold;"><i class="fa fa-fw fa-search"></i></li>
				
		<li class="dropdown" style="float:right;">
	    <a href="javascript:void(0)" class="dropbtn" style="font-weight: 700;"><i class="fa fa-fw fa-user"></i> <%=userName%></a>
	    <div class="dropdown-content">
	      <a href="adminpage.jsp">Profile</a>
	      <a href="deleteRecord.jsp">Change password</a>
	      <a href="logout.jsp">Logout</a>
	    </div>
	  </li>
			
	</ul>


<div class="sidebar" style="background-color: white;">
<div class="sideNavTop">
	<i class="fa fa-fw fa-user-circle-o sideUserIcon"></i>
	<p><%=userName%></p>
	<p>abc@gmail.com</p>
</div>
	
	<div class="main-nav">
	<p>Main Navigation</p>
	</div>
  <a href="#home" style="color: ##f44336;font-weight: bold;font-family: sans-serif;"> <i class="fa fa-fw fa-home" style="color:black;"></i> Home</a>
  <a href="#services" style="color: #808080;font-weight: bold;font-family: sans-serif;"> <i class="fa fa-fw fa-wrench" style="color:black;"></i> Services</a>
  <a href="#clients" style="color: #808080;font-weight: bold;font-family: sans-serif;"> <i class="fa fa-fw fa-user" style="color:black;"></i> Clients</a>
  <a href="#contact" style="color: #808080;font-weight: bold;font-family: sans-serif;"> <i class="fa fa-fw fa-envelope" style="color:black;"></i> Contact</a>
</div>



<div class="container" style="height: 100%">
<p style="margin: 0;padding: 10px 10px"> DASHBOARD</p>
	<h3 style="padding: 10px">Hi	<%=userName%>, Login successful. Your Session ID=<%=sessionID%></h3>
<div class="card1">
	<div class="flex-container">
	  <div class="felx-container-child"><div style="background-color: #cc1855;"><i class="fa fa-file-text-o" style="font-size:36px;"></i></div><a href="showall" style="text-decoration: none;color: white;">View all Records</a></div>
	  <div class="felx-container-child"><div style="background-color: #00a5ba;"><i class="fa fa-trash-o" style="font-size:40px;"></i></div><a href="delete" style="text-decoration: none;color: white;">Delete a Record</a> </div>
	  <div class="felx-container-child"><div style="background-color: #7aab41;"><i class="fa fa-file-text-o" style="font-size:36px;"></i></div><a href="#" style="text-decoration: none;color: white;">View all Records </a></div>  
	  <div class="felx-container-child"><div style="background-color: #e08600;"><i class="fa fa-file-text-o" style="font-size:36px;"></i></div><a href="#" style="text-decoration: none;color: white;">View all Records </a></div>
	
	</div>
</div>

<div class="card2" style="display: flex;">
<div>
<table id="customers" >
  <tr>
    <th>Company</th>
    <th>Contact</th>
    <th>Country</th>
  </tr>
  <tr>
    <td>Alfreds Futterkiste</td>
    <td>Maria Anders</td>
    <td>Germany</td>
  </tr>
  <tr>
    <td>Berglunds snabbköp</td>
    <td>Christina Berglund</td>
    <td>Sweden</td>
  </tr>
  <tr>
    <td>Centro comercial Moctezuma</td>
    <td>Francisco Chang</td>
    <td>Mexico</td>
  </tr>
  <tr>
    <td>Ernst Handel</td>
    <td>Roland Mendel</td>
    <td>Austria</td>
  </tr>
  <tr>
    <td>Island Trading</td>
    <td>Helen Bennett</td>
    <td>UK</td>
  </tr>
  <tr>
    <td>Königlich Essen</td>
    <td>Philip Cramer</td>
    <td>Germany</td>
  </tr>
  <tr>
    <td>Laughing Bacchus Winecellars</td>
    <td>Yoshi Tannamuri</td>
    <td>Canada</td>
  </tr>
  <tr>
    <td>Magazzini Alimentari Riuniti</td>
    <td>Giovanni Rovelli</td>
    <td>Italy</td>
  </tr>
  <tr>
    <td>North/South</td>
    <td>Simon Crowther</td>
    <td>UK</td>
  </tr>
  <tr>
    <td>Paris spécialités</td>
    <td>Marie Bertrand</td>
    <td>France</td>
  </tr>
</table>
</div>

<div
id="myChart">
</div>
<script type="text/javascript">

google.charts.load('current', {'packages':['corechart']});
google.charts.setOnLoadCallback(drawChart);

function drawChart() {
var data = google.visualization.arrayToDataTable([
  ['Contry', 'Mhl'],
  ['Italy',54.8],
  ['France',48.6],
  ['Spain',44.4],
  ['USA',23.9],
  ['Argentina',14.5]
]);

var options = {
  title:'User Update Display Chart',
  is3D:true
};

var chart = new google.visualization.PieChart(document.getElementById('myChart'));
  chart.draw(data, options);
}
</script>
	</div>


</div>


</body>
</html>