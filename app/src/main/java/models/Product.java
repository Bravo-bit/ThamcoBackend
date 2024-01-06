package models;

public class Product {
    private int productId;
    private String productEan;
    private int categoryId;
    private int brandId;
    private String productName;
    private String productDescription;
    private double productPrice;
    private int productInStock;
    private String productExpectedRestock;

    public Product() {

    }

    public Product(int productId, String productEan, int categoryId, int brandId, String productName,
            String productDescription, double productPrice, int productInStock, String productExpectedRestock) {
        this.productId = productId;
        this.productEan = productEan;
        this.categoryId = categoryId;
        this.brandId = brandId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productInStock = productInStock;
        this.productExpectedRestock = productExpectedRestock;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductEan() {
        return productEan;
    }

    public void setProductEan(String productEan) {
        this.productEan = productEan;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductInStock() {
        return productInStock;
    }

    public void setProductInStock(int productInStock) {
        this.productInStock = productInStock;
    }

    public String getProductExpectedRestock() {
        return productExpectedRestock;
    }

    public void setProductExpectedRestock(String productExpectedRestock) {
        this.productExpectedRestock = productExpectedRestock;
    }

}
