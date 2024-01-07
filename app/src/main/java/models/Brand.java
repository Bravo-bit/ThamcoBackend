package models;

public class Brand {

    private int Id;
    private String Name;
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

    public int getAvailableProductCount() {
        return AvailableProductCount;
    }

    public void setAvailableProductCount(int availableProductCount) {
        AvailableProductCount = availableProductCount;
    }

}
