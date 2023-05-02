public class GanjinehBook extends Resource{
    private String donor;

    public GanjinehBook(String id, String title, String authorName, String category_id, String library_id, String donor) {
        super(id, title, authorName, category_id, library_id);
        this.donor = donor;
    }

    public String getDonor() {
        return donor;
    }

    public void setDonor(String donor) {
        this.donor = donor;
    }
}
