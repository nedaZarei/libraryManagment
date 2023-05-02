public class GanjinehBook extends Resource{
    private String donor;
    private String dateOfReading;
    private String timeOfReading;

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

    public String getDateOfReading() {
        return dateOfReading;
    }

    public void setDateOfReading(String dateOfReading) {
        this.dateOfReading = dateOfReading;
    }

    public String getTimeOfReading() {
        return timeOfReading;
    }

    public void setTimeOfReading(String timeOfReading) {
        this.timeOfReading = timeOfReading;
    }
}
