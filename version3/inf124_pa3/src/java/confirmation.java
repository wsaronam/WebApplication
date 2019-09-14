import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(urlPatterns = {"/confirmation"})
public class confirmation extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
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
        
        if (firstname.equals("")) {
            out.print("Please enter a first name.");
            RequestDispatcher rd = request.getRequestDispatcher("viewCart");
            rd.forward(request, response);
        }
        if (lastname.equals("")) {
            out.print("Please enter a last name.");
            RequestDispatcher rd = request.getRequestDispatcher("viewCart");
            rd.forward(request, response);
        }
        if ((Long.toString(phonenumber)).equals("")) {
            out.print("Please enter a phone number.");
            RequestDispatcher rd = request.getRequestDispatcher("viewCart");
            rd.forward(request, response);
        } 
        if (street.equals("")) {
            out.print("Please enter a street.");
            RequestDispatcher rd = request.getRequestDispatcher("viewCart");
            rd.forward(request, response);
        }
        if (city.equals("")) {
            out.print("Please enter a city.");
            RequestDispatcher rd = request.getRequestDispatcher("viewCart");
            rd.forward(request, response);
        }
        if (state.equals("")) {
            out.print("Please enter a state.");
            RequestDispatcher rd = request.getRequestDispatcher("viewCart");
            rd.forward(request, response);
        }
        if ((Integer.toString(zip)).equals("")) {
            out.print("Please enter a zip.");
            RequestDispatcher rd = request.getRequestDispatcher("viewCart");
            rd.forward(request, response);
        }
        if ((Long.toString(cardnumber)).equals("")) {
            out.print("Please enter a card number.");
            RequestDispatcher rd = request.getRequestDispatcher("viewCart");
            rd.forward(request, response);
        }
        if (expdate.equals("")) {
            out.print("Please enter an expiration date.");
            RequestDispatcher rd = request.getRequestDispatcher("viewCart");
            rd.forward(request, response);
        }
        if ((Integer.toString(csv)).equals("")) {
            out.print("Please enter a csv.");
            RequestDispatcher rd = request.getRequestDispatcher("viewCart");
            rd.forward(request, response);
        }
        else {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection ("jdbc:mysql://localhost/willyswares", "root", "willyswares");
                Statement statement = conn.createStatement();
                String sql = "INSERT INTO Purchases (productid, amountpurchased, shippingmethod, firstname, lastname, phonenumber, street, city, state, country, zip, cardnumber, expdate, csv) VALUES ";
                
                HttpSession session = request.getSession();
                HashMap<String, Integer> shoppingCart = (HashMap<String, Integer>)session.getAttribute("shoppingCart");
                for (String key : shoppingCart.keySet()) {
                    try {
                        String newsql = sql + "('" + key + "', " + shoppingCart.get(key) + ", " + shipping + ", '" + firstname + "', '" + lastname + "', " + phonenumber + ", '" + street + "', '" + city + "', '" + state + "', '" + country + "', " + zip + ", " + cardnumber + ", '" + expdate + "', " + csv + ")";
                        statement.executeUpdate(newsql);
                    }
                    catch (Exception e) {
                        out.println(e);
                    }
                }
                
                conn.close();
                statement.close();
            }
            catch (Exception e) {
                out.println(e);
            }
            RequestDispatcher rd = request.getRequestDispatcher("orderSummary");
            rd.forward(request, response);
        }
    }
}














































