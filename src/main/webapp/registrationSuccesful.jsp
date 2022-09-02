<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body {
	background-size: cover;
	background-repeat: no-repeat;
	background-attachment: fixed;
	font-family: HelveticaNeue-Light;
	color: #333333;
}

.form {
	justify-content: center;
	align-items: center;
	margin: 10%;
}

.container {
	padding: 2% 13%;
	display: flex;
	background-size: cover;
	/* background-color: #FFF;
 */	margin: auto;
	
}

.box{
	flex: 1;
    
	/* background-color: rgb(202, 254, 255); */
	/* max-width: 500px;
	margin: auto;
	height: auto;
	border-radius: 12px;
	padding: 5px; */
}

.box:first-child {
    margin-right: 0px;
    background-color:#fff;
/*     background-color: black;
 */    background-image:url("https://img.freepik.com/free-vector/access-control-system-abstract-concept_335657-3180.jpg?w=740&t=st=1659612220~exp=1659612820~hmac=d7c63898fd37d886bd766fa15aa4b8788972fbfea36ed158b9f14732343f78ed");
 		background-position: center;
		background-size: cover;
} 

::-webkit-input-placeholder { /* WebKit browsers */
	opacity: 0.4 !important;
}

.techno {
	font-family: HelveticaNeue-Light;
	font-weight: bold;
	text-align: center;
}
.techno1 {
	color:red;
	font-family: HelveticaNeue-Light;
	font-weight: bold;
	text-align: center;
}

.ptag {
	font-size: medium;
	font-family: serif;
}

/* CSS */
.button-77 {
	background-clip: padding-box;
	background-color: initial;
	background-image: none;
	border-style: none;
	box-sizing: border-box;
	color: #fff;
	cursor: pointer;
	padding: 7% 39%;
	font-family: Eina01, sans-serif;
	font-size: 16px;
	font-weight: 800;
	min-height: 50px;
	outline: none;
	overflow: visible;
	margin-left: auto;
	pointer-events: auto;
	position: relative;
	text-align: center;
	text-decoration: none;
	text-transform: none;
	user-select: none;
	-webkit-user-select: none;
	touch-action: manipulation;
	vertical-align: middle;
	word-break: keep-all;
	z-index: 0;
}

@media ( max-width : 768px) {
	.button-77 {
		padding: 15px 100px;
	}
}

.button-77:before, .button-77:after {
	border-radius: 80px;
}

.button-77:before {
	background-color: #00dbde;
	content: "";
	display: block;
	height: 100%;
	left: 0;
	overflow: hidden;
	position: absolute;
	top: 0;
	width: 100%;
	z-index: -2;
}

.button-77:after {
	background-color: initial;
	background-image: linear-gradient(92.83deg, #fc00ff 0, #00dbde 100%);
	bottom: 4px;
	content: "";
	display: block;
	left: 4px;
	overflow: hidden;
	position: absolute;
	right: 4px;
	top: 4px;
	transition: all 100ms ease-out;
	z-index: -1;
}

.button-77:hover:not(:disabled):after {
	bottom: 0;
	left: 0;
	right: 0;
	top: 0;
	transition-timing-function: ease-in;
}

.button-77:active:not(:disabled) {
	color: #ccc;
}

.button-77:active:not(:disabled):after {
	background-image: linear-gradient(0deg, rgba(0, 0, 0, .2),
		rgba(0, 0, 0, .2)), linear-gradient(92.83deg, #00dbde 0, #00dbde 100%);
	bottom: 4px;
	left: 4px;
	right: 4px;
	top: 4px;
}

.button-77:disabled {
	cursor: default;
	opacity: .24;
}

.label {
	text-align: left;
	margin-bottom: 40px;
}

.input100 {
	/* background-color: rgb(128, 128, 255); */
	border: 1px solid rgb(128, 128, 255);
	float: left;
	margin: auto;
	margin-bottom: 25px;
	width: 400px;
	padding: 5px;
	border-top: 0px;
	border-left: 0px;
	border-right: 0px;
	width: -webkit-fill-available;
}

.forgot-pass {
	text-align: right;
}

</style>


</head>
<body>

	<div class="container">
		 <div class="box"> 
			
		</div>
		<div class="box">
			<h1 class="techno1">Registration Successful !!</h1>
			<h1 class="techno">Login into Account</h1>
			
			<form class="form" name="RegForm" action="login" 	method="post">

				<label for="userName">User Name</label> <br> 
				<input
					class="input100" type="text" name="userName" id="userName"
					placeholder="Enter your username"> <br> <br> 
					<label
					for="pass">Password</label> <br> <input class="input100"
					type="password" name="passWord" id="pass"
					placeholder="Enter your password"> <br> <br> 


				<div class="forgot-pass">
					<a href="#"> Forgot password? </a>
				</div>

				<br>
				<br>
				<button class="button-77">Login</button>

			</form>
		</div>
	</div>

</body>
</html>