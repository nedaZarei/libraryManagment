import java.util.ArrayList;

public class Library {
    private final String libId;
    private final String name;
    private final int startYear;
    private final int numberOfDesks;
    private final String address;
    private ArrayList<Manager> managers;
    private ArrayList<Resource> resources;
    private  ArrayList<Book> books;
    private  ArrayList<Thesis> theses;
    private ArrayList<BorrowedResource> borrowedResources;
    private ArrayList<ReturnedResource> returnedResources;
    private  ArrayList<GanjinehBook> ganjinehBooks;
    private ArrayList<SellingBook> sellingBooks;
    private ArrayList<SellingBook> boughtBooks;
    private ArrayList<GanjinehBook> readGanjinehBooks;

    public Library(String libId, String name, int startYear, int numberOfDesks, String address) {
        this.libId = libId;
        this.name = name;
        this.startYear = startYear;
        this.numberOfDesks = numberOfDesks;
        this.address = address;
        this.managers = new ArrayList<>();
        this.resources = new ArrayList<>();
        this.books = new ArrayList<>();
        this.theses = new ArrayList<>();
        this.borrowedResources = new ArrayList<>();
        this.returnedResources = new ArrayList<>();
        this.ganjinehBooks = new ArrayList<>();
        this.sellingBooks = new ArrayList<>();
        this.boughtBooks = new ArrayList<>();
        this.readGanjinehBooks = new ArrayList<>();
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

    public ArrayList<Resource> getResources() {
        return resources;
    }

    public void setResources(ArrayList<Resource> resources) {
        this.resources = resources;
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

    public ArrayList<BorrowedResource> getBorrowedResources() {
        return borrowedResources;
    }

    public void setBorrowedResources(ArrayList<BorrowedResource> borrowedResources) {
        this.borrowedResources = borrowedResources;
    }

    public ArrayList<ReturnedResource> getReturnedResources() {
        return returnedResources;
    }

    public void setReturnedResources(ArrayList<ReturnedResource> returnedResources) {
        this.returnedResources = returnedResources;
    }

    public ArrayList<SellingBook> getBoughtBooks() {
        return boughtBooks;
    }

    public void setBoughtBooks(ArrayList<SellingBook> boughtBooks) {
        this.boughtBooks = boughtBooks;
    }

    public ArrayList<GanjinehBook> getReadGanjinehBooks() {
        return readGanjinehBooks;
    }

    public void setReadGanjinehBooks(ArrayList<GanjinehBook> readGanjinehBooks) {
        this.readGanjinehBooks = readGanjinehBooks;
    }
}
