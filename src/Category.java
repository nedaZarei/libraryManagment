public class Category {
    private final String catId;
    private final String name;
    public Category(String catId , String name){
        this.catId = catId;
        this.name = name;
    }
    public String getCatId() {
        return catId;
    }

    public String getName() {
        return name;
    }
}
