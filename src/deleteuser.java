
import java.io.IOException;
import java.io.PrintStream;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class deleteuser extends HttpServlet
{

    public deleteuser()
    {
    }

    public void init(ServletConfig servletconfig)
        throws ServletException
    {
        super.init(servletconfig);
        try
        {
            System.out.println("inside try");
             Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("driver is created");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "care", "care");
            System.out.println("Connection is created");
            st = con.createStatement();
            System.out.println("statement is created");
        }
        catch(Exception exception)
        {
            System.out.println(exception);
        }
    }

    public void service(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws ServletException, IOException
    {
        String s = "";
        java.io.PrintWriter printwriter = httpservletresponse.getWriter();
        httpservletresponse.setContentType("text/html");
        System.out.println("before try");
        try
        {
            String s1 = httpservletrequest.getParameter("u");
            System.out.println("ucode is " + s1);
		int k= st.executeUpdate("delete from userinfo where user_id='"+s1+"'");
		System.out.println("deleted from userinfo"+k);
            int i = st.executeUpdate("delete from registration where user_id='" + s1 + "' ");
            System.out.println("deleted from registration:" + i);
            httpservletresponse.sendRedirect("./createuser");
        }
        catch(Exception exception)
        {
            System.out.println(exception);
        }
    }

    Connection con;
    Statement st;
    ResultSet rs;
}