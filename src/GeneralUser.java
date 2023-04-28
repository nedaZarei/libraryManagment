abstract public class GeneralUser {
    private String id;
    private String passWord;

    public GeneralUser(String id, String passWord) {
        this.id = id;
        this.passWord = passWord;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
