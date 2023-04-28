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
}
