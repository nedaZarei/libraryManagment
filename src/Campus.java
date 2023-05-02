import jdk.internal.dynalink.beans.StaticClass;

import java.util.ArrayList;
import java.util.Scanner;

public class Campus {
    private static ArrayList<Library> libraries = new ArrayList<>();
    private static ArrayList<Category> categories = new ArrayList<>();
    private static ArrayList<Student> students = new ArrayList<>();
    private static ArrayList<Staff> staffs = new ArrayList<>();
    private static ArrayList<Professor> professors = new ArrayList<>();

    private static ArrayList<GeneralUser> users = new ArrayList<>();
    private static ArrayList<LibraryUser> libraryUsers = new ArrayList<>();

    public static ArrayList<Library> getLibraries() {
        return libraries;
    }
    public static void setLibraries(ArrayList<Library> libraries) {
        Campus.libraries = libraries;
    }

    public static ArrayList<Category> getCategories() {
        return categories;
    }

    public static void setCategories(ArrayList<Category> categories) {
        Campus.categories = categories;
    }

    public static ArrayList<Student> getStudents() {
        return students;
    }

    public static void setStudents(ArrayList<Student> students) {
        Campus.students = students;
    }

    public static ArrayList<Staff> getStaffs() {
        return staffs;
    }

    public static void setStaffs(ArrayList<Staff> staffs) {
        Campus.staffs = staffs;
    }

    public static ArrayList<Professor> getProfessors() {
        return professors;
    }

    public static void setProfessors(ArrayList<Professor> professors) {
        Campus.professors = professors;
    }

    public static ArrayList<GeneralUser> getUsers() {
        return users;
    }

    public static void setUsers(ArrayList<GeneralUser> users) {
        Campus.users = users;
    }

    public static ArrayList<LibraryUser> getLibraryUsers() {
        return libraryUsers;
    }

    public static void setLibraryUsers(ArrayList<LibraryUser> libraryUsers) {
        Campus.libraryUsers = libraryUsers;
    }
}
