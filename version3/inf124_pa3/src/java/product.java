import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/product"})
public class product extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            
            out.println("<head>");
            out.println("<title>Willy's Wares</title>");
            out.println("</head>");
            
            out.println("<body>");
            out.println("<div style=\"background-color:red\">");
            out.println("<center>");
            out.println("<h1 style=\"font-size:350%; color:lightgreen\">Willy's Wares</h1>");
            out.println("<p1 style=\"font-size:160%; color:yellow\">For all your console gaming needs!</p1>");
            out.println("</center>");
            out.println("</div>");
            
            out.println("<hr>");
            
            String id = request.getParameter("id");
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection ("jdbc:mysql://localhost/willyswares", "root", "willyswares");
                Statement statement = conn.createStatement();
                ResultSet currentProduct = statement.executeQuery("SELECT productid, productname, manufacturer, price, descriptor1, descriptor2, descriptor3, descriptor4, imagelink1, imagelink2, imagelink3, imagelink4 FROM Products WHERE productid='" + id + "'");
                while (currentProduct.next()) {
                    String productid = currentProduct.getString("productid");
                    String productname = currentProduct.getString("productname");
                    String manufacturer = currentProduct.getString("manufacturer");
                    String descriptor1 = currentProduct.getString("descriptor1");
                    String descriptor2 = currentProduct.getString("descriptor2");
                    String descriptor3 = currentProduct.getString("descriptor3");
                    String descriptor4 = currentProduct.getString("descriptor4");
                    String imagelink1 = currentProduct.getString("imagelink1");
                    String imagelink2 = currentProduct.getString("imagelink2");
                    String imagelink3 = currentProduct.getString("imagelink3");
                    String imagelink4 = currentProduct.getString("imagelink4");
                    float price = currentProduct.getFloat("price");
                    
                    try {
                        String item1 = (String) session.getAttribute("item1");
                        String item2 = (String) session.getAttribute("item2");
                        String item3 = (String) session.getAttribute("item3");
                        String item4 = (String) session.getAttribute("item4");
                        String item5 = (String) session.getAttribute("item5");
                        if (item1.equals(productid) || item2.equals(productid) || item3.equals(productid) || item4.equals(productid) || item5.equals(productid)) {
                            // do nothing
                        }
                        else {
                            Integer integerCounter = (Integer) session.getAttribute("counter");
                            int counter = integerCounter.intValue();
                            String itemnum = "item" + counter;
                            session.setAttribute(itemnum, productid);
                            if (counter == 5) {
                                session.setAttribute("counter", new Integer(1));
                            }
                            else {
                                counter++;
                                session.setAttribute("counter", new Integer(counter));
                            }
                        }
                    }
                    catch (Exception e) {
                        // do nothing
                    }

                    out.println("<div style=\"background-color:lightblue\">");
                    out.println("<form action=\"mainPage\"><input type=\"submit\" value=\"Back to Main Page\" style=\"float: left;\" /></form>");
                    out.println("<form action=\"viewCart\"><input type=\"submit\" value=\"View Shopping Cart\" style=\"float: right;\" /></form><br>");
                    out.println("<center><h1 style=\"font-size:225%\">" + productname + "</h1></center>");

                    out.println("<center>");
                    out.println("<table cellpadding=\"15\">");
                    out.println("<tr>");
                    out.println("<div>");
                    out.println("<td><img onmouseover=\"this.width='600'; this.height='440'\" onmouseout=\"this.width='300'; this.height='220'\" src=" + imagelink1 + " width=\"300\" height=\"220\"></td>");
                    out.println("<td><img onmouseover=\"this.width='600'; this.height='440'\" onmouseout=\"this.width='300'; this.height='220'\" src=" + imagelink2 + " width=\"300\" height=\"220\"></td>");
                    out.println("<td><img onmouseover=\"this.width='600'; this.height='440'\" onmouseout=\"this.width='300'; this.height='220'\" src=" + imagelink3 + " width=\"300\" height=\"220\"></td>");
                    out.println("<td><img onmouseover=\"this.width='600'; this.height='440'\" onmouseout=\"this.width='300'; this.height='220'\" src=" + imagelink4 + " width=\"300\" height=\"220\"></td>");
                    out.println("</div>");
                    out.println("</tr>");
                    out.println("</table>");
                    out.println("</center>");

                    out.println("<h1>About the Product</h1>");
                    out.println("<p1>");
                    out.println("$" + price);
                    out.println("<br>");
                    out.println("Manufactured by " + manufacturer);
                    out.println("<br><br>");
                    out.println("- " + descriptor1);
                    out.println("<br>");
                    out.println("- " + descriptor2);
                    out.println("<br>");
                    out.println("- " + descriptor3);
                    out.println("<br>");
                    out.println("- " + descriptor4);
                    out.println("</p1>");
                    
                    out.println("<br><br><br>");
                    
                    out.println("<form action=\"addToCart\" method=\"Post\">");
                    out.println("Item ID<br><input type=\"text\" name=\"itemToAdd\" id=\"itemToAdd\" value=\"" + productid + "\" readonly><br><br>");
                    out.println("<input type=\"submit\" value=\"Add to Cart\"> </form>");
                }
                conn.close();
                statement.close();
            }
            catch (Exception e) {
                out.println(e);
            }
            
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































































