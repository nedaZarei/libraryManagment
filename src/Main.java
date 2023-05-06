import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String command;

        Admin firstAdmin = new Admin("admin", "AdminPass");
        Campus.getUsers().add(firstAdmin);

        do {
            command = input.nextLine();
            if (command.equals("finish")) {
                System.exit(0);
            }
            String[] parts = command.split("[#|]");

            switch (parts[0]) {
                case "add-library":
                    if (admin_and_checking_other_things(parts)) {
                        Library library = new Library(parts[3], parts[4], Integer.valueOf(parts[5]), Integer.valueOf(parts[6]), parts[7]);
                        //admin can add a library
                        for(int i=0; i<Campus.getUsers().size(); i++){
                            if(Campus.getUsers().get(i).getId().equals(parts[1])){
                                //we are sure this user is admin (because we checked in checking_other_things method)
                                Admin admin = (Admin) Campus.getUsers().get(i);
                                admin.addLibrary(library);
                                break;
                            }
                        }
                    }
                    break;
                case "add-category":
                    boolean upper_category_is_found = false;
                    if (!parts[5].equals("null") ) {
                        for (int i = 0; i < Campus.getCategories().size(); i++) {
                            if (Campus.getCategories().get(i).getCatId().equals(parts[5])
                                   || Campus.getCategories().get(i).getName().equals(parts[5])) {
                                upper_category_is_found = true;
                                break;
                            }
                        }
                        if (!upper_category_is_found) {
                            System.out.println("not-found");
                        }
                    }
                    if( parts[5].equals("null") || upper_category_is_found ){
                        if (admin_and_checking_other_things(parts)) {
                            Category category = new Category(parts[3], parts[4],parts[5]);
                            for(int i=0; i<Campus.getUsers().size(); i++){
                                if(Campus.getUsers().get(i).getId().equals(parts[1])){
                                    //we are sure this user is admin (because we checked in checking_other_things method)
                                    Admin admin = (Admin) Campus.getUsers().get(i);
                                    admin.addCategory(category);
                                    break;
                                }
                            }
                        }
                    }
                    break;
                case "add-student":
                    if (admin_and_checking_other_things(parts)) {
                        Student student = new Student(parts[3], parts[4], parts[5], parts[6], parts[7], Integer.valueOf(parts[8]), parts[9]);
                        for(int i=0; i<Campus.getUsers().size(); i++){
                            if(Campus.getUsers().get(i).getId().equals(parts[1])){
                                //we are sure this user is admin (because we checked in checking_other_things method)
                                Admin admin = (Admin) Campus.getUsers().get(i);
                                admin.addStudent(student);
                                break;
                            }
                        }
                    }
                    break;
                case "add-staff":
                    if (admin_and_checking_other_things(parts)) {

                        if (parts[10].equals("staff")) {
                            Staff staff = new Staff(parts[3], parts[4], parts[5], parts[6], parts[7], Integer.valueOf(parts[8]), parts[9]);
                            for(int i=0; i<Campus.getUsers().size(); i++){
                                if(Campus.getUsers().get(i).getId().equals(parts[1])){
                                    //we are sure this user is admin (because we checked in checking_other_things method)
                                    Admin admin = (Admin) Campus.getUsers().get(i);
                                    admin.addStaff(staff);
                                    break;
                                }
                            }
                        } else if (parts[10].equals("professor")) {
                            Professor professor = new Professor(parts[3], parts[4], parts[5], parts[6], parts[7], Integer.valueOf(parts[8]), parts[9]);
                            for(int i=0; i<Campus.getUsers().size(); i++){
                                if(Campus.getUsers().get(i).getId().equals(parts[1])){
                                    //we are sure this user is admin (because we checked in checking_other_things method)
                                    Admin admin = (Admin) Campus.getUsers().get(i);
                                    admin.addProfessor(professor);
                                    break;
                                }
                            }
                        }
                    }
                    break;
                case "add-manager":
                    boolean lib_is_found = false;
                    for (int i = 0; i < Campus.getLibraries().size(); i++) {
                        if (Campus.getLibraries().get(i).getLibId().equals(parts[10])) {
                            lib_is_found = true;
                            break;
                        }
                    }
                    if (!lib_is_found) {
                        System.out.println("not-found");
                    } else if (admin_and_checking_other_things(parts)) {
                        Manager manager = new Manager(parts[3], parts[4], parts[5], parts[6], parts[7], Integer.valueOf(parts[8]), parts[9]);
                        for(int i=0; i<Campus.getUsers().size(); i++){
                            if(Campus.getUsers().get(i).getId().equals(parts[1])){
                                //we are sure this user is admin (because we checked in checking_other_things method)
                                Admin admin = (Admin) Campus.getUsers().get(i);
                                admin.addManager(manager,parts[10]);
                                break;
                            }
                        }
                    }
                    break;
                case "remove-user":
                    if (admin_and_checking_other_things(parts)) {
                        for(int i=0; i<Campus.getUsers().size(); i++){
                            if(Campus.getUsers().get(i).getId().equals(parts[1])){
                                //we are sure this user is admin (because we checked in checking_other_things method)
                                Admin admin = (Admin) Campus.getUsers().get(i);
                                admin.removeUser(parts[3]);
                                break;
                            }
                        }
                    }
                    break;
                case "add-book":
                    if (manager_and_checking_other_things(parts[1],parts[2],parts[9],parts[10])) {
                        Book book = new Book(parts[3], parts[4], parts[5], parts[9], parts[10], Integer.valueOf(parts[7]), Integer.valueOf(parts[8]), parts[6]);
                       for(int i=0; i<Campus.getUsers().size(); i++){
                           if(Campus.getUsers().get(i).getId().equals(parts[1])){
                               //we are sure this user is a manager (because we checked in checking_other_things method)
                                   Manager manager = (Manager) Campus.getUsers().get(i);
                                   manager.addBook(book,parts[10]);
                                   break;
                           }
                       }
                    }
                    break;
                case "add-thesis":
                    if (manager_and_checking_other_things(parts[1],parts[2],parts[8],parts[9])) {
                        Thesis thesis = new Thesis(parts[3], parts[4], parts[5], parts[8], parts[9], parts[6], Integer.valueOf(parts[7]));
                        for(int i=0; i<Campus.getUsers().size(); i++){
                            if(Campus.getUsers().get(i).getId().equals(parts[1])){
                                //we are sure this user is a manager (because we checked in checking_other_things method)
                                Manager manager = (Manager) Campus.getUsers().get(i);
                                manager.addThesis(thesis,parts[9]);
                                break;
                            }
                        }
                    }
                    break;
                case "add-ganjineh-book":
                    if (manager_and_checking_other_things(parts[1],parts[2],parts[9],parts[10])) {
                        GanjinehBook ganjinehBook = new GanjinehBook(parts[3], parts[4], parts[5], parts[9], parts[10], parts[8]);
                        for(int i=0; i<Campus.getUsers().size(); i++){
                            if(Campus.getUsers().get(i).getId().equals(parts[1])){
                                //we are sure this user is a manager (because we checked in checking_other_things method)
                                Manager manager = (Manager) Campus.getUsers().get(i);
                                manager.addGanjinehBook(ganjinehBook,parts[10]);
                                break;
                            }
                        }
                    }
                    break;
                case "add-selling-book":
                    if (manager_and_checking_other_things(parts[1],parts[2],parts[11],parts[12])) {
                        SellingBook sellingBook = new SellingBook(parts[3], parts[4], parts[5], parts[11], parts[12], Integer.valueOf(parts[7]), Integer.valueOf(parts[8]), parts[6], Double.valueOf(parts[9]), Double.valueOf(parts[10]));
                        for(int i=0; i<Campus.getUsers().size(); i++){
                            if(Campus.getUsers().get(i).getId().equals(parts[1])){
                                //we are sure this user is a manager (because we checked in checking_other_things method)
                                Manager manager = (Manager) Campus.getUsers().get(i);
                                manager.addSellingBook(sellingBook,parts[12]);
                                break;
                            }
                        }
                    }
                    break;
                case "remove-resource":
                    if (manager_and_checking_other_things(parts[1],parts[2],"null",parts[4])) {
                        for(int i=0; i<Campus.getUsers().size(); i++){
                            if(Campus.getUsers().get(i).getId().equals(parts[1])){
                                //we are sure this user is a manager (because we checked in checking_other_things method)
                                Manager manager = (Manager) Campus.getUsers().get(i);
                                manager.removeResource(parts[3],parts[4]);
                                break;
                            }
                        }
                    }
                    break;
                case "borrow":
                    if(!is_unsuccessful(parts,"library_user","borrow")){
                        for(int i=0; i<Campus.getLibraryUsers().size(); i++){
                            if(Campus.getLibraryUsers().get(i).getId().equals(parts[1])){

                                Campus.getLibraryUsers().get(i).borrow(parts[1],parts[3],parts[4],parts[5],parts[6]);
                                break;
                            }
                        }
                    }
                    break;
                case "return" :
                    if(!is_unsuccessful(parts,"library_user","return")){
                        for(int i=0; i<Campus.getLibraryUsers().size(); i++){
                            if(Campus.getLibraryUsers().get(i).getId().equals(parts[1])){

                                Campus.getLibraryUsers().get(i).returnResource(parts[1],parts[3],parts[4],parts[5],parts[6]);
                                break;
                            }
                        }
                    }
                    break;
                case "buy" :
                    if(!is_unsuccessful(parts,"general_user","buy")){
                        for(int i=0; i<Campus.getUsers().size(); i++){
                            if(Campus.getUsers().get(i).getId().equals(parts[1])){

                                Campus.getUsers().get(i).buy(parts[1],parts[3],parts[4]);
                                break;
                            }
                        }
                    }
                    break;
                case "read" :
                    if(!is_unsuccessful(parts,"general_user","read")){
                        for(int i=0; i<Campus.getUsers().size(); i++){
                            if(Campus.getUsers().get(i).getId().equals(parts[1])){

                                Campus.getUsers().get(i).read(parts[1],parts[3],parts[4],parts[5],parts[6]);
                                break;
                            }
                        }
                    }
                    break;
                case "add-comment" :
                    if(!is_unsuccessful(parts,"general_user","add-comment")){
                        for(int i=0;i<Campus.getUsers().size(); i++){
                            if(Campus.getUsers().get(i).getId().equals(parts[1])){

                                Campus.getUsers().get(i).addComment(parts[3],parts[4],parts[5]);
                                break;
                            }
                        }
                    }
                    break;
                case "search" :
                    GeneralUser.search(parts[1]);
                    if(Campus.getSearch_results().size() == 0){//nothing was found
                        System.out.println("not-found");
                    }
                    else {//something was found
                       print_search_results();
                       Campus.getSearch_results().clear(); // clearing this for next search command
                    }
                    break;
                case "search-user" :
                    if(check_conditions(parts)){
                      for(int i=0; i<Campus.getUsers().size(); i++){
                          if(Campus.getUsers().get(i).getId().equals(parts[1])){
                              Campus.getUsers().get(i).searchUser(parts[3]);
                              break;
                          }
                      }
                      Campus.getSearch_user_results().clear();
                    }
                    break;
                case "category-report" :
                    if(manager_and_checking_other_things(parts[1],parts[2],parts[3],parts[4])){
                        for(int i=0; i<Campus.getUsers().size(); i++){
                            if(Campus.getUsers().get(i).getId().equals(parts[1])){
                                //we are sure this user is a manager (because we checked in checking_other_things method)
                                Manager manager = (Manager) Campus.getUsers().get(i);
                                manager.categoryReport(parts[3],parts[4]);
                                break;
                            }
                        }
                    }
                    break;
                case "library-report" :
                    if(manager_and_checking_other_things(parts[1],parts[2],"null",parts[3])){
                        for(int i=0; i<Campus.getUsers().size(); i++){
                            if(Campus.getUsers().get(i).getId().equals(parts[1])){
                                //we are sure this user is a manager (because we checked in checking_other_things method)
                                Manager manager = (Manager) Campus.getUsers().get(i);
                                manager.libraryReport(parts[3]);
                                break;
                            }
                        }
                    }
                    break;
                case "report-passed-deadline" :
                    if(manager_and_checking_other_things(parts[1],parts[2],"null",parts[3])){
                        for(int i=0; i<Campus.getUsers().size(); i++){
                            if(Campus.getUsers().get(i).getId().equals(parts[1])){
                                //we are sure this user is a manager (because we checked in checking_other_things method)
                                Manager manager = (Manager) Campus.getUsers().get(i);
                                manager.reportPassedDeadline(parts[3],parts[4],parts[5]);
                                break;
                            }
                        }
                    }
                    break;
                case "report-penalties-sum" :
                    if(admin_and_checking_other_things(parts)){
                        for(int i=0; i<Campus.getUsers().size(); i++){
                            if(Campus.getUsers().get(i).getId().equals(parts[1])){
                                //we are sure this user is admin (because we checked in checking_other_things method)
                                Admin admin = (Admin) Campus.getUsers().get(i);
                                admin.report_penalties_sum();
                                break;
                            }
                        }
                    }
//                case "report-most-popular" :
//                    if(manager_and_checking_other_things(parts[1],parts[2],"null",parts[3])){
//                        for(int i=0; i<Campus.getUsers().size(); i++){
//                            if(Campus.getUsers().get(i).getId().equals(parts[1])){
//                                //we are sure this user is a manager (because we checked in checking_other_things method)
//                                Manager manager = (Manager) Campus.getUsers().get(i);
//                                manager.reportMostPopular(parts[3]);
//                                break;
//                            }
//                        }
//                    }
//                    break;
//                case "report-sell" :
//                    if(manager_and_checking_other_things(parts[1],parts[2],"null",parts[3])){
//                        for(int i=0; i<Campus.getUsers().size(); i++){
//                            if(Campus.getUsers().get(i).getId().equals(parts[1])){
//                                //we are sure this user is a manager (because we checked in checking_other_things method)
//                                Manager manager = (Manager) Campus.getUsers().get(i);
//                                manager.reportSell(parts[3]);
//                                break;
//                            }
//                        }
//                    }
//                    break;
            }
        }
        while (true);
    }
    private static boolean admin_and_checking_other_things(String[] parts) {
        boolean user_is_found = false;
        for (int i = 0; i < Campus.getUsers().size(); i++) {
            if (Campus.getUsers().get(i).getId().equals(parts[1])) { //id is found
                user_is_found = true;
                    if (!(Campus.getUsers().get(i) instanceof Admin)) { //if not admin
                        System.out.println("permission-denied");
                        return false;
                    }
                    if (!Campus.getUsers().get(i).getPassWord().equals(parts[2])) {
                         System.out.println("invalid-pass");
                         return false;
                      }
            }
        }
        if(!user_is_found){
            System.out.println("not-found");
            return false;
        }
        return true;
    }

    private static boolean manager_and_checking_other_things(String user_id,String pass,String cat_id,String lib_id) {
        boolean user_is_found = false, lib_is_found = false, cat_is_found = false;
        boolean manager_is_in_lib = false;
        for (int i = 0; i < Campus.getUsers().size(); i++) {
            if (Campus.getUsers().get(i).getId().equals(user_id)) {
                user_is_found = true;
                break;
            }
        }
        if (!user_is_found) {
            System.out.println("not-found");
            return false;
        }
        if (!cat_id.equals("null")) {
            for (int i = 0; i < Campus.getCategories().size(); i++) {
                if (Campus.getCategories().get(i).getCatId().equals(cat_id)) {
                    cat_is_found = true;
                    break;
                }
            }
            if (!cat_is_found) {
                System.out.println("not-found");
                return false;
            }
        }
        for (int i = 0; i < Campus.getLibraries().size(); i++) {
            if (Campus.getLibraries().get(i).getLibId().equals(lib_id)) {
                lib_is_found = true;

                for (int k = 0; k < Campus.getLibraries().get(i).getManagers().size(); k++) {

                    if (Campus.getLibraries().get(i).getManagers().get(k).getId().equals(user_id)) {
                        manager_is_in_lib = true;
                        break;
                    }
                }
                break;
            }
        }
        if (!lib_is_found) {
            System.out.println("not-found");
            return false;
        } else if (!manager_is_in_lib) {
            System.out.println("permission-denied");
            return false;
        }
        for(int i=0; i<Campus.getUsers().size(); i++){
            if(Campus.getUsers().get(i).getId().equals(user_id)){

                if (!(Campus.getUsers().get(i) instanceof Manager) ){
                    // not a manager
                    System.out.println("permission-denied");
                    return false;
                }
                else if (!Campus.getUsers().get(i).getPassWord().equals(pass)) {
                    System.out.println("invalid-pass");
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean is_unsuccessful(String[] parts,String user_type,String command) {
        boolean user_is_found = false, lib_is_found = false, resource_is_found = false;

       if(user_type.equals("library_user")){
           for(int i=0; i<Campus.getLibraryUsers().size(); i++){
               if(Campus.getLibraryUsers().get(i).getId().equals(parts[1])){
                   user_is_found = true;
                   if(!Campus.getLibraryUsers().get(i).getPassWord().equals(parts[2])){
                       System.out.println("invalid-pass");
                       log_invalid_pass(parts,command);
                       return true;
                   }
                   break;
               }
           }
       }
       else if(user_type.equals("general_user")){
           for(int i=0; i<Campus.getUsers().size(); i++){
               if(Campus.getUsers().get(i).getId().equals(parts[1])){
                   user_is_found = true;
                   if(!Campus.getUsers().get(i).getPassWord().equals(parts[2])){
                       System.out.println("invalid-pass");
                       log_invalid_pass(parts,command);
                       return true;
                   }
                   break;
               }
           }
       }
        if(!user_is_found){
            System.out.println("not-found");
            log_not_found(parts,command);
            return true;
        }
        for (int i = 0; i < Campus.getLibraries().size(); i++) {
            if (Campus.getLibraries().get(i).getLibId().equals(parts[3])) {
                lib_is_found = true;

                for(int k=0; k<Campus.getLibraries().get(i).getResources().size(); k++){
                    if(Campus.getLibraries().get(i).getResources().get(k).getId().equals(parts[4])){
                        resource_is_found = true;
                    }
                }
                break;
            }
        }
        if ((!lib_is_found) || (!resource_is_found)) {
            System.out.println("not-found");
            log_not_found(parts,command);
            return true;
        }
        return false;
    }
    private static void log_invalid_pass(String[] parts,String command){
        switch (command) {
            case "borrow":
                Logger.createObj("INVALID-PASS", new String[]{"borrow", parts[1], parts[5], parts[6], parts[4],parts[3]});
                break;
            case "buy":
                Logger.createObj("INVALID-PASS", new String[]{"buy",parts[1],parts[4],parts[3]});
                break;
        }
    }
    private static void log_not_found(String[] parts,String command){
        switch(command){
            case "borrow" :
                Logger.createObj("NOT-FOUND",new String[]{"borrow",parts[1],parts[5],parts[6],parts[4],parts[3]});
                break;
            case "buy":
                Logger.createObj("NOT-FOUND",new String[]{"buy",parts[1],parts[4],parts[3]});
                break;
        }
    }
    private static boolean check_conditions(String[] parts){
        boolean user_is_found = false;
        for (int i=0; i<Campus.getUsers().size(); i++){
            if(Campus.getUsers().get(i).getId().equals(parts[1])){
                user_is_found = true;
                if(!Campus.getUsers().get(i).getPassWord().equals(parts[2])){
                    System.out.println("invalid-pass");
                    return false;
                }
                break;
            }
        }
        if(!user_is_found){
            System.out.println("not-found");
            return false;
        }
        return true;
    }
    private static void print_search_results(){
        Collections.sort(Campus.getSearch_results()); //SORTING
        //printing the results
        for (int i = 0; i < Campus.getSearch_results().size(); i++) {
            if (i == Campus.getSearch_results().size() - 1)
                System.out.print(Campus.getSearch_results().get(i));
            else
                System.out.print(Campus.getSearch_results().get(i) + "|");
        }
        System.out.print("\n");
    }
}
