abstract public class ReturnedResource {
    private String lib_id;
    private String id;
    private String costumer_id;
    private String date;
    private String time;
    private int penalty;

    public ReturnedResource(String lib_id, String id, String costumer_id, String date, String time, int penalty) {
        this.lib_id = lib_id;
        this.id = id;
        this.costumer_id = costumer_id;
        this.date = date;
        this.time = time;
        this.penalty = penalty;
    }

    public String getLib_id() {
        return lib_id;
    }

    public void setLib_id(String lib_id) {
        this.lib_id = lib_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCostumer_id() {
        return costumer_id;
    }

    public void setCostumer_id(String costumer_id) {
        this.costumer_id = costumer_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getPenalty() {
        return penalty;
    }

    public void setPenalty(int penalty) {
        this.penalty = penalty;
    }
}
