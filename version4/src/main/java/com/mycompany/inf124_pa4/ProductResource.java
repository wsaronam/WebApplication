package com.mycompany.inf124_pa4;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/products")
public class ProductResource {
    
    ProductService productService = new ProductService();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getProducts() {
        return productService.getProductsFromDb();
    }
    
    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Product getProductById(@PathParam("id") String id) {
        return productService.getProductById(id);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addProduct(Product product) {
        productService.addProductToDb(product);
    }
    
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_XML)
    public void updateProduct(@PathParam("id") String id, Product product) {
        product.setProductId(id);
        productService.updateProductInDb(product);
    }
    
    @DELETE
    @Path("/{id}")
    public void deleteProduct(@PathParam("id") String id) {
        Product product = productService.getProductById(id);
        productService.deleteProductInDb(product);
    }
}
