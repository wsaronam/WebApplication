import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/orderSummary"})
public class orderSummary extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        
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
            out.println("<center>");
            out.println("<h1 style=\"font-size:225%\">Order Summary</h1>");
            out.println("</center>");
            
            Float shipping = Float.parseFloat(request.getParameter("shippingmethod"));
            String firstname = request.getParameter("firstname");
            String lastname = request.getParameter("lastname");
            long phonenumber = Long.parseLong(request.getParameter("phonenumber"));
            String street = request.getParameter("street");
            String city = request.getParameter("city");
            String state = request.getParameter("state");
            String country = request.getParameter("country");
            int zip = Integer.parseInt(request.getParameter("zip"));
            long cardnumber = Long.parseLong(request.getParameter("cardnumber"));
            String expdate = request.getParameter("expdate");
            int csv = Integer.parseInt(request.getParameter("csv"));
            
            out.println("Thank you for shopping with Willy's Wares!  We'll get you your stuff safe and sound; hang tight!<br>");
            out.println("Below is the purchase confirmation for your order.  We hope to see you again!<br>");
            out.println("If you have any questions/issues/problems with your order, feel free to contact us with the information given at the \"Contact Us\" section located at the bottom of our pages!<br><br><br>");
            HttpSession session = request.getSession();
            HashMap<String, Integer> shoppingCart = (HashMap<String, Integer>)session.getAttribute("shoppingCart");
            for (String key : shoppingCart.keySet()) {
                try {
                    out.println(shoppingCart.get(key) + "x  " + key + "<br>");
                }
                catch (Exception e) {
                    out.println(e);
                }
            }
            Float grandTotalPrice = (Float) session.getAttribute("totalPrice");
            grandTotalPrice = grandTotalPrice + shipping;
            out.println("Total price: $" + grandTotalPrice);
            out.println("<br><br>");
            
            out.println("Ship to:<br>");
            out.println(firstname + " " + lastname + "<br>");
            out.println(street + " " + city + ", " + state + "    " + zip + "<br><br>");
            
            if (session != null) {
                session.invalidate();
            }
            
            out.println("<form action=\"mainPage\"><input type=\"submit\" value=\"Back to Main Page\" /></form><br>");
            
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

