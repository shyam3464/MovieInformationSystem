<html>
<meta charset="UTF-8" />
<!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
<title>Customer Search Screen</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="resources/css/demo.css" />
<link rel="stylesheet" type="text/css" href="resources/css/style.css" />
<!-- <link rel="stylesheet" type="text/css"
	href="resources/css/bootstrap.css" /> -->
<link rel="stylesheet" type="text/css"
	href="resources/css/animate-custom.css" />
<!-- <script src="resources/js/jquery.js"></script>
<script src="resources/js/bootstrap.js"></script> -->
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script> -->
<%
	String errMsg = (String) request.getAttribute("errMsg");
	if (null == errMsg) {

	}
%>


<%
	String successMsg = (String) request.getAttribute("successMsg");
	if (null == successMsg) {

	}
%>
<body>
	<div class="container">
		<!-- 		<a href="home.jsp" name="logout"  class="menu" type="button" style="float: right;color: #FF0000;">Logout</a> -->
		<header>
			<h1>Movie Information System</h1>
		</header>
		<a href="<%=request.getContextPath()%>/logout.do" name="logout"
			class="menu" type="button" style="float: right; color: #FF0000;">Logout</a>
		<section>
			<div id="container_demo">
				<div id="wrapper">
					<div id="searchScreen" class="animate form">
						<form action="<%=request.getContextPath()%>/insertDetails.do"
							autocomplete="on" method="post">
							<h1>Enter the details to add a new Movies</h1>
							<p>
								<label for="name" class="name">Movie Name </label> <input
									id="name" name="name" required="required" type="text" />
							</p>
							<p>
								<label for="releaseDate" class="date">Release Date </label> <input
									id="releaseDate" name="releaseDate" required="required"
									type="date" />
							</p>
							<p>
								<label for="director" class="director">Director </label> <input
									id="ddirector" name="director" required="required" type="text" />
							</p>
							<p>
								<label for="productionHouse" class="productionHouse">Production
									House </label> <input id="productionHouse" name="productionHouse"
									required="required" type="text" />
							</p>
							<p>
								<label for="genre" class="genre">Genre</label>
							</p>
							<p>
								<select name=genre style="padding: 5px 10px; width: 100%">
									<option selected disabled>Choose here</option>
									<option value="Adventure">Adventure</option>
									<option value="Action">Action</option>
									<option value="Thriller">Thriller</option>
									<option value="Biography">Biography</option>
									<option value="Drama">Drama</option>
									<option value="History">History</option>
									<option value="Horror">Horror</option>
									<option value="War">War</option>
									<option value="Family">Family</option>
									<option value="Comedy">Comedy</option>
									<option value="Animated">Animated</option>
									<option value="Science Fiction">Science Fiction</option>
								</select>
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
							<p class="submit button">
								<input type="submit" value="Submit" /> <b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
									type="reset" value="Reset" />
							</p>
						</form>
					</div>

				</div>
			</div>
		</section>
	</div>
</body>
</html>