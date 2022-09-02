<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>


.container{
	/* background-color: lime; */
	padding-top: 30px;
}

ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #38444d;
}

li {
  float: left;
}

li a, .dropbtn {
  display: inline-block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover, .dropdown:hover .dropbtn {
  background-color: red;
}

li.dropdown {
  position: relative;
  display: inline-block;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
  text-align: left;
}


.dropdown-content a:hover {background-color: #f1f1f1;}
  .dropdown:hover .dropdown-content {display: block;}



@media screen and (max-width: 600px) {
	ul.topnav li.right, ul.topnav li {
		float: none;
	}
}


</style>
</head>
<body>

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

<%-- 	<ul class="topnav">
		<li><a href="#home">Home</a></li>
		<li><a href="#news">News</a></li>
		<li><a href="#contact">Contact</a></li>
		<li><a href="#about">About</a></li>
		
		<li class="dropdown" style="float:right;font-weight:bold;">
	    <a href="javascript:void(0)" class="dropbtn"><i class="fa fa-fw fa-user"></i> <%=userName%></a>
	    <div class="dropdown-content">
	      <a href="adminpage.jsp">Profile</a>
	      <a href="deleteRecord.jsp">Change password</a>
	      <a href="logout.jsp">Logout</a>
	    </div>
	  </li>
			
	</ul> --%>


	<div class="container">


		<br>
		<h1 style="text-align: center">Welcome USer <%=userName%> !!</h1>
	<!-- 	<table>
			<tr>
				<td>Click here to</td>
				<td><a href="adminpage.jsp">view all records</a></td>
			</tr>
			<tr>
				<td>Click here to</td>
				<td><a href="deleteRecord.jsp">delete record</a></td>
			</tr>

			<tr>
				<td>Click here to</td>
				<td><a href="logout.jsp">Logout</a></td>
			</tr>
		</table> -->
		<h3>
			Hi
			<%=userName%>, Login successful. Your Session ID=<%=sessionID%></h3>
	</div>



</body>
</html>