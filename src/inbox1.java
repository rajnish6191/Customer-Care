
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class inbox1 extends HttpServlet
{

    public inbox1()
    {
    }

    public void init(ServletConfig servletconfig)
        throws ServletException
    {
        super.init(servletconfig);
        try
        {
            System.out.println("inside init");
             Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("driver is created");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "care", "care");
            System.out.println("Connection is created");
            st = con.createStatement();
            st1 = con.createStatement();
            System.out.println("statement is created");
        }
        catch(Exception exception)
        {
            System.out.println("init method" + exception);
        }
    }

    public void service(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws ServletException, IOException
    {
        System.out.println("inside service");
        PrintWriter printwriter = httpservletresponse.getWriter();
        httpservletresponse.setContentType("text/html");
        try
        {
            System.out.println("inside try");
            rs = st.executeQuery("select * from level1messages");
            printwriter.println("<html>");
            printwriter.println("<head>");
            printwriter.println("<style>");
            printwriter.println("a{ Text-Decoration:none;}");
            printwriter.println("</style>");
            printwriter.println("</head>");
            printwriter.println("<body>");
            printwriter.println("<form > ");
            printwriter.println("<TABLE border=0 cellPadding=1 cellSpacing=1 width=75% align=center>");
            printwriter.println("<P>");
            printwriter.println(" <TR>");
            printwriter.println("  <TD></TD>");
            printwriter.println("  <TD></TD>");
            printwriter.println("<TD>");
            printwriter.println("<P align=left style='COLOR: forestgreen'><FONT size=5><STRONG><U>Messages</U></STRONG></FONT></P></TD></TR>");
            printwriter.println("<P align=center>&nbsp;</P>");
            printwriter.println("<P align=center>");
            printwriter.println("<TABLE border=0 cellPadding=1 cellSpacing=1 style='HEIGHT: 130px; WIDTH: 431px'");
            printwriter.println("width=75%>");
            printwriter.println("<TR>");
            printwriter.println("<TD><STRONG>From</STRONG></TD>");
            printwriter.println("<TD><STRONG>&nbsp;&nbsp;Subject</STRONG></TD>");
            printwriter.println("<TD><STRONG>&nbsp;&nbsp;Date </STRONG></TD>");
            System.out.println("after rs");
            String s2;
            for(; rs.next(); printwriter.println(" <TD>&nbsp;&nbsp;" + s2 + "&nbsp;&nbsp;</TD> "))
            {
                System.out.println("INSIDE RS");
                String s = rs.getString(2);
                System.out.println("from name is " + s);
                String s1 = rs.getString(3);
                System.out.println("subject is : " + s1);
                String s3 = rs.getString(4);
                System.out.println("datesent is " + s3);
                s2 = rs.getString(5);
                System.out.println("datesent is " + s2);
                printwriter.println(" <TR> ");
                printwriter.println(" <TD><a href='./messagefrom1?fnam=" + s + "&des=" + s3 + "'>" + s + "</a>&nbsp;&nbsp;</TD> ");
                printwriter.println(" <TD>&nbsp;&nbsp;" + s1 + "&nbsp;&nbsp;</TD> ");
            }

            printwriter.println("<TR>");
            printwriter.println("<TD></TD>");
            printwriter.println("<TD>&nbsp;</TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("<TD></TD>");
            printwriter.println("<TD></TD>");
            printwriter.println("<TD><STRONG>Click here to &gt;&gt;</STRONG></TD>");
            printwriter.println("<TD>&nbsp;<a href='./message1.html'>Go Back to Messages</a></TD></TR>");
            printwriter.println("</P> ");
            printwriter.println("</form>");
            printwriter.println("</body>");
            printwriter.println("</html>");
        }
        catch(Exception exception)
        {
            System.out.println(exception);
        }
    }

    Connection con;
    Statement st;
    Statement st1;
    ResultSet rs;
    ResultSet rs1;
}