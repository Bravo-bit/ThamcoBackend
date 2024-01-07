package models;

public class Category {

    private int Id;
    private String Name;
    private String Description;
    private int AvailableProductCount;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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

    public int getAvailableProductCount() {
        return AvailableProductCount;
    }

    public void setAvailableProductCount(int availableProductCount) {
        AvailableProductCount = availableProductCount;
    }

}
