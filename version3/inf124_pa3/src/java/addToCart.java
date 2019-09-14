import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class addToCart extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        String itemToAdd = request.getParameter("itemToAdd");
        
        HttpSession session = request.getSession();
        HashMap<String, Integer> shoppingCart = (HashMap<String, Integer>) session.getAttribute("shoppingCart");
        
        if (shoppingCart.containsKey(itemToAdd)) {
            shoppingCart.put(itemToAdd, shoppingCart.get(itemToAdd) + 1);
        }
        else {
            shoppingCart.put(itemToAdd, 1);
        }
        
        session.setAttribute("shoppingCart", shoppingCart); 
        
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
            
            out.println("<div style=\"background-color:lightblue\">");
            out.println("<form action=\"mainPage\"><input type=\"submit\" value=\"Back to Main Page\" style=\"float: left;\" /></form>");
            out.println("<form action=\"viewCart\"><input type=\"submit\" value=\"View Shopping Cart\" style=\"float: right;\" /></form><br>");
            out.println("<center><h1 style=\"font-size:225%\">Added to Cart!</h1></center>");
            
            try {
                Connection conn = DriverManager.getConnection ("jdbc:mysql://localhost/willyswares", "root", "willyswares");
                Statement statement = conn.createStatement();
                ResultSet currentProduct = statement.executeQuery("SELECT productname, imagelink1 FROM Products WHERE productid='" + itemToAdd + "'");
                while (currentProduct.next()) {
                    String productname = currentProduct.getString("productname");
                    String imagelink = currentProduct.getString("imagelink1");
                    out.println("<center><img src=" + imagelink + " width=\"300\" height=\"220\"></center><br>");
                    out.println("<center>Added " + productname + " to your Shopping Cart!</center><br><br>");
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





















