abstract public class BorrowedResource {
    private String costumer_id;
    private String name;
    private String lib_id;
    private String item_id;
    private String date_of_borrowing;
    private String time_of_borrowing;

    public BorrowedResource(String costumer_id, String name, String lib_id, String item_id, String date_of_borrowing, String time_of_borrowing) {
        this.costumer_id = costumer_id;
        this.name = name;
        this.lib_id = lib_id;
        this.item_id = item_id;
        this.date_of_borrowing = date_of_borrowing;
        this.time_of_borrowing = time_of_borrowing;
    }

    public String getCostumer_id() {
        return costumer_id;
    }

    public void setCostumer_id(String costumer_id) {
        this.costumer_id = costumer_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLib_id() {
        return lib_id;
    }

    public void setLib_id(String lib_id) {
        this.lib_id = lib_id;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getDate_of_borrowing() {
        return date_of_borrowing;
    }

    public void setDate_of_borrowing(String date_of_borrowing) {
        this.date_of_borrowing = date_of_borrowing;
    }

    public String getTime_of_borrowing() {
        return time_of_borrowing;
    }

    public void setTime_of_borrowing(String time_of_borrowing) {
        this.time_of_borrowing = time_of_borrowing;
    }
}
