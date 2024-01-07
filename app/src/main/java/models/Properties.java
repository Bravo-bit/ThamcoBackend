package models;

public class Properties {

    private String dbFile;
    private String productUrl;
    private String categoryUrl;
    private String brandUrl;

    public Properties() {
    }

    public Properties(String dbFile, String productUrl, String categoryUrl, String brandUrl) {
        this.dbFile = dbFile;
        this.productUrl = productUrl;
        this.categoryUrl = categoryUrl;
        this.brandUrl = brandUrl;
    }

    public String getDbFile() {
        return this.dbFile;
    }

    public void setDbFile(String dbFile) {
        this.dbFile = dbFile;
    }

    public String getProductUrl() {
        return this.productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    public String getCategoryUrl() {
        return this.categoryUrl;
    }

    public void setCategoryUrl(String categoryUrl) {
        this.categoryUrl = categoryUrl;
    }

    public String getBrandUrl() {
        return this.brandUrl;
    }

    public void setBrandUrl(String brandUrl) {
        this.brandUrl = brandUrl;
    }
}
