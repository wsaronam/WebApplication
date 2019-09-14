import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;


@WebServlet(urlPatterns = {"/mainPage"})
public class mainPage extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        if (session.isNew()) {
            session.setAttribute("counter", new Integer(1));
            session.setAttribute("item1", "");
            session.setAttribute("item2", "");
            session.setAttribute("item3", "");
            session.setAttribute("item4", "");
            session.setAttribute("item5", "");
            session.setAttribute("shoppingCart", new HashMap<String, Integer>());
        }
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            
            out.println("<head>");
            out.println("<title>Willy's Wares</title>");
            out.println("<style>"); // Style created by Eric Du
            out.println("table { border-collapse: collapse; }  td { width:52.5px; text-align:center; } .lefttd { border-right:hidden; }");
            out.println("</style>");
            out.println("</head>");
            
            out.println("<body>");
            out.println("<div style=\"background-color:red\">");
            out.println("<center>");
            out.println("<h1 style=\"font-size:350%; color:lightgreen\">Willy's Wares</h1>");
            out.println("<p1 style=\"font-size:160%; color:yellow\">For all your console gaming needs!</p1>");
            out.println("</center>");
            out.println("</div>");
            
            out.println("<hr>");
            
            out.println("<div style=\"background-color:lightblue\">");
            out.println("<form action=\"viewCart\"><input type=\"submit\" value=\"View Shopping Cart\" style=\"float: right;\" /></form><br>");
            out.println("<center>");
            out.println("<h1 style=\"font-size:225%\">Available Consoles</h1>");
            out.println("</center>");
            
            out.println("<center>");
            out.println("<table cellpadding=\"15\" style=\"border-collapse:separate; border-spacing:0 50px; margin-top:-50px;\">");
            out.println("<tr>");
            out.println("<td>");
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection ("jdbc:mysql://localhost/willyswares", "root", "willyswares");
                Statement statement = conn.createStatement();
                ResultSet currentProduct = statement.executeQuery("SELECT productname, manufacturer, price, imagelink1 FROM Products WHERE productid='switch'");
                while (currentProduct.next()) {
                    String productname = currentProduct.getString("productname");
                    String manufacturer = currentProduct.getString("manufacturer");
                    String imagelink = currentProduct.getString("imagelink1");
                    float price = currentProduct.getFloat("price");
                    out.println("<a href=\"/inf124_pa3/product?id=switch\">");
                    out.println("<center><h2>" + productname + "</h2></center>");
                    out.println("<img src=" + imagelink + " width=\"300\" height=\"220\"></a>");
                    out.println("<p align=\"left\">" + "$" + price + "</p>");
                    out.println("<p align=\"left\">by " + manufacturer + "</h2></center>");
                }
                conn.close();
                statement.close();
            }
            catch (Exception e) {
                out.println(e);
            }
            out.println("</td>");
            out.println("<td>");
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection ("jdbc:mysql://localhost/willyswares", "root", "willyswares");
                Statement statement = conn.createStatement();
                ResultSet currentProduct = statement.executeQuery("SELECT productname, manufacturer, price, imagelink1 FROM Products WHERE productid='3dsxl'");
                while (currentProduct.next()) {
                    String productname = currentProduct.getString("productname");
                    String manufacturer = currentProduct.getString("manufacturer");
                    String imagelink = currentProduct.getString("imagelink1");
                    float price = currentProduct.getFloat("price");
                    out.println("<a href=\"product?id=3dsxl\">");
                    out.println("<center><h2>" + productname + "</h2></center>");
                    out.println("<img src=" + imagelink + " width=\"300\" height=\"220\"></a>");
                    out.println("<p align=\"left\">" + "$" + price + "</p>");
                    out.println("<p align=\"left\">by " + manufacturer + "</h2></center>");
                }
                conn.close();
                statement.close();
            }
            catch (Exception e) {
                out.println(e);
            }
            out.println("</td>");
            out.println("<td>");
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection ("jdbc:mysql://localhost/willyswares", "root", "willyswares");
                Statement statement = conn.createStatement();
                ResultSet currentProduct = statement.executeQuery("SELECT productname, manufacturer, price, imagelink1 FROM Products WHERE productid='2dsxl'");
                while (currentProduct.next()) {
                    String productname = currentProduct.getString("productname");
                    String manufacturer = currentProduct.getString("manufacturer");
                    String imagelink = currentProduct.getString("imagelink1");
                    float price = currentProduct.getFloat("price");
                    out.println("<a href=\"product?id=2dsxl\">");
                    out.println("<center><h2>" + productname + "</h2></center>");
                    out.println("<img src=" + imagelink + " width=\"300\" height=\"220\"></a>");
                    out.println("<p align=\"left\">" + "$" + price + "</p>");
                    out.println("<p align=\"left\">by " + manufacturer + "</h2></center>");
                }
                conn.close();
                statement.close();
            }
            catch (Exception e) {
                out.println(e);
            }
            out.println("</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>");
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection ("jdbc:mysql://localhost/willyswares", "root", "willyswares");
                Statement statement = conn.createStatement();
                ResultSet currentProduct = statement.executeQuery("SELECT productname, manufacturer, price, imagelink1 FROM Products WHERE productid='ps4pro'");
                while (currentProduct.next()) {
                    String productname = currentProduct.getString("productname");
                    String manufacturer = currentProduct.getString("manufacturer");
                    String imagelink = currentProduct.getString("imagelink1");
                    float price = currentProduct.getFloat("price");
                    out.println("<a href=\"product?id=ps4pro\">");
                    out.println("<center><h2>" + productname + "</h2></center>");
                    out.println("<img src=" + imagelink + " width=\"300\" height=\"220\"></a>");
                    out.println("<p align=\"left\">" + "$" + price + "</p>");
                    out.println("<p align=\"left\">by " + manufacturer + "</h2></center>");
                }
                conn.close();
                statement.close();
            }
            catch (Exception e) {
                out.println(e);
            }
            out.println("</td>");
            out.println("<td>");
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection ("jdbc:mysql://localhost/willyswares", "root", "willyswares");
                Statement statement = conn.createStatement();
                ResultSet currentProduct = statement.executeQuery("SELECT productname, manufacturer, price, imagelink1 FROM Products WHERE productid='ps4'");
                while (currentProduct.next()) {
                    String productname = currentProduct.getString("productname");
                    String manufacturer = currentProduct.getString("manufacturer");
                    String imagelink = currentProduct.getString("imagelink1");
                    float price = currentProduct.getFloat("price");
                    out.println("<a href=\"product?id=ps4\">");
                    out.println("<center><h2>" + productname + "</h2></center>");
                    out.println("<img src=" + imagelink + " width=\"300\" height=\"220\"></a>");
                    out.println("<p align=\"left\">" + "$" + price + "</p>");
                    out.println("<p align=\"left\">by " + manufacturer + "</h2></center>");
                }
                conn.close();
                statement.close();
            }
            catch (Exception e) {
                out.println(e);
            }
            out.println("</td>");
            out.println("<td>");
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection ("jdbc:mysql://localhost/willyswares", "root", "willyswares");
                Statement statement = conn.createStatement();
                ResultSet currentProduct = statement.executeQuery("SELECT productname, manufacturer, price, imagelink1 FROM Products WHERE productid='psp'");
                while (currentProduct.next()) {
                    String productname = currentProduct.getString("productname");
                    String manufacturer = currentProduct.getString("manufacturer");
                    String imagelink = currentProduct.getString("imagelink1");
                    float price = currentProduct.getFloat("price");
                    out.println("<a href=\"product?id=psp\">");
                    out.println("<center><h2>" + productname + "</h2></center>");
                    out.println("<img src=" + imagelink + " width=\"300\" height=\"220\"></a>");
                    out.println("<p align=\"left\">" + "$" + price + "</p>");
                    out.println("<p align=\"left\">by " + manufacturer + "</h2></center>");
                }
                conn.close();
                statement.close();
            }
            catch (Exception e) {
                out.println(e);
            }
            out.println("</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>");
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection ("jdbc:mysql://localhost/willyswares", "root", "willyswares");
                Statement statement = conn.createStatement();
                ResultSet currentProduct = statement.executeQuery("SELECT productname, manufacturer, price, imagelink1 FROM Products WHERE productid='onex'");
                while (currentProduct.next()) {
                    String productname = currentProduct.getString("productname");
                    String manufacturer = currentProduct.getString("manufacturer");
                    String imagelink = currentProduct.getString("imagelink1");
                    float price = currentProduct.getFloat("price");
                    out.println("<a href=\"product?id=onex\">");
                    out.println("<center><h2>" + productname + "</h2></center>");
                    out.println("<img src=" + imagelink + " width=\"300\" height=\"220\"></a>");
                    out.println("<p align=\"left\">" + "$" + price + "</p>");
                    out.println("<p align=\"left\">by " + manufacturer + "</h2></center>");
                }
                conn.close();
                statement.close();
            }
            catch (Exception e) {
                out.println(e);
            }
            out.println("</td>");
            out.println("<td>");
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection ("jdbc:mysql://localhost/willyswares", "root", "willyswares");
                Statement statement = conn.createStatement();
                ResultSet currentProduct = statement.executeQuery("SELECT productname, manufacturer, price, imagelink1 FROM Products WHERE productid='ones'");
                while (currentProduct.next()) {
                    String productname = currentProduct.getString("productname");
                    String manufacturer = currentProduct.getString("manufacturer");
                    String imagelink = currentProduct.getString("imagelink1");
                    float price = currentProduct.getFloat("price");
                    out.println("<a href=\"product?id=ones\">");
                    out.println("<center><h2>" + productname + "</h2></center>");
                    out.println("<img src=" + imagelink + " width=\"300\" height=\"220\"></a>");
                    out.println("<p align=\"left\">" + "$" + price + "</p>");
                    out.println("<p align=\"left\">by " + manufacturer + "</h2></center>");
                }
                conn.close();
                statement.close();
            }
            catch (Exception e) {
                out.println(e);
            }
            out.println("</td>");
            out.println("<td>");
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection ("jdbc:mysql://localhost/willyswares", "root", "willyswares");
                Statement statement = conn.createStatement();
                ResultSet currentProduct = statement.executeQuery("SELECT productname, manufacturer, price, imagelink1 FROM Products WHERE productid='one'");
                while (currentProduct.next()) {
                    String productname = currentProduct.getString("productname");
                    String manufacturer = currentProduct.getString("manufacturer");
                    String imagelink = currentProduct.getString("imagelink1");
                    float price = currentProduct.getFloat("price");
                    out.println("<a href=\"product?id=one\">");
                    out.println("<center><h2>" + productname + "</h2></center>");
                    out.println("<img src=" + imagelink + " width=\"300\" height=\"220\"></a>");
                    out.println("<p align=\"left\">" + "$" + price + "</p>");
                    out.println("<p align=\"left\">by " + manufacturer + "</h2></center>");
                }
                conn.close();
                statement.close();
            }
            catch (Exception e) {
                out.println(e);
            }
            out.println("</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>");
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection ("jdbc:mysql://localhost/willyswares", "root", "willyswares");
                Statement statement = conn.createStatement();
                ResultSet currentProduct = statement.executeQuery("SELECT productname, manufacturer, price, imagelink1 FROM Products WHERE productid='rift'");
                while (currentProduct.next()) {
                    String productname = currentProduct.getString("productname");
                    String manufacturer = currentProduct.getString("manufacturer");
                    String imagelink = currentProduct.getString("imagelink1");
                    float price = currentProduct.getFloat("price");
                    out.println("<a href=\"product?id=rift\">");
                    out.println("<center><h2>" + productname + "</h2></center>");
                    out.println("<img src=" + imagelink + " width=\"300\" height=\"220\"></a>");
                    out.println("<p align=\"left\">" + "$" + price + "</p>");
                    out.println("<p align=\"left\">by " + manufacturer + "</h2></center>");
                }
                conn.close();
                statement.close();
            }
            catch (Exception e) {
                out.println(e);
            }
            out.println("</td>");
            out.println("<td>");
            out.println("</td>");
            out.println("<td>");
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection ("jdbc:mysql://localhost/willyswares", "root", "willyswares");
                Statement statement = conn.createStatement();
                ResultSet currentProduct = statement.executeQuery("SELECT productname, manufacturer, price, imagelink1 FROM Products WHERE productid='vive'");
                while (currentProduct.next()) {
                    String productname = currentProduct.getString("productname");
                    String manufacturer = currentProduct.getString("manufacturer");
                    String imagelink = currentProduct.getString("imagelink1");
                    float price = currentProduct.getFloat("price");
                    out.println("<a href=\"product?id=vive\">");
                    out.println("<center><h2>" + productname + "</h2></center>");
                    out.println("<img src=" + imagelink + " width=\"300\" height=\"220\"></a>");
                    out.println("<p align=\"left\">" + "$" + price + "</p>");
                    out.println("<p align=\"left\">by " + manufacturer + "</h2></center>");
                }
                conn.close();
                statement.close();
            }
            catch (Exception e) {
                out.println(e);
            }
            out.println("</td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("</center>");
            
            out.println("<hr>");
            
            out.println("<center><h1>Previously Viewed Items</h1></center>");
            out.println("<center>");
            out.println("<table cellpadding=\"15\">");
            out.println("<tr>");
            out.println("<div>");
            
            try {
                RequestDispatcher rd = request.getRequestDispatcher("sessionTracking");
                rd.include(request, response);
            }
            catch (Exception e) {
                out.println(e);
            }
            
            out.println("</div>");
            out.println("</tr>");
            out.println("</table>");
            out.println("</center>");
            
            out.println("<hr>");
            
            out.println("<h1>About Us</h1>");
            out.println("<p1>Here, at Willy's Wares, we're dedicated to bringing you pristine condition gaming consoles in a quick and efficient manner.  Every employee is dedicated in handling your gaming consoles with finesse and care to make sure you get the excellent service that you deserve.  We're a new company based in Irvine, CA that specializes in dealing with gaming consoles and each of our employees are gamers themselves that understand the importance of delicacy in handling gaming consoles.  We hope you have a pleasant experience buying from us!</p1>");
            out.println("<h1>The Team</h1>");
            out.println("<p1>Owner: Willy Saronamihardja</p1>");
            out.println("<br>");
            out.println("<p1>Managers: John Smith, Susan Sue, Lilly Ko</p1>");
            out.println("<br>");
            out.println("<p1>Staff: Ryan Bo, Jessie Zayn, Laurence Tran, Abigail Turner, Jason Bourne, Bobby Soprano, Roger Murdock, Larry Parker</p1>");
            out.println("<h1>Contact Us</h1>");
            out.println("<p1>Phone number: (123)456-7890</p1>");
            out.println("<br>");
            out.println("<p1>Email: customer-service@willyswares.com</p1>");
            out.println("<br>");
            out.println("<p1>Address: 123 Gaming St. Irvine, CA  92612</p1>");
            
            out.println("<br><br><br>");
            out.println("<h1>Site Developer</h1>");
            out.println("<p1>Willy Saronamihardja</p1>");
            
            out.println("</div>");
            
            out.println("</body>");
            
            out.println("</html>");
        }
    }

}





















