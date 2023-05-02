import java.util.ArrayList;

public class Library {
    private final String libId;
    private final String name;
    private final int startYear;
    private final int numberOfDesks;
    private final String address;
    private ArrayList<Manager> managers;
    private  ArrayList<Book> books;
    private  ArrayList<Thesis> theses;
    private   ArrayList<BorrowedBook> borrowedBooks;
    private   ArrayList<BorrowedThesis> borrowedTheses;
    private   ArrayList<ReturnedBook> returnedBooks;
    private   ArrayList<ReturnedThesis> returnedTheses;
    private  ArrayList<GanjinehBook> ganjinehBooks;
    private ArrayList<SellingBook> sellingBooks;


    public Library(String libId, String name, int startYear, int numberOfDesks, String address) {
        this.libId = libId;
        this.name = name;
        this.startYear = startYear;
        this.numberOfDesks = numberOfDesks;
        this.address = address;
        this.managers = new ArrayList<>();
        this.books = new ArrayList<>();
        this.theses = new ArrayList<>();
        this.borrowedBooks = new ArrayList<>();
        this.borrowedTheses = new ArrayList<>();
        this.returnedBooks = new ArrayList<>();
        this.returnedTheses = new ArrayList<>();
        this.ganjinehBooks = new ArrayList<>();
        this.sellingBooks = new ArrayList<>();
    }

    public String getLibId() {
        return libId;
    }

    public String getName() {
        return name;
    }

    public int getStartYear() {
        return startYear;
    }

    public int getNumberOfDesks() {
        return numberOfDesks;
    }

    public String getAddress() {
        return address;
    }

    public ArrayList<Manager> getManagers() {
        return managers;
    }

    public void setManagers(ArrayList<Manager> managers) {
        this.managers = managers;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public ArrayList<Thesis> getTheses() {
        return theses;
    }

    public void setTheses(ArrayList<Thesis> theses) {
        this.theses = theses;
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

    public ArrayList<ReturnedBook> getReturnedBooks() {
        return returnedBooks;
    }

    public void setReturnedBooks(ArrayList<ReturnedBook> returnedBooks) {
        this.returnedBooks = returnedBooks;
    }

    public ArrayList<ReturnedThesis> getReturnedTheses() {
        return returnedTheses;
    }

    public void setReturnedTheses(ArrayList<ReturnedThesis> returnedTheses) {
        this.returnedTheses = returnedTheses;
    }

    public ArrayList<GanjinehBook> getGanjinehBooks() {
        return ganjinehBooks;
    }

    public void setGanjinehBooks(ArrayList<GanjinehBook> ganjinehBooks) {
        this.ganjinehBooks = ganjinehBooks;
    }

    public ArrayList<SellingBook> getSellingBooks() {
        return sellingBooks;
    }

    public void setSellingBooks(ArrayList<SellingBook> sellingBooks) {
        this.sellingBooks = sellingBooks;
    }
}
