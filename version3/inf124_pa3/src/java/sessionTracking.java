import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/sessionTracking"})
public class sessionTracking extends HttpServlet {
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection ("jdbc:mysql://localhost/willyswares", "root", "willyswares");
            Statement statement = conn.createStatement();
            String currentProduct = (String) session.getAttribute("item1");
            ResultSet product = statement.executeQuery("SELECT productid, productname, imagelink1 FROM Products WHERE productid='" + currentProduct + "'");
            while (product.next()) {
                String productid = product.getString("productid");
                String productname = product.getString("productname");
                String imagelink = product.getString("imagelink1");
                out.println("<td>");
                out.println("<a href=\"product?id=" + productid + "\">");
                out.println("<center><h2>" + productname + "</h2></center>");
                out.println("<img src=" + imagelink + " width=\"200\" height=\"110\">");
                out.println("</td>");
            }
            conn.close();
            statement.close();
        }
        catch (Exception e) {
            out.println(e);
        }
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection ("jdbc:mysql://localhost/willyswares", "root", "willyswares");
            Statement statement = conn.createStatement();
            String currentProduct = (String) session.getAttribute("item2");
            ResultSet product = statement.executeQuery("SELECT productid, productname, imagelink1 FROM Products WHERE productid='" + currentProduct + "'");
            while (product.next()) {
                String productid = product.getString("productid");
                String productname = product.getString("productname");
                String imagelink = product.getString("imagelink1");
                out.println("<td>");
                out.println("<a href=\"product?id=" + productid + "\">");
                out.println("<center><h2>" + productname + "</h2></center>");
                out.println("<img src=" + imagelink + " width=\"200\" height=\"110\">");
                out.println("</td>");
            }
            conn.close();
            statement.close();
        }
        catch (Exception e) {
            out.println(e);
        }
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection ("jdbc:mysql://localhost/willyswares", "root", "willyswares");
            Statement statement = conn.createStatement();
            String currentProduct = (String) session.getAttribute("item3");
            ResultSet product = statement.executeQuery("SELECT productid, productname, imagelink1 FROM Products WHERE productid='" + currentProduct + "'");
            while (product.next()) {
                String productid = product.getString("productid");
                String productname = product.getString("productname");
                String imagelink = product.getString("imagelink1");
                out.println("<td>");
                out.println("<a href=\"product?id=" + productid + "\">");
                out.println("<center><h2>" + productname + "</h2></center>");
                out.println("<img src=" + imagelink + " width=\"200\" height=\"110\">");
                out.println("</td>");
            }
            conn.close();
            statement.close();
        }
        catch (Exception e) {
            out.println(e);
        }
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection ("jdbc:mysql://localhost/willyswares", "root", "willyswares");
            Statement statement = conn.createStatement();
            String currentProduct = (String) session.getAttribute("item4");
            ResultSet product = statement.executeQuery("SELECT productid, productname, imagelink1 FROM Products WHERE productid='" + currentProduct + "'");
            while (product.next()) {
                String productid = product.getString("productid");
                String productname = product.getString("productname");
                String imagelink = product.getString("imagelink1");
                out.println("<td>");
                out.println("<a href=\"product?id=" + productid + "\">");
                out.println("<center><h2>" + productname + "</h2></center>");
                out.println("<img src=" + imagelink + " width=\"200\" height=\"110\">");
                out.println("</td>");
            }
            conn.close();
            statement.close();
        }
        catch (Exception e) {
            out.println(e);
        }
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection ("jdbc:mysql://localhost/willyswares", "root", "willyswares");
            Statement statement = conn.createStatement();
            String currentProduct = (String) session.getAttribute("item5");
            ResultSet product = statement.executeQuery("SELECT productid, productname, imagelink1 FROM Products WHERE productid='" + currentProduct + "'");
            while (product.next()) {
                String productid = product.getString("productid");
                String productname = product.getString("productname");
                String imagelink = product.getString("imagelink1");
                out.println("<td>");
                out.println("<a href=\"product?id=" + productid + "\">");
                out.println("<center><h2>" + productname + "</h2></center>");
                out.println("<img src=" + imagelink + " width=\"200\" height=\"110\">");
                out.println("</td>");
            }
            conn.close();
            statement.close();
        }
        catch (Exception e) {
            out.println(e);
        }
    }
}









