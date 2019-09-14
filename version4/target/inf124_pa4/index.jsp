<html>
    <head>
	<title>Willy's Wares</title>

        <!--Style written by Eric Du-->
        <style>
        table {
                border-collapse: collapse;
        }
        td {
        width:52.5px;
        text-align:center;

        }
        .lefttd {
        border-right:hidden;
        }
        </style>
    </head>
	
    <body>
	
        <div style="background-color:red">
            <center>
                <h1 style="font-size:350%; color:lightgreen">Willy's Wares</h1>
                <p1 style="font-size:160%; color:yellow">For all your console gaming needs!</p1>
            </center>
        </div>
		
        <hr>
		
        <div style="background-color:lightblue">

            <center>
                <h1 style="font-size:225%">Available Consoles</h1>
            </center>

            <center>
                <table cellpadding="15" style="border-collapse:separate; border-spacing:0 50px; margin-top:-50px;">
                    <tr>
                        <td>
                        <%@ page import = "java.sql.*" %>
                        <%
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/willyswares",
                                "root", "willyswares");
                            Statement statement = conn.createStatement();
                            String sql = "SELECT productname, imagelink1, price, manufacturer FROM Products WHERE productid='switch'";
                            ResultSet result = statement.executeQuery(sql);
                            
                            while (result.next()) {
                        %>
                        <a href="index.jsp">
                        <center><h2><%= result.getString("productname") %></h2></center>
                        <img src=<%= result.getString("imagelink1") %> width="300" height="220">
                        </a>
                        <p align="left">$<%= result.getFloat("price") %></p>
                        <p align="left">by <%= result.getString("manufacturer") %></h2></center>
                        <%
                            }
                        %>
                        </td>
                        <td>
                        <%
                            sql = "SELECT productname, imagelink1, price, manufacturer FROM Products WHERE productid='3dsxl'";
                            result = statement.executeQuery(sql);
                            
                            while (result.next()) {
                        %>
                        <a href="index.jsp">
                        <center><h2><%= result.getString("productname") %></h2></center>
                        <img src=<%= result.getString("imagelink1") %> width="300" height="220">
                        </a>
                        <p align="left">$<%= result.getFloat("price") %></p>
                        <p align="left">by <%= result.getString("manufacturer") %></h2></center>
                        <%
                            }
                        %>
                        </td>
                        <td>
                        <%
                            sql = "SELECT productname, imagelink1, price, manufacturer FROM Products WHERE productid='2dsxl'";
                            result = statement.executeQuery(sql);
                            
                            while (result.next()) {
                        %>
                        <a href="index.jsp">
                        <center><h2><%= result.getString("productname") %></h2></center>
                        <img src=<%= result.getString("imagelink1") %> width="300" height="220">
                        </a>
                        <p align="left">$<%= result.getFloat("price") %></p>
                        <p align="left">by <%= result.getString("manufacturer") %></h2></center>
                        <%
                            }
                        %>
                        </td>
                    </tr>
                    <tr>
                        <td>
                        <%
                            sql = "SELECT productname, imagelink1, price, manufacturer FROM Products WHERE productid='ps4pro'";
                            result = statement.executeQuery(sql);
                            
                            while (result.next()) {
                        %>
                        <a href="index.jsp">
                        <center><h2><%= result.getString("productname") %></h2></center>
                        <img src=<%= result.getString("imagelink1") %> width="300" height="220">
                        </a>
                        <p align="left">$<%= result.getFloat("price") %></p>
                        <p align="left">by <%= result.getString("manufacturer") %></h2></center>
                        <%
                            }
                        %>
                        </td>
                        <td>
                        <%
                            sql = "SELECT productname, imagelink1, price, manufacturer FROM Products WHERE productid='ps4'";
                            result = statement.executeQuery(sql);
                            
                            while (result.next()) {
                        %>
                        <a href="index.jsp">
                        <center><h2><%= result.getString("productname") %></h2></center>
                        <img src=<%= result.getString("imagelink1") %> width="300" height="220">
                        </a>
                        <p align="left">$<%= result.getFloat("price") %></p>
                        <p align="left">by <%= result.getString("manufacturer") %></h2></center>
                        <%
                            }
                        %>
                        </td>
                        <td>
                        <%
                            sql = "SELECT productname, imagelink1, price, manufacturer FROM Products WHERE productid='psp'";
                            result = statement.executeQuery(sql);
                            
                            while (result.next()) {
                        %>
                        <a href="index.jsp">
                        <center><h2><%= result.getString("productname") %></h2></center>
                        <img src=<%= result.getString("imagelink1") %> width="300" height="220">
                        </a>
                        <p align="left">$<%= result.getFloat("price") %></p>
                        <p align="left">by <%= result.getString("manufacturer") %></h2></center>
                        <%
                            }
                        %>
                        </td>
                    </tr>
                    <tr>
                        <td>
                        <%
                            sql = "SELECT productname, imagelink1, price, manufacturer FROM Products WHERE productid='onex'";
                            result = statement.executeQuery(sql);
                            
                            while (result.next()) {
                        %>
                        <a href="index.jsp">
                        <center><h2><%= result.getString("productname") %></h2></center>
                        <img src=<%= result.getString("imagelink1") %> width="300" height="220">
                        </a>
                        <p align="left">$<%= result.getFloat("price") %></p>
                        <p align="left">by <%= result.getString("manufacturer") %></h2></center>
                        <%
                            }
                        %>
                        </td>
                        <td>
                        <%
                            sql = "SELECT productname, imagelink1, price, manufacturer FROM Products WHERE productid='ones'";
                            result = statement.executeQuery(sql);
                            
                            while (result.next()) {
                        %>
                        <a href="index.jsp">
                        <center><h2><%= result.getString("productname") %></h2></center>
                        <img src=<%= result.getString("imagelink1") %> width="300" height="220">
                        </a>
                        <p align="left">$<%= result.getFloat("price") %></p>
                        <p align="left">by <%= result.getString("manufacturer") %></h2></center>
                        <%
                            }
                        %>
                        </td>
                        <td>
                        <%
                            sql = "SELECT productname, imagelink1, price, manufacturer FROM Products WHERE productid='one'";
                            result = statement.executeQuery(sql);
                            
                            while (result.next()) {
                        %>
                        <a href="index.jsp">
                        <center><h2><%= result.getString("productname") %></h2></center>
                        <img src=<%= result.getString("imagelink1") %> width="300" height="220">
                        </a>
                        <p align="left">$<%= result.getFloat("price") %></p>
                        <p align="left">by <%= result.getString("manufacturer") %></h2></center>
                        <%
                            }
                        %>
                        </td>
                    </tr>
                    <tr>
                        <td>
                        <%
                            sql = "SELECT productname, imagelink1, price, manufacturer FROM Products WHERE productid='rift'";
                            result = statement.executeQuery(sql);
                            
                            while (result.next()) {
                        %>
                        <a href="index.jsp">
                        <center><h2><%= result.getString("productname") %></h2></center>
                        <img src=<%= result.getString("imagelink1") %> width="300" height="220">
                        </a>
                        <p align="left">$<%= result.getFloat("price") %></p>
                        <p align="left">by <%= result.getString("manufacturer") %></h2></center>
                        <%
                            }
                        %>
                        </td>
                        <td>
                        </td>
                        <td>
                        <%
                            sql = "SELECT productname, imagelink1, price, manufacturer FROM Products WHERE productid='vive'";
                            result = statement.executeQuery(sql);
                            
                            while (result.next()) {
                        %>
                        <a href="index.jsp">
                        <center><h2><%= result.getString("productname") %></h2></center>
                        <img src=<%= result.getString("imagelink1") %> width="300" height="220">
                        </a>
                        <p align="left">$<%= result.getFloat("price") %></p>
                        <p align="left">by <%= result.getString("manufacturer") %></h2></center>
                        <%
                            }
                            conn.close();
                            statement.close();
                            result.close();
                        %>
                        </td>
                    </tr>
                </table>
            </center>

            <hr>

            <h1>About Us</h1>
            <p1>
            Here, at Willy's Wares, we're dedicated to bringing you pristine condition gaming consoles in a quick and efficient manner.  Every employee is dedicated in handling your 
            gaming consoles with finesse and care to make sure you get the excellent service that you deserve.  We're a new company based in Irvine, CA that specializes in dealing with gaming
            consoles and each of our employees are gamers themselves that understand the importance of delicacy in handling gaming consoles.  We hope you have a pleasant experience buying 
            from us!
            </p1>

            <h1>The Team</h1>
            <p1>Owner: Willy Saronamihardja</p1>
            <br>
            <p1>Managers: John Smith, Susan Sue, Lilly Ko</p1>
            <br>
            <p1>Staff: Ryan Bo, Jessie Zayn, Laurence Tran, Abigail Turner, Jason Bourne, Bobby Soprano, Roger Murdock, Larry Parker</p1>

            <h1>Contact Us</h1>
            <p1>Phone number: (123)456-7890</p1>
            <br>
            <p1>Email: customer-service@willyswares.com</p1>
            <br>
            <p1>Address: 123 Gaming St. Irvine, CA  92612</p1>

            <br><br><br>
            <h1>Site Developer</h1>
            <p1>Willy Saronamihardja</p1>

        </div>
		
    </body>
	
</html>






























































































