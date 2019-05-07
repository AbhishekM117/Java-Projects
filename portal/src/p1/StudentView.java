package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import p1.Connector;

@WebServlet("/StudentView")
public class StudentView extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String num=request.getParameter("reg_no");
		String pass=request.getParameter("pass");
		String name,m;
		int s,e;
		boolean t=false;
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		
		try {
			Connection con=Connector.getconnection();
			PreparedStatement stmt=con.prepareStatement("Select * from student_details");
			ResultSet rs=stmt.executeQuery();
			
			while(rs.next()) {
				if(num.equals(Integer.toString(rs.getInt(1))) && pass.equals(rs.getString(3))) {
					name=rs.getString(2);
					m=rs.getString(4);
					s=rs.getInt(5);
					e=rs.getInt(6);
					out.print("<head><link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\"></head>");
					out.print("<div class='sub'>");
					out.print("<h1 align=\"center\">GOOGLE</h1>");
					out.print("<h2 align='center'>EMPLOYEE DETAILS </h2><br><br>");
					out.print("<table align='center'>");
					out.print("<tr><td><h2>Employee name : </h2></td><td><h2>"+name+"</h2></td></tr>");
					out.print("<tr><td><h2>eid number : </h2></td><td><h2>"+num+"</h2></td></tr>");
					out.print("<tr><td><h2>Semester : </h2></td><td><h2>VI SEM</h2></td></tr>");
					out.print("</table><br><br>");
					/*out.print("<h2>marks sheet : <h2><br>");*/
					out.print("<table border='1' align='center'");
					out.print("<tr><th>Emp name</th><th>Attendance</th><th>required attendance</th><th>status</th></tr>");
					out.print("<tr><td>Attendance</td><td>"+e+"</td><td>75</td><td>"+status(e)+"</td></tr>");
					out.print("</table>");
					out.print("<a href='mainlogin.html' align='bottom'>logout<a>");
					out.print("</div>");
					t=true;
					
					break;
				
					
			}else if(num.equals("jay") && pass.equals("jay")) {
				response.sendRedirect("faculty.jsp");  
			}
					
					
				}
			if(t==false) {
				out.println("<h1 align=\"center\">EMPLOYEE NOT FOUND</h1>");
			}
				
			
			
			
			
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		
	}
	public String status(int attendance) {
		if(attendance>=75)
			return "PROMOTED";
		else
			return "<p >DEMOTED</p>";
	}


}
