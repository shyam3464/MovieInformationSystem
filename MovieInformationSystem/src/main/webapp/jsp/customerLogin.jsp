<head>
<meta charset="UTF-8" />
<!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
<title>Login and Registration Form with HTML5 and CSS3</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="resources/css/demo.css" />
<link rel="stylesheet" type="text/css" href="resources/css/style.css" />
<link rel="stylesheet" type="text/css"
	href="resources/css/animate-custom.css" />

<% 	String errMsg = (String) request.getAttribute("errMsg");
	if (null == errMsg) {

	}
%>


<%
	String errMsgRegister = (String) request.getAttribute("errMsgRegister");
	if (null == errMsgRegister) {

	}
%>

<%
	String successMsg = (String) request.getAttribute("successMsg");
	if (null == successMsg) {

	}
%>

</head>
<body>
	<div class="container">
		<header>
			<h1>Movie Information System</h1>
		</header>
		<section>
			<div id="container_demo">
				<!-- hidden anchor to stop jump http://www.css3create.com/Astuce-Empecher-le-scroll-avec-l-utilisation-de-target#wrap4  -->
				<a class="hiddenanchor" id="toregister"></a> <a class="hiddenanchor"
					id="tologin"></a>
				<div id="wrapper">
					<div id="login" class="animate form">
						<form action="<%=request.getContextPath()%>/customerLogin.do"
							autocomplete="on" method="post">
							<h1>Customer Log in</h1>
							<p>
								<label for="username" class="uname">username </label> <input
									id="userName" name="userName" required="required" type="text" />
							</p>
							<p>
								<label for="password" class="youpasswd"> Your password </label>
								<input id="password" name="password" required="required"
									type="password" />
							</p>
							<p class="keeplogin">
								<input type="checkbox" name="loginkeeping" id="loginkeeping"
									value="loginkeeping" /> <label for="loginkeeping">Keep
									me logged in</label>
							</p>
							<p>
								<label for="errorMessage" class="uname"> <% if (errMsg != null) { %>
									<%=errMsg%> <% } %>
								</label>
							</p>
							<p>
								<label for="successMessage" class="uname"> <% if (successMsg != null) { %>
									<%=successMsg%> <% } %>
								</label>
							</p>
							<p class="login button">
								<input type="submit" value="Login" />
							</p>
							<p class="change_link">
								Not a member yet ? <a href="#toregister" class="to_register">Join
									us</a>
							</p>
						</form>
					</div>

					<div id="register" class="animate form">
						<form action="<%=request.getContextPath()%>/signup.do"
							method="post" autocomplete="on">
							<h1>Sign up</h1>
							<p>
								<label for="usernamesignup" class="uname">Your username</label>
								<input id="userName" name="userName" required="required"
									type="text" />
							</p>
							<p>
								<label for="emailsignup" class="youmail"> Your email</label> <input
									id="email" name="email" required="required" type="email" />
							</p>
							<p>
								<label for="passwordsignup" class="youpasswd">Your
									password </label> <input id="password" name="password"
									required="required" type="password" />
							</p>
							<p>
								<label for="errMsgRegister" class="uname"> <% if (errMsgRegister != null) { %>
									<%=errMsgRegister%> <% } %>
								</label>
							</p>
							<p class="signin button">
								<input type="submit" value="Sign up" />
							</p>
							<p class="change_link">
								Already a member ? <a href="#tologin" class="to_register">
									Go and log in </a>
							</p>
						</form>
					</div>

				</div>
			</div>
		</section>
	</div>
</body>
</html>