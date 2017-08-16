<%@ page import="com.ethicalprogrammers.mis.model.Movie" %>
<%@ page import="java.util.ArrayList" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Search Display</title>

<style>
body  {
	
	background-image: url("Movie.jpg");
    background-repeat:no-repeat;
    background-size:cover;
    
	}
</style>

</head>
<body>

<%
ArrayList<Movie> movList =(ArrayList<Movie>)request.getAttribute("movieList");
%>

<% System.out.println("Movie details from list "); %>

<center><h1>Movie Details</h1></center><br>

<center>
<table border="2" cellpadding="2" width="120%" >
<tr>
<!-- <th bgcolor="#FF9999"><b>Movie_ID</b></th> -->
<th bgcolor="#FF9999"><b>Movie_Name</b></th>
<th bgcolor="#FF9999"><b>Release_Date</b></th>
<th bgcolor="#FF9999"><b>Production_House</b></th>
<!-- <th bgcolor="#FF9999"><b>Duration</b></th> -->
<th bgcolor="#FF9999"><b>Movie_Rating</b></th>
<!-- <th bgcolor="#FF9999"><b>Lead_Actor_ID</b></th> -->
<th bgcolor="#FF9999"><b>Budget</b></th>
<th bgcolor="#FF9999"><b>Collections</b></th>
<!-- <th bgcolor="#FF9999"><b>Genre_ID</b></th> -->
</tr>

<% 
for(Movie st:movList){
%>
	<tr>
	<td><% out.println(st.getName());%></td> 
	<td><% out.println(st.getReleaseDate().toString());%></td>
	<td><% out.println(st.getProductionHouse());%></td>
	<td><% out.println(st.getRating());%></td>
	<td><% out.println(st.getBudget());%></td>
	<td><% out.println(st.getCollections());%></td>
	</tr>
<%
}
%>

</table>
</body>
</html>