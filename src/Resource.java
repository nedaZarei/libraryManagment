abstract public class Resource {
    private String id;
    private String title;
    private String authorName;
    private String category_id; //optional(if a book doesn't have category -> null)
    private String library_id;

    public Resource(String id, String title, String authorName, String category_id, String library_id) {
        this.id = id;
        this.title = title;
        this.authorName = authorName;
        this.category_id = category_id;
        this.library_id = library_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getLibrary_id() {
        return library_id;
    }

    public void setLibrary_id(String library_id) {
        this.library_id = library_id;
    }
}
