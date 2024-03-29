public class Book extends Resource {
    private String publisher;
    private int publishYear;
    private int numberOfCopies;

    public Book(String id, String title, String authorName, String category_id, String library_id, int publishYear, int numberOfCopies,String publisher) {
        super(id, title, authorName, category_id, library_id);
        this.publishYear = publishYear;
        this.numberOfCopies = numberOfCopies;
        this.publisher = publisher;
    }

    public String getPublisher() {
        return publisher;
    };

    public int getPublishYear() {
        return publishYear;
    }

    public int getNumberOfCopies() {
        return numberOfCopies;
    }
}
