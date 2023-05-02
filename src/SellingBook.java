public class SellingBook extends Book{
    private double price;
    private double discountPercentage;

    public SellingBook(String id, String title, String authorName, String category_id, String library_id, int publishYear, int numberOfCopies, String publisher, double price, double discountPercentage) {
        super(id, title, authorName, category_id, library_id, publishYear, numberOfCopies, publisher);
        this.price = price;
        this.discountPercentage = discountPercentage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }
}
