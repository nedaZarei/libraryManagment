import java.util.ArrayList;

public class Category {
    private final String catId;
    private final String name;
    private String upperCategoryId;
    private ArrayList<Category> lowerCategories;

    public Category(String catId, String name, String upperCategoryId) {
        this.catId = catId;
        this.name = name;
        this.upperCategoryId = upperCategoryId;
    }

    public String getCatId() {
        return catId;
    }

    public String getName() {
        return name;
    }

    public String getUpperCategoryId() {
        return upperCategoryId;
    }

    public void setUpperCategoryId(String upperCategoryId) {
        this.upperCategoryId = upperCategoryId;
    }

    public ArrayList<Category> getLowerCategories() {
        return lowerCategories;
    }

    public void setLowerCategories(ArrayList<Category> lowerCategories) {
        this.lowerCategories = lowerCategories;
    }
}
