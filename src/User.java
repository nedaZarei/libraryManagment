import java.util.ArrayList;

abstract public class User extends GeneralUser{
    private String firstName;
    private String lastName;
    private String nationalId;
    private int birthYear;
    private String address;

    public User(String id, String passWord,String firstName,String lastName,String nationalId,int birthYear,String address){
      super(id,passWord);
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalId = nationalId;
        this.birthYear = birthYear;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
