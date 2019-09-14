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

@WebServlet(urlPatterns = {"/viewCart"})
public class viewCart extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            
            out.println("<head>");
            out.println("<title>Willy's Wares</title>");
            
            /*
            out.println("<script>");
            out.println("function validatePurchase() {");
            out.println("var product = document.PurchaseForm.product");
            out.println("var shippingmethod = document.PurchaseForm.shippingmethod");
            out.println("var firstname = document.PurchaseForm.fname");
            out.println("var lastname = document.PurchaseForm.lname");
            out.println("var phonenumber = document.PurchaseForm.phonenumber");
            out.println("var street = document.PurchaseForm.street");
            out.println("var city = document.PurchaseForm.city");
            out.println("var state = document.PurchaseForm.state");
            out.println("var country = document.PurchaseForm.country");
            out.println("var zip = document.PurchaseForm.zip");
            out.println("var cardnumber = document.PurchaseForm.cardnumber");
            out.println("var expdate = document.PurchaseForm.expdate");
            out.println("var csv = document.PurchaseForm.csv");
            out.println("if (firstname.value == \"\") { alert(\"Please enter your first name.\");  return false; }");
            out.println("if (lastname.value == \"\") { alert(\"Please enter your last name.\");  return false; }");
            out.println("if (phonenumber.value == \"\") { alert(\"Please enter a phone number.\");  return false; }");
            out.println("if (isNaN(phonenumber.value)) { alert(\"Please enter a valid phone number.\");  return false; }");
            out.println("if (street.value == \"\") { alert(\"Please enter a street name.\");  return false; }");
            out.println("if (city.value == \"\") { alert(\"Please enter a city name.\");  return false; }");
            out.println("if (state.value == \"\") { alert(\"Please enter a state name.\");  return false; }");
            out.println("if (zip.value == \"\") { alert(\"Please enter a zip/postal code.\");  return false; }");
            out.println("if (isNaN(zip.value)) { alert(\"Please enter a valid zip/postal code.\");  return false; }");
            out.println("if (cardnumber.value == \"\") { alert(\"Please enter a card number.\");  return false; }");
            out.println("if (isNaN(cardnumber.value)) { alert(\"Please enter a valid card number.\");  return false; }");
            out.println("if (expdate.value == \"\") { alert(\"Please enter an expiration date.\");  return false; }");
            out.println("if (csv.value == \"\") { alert(\"Please enter a CSV.\");  return false; }");
            out.println("if (isNaN(csv.value)) { alert(\"Please enter a valid CSV number.\");  return false; }");
            out.println("return true; }");
            out.println("</script>");
            */
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
            out.println("<form action=\"mainPage\"><input type=\"submit\" value=\"Back to Main Page\" style=\"float: left;\" /></form><br>");
            out.println("<center>");
            out.println("<h1 style=\"font-size:225%\">Shopping Cart</h1>");
            out.println("</center>");
            
            HttpSession session = request.getSession();
            HashMap<String, Integer> shoppingCart = (HashMap<String, Integer>)session.getAttribute("shoppingCart");
            float grandTotalPrice = 0;
            for (String key : shoppingCart.keySet()) {
                try {
                    Connection conn = DriverManager.getConnection ("jdbc:mysql://localhost/willyswares", "root", "willyswares");
                    Statement statement = conn.createStatement();
                    ResultSet currentProduct = statement.executeQuery("SELECT productname, price FROM Products WHERE productid='" + key + "'");
                    while (currentProduct.next()) {
                        String productname = currentProduct.getString("productname");
                        float price = currentProduct.getInt("price");
                        float totalPrice = (shoppingCart.get(key) * price);
                        grandTotalPrice += totalPrice;
                        out.println(shoppingCart.get(key) + "x " + productname + "..... $" + totalPrice + "<br>");
                    }
                    conn.close();
                    statement.close();
                }
                catch (Exception e) {
                    out.println(e);
                }
            }
            out.println("<br>Total price: $" + grandTotalPrice);
            session.setAttribute("totalPrice", new Float(grandTotalPrice));
            
            
            out.println("<br><br><br><br>");
            
            try {
                Connection conn = DriverManager.getConnection ("jdbc:mysql://localhost/willyswares", "root", "willyswares");
                Statement statement = conn.createStatement();
                ResultSet shippingInfo = statement.executeQuery("SELECT 6daysgroundprice, 2daysexpeditedprice, overnightprice FROM ShippingInformation WHERE id='0'");
                while (shippingInfo.next()) {
                    Float sixdaysprice = shippingInfo.getFloat("6daysgroundprice");
                    Float twodaysprice = shippingInfo.getFloat("2daysexpeditedprice");
                    Float onedayprice = shippingInfo.getFloat("overnightprice");

                    out.println("<form action=\"confirmation\" name=\"PurchaseForm\" method=\"post\">");
                    out.println("<table><tr><td>");
                    out.println("Shipping Method:<br>");
                    out.println("<select name=\"shippingmethod\">");
                    out.println("<option value=" + sixdaysprice + " selected=\"selected\">6-days ground ($" + sixdaysprice + ")</option>");
                    out.println("<option value=" + twodaysprice + ">2-days expedited ($" + twodaysprice + ")</option>");
                    out.println("<option value=" + onedayprice + ">Overnight ($" + onedayprice + ")</option></td>");
                    out.println("</tr><tr>");
                    out.println("<td>First name:<br><input type=\"text\" name=\"firstname\" required></td>");
                    out.println("<td>Last name:<br><input type=\"text\" name=\"lastname\" required></td>");
                    out.println("<td>Phone number: <i>ex) 1234567890</i><br><input type=\"text\" name=\"phonenumber\" required>");
                    out.println("</tr><tr>");
                    out.println("<td>Street:<br><input type=\"text\" name=\"street\" required></td>");
                    out.println("<td>City:<br><input type=\"text\" name=\"city\" id=\"city\" required></td>");
                    out.println("<td>State:<br><input type=\"text\" name=\"state\" id=\"state\" required></td>");
                    out.println("<td>Country:<br><input type=\"text\" name=\"country\" value=\"United States of America\" readonly required></td>");
                    out.println("<td>Zip code:<br><input type=\"text\" name=\"zip\" required></td>");
                    out.println("</tr><tr>");
                    out.println("<td>Card number:<br><input type=\"text\" name=\"cardnumber\" required></td>");
                    out.println("<td>Exp. date: <i>ex) MM-YY</i><br><input type=\"text\" name=\"expdate\" required></td>");
                    out.println("<td>CSV:<br><input type=\"text\" name=\"csv\" required></td>");
                    out.println("</tr></table>");
                    out.println("<br>");
                    out.println("<input type=\"submit\" name=\"submit\" value=\"Submit\" onClick=\"return confirm('Are you sure you want to make this purchase?')\"/a>");
                    out.println("</form>");
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

















































































































