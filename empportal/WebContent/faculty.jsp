<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*" %>
    <%@page import="empportal.Connector" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>faculty login</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<div class="faculty">
<h1>Alliance University</h1>
<H2>ADMIN PORTAL</H2>
<table><tr><th>eid</th><th>name</th><th>email</th><th>Salary</th><th>attendance</th></tr>

<%
try{
	Connection con=Connector.getconnection();
	PreparedStatement stmt=con.prepareStatement("Select * from student_details");
	ResultSet rs=stmt.executeQuery();
	while(rs.next()){
		out.print("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getInt(5)+"</td><td>"+rs.getInt(6)+"</td></tr>");
	}
	
}catch(Exception e){
	e.printStackTrace();
}


%>
</table>
</div>
</body>
</html>