
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class forwardTo extends HttpServlet
{

    public forwardTo()
    {
        fid = "F001";
        ffrom = "f001";
        fto = "";
        status = "";
        level = "";
    }

    public void init(ServletConfig servletconfig)
        throws ServletException
    {
        super.init(servletconfig);
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:odbc:ecare", "harish", "clsr");
            System.out.println("inside forward to Connection is created");
            st = con.createStatement();
            System.out.println("statement is created");
        }
        catch(Exception exception)
        {
            System.out.println(exception.getMessage());
        }
    }

    public void service(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws ServletException, IOException, NumberFormatException
    {
        PrintWriter printwriter = httpservletresponse.getWriter();
        httpservletresponse.setContentType("text/html");
        String s = httpservletrequest.getParameter("fticketno");
        int i = Integer.parseInt(s);
        level = httpservletrequest.getParameter("levelsel");
        fto = httpservletrequest.getParameter("user");
        System.out.println("level = " + level + " user = :  " + fto);
        try
        {
            int j = st.executeUpdate("insert into forward values('" + i + "','" + ffrom + "','" + fto + "','" + status + "')");
            printwriter.println("<html>");
            printwriter.println("<body>Succesfully eI Val is " + j);
            printwriter.println("PROBLEM WITH TICKET ID " + i + "IS FORWARDED TO" + fto);
            printwriter.println("</body></html>");
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }

    Connection con;
    Statement st;
    Statement st1;
    ResultSet rs;
    ResultSet rs1;
    String fid;
    String ffrom;
    String fto;
    String status;
    String level;
}