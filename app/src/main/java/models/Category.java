package models;

public class Category {
    private int categoryId;
    private String categoryName;
    private String categoryDescription;
    private int categoryAvailableProductCount;

    public Category() {

    }

    public Category(int categoryId, String categoryName, String categoryDescription,
            int categoryAvailableProductCount) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
        this.categoryAvailableProductCount = categoryAvailableProductCount;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public int getCategoryAvailableProductCount() {
        return categoryAvailableProductCount;
    }

    public void setCategoryAvailableProductCount(int categoryAvailableProductCount) {
        this.categoryAvailableProductCount = categoryAvailableProductCount;
    }

}
