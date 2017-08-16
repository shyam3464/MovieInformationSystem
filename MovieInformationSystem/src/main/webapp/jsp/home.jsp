
<head>
<meta charset="UTF-8" />
<!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
<title>Login and Registration Form with HTML5 and CSS3</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="resources/css/demo.css" />
<link rel="stylesheet" type="text/css" href="resources/css/style.css" />
<link rel="stylesheet" type="text/css"
	href="resources/css/animate-custom.css" />

</head>
<body>
	<div class="container">
		<header>
			<h1>
				Movie Information System
			</h1>
		</header>
		<section>
			<div id="container_demo1">
				<div id="wrapper">
					<div id="welcome" class="animate form">
						<table align="right">
							<tr>
							<form action="<%=request.getContextPath()%>/customerPage.do"
								autocomplete="on" method="get">
								<p class="customer button">
									<input type="submit" value="Customer Login" />
								</p>
							</form>
							</tr>
							<tr>
							<form action="<%=request.getContextPath()%>/adminPage.do"
								autocomplete="on" method="get">
								<p class="admin button">
									<input type="submit" value="Admin Login" />
								</p>
							</form>
							</tr>
						 </table>
					</div>

				</div>
			</div>
		</section>
	</div>
</body>
</html>