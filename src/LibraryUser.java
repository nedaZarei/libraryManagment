import java.util.ArrayList;

abstract public class LibraryUser extends User{
    private ArrayList<BorrowedBook> borrowedBooks;
    private ArrayList<BorrowedThesis> borrowedTheses;

    public LibraryUser(String id, String passWord, String firstName, String lastName, String nationalId, int birthYear, String address) {
        super(id, passWord, firstName, lastName, nationalId, birthYear, address);
        this.borrowedBooks = new ArrayList<>();
        this.borrowedTheses = new ArrayList<>();
    }

    public ArrayList<BorrowedBook> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(ArrayList<BorrowedBook> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public ArrayList<BorrowedThesis> getBorrowedTheses() {
        return borrowedTheses;
    }

    public void setBorrowedTheses(ArrayList<BorrowedThesis> borrowedTheses) {
        this.borrowedTheses = borrowedTheses;
    }

}
