package com.mycompany.inf124_pa4;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Product {

    private String productId;
    private String productName;
    private String productManufacturer;
    private float productPrice;
    private String productDesc1;
    private String productDesc2;
    private String productDesc3;
    private String productDesc4;
    private String productImage1;
    private String productImage2;
    private String productImage3;
    private String productImage4;

    public String getProductId() {
            return productId;
    }
    
    public void setProductId(String id) {
        productId = id;
    }

    public String getProductName() {
        return productName;
    }
    
    public void setProductName(String name) {
        productName = name;
    }

    public String getProductManufacturer() {
        return productManufacturer;
    }
    
    public void setProductManufacturer(String manu) {
        productManufacturer = manu;
    }

    public float getProductPrice() {
        return productPrice;
    }
    
    public void setProductPrice(float price) {
        productPrice = price;
    }

    public String[] getProductDescriptions() {
        String[] productDesc = new String[]{ productDesc1, productDesc2, productDesc3, productDesc4 };
        return productDesc;
    }
    
    public void setProductDescriptions(String[] descs) {
        productDesc1 = descs[0];
        productDesc2 = descs[1];
        productDesc3 = descs[2];
        productDesc4 = descs[3];
    }

    public String[] getProductImages() {
        String[] productImg = new String[]{ productImage1, productImage2, productImage3, productImage4 };
        return productImg;
    }
    
    public void setProductImages(String[] images) {
        productImage1 = images[0];
        productImage2 = images[1];
        productImage3 = images[2];
        productImage4 = images[3];
    }
}