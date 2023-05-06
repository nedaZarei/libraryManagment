import java.util.ArrayList;

public class Library {
    private final String libId;
    private final String name;
    private final int startYear;
    private final int numberOfDesks;
    private final String address;
    private  ArrayList<Manager> managers = new ArrayList<>();
    private  ArrayList<Resource> resources =new ArrayList<>();
    private  ArrayList<Book> books = new ArrayList<>();
    private   ArrayList<Thesis> theses = new ArrayList<>();
    private   ArrayList<BorrowedResource> borrowedResources =new ArrayList<>();
    private   ArrayList<ReturnedResource> returnedResources = new ArrayList<>();
    private  ArrayList<GanjinehBook> ganjinehBooks=new ArrayList<>();
    private  ArrayList<SellingBook> sellingBooks=new ArrayList<>();
    private  ArrayList<SellingBook> boughtBooks=new ArrayList<>();
    private  ArrayList<GanjinehBook> readGanjinehBooks=new ArrayList<>();

    public Library(String libId, String name, int startYear, int numberOfDesks, String address) {
        this.libId = libId;
        this.name = name;
        this.startYear = startYear;
        this.numberOfDesks = numberOfDesks;
        this.address = address;
    }

    public void setManagers(ArrayList<Manager> managers) {
        this.managers = managers;
    }

    public void setResources(ArrayList<Resource> resources) {
        this.resources = resources;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public void setTheses(ArrayList<Thesis> theses) {
        this.theses = theses;
    }

    public void setGanjinehBooks(ArrayList<GanjinehBook> ganjinehBooks) {
        this.ganjinehBooks = ganjinehBooks;
    }

    public void setSellingBooks(ArrayList<SellingBook> sellingBooks) {
        this.sellingBooks = sellingBooks;
    }

    public void setReadGanjinehBooks(ArrayList<GanjinehBook> readGanjinehBooks) {
        this.readGanjinehBooks = readGanjinehBooks;
    }

    public void setBorrowedResources(ArrayList<BorrowedResource> borrowedResources) {
        this.borrowedResources = borrowedResources;
    }

    public void setReturnedResources(ArrayList<ReturnedResource> returnedResources) {
        this.returnedResources = returnedResources;
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

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<Thesis> getTheses() {
        return theses;
    }


    public ArrayList<GanjinehBook> getGanjinehBooks() {
        return ganjinehBooks;
    }

    public ArrayList<SellingBook> getSellingBooks() {
        return sellingBooks;
    }

    public ArrayList<BorrowedResource> getBorrowedResources() {
        return borrowedResources;
    }

    public ArrayList<ReturnedResource> getReturnedResources() {
        return returnedResources;
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
}
