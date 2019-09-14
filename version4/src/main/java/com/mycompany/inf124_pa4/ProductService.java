package com.mycompany.inf124_pa4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    
    public List<Product> getProductsFromDb() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/willyswares",
                "root", "willyswares");
            Statement statement = conn.createStatement();
            String sql = "SELECT * FROM Products";
            ResultSet results = statement.executeQuery(sql);
            
            List<Product> products = new ArrayList<Product>();
            
            if (results != null) {
                try {
                    while (results.next()) {
                        Product product = new Product();
                        
                        product.setProductId(results.getString("productid"));
                        product.setProductName(results.getString("productname"));
                        product.setProductManufacturer(results.getString("manufacturer"));
                        product.setProductPrice(results.getFloat("price"));
                        String[] descriptions = new String[]{ results.getString("descriptor1"), results.getString("descriptor2"), results.getString("descriptor3"), results.getString("descriptor4") };
                        product.setProductDescriptions(descriptions);
                        String[] images = new String[]{ results.getString("imagelink1"), results.getString("imagelink2"), results.getString("imagelink3"), results.getString("imagelink4") };
                        product.setProductImages(images);
                        
                        products.add(product);
                    }
                } 
                catch (Exception e) {
                    e.printStackTrace();
                } 
                finally {
                    conn.close();
                    statement.close();
                    results.close();
                }
            }
            
            return products;
        }
        
        catch (Exception e) {
            // bad error checks
        }
        
        return null;
    }

    public Product getProductById(String id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/willyswares",
                "root", "willyswares");
            Statement statement = conn.createStatement();
            String sql = "SELECT * FROM Products WHERE productid =" + id;
            ResultSet result = statement.executeQuery(sql);
            
            if (result != null) {
                while (result.next()) {
                    Product product = new Product();
                        
                    product.setProductId(result.getString("productid"));
                    product.setProductName(result.getString("productname"));
                    product.setProductManufacturer(result.getString("manufacturer"));
                    product.setProductPrice(result.getFloat("price"));
                    String[] descriptions = new String[]{ result.getString("descriptor1"), result.getString("descriptor2"), result.getString("descriptor3"), result.getString("descriptor4") };
                    product.setProductDescriptions(descriptions);
                    String[] images = new String[]{ result.getString("imagelink1"), result.getString("imagelink2"), result.getString("imagelink3"), result.getString("imagelink4") };
                    product.setProductImages(images);
                    
                    conn.close();
                    statement.close();
                    result.close();
                    
                    return product;
                }
            }
        }
        catch (Exception e) {
            // do nothing
        }
        
        return null;
    }

    public void addProductToDb(Product product) {
        try {
            String sql = "INSERT INTO Products (productid, productname, manufacturer, price, descriptor1, descriptor2, descriptor3, descriptor4, imagelink1, imagelink2, imagelink3, imagelink4)" + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/willyswares",
                "root", "willyswares");
            
            PreparedStatement statement = conn.prepareStatement(sql);
            String[] descriptions = product.getProductDescriptions();
            String[] images = product.getProductImages();
            statement.setString(1, product.getProductId());
            statement.setString(2, product.getProductName());
            statement.setString(3, product.getProductManufacturer());
            statement.setFloat(4, product.getProductPrice());
            statement.setString(5, descriptions[0]);
            statement.setString(6, descriptions[1]);
            statement.setString(7, descriptions[2]);
            statement.setString(8, descriptions[3]);
            statement.setString(9, images[0]);
            statement.setString(10, images[1]);
            statement.setString(11, images[2]);
            statement.setString(12, images[3]);
            
            statement.executeUpdate();
            
            conn.close();
            statement.close();
        }
        catch (Exception e) {
            // do nothing
        }
    }
    
    public void updateProductInDb(Product product) {
        try {
            String sql = "UPDATE Products SET productname=?, manufacturer=?, price=?, descriptor1=?, descriptor2=?, descriptor3=?, descriptor4=?, imagelink1=?, imagelink2=?, imagelink3=?, imagelink4=? WHERE productid=?";
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/willyswares",
                "root", "willyswares");
            
            PreparedStatement statement = conn.prepareStatement(sql);
            String[] descriptions = product.getProductDescriptions();
            String[] images = product.getProductImages();
            statement.setString(1, product.getProductName());
            statement.setString(2, product.getProductManufacturer());
            statement.setFloat(3, product.getProductPrice());
            statement.setString(4, descriptions[0]);
            statement.setString(5, descriptions[1]);
            statement.setString(6, descriptions[2]);
            statement.setString(7, descriptions[3]);
            statement.setString(8, images[0]);
            statement.setString(9, images[1]);
            statement.setString(10, images[2]);
            statement.setString(11, images[3]);
            statement.setString(12, product.getProductId());
            
            statement.executeUpdate();
            
            conn.close();
            statement.close();
        }
        catch (Exception e) {
            // do nothing
        }
    }
    
    public void deleteProductInDb(Product product) {
        try {
            String sql = "DELETE FROM Products WHERE productid=?";
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/willyswares",
                "root", "willyswares");
            
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, product.getProductId());
            statement.executeUpdate();
            
            conn.close();
            statement.close();
        }
        catch (Exception e) {
            // do nothing
        }
    }
}
