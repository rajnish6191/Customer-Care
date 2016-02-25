
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class level2profile extends HttpServlet
{

    public level2profile()
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
        String s1 = "";
        String s2 = "";
        String s3 = "";
        String s4 = "";
        String s6 = "";
        String s7 = "";
        String s8 = "";
        String s9 = "";
        String s10 = "";
        String s11 = "";
        String s12 = "";
        String s13 = "";
        String s14 = "";
        String s16 = "";
        int i = 0;
        int j = 0;
        String s18 = "Level2";
        PrintWriter printwriter = httpservletresponse.getWriter();
        httpservletresponse.setContentType("text/html");
        HttpSession httpsession = httpservletrequest.getSession(true);
        String s17 = (String)httpsession.getValue("uid");
        String name =(String)httpsession.getValue("name");
        System.out.println("inside servicemethod");
        try
        {
            System.out.println("inside servicetry");
            rs = st.executeQuery("select * from hdemp1 where levelname='" + s18 + "'  and employeename='"+name+"'");
            if(rs.next())
            {
                System.out.println("inside if");
                s = rs.getString(1);
                System.out.println("lnameis " + s);
                s1 = rs.getString(2);
                System.out.println("category id is " + s1);
                s2 = rs.getString(3);
                System.out.println("module id is " + s2);
                s3 = rs.getString(4);
                System.out.println("supportid is " + s3);
                String s5 = rs.getString(5);
                System.out.println("userid is " + s5);
                s6 = rs.getString(6);
                System.out.println("ename is:" + s6);
                s7 = rs.getString(7);
                System.out.println("address:" + s7);
                s8 = rs.getString(8);
                System.out.println("city is:" + s8);
                s9 = rs.getString(9);
                System.out.println("state is:" + s9);
                s10 = rs.getString(10);
                System.out.println("country is:" + s10);
                i = rs.getInt(11);
                System.out.println("zip is:" + i);
                j = rs.getInt(12);
                System.out.println("phone is:" + j);
                s11 = rs.getString(13);
                System.out.println("website is:" + s11);
                String s15 = rs.getString(14);
            }
            printwriter.println("<HTML>");
            printwriter.println("<HEAD>");
            printwriter.println("<TITLE></TITLE>");
            printwriter.println("</HEAD>");
            printwriter.println("<BODY>");
            printwriter.println("<form name=f action='./secondleveladminstrator.html'target='_parent'>");
            printwriter.println("<P align=center><FONT color=forestgreen ");
            printwriter.println("size=6><STRONG>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
            printwriter.println("&nbsp;&nbsp; ");
            printwriter.println("<U><strong>Profile</strong></U></STRONG></FONT></P>");
            printwriter.println("<TABLE border=0 align=center cellPadding=1 cellSpacing=1 width=75%>");
            printwriter.println("<TR>");
            printwriter.println("<TD><strong>Level Name</strong></TD>");
            printwriter.println("<TD>" + s + "</TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("<TD><strong>Category Id</strong></TD>");
            printwriter.println("<TD>" + s1 + "</TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("<TD><strong>Module ID</strong></TD>");
            printwriter.println("<TD>" + s2 + "</TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("<TD><strong>Support Id</strong></TD>");
            printwriter.println("<TD>" + s3 + "</TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("<TD><strong>Employeename</strong></TD>");
            printwriter.println("<TD>" + s6 + "</TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("<TD><strong>Address</strong></TD>");
            printwriter.println("<TD>" + s7 + "</TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("<TD><strong>City</strong></TD>");
            printwriter.println("<TD>" + s8 + "</TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("<TD><strong>State</strong></TD>");
            printwriter.println(" <TD>" + s9 + "</TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("<TD><strong>Country</strong></TD>");
            printwriter.println(" <TD>" + s10 + "</TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("<TD><strong>Pincode</strong></TD>");
            printwriter.println(" <TD>" + i + "</TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("<TD><strong>Phone No</strong></TD>");
            printwriter.println("<TD>" + j + "</TD></TR>");
            printwriter.println("<TR>");
            printwriter.println(" <TD><strong>Email ID</strong></TD>");
            printwriter.println(" <TD>" + s11 + "</TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("<TD>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
            printwriter.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
            printwriter.println("&nbsp;&nbsp;");
            printwriter.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ");
            printwriter.println("<INPUT id=submit1 name=submit1 type=submit value=Ok></TD>");
            printwriter.println(" <TD></TD></TR></TABLE>");
            printwriter.println("</form>");
            printwriter.println("</BODY>");
            printwriter.println("</HTML>");
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