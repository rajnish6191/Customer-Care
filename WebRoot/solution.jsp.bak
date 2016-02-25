<%@ page import="java.sql.*;>
 <% String ticketno=request.getParameter("ticketno");
	String sol=request.getParameter("sol");
    
Class.forName("oracle.jdbc.driver.OracleDriver");
     Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "care", "care");
	PreparedStatement stmt=con.createPrepareStatement();
      int i=stmt.executeUpdate("insert into problemhistory values(?,?) where ticket='"+ticketno+"'");
      stmt.setString(4,sol);
      Stmt.setString(7,"finished");
     stmt.execute();
%>
SUCCESS FULLY COMPLETED