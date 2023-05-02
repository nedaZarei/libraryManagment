import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String command;

        Admin firstAdmin = new Admin("admin","AdminPass");
        Campus.getUsers().add(firstAdmin);

        do {
            command = input.nextLine();
            if (command.equals("finish")) {
                System.exit(0);
            }
            String[] parts = command.split("[#|]");

            switch (parts[0]) {
                case "add-library":
                    if ( admin_and_checking_other_things(parts) != null ){
                        Library library = new Library(parts[3], parts[4],Integer.valueOf(parts[5]),Integer.valueOf(parts[6]), parts[7]);
                        //admin can add a library
                        admin_and_checking_other_things(parts).addLibrary(library);
                    }
                    break;
                case "add-category":
                    boolean upper_category_is_found = false;
                    if(!parts[5].equals("null")){
                        for(int i=0; i<Campus.getCategories().size(); i++){
                            if(Campus.getCategories().get(i).getCatId().equals(parts[5])){
                                upper_category_is_found = true;
                                break;
                            }
                        }
                    }
                    if(!upper_category_is_found){
                        System.out.println("not-found");
                    }
                    else if ( admin_and_checking_other_things(parts) != null ){
                        Category category = new Category(parts[3], parts[4]);
                        admin_and_checking_other_things(parts).addCategory(category);
                    }
                    break;
                case "add-student" :
                    if ( admin_and_checking_other_things(parts) != null ){
                        Student student = new Student(parts[3], parts[4],parts[5],parts[6],parts[7],Integer.valueOf(parts[8]),parts[9]);

                        admin_and_checking_other_things(parts).addStudent(student);
                    }
                    break;
                case "add-staff" :
                    if ( admin_and_checking_other_things(parts) != null ){

                        if(parts[10].equals("staff")){
                            Staff staff = new Staff(parts[3], parts[4],parts[5],parts[6],parts[7],Integer.valueOf(parts[8]),parts[9]);
                            admin_and_checking_other_things(parts).addStaff(staff);
                        }
                        else if(parts[10].equals("professor")){
                            Professor professor = new Professor(parts[3], parts[4],parts[5],parts[6],parts[7],Integer.valueOf(parts[8]),parts[9]);
                            admin_and_checking_other_things(parts).addProfessor(professor);
                        }
                    }
                    break;
                case "add-manager" :
                    boolean lib_is_found = false;
                    for(int i=0; i<Campus.getLibraries().size(); i++){
                        if(Campus.getLibraries().get(i).getLibId().equals(parts[10])){
                            lib_is_found = true;
                            break;
                        }
                    }
                    if(!lib_is_found){
                        System.out.println("not-found");
                    }
                    else if ( admin_and_checking_other_things(parts) != null ){
                        Manager manager = new Manager(parts[3], parts[4],parts[5],parts[6],parts[7],Integer.valueOf(parts[8]),parts[9]);

                        admin_and_checking_other_things(parts).addManager( manager , parts[10] );
                    }
                    break;
                case "remove-user" :
                    if ( admin_and_checking_other_things(parts) != null ){
                        admin_and_checking_other_things(parts).removeUser(parts[3]);
                    }
                    break;
                case "add-book" :
                    if( manager_and_checking_other_things(parts) != null ){
                        Book book = new Book(parts[3],parts[4],parts[5],parts[9],parts[10],Integer.valueOf(parts[7]),Integer.valueOf(parts[8]),parts[6]);
                        manager_and_checking_other_things(parts).addBook(book,parts[10]);
                    }
                    break;
                case "add-thesis" :
                    if( manager_and_checking_other_things(parts) != null ){
                        Thesis thesis = new Thesis(parts[3],parts[4],parts[5],parts[8],parts[9],parts[6],Integer.valueOf(parts[7]));
                        manager_and_checking_other_things(parts).addThesis(thesis,parts[9]);
                    }
                    break;
                case "add-ganjineh-book":
                    if( manager_and_checking_other_things(parts) != null){
                        GanjinehBook ganjinehBook = new GanjinehBook(parts[3],parts[4],parts[5],parts[9],parts[10],parts[8]);
                        manager_and_checking_other_things(parts).addGanjinehBook(ganjinehBook,parts[10]);
                    }
                    break;
                case "add-selling-book" :
                    if ( manager_and_checking_other_things(parts) != null) {
                        SellingBook sellingBook = new SellingBook(parts[3],parts[4],parts[5],parts[11],parts[12],Integer.valueOf(parts[7]),Integer.valueOf(parts[8]),parts[6],Double.valueOf(parts[9]),Double.valueOf(parts[10]));
                        manager_and_checking_other_things(parts).addSellingBook(sellingBook,parts[12]);
                    }
                    break;
                case "remove-resource" :
                    if( manager_and_checking_other_things(parts) != null){
                        manager_and_checking_other_things(parts).removeResource(parts[3],parts[4]);
                    }
                    break;
            }

        }
        while (!command.equals("finish"));
    }

    private static Admin admin_and_checking_other_things(String[] parts) {

        for(int i=0; i<Campus.getUsers().size(); i++){
            if( Campus.getUsers().get(i).getId().equals(parts[1]) ){ //id is found

                if( Campus.getUsers().get(i).getPassWord().equals(parts[2]) == false ){
                    System.out.println("invalid-pass");
                    return null;
                }
                else{ //id and pass is found
                    if( !(Campus.getUsers().get(i) instanceof AddLibrary)
                          || !(Campus.getUsers().get(i) instanceof AddCategory)
                           || !(Campus.getUsers().get(i) instanceof AddStudent)
                            || !(Campus.getUsers().get(i) instanceof AddStaff)
                              || !(Campus.getUsers().get(i) instanceof AddManager)
                               || !(Campus.getUsers().get(i) instanceof RemoveUser) ){ //if not admin
                        System.out.println("permission-denied");
                        return null;
                    }
                    else {
                        Admin admin = (Admin) (Campus.getUsers().get(i)); //down casting
                        return admin;
                    }
                }
            }
        }
        System.out.println("not-found");
        return null;
    }
    private static Manager manager_and_checking_other_things(String[] parts) {
        boolean user_is_found = false, lib_is_found = false, cat_is_found = false;
        boolean manager_is_in_lib = false;

        for (int i = 0; i < Campus.getLibraries().size(); i++) {
            if (Campus.getLibraries().get(i).getLibId().equals(parts[10])) {
                lib_is_found = true;

                for (int k = 0; k < Campus.getLibraries().get(i).getManagers().size(); k++) {

                    if (Campus.getLibraries().get(i).getManagers().get(k).getId().equals(parts[1])) {
                        manager_is_in_lib = true;
                        break;
                    }
                }
                break;
            }
        }
        if (!lib_is_found) {
            System.out.println("not-found");
        } else if (!manager_is_in_lib) {
            System.out.println("permission-denied");
            return null;
        }
        for (int i = 0; i < Campus.getUsers().size(); i++) {
            if (Campus.getUsers().get(i).getId().equals(parts[1])) {
                user_is_found = true;

                if (!Campus.getUsers().get(i).getPassWord().equals(parts[2])) {
                    System.out.println("invalid-pass");
                    return null;
                }
                if (!(Campus.getUsers().get(i) instanceof AddBook)
                        || !(Campus.getUsers().get(i) instanceof AddThesis)
                        || !(Campus.getUsers().get(i) instanceof AddGanginehBook)
                        || !(Campus.getUsers().get(i) instanceof AddSellingBook)) {
                    // not a manager
                    System.out.println("permission-denied");
                    return null;
                } else if (manager_is_in_lib) {
                    Manager manager = (Manager) Campus.getUsers().get(i);
                    return manager;
                }
                break;
            }
        }
        if (!user_is_found) {
            System.out.println("not-found");
            return null;
        }
        if(!parts[9].equals("null")){
            for (int i = 0; i < Campus.getCategories().size(); i++) {
                if (Campus.getCategories().get(i).getCatId().equals(parts[9])) {
                    cat_is_found = true;
                    break;
                }
            }
            if (!cat_is_found) {
                System.out.println("not-found");
                return null;
            }
        }
        return null;
    }
}
