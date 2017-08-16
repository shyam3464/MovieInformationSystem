
<head>
<meta charset="UTF-8" />
<!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
<title>Login and Registration Form with HTML5 and CSS3</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="resources/css/demo.css" />
<link rel="stylesheet" type="text/css" href="resources/css/style.css" />
<link rel="stylesheet" type="text/css"
	href="resources/css/animate-custom.css" />

<%
	String errMsg = (String) request.getAttribute("errMsg");
	if (null == errMsg) {

	}
%>

</head>
<body>
	<div class="container">
		<header>
			<h1>
				Movie Information System
			</h1>
		</header>
		<section>
			<div id="container_demo">
					<div id="wrapper">
					<div id="adminLogin" class="animate form">
						<form action="<%=request.getContextPath()%>/adminLogin.do"
							autocomplete="on" method="post">
							<h1>Admin Log in</h1>
							<p>
								<label for="username" class="uname" >username </label> <input id="userName" name="userName"
									required="required" type="text" />
							</p>
							<p>
								<label for="password" class="youpasswd">
									Your password </label> <input id="password" name="password"
									required="required" type="password"  />
							</p>
							<p class="keeplogin">
								<input type="checkbox" name="loginkeeping" id="loginkeeping"
									value="loginkeeping" /> <label for="loginkeeping">Keep
									me logged in</label>
							</p>
							<p><label for="errorMessage" class="uname"> 
									<% if (errMsg != null) { %>
										<%=errMsg%>
									<% } %>
							</label></p>
							<p class="login button">
								<input type="submit" value="Login" />
							</p>
						</form>
					</div>

				</div>
			</div>
		</section>
	</div>
</body>
</html>