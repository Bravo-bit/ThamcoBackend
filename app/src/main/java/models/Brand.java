package models;

public class Brand {
    private int brandId;
    private String brandName;
    private int brandAvailableProductCount;

    public Brand() {
    }

    public Brand(int brandId, String brandName, int brandAvailableProductCount) {
        this.brandId = brandId;
        this.brandName = brandName;
        this.brandAvailableProductCount = brandAvailableProductCount;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getBrandAvailableProductCount() {
        return brandAvailableProductCount;
    }

    public void setBrandAvailableProductCount(int brandAvailableProductCount) {
        this.brandAvailableProductCount = brandAvailableProductCount;
    }

}
