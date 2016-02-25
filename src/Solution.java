import java.io.*;
import java.sql.*;
import javax.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Solution extends HttpServlet
{
	Connection con=null;
	

    public Solution ()
    {
    }

    public void init(ServletConfig servletconfig)
        throws ServletException
    {
        super.init(servletconfig);
       
    }

    public void service(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws ServletException, IOException
    {    
           try
        {
           String ticketno=httpservletrequest.getParameter("ticketno");
	String sol=httpservletrequest.getParameter("sol");
     Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("driver is created");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "care","care");
     PreparedStatement stmt = con.prepareStatement("insert into problemhistory values(?,?) where ticket='"+ticketno+"'");
      stmt.setString(4,"sol");
      stmt.setString(7,"finished");
       stmt.executeUpdate();

       }catch(Exception exception)
        {
            System.out.println(exception.getMessage());
        }

    
    }
}