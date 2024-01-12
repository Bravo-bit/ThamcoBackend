package models;

public class Product {
    private int Id;
    private String Ean;
    private int CategoryId;
    private int BrandId;
    private String Name;
    private String Description;
    private double Price;
    private boolean InStock;
    private String ExpectedRestock;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getEan() {
        return Ean;
    }

    public void setEan(String ean) {
        Ean = ean;
    }

    public int getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(int categoryId) {
        CategoryId = categoryId;
    }

    public int getBrandId() {
        return BrandId;
    }

    public void setBrandId(int brandId) {
        BrandId = brandId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public String isInStock() {
        return InStock ? "Yes" : "No";
    }

    public void setInStock(boolean inStock) {
        InStock = inStock;
    }

    public String getExpectedRestock() {
        return ExpectedRestock;
    }

    public void setExpectedRestock(String expectedRestock) {
        ExpectedRestock = expectedRestock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "Id=" + Id +
                ", Ean='" + Ean + '\'' +
                ", CategoryId=" + CategoryId +
                ", BrandId=" + BrandId +
                ", Name='" + Name + '\'' +
                ", Description='" + Description + '\'' +
                ", Price=" + Price +
                ", InStock=" + InStock +
                ", ExpectedRestock='" + ExpectedRestock + '\'' +
                '}';
    }
}
